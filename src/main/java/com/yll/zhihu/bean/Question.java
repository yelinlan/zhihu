/**
  * Copyright 2023 bejson.com 
  */
package com.yll.zhihu.bean;
import java.util.List;

/**
 * Auto-generated: 2023-12-06 21:22:46
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Question {

    private long id;
    private String type;
    private String url;
    private Author author;
    private String title;
    private long created;
    private int answer_count;
    private int follower_count;
    private int comment_count;
    private List<Integer> bound_topic_ids;
    private boolean is_following;
    private String excerpt;
    private Relationship relationship;
    private String detail;
    private String question_type;
    public void setId(long id) {
         this.id = id;
     }
     public long getId() {
         return id;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setUrl(String url) {
         this.url = url;
     }
     public String getUrl() {
         return url;
     }

    public void setAuthor(Author author) {
         this.author = author;
     }
     public Author getAuthor() {
         return author;
     }

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setCreated(long created) {
         this.created = created;
     }
     public long getCreated() {
         return created;
     }

    public void setAnswer_count(int answer_count) {
         this.answer_count = answer_count;
     }
     public int getAnswer_count() {
         return answer_count;
     }

    public void setFollower_count(int follower_count) {
         this.follower_count = follower_count;
     }
     public int getFollower_count() {
         return follower_count;
     }

    public void setComment_count(int comment_count) {
         this.comment_count = comment_count;
     }
     public int getComment_count() {
         return comment_count;
     }

    public void setBound_topic_ids(List<Integer> bound_topic_ids) {
         this.bound_topic_ids = bound_topic_ids;
     }
     public List<Integer> getBound_topic_ids() {
         return bound_topic_ids;
     }

    public void setIs_following(boolean is_following) {
         this.is_following = is_following;
     }
     public boolean getIs_following() {
         return is_following;
     }

    public void setExcerpt(String excerpt) {
         this.excerpt = excerpt;
     }
     public String getExcerpt() {
         return excerpt;
     }

    public void setRelationship(Relationship relationship) {
         this.relationship = relationship;
     }
     public Relationship getRelationship() {
         return relationship;
     }

    public void setDetail(String detail) {
         this.detail = detail;
     }
     public String getDetail() {
         return detail;
     }

    public void setQuestion_type(String question_type) {
         this.question_type = question_type;
     }
     public String getQuestion_type() {
         return question_type;
     }

}