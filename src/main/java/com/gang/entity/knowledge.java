package com.gang.entity;

/**
 * Created by 吕港 on 2018/2/11.
 */
public class knowledge {

    private String id;
    private String title;
    private String relation;
    private String tag;
    private String summary;

    public knowledge(){}

    public knowledge(String id, String title, String relation, String tag, String summary) {
        this.id = id;
        this.title = title;
        this.relation = relation;
        this.tag = tag;
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id +
                ", title='" + title + '\'' +
                ", relation=" + relation +
                ", tag=" + tag +
                ", summary" + summary + '}';
    }

}
