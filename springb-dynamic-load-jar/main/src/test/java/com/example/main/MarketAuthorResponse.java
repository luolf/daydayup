package com.example.main;

import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: luolifeng
 * Date: 2020-11-16 10:47
 */
@lombok.Data
@NoArgsConstructor
public class MarketAuthorResponse {


        private String msg;
        private int code;
        private Data data;

    @lombok.Data
    @NoArgsConstructor
    public static class Data {
        private Pagination pagination;
        private List<Author> authors;
    }
    @lombok.Data
    @NoArgsConstructor
    public static class Pagination {
        private int total_count;
        private int limit;
        private int page;
    }
    @lombok.Data
    public static class Author {

        private int status;
        private int avg_views;
        private AudienceProfile audience_profile;
        private String nick_name;
        private int reach;
        private String brief;
        private long id;
        private int e_cart;
        private String region;
        private long core_user_id;
    }
    @lombok.Data
    public static class AudienceProfile {
        private MaxDistribution gender;
        private MaxDistribution age;
        private MaxDistribution region;
    }
    @lombok.Data
    public static class MaxDistribution {
        private double max_ratio;
        private String max_distribution;
    }
}
