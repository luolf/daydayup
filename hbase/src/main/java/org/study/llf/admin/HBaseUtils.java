package org.study.llf.admin;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-06-02
 * Time 11:42
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class HBaseUtils {
    private static Configuration conf;
    private static Connection conn;
    private static HBaseUtils hBaseUtils;
    private static Properties prop;
    private static Logger logger = Logger.getLogger(HBaseUtils.class);
    @Test
    public void createTable(){

    }
    public void init() {
        conf = HBaseConfiguration.create();
        prop = new Properties();
        try {
            prop.load(HBaseUtils.class.getResourceAsStream("/hbase.properties"));
            String clientPort = prop.getProperty("clientPort");
            String quorum = prop.getProperty("quorum");
            conf.set("hbase.zookeeper.quorum", quorum);
            conf.set("hbase.zookeeper.property.clientPort", clientPort);
            conn = ConnectionFactory.createConnection(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private HBaseUtils() {
    }
    public static HBaseUtils getInstance() {
        if(hBaseUtils == null) {
            synchronized (HBaseUtils.class) {
                if (hBaseUtils == null) {
                    hBaseUtils = new HBaseUtils();
                    hBaseUtils.init();
                }
            }
        }
        return hBaseUtils;
    }

    /**
     * by 1022
     * @return
     */
    public Configuration getConfiguration(){
        return this.conf;
    }

    /**
     * by 1022
     * @param tableName
     * @param row
     * @param columnFamily
     * @param column
     * @param data
     * @throws IOException
     */
    public static void putData(String tableName, String row, String columnFamily, String column, String data)
            throws IOException {
        Connection conn = ConnectionFactory.createConnection(conf);
        Table table = conn.getTable(TableName.valueOf(tableName));
        try {
            Put put = new Put(Bytes.toBytes(row));
            put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column), Bytes.toBytes(data));
            table.put(put);

        } finally {
            table.close();
            conn.close();
        }
    }



    public void testGet() throws IOException {

        long begin = System.currentTimeMillis();
        HTable table = (HTable) conn.getTable(TableName.valueOf("CFSchema"));
        TableName name = table.getName();
        System.out.println("name : " + name);
       /* Get get = new Get(Bytes.toBytes("91244740570"));
        Result result = table.get(get);
        String str = Bytes.toString(result.getValue(Bytes.toBytes("mediaCodes"),
                Bytes.toBytes("Userid")));
        System.out.println(str);
        long end = System.currentTimeMillis();
        System.out.println("used time : " + (end - begin));*/
        table.close();
    }
    public void createTable() throws IOException {

        HBaseAdmin admin = (HBaseAdmin) conn.getAdmin();
        HTableDescriptor htd = new HTableDescriptor(TableName.valueOf("people"));
        HColumnDescriptor htd_info = new HColumnDescriptor("info");
        htd.addFamily(htd_info);
        htd.addFamily(new HColumnDescriptor("data"));
        htd_info.setMaxVersions(3);

        admin.createTable(htd);
        admin.close();

    }
    public String getListByUserId(String userid) {
        HTable table;
        String rs = "";
        try {
            table = (HTable) conn.getTable(TableName.valueOf("CFSchema"));
            logger.debug("<debug> tableName : " + table + "</debug>");
            //Get get = new Get(Bytes.toBytes(userid));
            //Result result = table.get(get);
            Scan scan = new Scan(Bytes.toBytes(userid),Bytes.toBytes(userid));
            scan.addColumn("cf".getBytes(), "mediaCodes".getBytes());
            ResultScanner scanner = table.getScanner(scan);
            Result result = null;
            for (Result r : scanner){
                result = r;
                rs = Bytes.toString(result.getValue(Bytes.toBytes("cf"),
                        Bytes.toBytes("mediaCodes")));
            }
            logger.debug("<debug> recmd list : " + rs + "</debug>");
            table.close();
        } catch (IOException e) {
            logger.debug("<error>  catch message : " + e.toString() + "</error>");
            e.printStackTrace();
        }
        return rs;

    }

    /**
     * @param userid
     * @return
     * 根据用户id获取用户分类再获取用户推荐列表
     */
    public String getListByUserIdForCluster(String userid) {
        HTable table;
        String rs = "";
        String cluster = "";
        Scan scan = null;
        Result result = null;
        ResultScanner scanner = null;
        try {
            //取用户分类
            table = (HTable) conn.getTable(TableName.valueOf("UserSchema"));
            logger.debug("<debug> tableName : " + table + "</debug>");
            scan = new Scan(Bytes.toBytes(userid),Bytes.toBytes(userid));
            scan.addColumn("cf".getBytes(), "mediaCodes".getBytes());
            scanner = table.getScanner(scan);
            for (Result r : scanner){
                result = r;
                cluster = Bytes.toString(result.getValue(Bytes.toBytes("cf"),
                        Bytes.toBytes("mediaCodes")));
            }
            table.close();
            logger.debug("<debug> cluster : " + cluster + "</debug>");
            //根据分类取推荐列表
            table = (HTable) conn.getTable(TableName.valueOf("KmeansSchema"));
            scan = new Scan(Bytes.toBytes(cluster),Bytes.toBytes(cluster));
            scan.addColumn("cf".getBytes(), "mediaCodes".getBytes());
            scanner = table.getScanner(scan);
            for (Result r : scanner){
                result = r;
                rs = Bytes.toString(result.getValue(Bytes.toBytes("cf"),
                        Bytes.toBytes("mediaCodes")));
            }
            logger.debug("<debug> recmd list : " + rs + "</debug>");
            table.close();
        } catch (IOException e) {
            logger.debug("<error>  catch message : " + e.toString() + "</error>");
            e.printStackTrace();
        }
        return rs;

    }
    public Map<Integer, String> getGYLFirstVersionField() {
        String fieldString = prop.getProperty("GYLFirstVersionFields");
        String[] fields = fieldString.split(",");
        HashMap<Integer, String> fieldsMap = new HashMap<Integer, String>();
        for (int i = 0; i < fields.length; i++) {
            fieldsMap.put(i, fields[i]);
        }
        return fieldsMap;
    }
    public Map<Integer, String> getGYLSecondVersionField() {
        String fieldString = prop.getProperty("GYLSecondVersionFields");
        String[] fields = fieldString.split(",");
        HashMap<Integer, String> fieldsMap = new HashMap<Integer, String>();
        for (int i = 0; i < fields.length; i++) {
            fieldsMap.put(i, fields[i]);
        }
        return fieldsMap;
    }

    //行计数
//    public static long rowCount(String tableName) {
//        long rowCount = 0;
//        @SuppressWarnings("resource")
//        AggregationClient aggregationClient = new AggregationClient(conf);
//        Scan scan = new Scan();
//        try {
//            rowCount = aggregationClient.rowCount(TableName.valueOf(tableName),
//                    new LongColumnInterpreter(), scan);
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        return rowCount;
//    }



}
