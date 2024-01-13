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
public class JsonRootBean {

    private List<Data> data;
    private Paging paging;
    private String fresh_text;
    public void setData(List<Data> data) {
         this.data = data;
     }
     public List<Data> getData() {
         return data;
     }

    public void setPaging(Paging paging) {
         this.paging = paging;
     }
     public Paging getPaging() {
         return paging;
     }

    public void setFresh_text(String fresh_text) {
         this.fresh_text = fresh_text;
     }
     public String getFresh_text() {
         return fresh_text;
     }

}