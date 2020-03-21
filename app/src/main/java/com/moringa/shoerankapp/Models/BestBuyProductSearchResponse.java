package com.moringa.shoerankapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BestBuyProductSearchResponse {

    @SerializedName("from")
    @Expose
    private Integer from;
    @SerializedName("to")
    @Expose
    private Integer to;
    @SerializedName("currentPage")
    @Expose
    private Integer currentPage;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("totalPages")
    @Expose
    private Integer totalPages;
    @SerializedName("queryTime")
    @Expose
    private String queryTime;
    @SerializedName("totalTime")
    @Expose
    private String totalTime;
    @SerializedName("partial")
    @Expose
    private Boolean partial;
    @SerializedName("canonicalUrl")
    @Expose
    private String canonicalUrl;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public BestBuyProductSearchResponse() {
    }

    /**
     *
     * @param total
     * @param canonicalUrl
     * @param totalTime
     * @param totalPages
     * @param queryTime
     * @param from
     * @param to
     * @param currentPage
     * @param partial
     * @param products
     */
    public BestBuyProductSearchResponse(Integer from, Integer to, Integer currentPage, Integer total, Integer totalPages, String queryTime, String totalTime, Boolean partial, String canonicalUrl, List<Product> products) {
        super();
        this.from = from;
        this.to = to;
        this.currentPage = currentPage;
        this.total = total;
        this.totalPages = totalPages;
        this.queryTime = queryTime;
        this.totalTime = totalTime;
        this.partial = partial;
        this.canonicalUrl = canonicalUrl;
        this.products = products;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public String getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(String queryTime) {
        this.queryTime = queryTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public Boolean getPartial() {
        return partial;
    }

    public void setPartial(Boolean partial) {
        this.partial = partial;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static class Product {
        @SerializedName("sku")
        @Expose
        private Integer sku;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("salePrice")
        @Expose
        private double salePrice;
        @SerializedName("image")
        @Expose
        private String image;

        /**
         * No args constructor for use in serialization
         *
         */
        public Product() {
        }

        /**
         *
         * @param image
         * @param salePrice
         * @param name
         * @param sku
         * @param type
         */
        public Product(Integer sku, String name, String type, double salePrice, String image) {
            super();
            this.sku = sku;
            this.name = name;
            this.type = type;
            this.salePrice = salePrice;
            this.image = image;
        }

        public Integer getSku() {
            return sku;
        }

        public void setSku(Integer sku) {
            this.sku = sku;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getSalePrice() {
            return salePrice;
        }

        public void setSalePrice(double salePrice) {
            this.salePrice = salePrice;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

    }
}

