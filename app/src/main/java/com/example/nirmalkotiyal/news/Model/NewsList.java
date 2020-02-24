
package com.example.nirmalkotiyal.news.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsList {

    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;
    @SerializedName("articleCount")
    @Expose
    private Integer articleCount;
    @SerializedName("articles")
    @Expose
    private List<Article> articles = null;

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

}
