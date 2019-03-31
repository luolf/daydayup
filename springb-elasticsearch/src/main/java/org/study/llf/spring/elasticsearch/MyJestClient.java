package org.study.llf.spring.elasticsearch;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.ClientConfig;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.study.llf.spring.elasticsearch.pojo.FsInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

public class MyJestClient {
    private static JestClient client;


    static {


        JestClientFactory factory = new JestClientFactory();

        factory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://192.168.203.234:9200")
                .multiThreaded(true)
                //Per default this implementation will create no more than 2 concurrent connections per given route
//                .defaultMaxTotalConnectionPerRoute(<YOUR_DESIRED_LEVEL_OF_CONCURRENCY_PER_ROUTE>)
                // and no more 20 connections in total
//                .maxTotalConnection(<YOUR_DESIRED_LEVEL_OF_CONCURRENCY_TOTAL>)
                        .build());

        client= factory.getObject();
    }
    public static void query() throws IOException {
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

//        .addIndex("twitter")
//                .addType("tweet")
//                .build();


        SearchResult result = client.execute(search);

        JsonObject jsonObject = result.getJsonObject();
        JsonObject hitsobject = jsonObject.getAsJsonObject("hits");
        JsonArray jsonArray = hitsobject.getAsJsonArray("hits");
        if(jsonArray.size()<1) {return ;}
        List<FsInfo> fsInfos=new ArrayList<>(jsonArray.size());
        for(int i=0;i<jsonArray.size();i++) {
            FsInfo fsInfo=new FsInfo();
            JsonObject js= jsonArray.get(i).getAsJsonObject();
            JsonObject source = js.getAsJsonObject("_source");
            System.out.println("");
            String id=js.get("_id").getAsString();
//            String id =jp.getAsJsonPrimitive().getAsString();
            fsInfo.setId(id);
//            fsInfo.setTimestamp();  source.get("timestamp");
            JsonObject fs = source.getAsJsonObject("fs");
            HashMap<String,String> rst=new HashMap<>();
            for (String key : fs.keySet()) {
                String v = fs.get(key).getAsJsonPrimitive().getAsString();
                rst.put(key, v);
                System.out.println(key + "=" + v);
            }
//            fsInfo.setFs(rst);
//            fsInfos.add(fsInfo);

        }


        JsonArray jsonArray3 =jsonObject.getAsJsonObject("hits").getAsJsonArray("hits").getAsJsonArray();
        System.out.println("");
    }
}