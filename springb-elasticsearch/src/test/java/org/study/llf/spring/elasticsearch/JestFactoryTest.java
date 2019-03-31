package org.study.llf.spring.elasticsearch;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.mapping.PutMapping;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.mapper.DocumentMapper;
import org.elasticsearch.index.mapper.RootObjectMapper;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Map;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-03-29
 * Time 9:50
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApp.class)
@TestPropertySource(locations = "classpath:application.yml")
public class JestFactoryTest {
   private  JestClient client;

    @Before
    public void init() {
        JestClientFactory factory = new JestClientFactory();
        client= factory.getObject();
    }
    @Test
    public void createIndex() throws IOException {

        Settings.Builder settingsBuilder = Settings.builder();
        settingsBuilder.put("number_of_shards",6);
        settingsBuilder.put("number_of_replicas",1);
        client.execute(new CreateIndex.Builder("articles").settings(String.valueOf(settingsBuilder.build().getAsGroups())).build());

    }
//   public void createMapping(){
////       RootObjectMapper.Builder rootObjectMapperBuilder = new RootObjectMapper.Builder("my_mapping_name").add(
////               new StringFieldMapper.Builder("message").store(true)
////       );
////       DocumentMapper documentMapper = new DocumentMapper.Builder("my_index", null, rootObjectMapperBuilder).build(null);
////       String expectedMappingSource = documentMapper.mappingSource().toString();
////       PutMapping putMapping = new PutMapping.Builder(
////               "my_index",
////               "my_type",
////               expectedMappingSource
////       ).build();
////       client.execute(putMapping);
////   }

    @Test
    public void query() throws IOException {
        int pageNumber=1;
        int pageSize=10;
        String indexName="glances-2019.03.30";


        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.queryStringQuery("JAVA"));
        searchSourceBuilder.query(QueryBuilders.termQuery("plugin","fs"));
        searchSourceBuilder.from((pageNumber - 1) * pageSize);//设置起始页

        searchSourceBuilder.size(pageSize);//设置页大小
        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex(indexName)// 索引名称
                .build();

        SearchResult result = client.execute(search);

        JsonObject jsonObject = result.getJsonObject();
        JsonObject hitsobject = jsonObject.getAsJsonObject("hits");
        JsonArray jsonArray = hitsobject.getAsJsonArray("hits");



    }
}