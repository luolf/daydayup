package org.study.llf.spring.elasticsearch.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Setter
@Getter
public class EsBaseInfo {
    @Field( type = FieldType.Date, format =DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
    public Date timestamp;
    public String id;
    public String plugin;

}
