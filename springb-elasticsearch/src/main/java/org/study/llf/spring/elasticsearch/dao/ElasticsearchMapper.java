package org.study.llf.spring.elasticsearch.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.study.llf.spring.elasticsearch.pojo.Blog;

import java.util.List;
import java.util.Optional;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-03-29
 * Time 11:01
 */
public interface ElasticsearchMapper extends ElasticsearchRepository<Blog,Integer> {

    List<Blog> findByTitle(String title);

    List<Blog> findByTitleContaining(String title);

    List<Blog> findByReadSizeBetween(Integer from,Integer to);


    Optional<Blog> findById(Integer id);

    List<Blog> findByTitleStartingWith(String title);


}