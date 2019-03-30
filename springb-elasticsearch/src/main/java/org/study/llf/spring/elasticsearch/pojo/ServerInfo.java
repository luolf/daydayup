package org.study.llf.spring.elasticsearch.pojo;

import org.springframework.data.elasticsearch.annotations.Document;

import java.sql.Timestamp;
import java.util.List;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-03-29
 * Time 17:13
 */
@Document(indexName = "blogs", type = "blog")
public class ServerInfo {
    public Timestamp  timestamp;
    public List<String> plugins;
    public String  dataType;
    public String  clientIdentifying;
    public String  dataIdentifying;
    public String  content;


}
