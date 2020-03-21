package com.jpa.springjpademo.entity;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "notes_table")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid") // 这个是hibernate的注解/生成32位UUID
public class Notes {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "notes_id", nullable = false, length = 32)
    private String notes_id;

    // 默认创建时间
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date time;

    // 默认更新时间
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date update_time;

    @Column(name = "title", nullable = true, length = 100)
    private String title;

    @Column(name = "description", nullable = true, length = 255)
    private String description;

    @Column(name = "content", nullable = true)
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String content;

    @Column(name = "author", nullable = true, length = 50)
    private String author;

    public String getId() {
        return notes_id;
    }

    public void setId(String notes_id) {
        this.notes_id = notes_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setUpdateTime(Date update_time) {
        this.update_time = update_time;
    }

    public Date getUpdateTime() {
        return update_time;
    }
}