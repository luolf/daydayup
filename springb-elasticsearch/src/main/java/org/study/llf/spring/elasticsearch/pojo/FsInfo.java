package org.study.llf.spring.elasticsearch.pojo;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import com.google.gson.JsonObject;
@Document(indexName = "glances-2019.03.30", type = "glances")
@Setter
@Getter
public class FsInfo extends  EsBaseInfo {
    public String clientIdentifying;

//    public LinkedTreeMap<String,String> fs;
//    <LinkedTreeMap<String,JsonPrimitive>>
    public JsonObject fs;
}
