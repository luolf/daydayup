package org.study.llf.admin;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.io.compress.Compression;
import org.apache.hadoop.hbase.security.User;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-06-02
 * Time 11:32
 */
public class HBaseAdminClient implements Constants {


    public static void main(String[] args) throws IOException {
        HBaseAdminClient clientExample = new HBaseAdminClient();

        // Step 1： 初始化HBase连接，返回Admin实例。
        Admin admin = getConnection().getAdmin();

        // Step 2: 设置表结构并建表。
        clientExample.createSchemaTables(admin);

        // Step 3: 修改表结构。
        clientExample.modifySchema(admin);

        // Step 4: 清空表数据
        clientExample.truncateHBaseTable(admin);

    }

    /**
     * 初始化HBase连接
     */
    private static Connection getConnection() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        conf.set(HConstants.ZOOKEEPER_CLIENT_PORT, ZOOKEEPER_CLIENT_PORT);
        conf.set(HConstants.ZOOKEEPER_QUORUM, ZOOKEEPER_LIST);
        conf.set(HConstants.ZOOKEEPER_ZNODE_PARENT, ZOOKEEPER_ZNODE_PARENT);
        User user = User.create(UserGroupInformation.createRemoteUser(USER_NAME));
        return ConnectionFactory.createConnection(conf, user);
    }

    /**
     * 创建HBase表
     */
    private void createSchemaTables(Admin admin) {
        try {
            HTableDescriptor table = new HTableDescriptor(TableName.valueOf(Constants.TABLE_NAME));
            table.addFamily(new HColumnDescriptor(Constants.COLUMN_FAMILY).setCompressionType(Compression.Algorithm.LZO));

            // 建表前需判断表是否存在，若存在，则删除
            if (admin.tableExists(table.getTableName())) {
                admin.disableTable(table.getTableName());
                admin.deleteTable(table.getTableName());
            }
            admin.createTable(table);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更改表结构：可修改 压缩方式、TTL 和 版本数
     */
    private void modifySchema(Admin admin) {
        try {
            TableName tn = TableName.valueOf(Constants.TABLE_NAME);

            // 表不存在，则不用修改
            if (!admin.tableExists(tn)) {
                System.out.println("Table does not exist...");
                System.exit(-1);
            }

            // 创建表描述实例。
            HTableDescriptor tableDesc = admin.getTableDescriptor(tn);

            // 定义新列族属性，并添加到表数据实例。
            HColumnDescriptor newColumn = new HColumnDescriptor("new_cf");
            newColumn.setCompactionCompressionType(Compression.Algorithm.LZO);
            // 设置最大版本数
            newColumn.setMaxVersions(10);
            // 设置TTL
            newColumn.setTimeToLive(86400);
            tableDesc.addFamily(newColumn);

            // 更新列族属性
            HColumnDescriptor existingColumn = new HColumnDescriptor(COLUMN_FAMILY);
            existingColumn.setCompactionCompressionType(Compression.Algorithm.NONE);
            existingColumn.setMaxVersions(3);
            existingColumn.setTimeToLive(Integer.MAX_VALUE);
            tableDesc.modifyFamily(existingColumn);
            admin.modifyTable(tn, tableDesc);

            // 删除某已存在的列族（当表仅有一个列族时无法进行此操作）
            admin.disableTable(tn);
            admin.deleteColumn(tn, COLUMN_FAMILY.getBytes(StandardCharsets.UTF_8));
            admin.enableTable(tn);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 清空表数据
     */
    private void truncateHBaseTable(Admin admin) throws IOException {
        admin.disableTable(TableName.valueOf(Constants.TABLE_NAME));
        admin.deleteTable(TableName.valueOf(Constants.TABLE_NAME));
    }

}