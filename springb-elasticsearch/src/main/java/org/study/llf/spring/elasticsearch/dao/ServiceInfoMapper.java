package org.study.llf.spring.elasticsearch.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.study.llf.spring.elasticsearch.pojo.Blog;
import org.study.llf.spring.elasticsearch.pojo.CpuInfo;

import java.util.List;
import java.util.Optional;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-03-29
 * Time 17:19
 */
public interface ServiceInfoMapper   extends ElasticsearchRepository<CpuInfo,String> {



        List<CpuInfo> findByClientIdentifyingContaining(String clientIdentifying);

        List<CpuInfo> findByIdleBetween(double from,double to);


        Optional<CpuInfo> findById(Integer id);

        List<CpuInfo> findByClientIdentifyingStartingWith(String clientIdentifying);

}
