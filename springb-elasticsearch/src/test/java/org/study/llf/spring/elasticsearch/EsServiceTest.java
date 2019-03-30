package org.study.llf.spring.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.lucene.search.join.ScoreMode;
import org.assertj.core.util.Lists;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.study.llf.spring.elasticsearch.pojo.Blog;

import javax.sql.DataSource;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;


/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-03-29
 * Time 11:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApp.class)
@TestPropertySource(locations = "classpath:application.yml")

public class EsServiceTest {
    private final Logger log = LoggerFactory.getLogger(EsServiceTest.class);
    Blog queryBlog=new Blog();
    @Autowired
    private EsService esService;
    @Before
    public void init(){
        Blog blog = new Blog();
        blog.setId(2);
        blog.setTitle("五一放假安排");
        blog.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        blog.setContent("五一放假7天，爽不?");
        blog.setReadSize(9827);
        blog.setVoteSize(99);
        queryBlog=blog;
    }

    public void nestdQuery(){

        QueryBuilder orderItemsQuery = QueryBuilders.nestedQuery("orderItem.orderItems",
                QueryBuilders.boolQuery()
                        .must(QueryBuilders.matchQuery("orderItem.orderItems.stockSite", "0001"))
                        .must(QueryBuilders.matchQuery("orderItem.orderItems.skuNo", "154018")),
                ScoreMode.Total);

        QueryBuilder orderQuery = QueryBuilders.nestedQuery("orderItem",
                QueryBuilders.boolQuery()
                        .must(QueryBuilders.matchQuery("orderItem.orderType", "RO"))
                        .must(QueryBuilders.matchQuery("orderItem.orderDate", "20170708")),
                ScoreMode.Total);

        QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(orderQuery).must(orderItemsQuery);

        Iterable<Blog> it = esService.search(queryBuilder);
        List<Blog> list = Lists.newArrayList(it);
    }
    /*/**

     * 测试 保存操作
     * @param []
     * @return      void
     * @exception
     */
    @org.junit.Test
    public void T1() {

        List<Blog> blogs = new ArrayList<>();
        Blog blog = new Blog();
        blog.setId(2);
        blog.setTitle("五一放假安排2");
        blog.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        blog.setContent("五一放假7天，爽不?");
        blog.setReadSize(9827);
        blog.setVoteSize(99);
        String jsonstr = JSON.toJSONString(blog);
        System.out.println(jsonstr);
        for (Blog bg : blogs) esService.save(bg);


    }

    /*/**

     * 匹配查询
     * @param []
     * @return      void
     * @exception
     */
    @org.junit.Test
    public void Testquery1() {
        List<Blog> blogs = esService.queryByTitle(queryBlog.getTitle());
        log.info("{}", blogs.size());
        for (Blog blog : blogs) {
            log.info("{}", blog);
        }
    }

    /*/**

     * 匹配查询
     * @param []
     * @return      void
     * @exception
     */

    @org.junit.Test
    public void TestQueryContainging() {
        List<Blog> blogs = esService.queryByTitleContaining(queryBlog.getTitle());
        log.info("{}", blogs.size());
        for (Blog blog : blogs) {
            log.info("{}", blog.getContent());
        }
    }

    /*/**

     * 针对readSize 范围查找
     * @param []
     * @return      void
     * @exception
     */
    @org.junit.Test
    public void TestByReadSizeBetween() {
        List<Blog> blogs = esService.queryByReadSizeBetween(1, 10000);
        log.info("{}", blogs.size());
        for (Blog blog : blogs) {
            log.info("{}", blog.getContent());
        }
    }

    /*/**

     * 根据id 查找
     * @param []
     * @return      void
     * @exception
     */
    @org.junit.Test
    public void TestQueryById() {
        Optional<Blog> blog = esService.queryById(2);
        log.info("{}", blog.get().getContent());
    }

    /*/**

     * 根据readSize 降序查找
     * @param []
     * @return      void
     * @exception
     */
    @org.junit.Test
    public void TestfindAll() {
        Iterable<Blog> iterable = esService.getAll();
        Iterator<Blog> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Blog blog = iterator.next();
            log.info("{}", blog.getTitle() + "         " + blog.getReadSize());
        }
    }

    @org.junit.Test
    public void TestsearchQuery() {
        Iterable<Blog> iterable = esService.searchQuery();
        Iterator<Blog> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Blog blog = iterator.next();
            log.info("{}", blog.getTitle() + "         " + blog.getReadSize());
        }
    }

    /*/**

     * 按时间先后排序查找
     * @param []
     * @return      void
     * @exception
     */
    @org.junit.Test
    public void TestgetAllBycreateTime() {
        Iterable<Blog> iterable = esService.getAllBycreateTime();
        Iterator<Blog> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Blog blog = iterator.next();
            log.info("{}", blog.getTitle() + "         " + blog.getCreateTime());
        }
    }

    /*/**

     * 以***为开始来进行匹配标题
     * @param []
     * @return      void
     * @exception
     */
    @org.junit.Test
    public void TestqueryByTitleStartingWith() {
        List<Blog> blogs = esService.queryByTitleStartingWith("五");
        for (Blog blog : blogs) {
            log.info("{}", blog.getTitle());
        }
    }

    /*/**

     * 根据id 进行删除操作
     * @param []
     * @return      void
     * @exception
     */
    @org.junit.Test
    public void Testdelete() {
        esService.delete(6);
    }
}