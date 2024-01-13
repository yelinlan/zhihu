/**
  * Copyright 2023 bejson.com 
  */
package com.yll.zhihu.bean;

/**
 * Auto-generated: 2023-12-06 21:22:46
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Data {

    private String id;
    private String type;
    private int offset;
    private String verb;
    private long created_time;
    private long updated_time;
    private Target target;
    private String brief;
    private String attached_info;
    private boolean action_card;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setOffset(int offset) {
         this.offset = offset;
     }
     public int getOffset() {
         return offset;
     }

    public void setVerb(String verb) {
         this.verb = verb;
     }
     public String getVerb() {
         return verb;
     }

    public void setCreated_time(long created_time) {
         this.created_time = created_time;
     }
     public long getCreated_time() {
         return created_time;
     }

    public void setUpdated_time(long updated_time) {
         this.updated_time = updated_time;
     }
     public long getUpdated_time() {
         return updated_time;
     }

    public void setTarget(Target target) {
         this.target = target;
     }
     public Target getTarget() {
         return target;
     }

    public void setBrief(String brief) {
         this.brief = brief;
     }
     public String getBrief() {
         return brief;
     }

    public void setAttached_info(String attached_info) {
         this.attached_info = attached_info;
     }
     public String getAttached_info() {
         return attached_info;
     }

    public void setAction_card(boolean action_card) {
         this.action_card = action_card;
     }
     public boolean getAction_card() {
         return action_card;
     }

}