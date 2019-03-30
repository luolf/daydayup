//package org.study.llf.spring.elasticsearch;
//
//import io.searchbox.client.JestClient;
//import io.searchbox.client.JestClientFactory;
//import io.searchbox.indices.CreateIndex;
//import io.searchbox.indices.mapping.PutMapping;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.index.mapper.DocumentMapper;
//import org.elasticsearch.index.mapper.RootObjectMapper;
//import org.elasticsearch.index.mapper.core.StringFieldMapper;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.IOException;
//import java.util.Map;
//
///**
// * Description 类描述
// *
// * @author luolifeng
// * @version 1.0.0
// * Date 2019-03-29
// * Time 9:50
// */
//public class JestFactoryTest {
//   private  JestClient client;
//
//    @Before
//    public void init() {
//        JestClientFactory factory = new JestClientFactory();
//        client= factory.getObject();
//    }
//    @Test
//    public void createIndex() throws IOException {
//
//        Settings.Builder settingsBuilder = Settings.builder();
//        settingsBuilder.put("number_of_shards",6);
//        settingsBuilder.put("number_of_replicas",1);
//        client.execute(new CreateIndex.Builder("articles").settings(String.valueOf(settingsBuilder.build().getAsGroups())).build());
//
//    }
//   public void createMapping(){
//       RootObjectMapper.Builder rootObjectMapperBuilder = new RootObjectMapper.Builder("my_mapping_name").add(
//               new StringFieldMapper.Builder("message").store(true)
//       );
//       DocumentMapper documentMapper = new DocumentMapper.Builder("my_index", null, rootObjectMapperBuilder).build(null);
//       String expectedMappingSource = documentMapper.mappingSource().toString();
//       PutMapping putMapping = new PutMapping.Builder(
//               "my_index",
//               "my_type",
//               expectedMappingSource
//       ).build();
//       client.execute(putMapping);
//   }
//}