package com.version.po;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author version
 * @version 1.0
 * @date 2020/3/24 17:35
 */
@Data
@Table(name="t_blog")
@Entity
public class Blog {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Type type;
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag>tags=new ArrayList<>();
    private String title;
    private String content;
    private String firstPicture;
    private String flag;
    private Integer view;
    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentabled;
    private boolean published;
    private boolean recommend;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creatTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @ManyToOne()
    private User user;
    @OneToMany(mappedBy = "blog")
    private List<Comment>comments=new ArrayList<>();
}
