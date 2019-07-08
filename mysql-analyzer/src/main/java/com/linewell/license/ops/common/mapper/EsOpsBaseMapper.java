package com.linewell.license.ops.common.mapper;

import com.linewell.license.ops.plugin.mysql.pojo.EsMysqlAllInfo;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-06-21
 * Time 11:09
 */
public interface EsOpsBaseMapper<T> extends ElasticsearchRepository<T, String> {

    List<T> findByClientIdentifyingAndPluginIdAndTimestampBetweenOrderByTimestampDesc(String clientIdentifying,String pluginId,String startTime, String endTime);
    List<T> findByClientIdentifyingAndPluginIdAndTimestampBetweenOrderByTimestampDesc(String clientIdentifying,String pluginId,String startTime, String endTime, Pageable pageable);

    List<T> findByInstanceIdAndTimestampBetweenOrderByTimestampDesc(String instanceId,String startTime, String endTime, Pageable pageable);
    List<T> findByInstanceIdAndTimestampBetweenOrderByTimestampDesc(String instanceId,String startTime, String endTime);
}

