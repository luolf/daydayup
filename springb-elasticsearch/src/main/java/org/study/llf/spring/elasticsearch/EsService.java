package org.study.llf.spring.elasticsearch;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.study.llf.spring.elasticsearch.dao.ElasticsearchMapper;
import org.study.llf.spring.elasticsearch.pojo.Blog;

import java.util.Collections;
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
@Service("EsService")
public class EsService {

    @Autowired
    private ElasticsearchMapper elasticsearchMapper;

    /*/**

     * 保存Blog
     * @param [blog]
     * @return      void
     * @exception
     */
    public void save(Blog blog){
        elasticsearchMapper.save(blog);
    }


    /*/**

     * 根据 title 来查找Blog
     * @param [title]
     * @return      java.util.List<com.lin.model.Blog>
     * @exception
     */
    public List<Blog> queryByTitle(String title){
        return elasticsearchMapper.findByTitle(title);
    }

    /*/**

     * 根据 title 来查找Blog
     * @param [title]
     * @return      java.util.List<com.lin.model.Blog>
     * @exception
     */
    public List<Blog> queryByTitleContaining(String title){
        return elasticsearchMapper.findByTitleContaining(title);
    }

    /*/**

     * 根据范围 查找 blog
     * @param [from, to]
     * @return      java.util.List<com.lin.model.Blog>
     * @exception
     */
    public List<Blog> queryByReadSizeBetween(Integer from,Integer to){
        return elasticsearchMapper.findByReadSizeBetween(from,to);
    }

    /*/**

     * 根据id 查找
     * @param [id]
     * @return      java.util.Optional<com.lin.model.Blog>
     * @exception
     */
    public Optional<Blog> queryById(Integer id){
        return elasticsearchMapper.findById(id);
    }

    /*/**

     * 针对readSize字段 按降序进行查找
     * @param []
     * @return      java.lang.Iterable<com.lin.model.Blog>
     * @exception
     */
    public Iterable<Blog> getAll(){
        Sort sort = new Sort(Sort.Direction.DESC,"readSize");

        return elasticsearchMapper.findAll(sort);
    }

    /*/**

     * 按时间排序查找 从最新的文章开始往下排
     * @param []
     * @return      java.lang.Iterable<com.lin.model.Blog>
     * @exception
     */
    public Iterable<Blog> getAllBycreateTime(){
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        return elasticsearchMapper.findAll(sort);
    }

    public  Iterable<Blog> search(QueryBuilder queryBuilder){

        return  elasticsearchMapper.search(queryBuilder);
    }


    /*/**

     * 使用 QueryBuilder进行匹配查询
     * @param []
     * @return      java.lang.Iterable<com.lin.model.Blog>
     * @exception
     * termQuery 匹配查询 前者为实体类的字段 后者为你希望匹配的内容
     *fuzzyQuery 模糊匹配  前者为实体类的字段 后者为你希望匹配的内容 只要出现了value 就可以匹配
     */
    public Iterable<Blog> searchQuery(){
        QueryBuilder queryBuilder = QueryBuilders.termQuery("title", "Web");
        QueryBuilder queryBuilder1 = QueryBuilders.fuzzyQuery("title", "人");
        return elasticsearchMapper.search(queryBuilder1);
    }


    /*/**

     * 以***为开始来进行匹配标题
     * @param [title]
     * @return      java.util.List<com.lin.model.Blog>
     * @exception
     */
    public List<Blog> queryByTitleStartingWith(String title){
        return elasticsearchMapper.findByTitleStartingWith(title);
    }

    /*/**

     * 通过id 删除实体
     * @param [id]
     * @return      void
     * @exception
     */
    public void delete(Integer id){
        elasticsearchMapper.deleteById(id);
    }





}
