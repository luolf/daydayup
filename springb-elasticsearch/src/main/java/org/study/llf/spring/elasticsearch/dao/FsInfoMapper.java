package org.study.llf.spring.elasticsearch.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.study.llf.spring.elasticsearch.pojo.FsInfo;

import java.util.List;

public interface FsInfoMapper  extends ElasticsearchRepository<FsInfo,String> {

    List<FsInfo> findAllByPluginNotNull();

}
