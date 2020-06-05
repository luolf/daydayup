package org.study.llf.admin;
import org.apache.hadoop.hbase.util.Bytes;
/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-06-02
 * Time 11:36
 */
public interface Constants {
    String ZOOKEEPER_LIST = "...";
    String ZOOKEEPER_CLIENT_PORT = "2015";
    String ZOOKEEPER_ZNODE_PARENT = "/hbase";
    String USER_NAME = "wj";
    String TABLE_NAME = "wj_table";
    String COLUMN_FAMILY = "f";
    byte[] ROWKEY = Bytes.toBytes("rowkey-1");
    byte[] ROWKEY_2 = Bytes.toBytes("rowkey-2");
    byte[] FAMILY = Bytes.toBytes("f");
    byte[] QUALIFIER = Bytes.toBytes("c1");
    byte[] QUALIFIER_2 = Bytes.toBytes("c2");
    byte[] VALUE = Bytes.toBytes("v1");
    byte[] VALUE_2 = Bytes.toBytes("v2");
}