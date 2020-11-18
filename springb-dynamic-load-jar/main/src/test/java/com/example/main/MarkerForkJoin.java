package com.example.main;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: luolifeng
 * Date: 2020-11-16 9:57
 */
public class MarkerForkJoin extends RecursiveTask<Integer> {
    int MAX=20*100;
    // 子任务开始计算的粉丝范围值
    private Integer startValue;

    // 子任务结束计算的粉丝范围值
    private Integer endValue;
//    @Autowired
    static RestTemplate restTemplate=new RestTemplate();
    public MarkerForkJoin(Integer startValue , Integer endValue) {
        this.startValue = startValue;
        this.endValue = endValue;
    }

    public int get(int page,int records,int minFans,int maxFans){
        String uri = "http://172.25.10.135:8083/api" + "/CreatorMarket/AuthorSearchByFans?page={page}&limit={records}&author_min_reach={minFans}&author_max_reach={maxFans}";
        ResponseEntity<MarketAuthorResponse> responseEntity = restTemplate.getForEntity(uri, MarketAuthorResponse.class,page,records,minFans,maxFans);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException(String.format("get blogger error. status: %s . msg: %s", responseEntity.getStatusCodeValue(), responseEntity.getBody()));
        }

        if (responseEntity.getBody() == null) {
            throw new RuntimeException("get blogger_market error, retry times 10. uri:" +
                    uri.replace("{page}", String.valueOf(page)));
        }
        return responseEntity.getBody().getData().getPagination().getTotal_count();
    }
    @Override
    protected Integer compute() {

        int cnt=get(1,20,startValue,endValue);

        // 如果条件成立，说明这个任务所需要计算的数值分为足够小了
        // 可以正式进行累加计算了
        if(cnt ==0 ) {
            return 0;
        }
        if(cnt <= MAX ) {
            String inf="开始计算的部分：startValue = " + startValue + ";endValue = " + endValue+";totalcnt="+cnt;
            System.out.println(inf);
            return cnt;
        }
        // 否则再进行任务拆分，拆分成两个任务

            MarkerForkJoin subTask1 = new MarkerForkJoin(startValue, (startValue + endValue) / 2);
            subTask1.fork();
            MarkerForkJoin subTask2 = new MarkerForkJoin((startValue + endValue) / 2 + 1 , endValue);
            subTask2.fork();
            return subTask1.join() + subTask2.join();

    }


    public static void main(String[] args) {

        // 这是Fork/Join框架的线程池
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> taskFuture =  pool.submit(new MarkerForkJoin(1,100000000));
        try {
            long s=System.currentTimeMillis();
            Integer result = taskFuture.get();
            System.out.println("result = " + result+" ;times="+(System.currentTimeMillis()-s)/1000);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace(System.out);
        }
    }
}
