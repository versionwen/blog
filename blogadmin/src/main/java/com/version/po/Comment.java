package com.version.po;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author version
 * @version 1.0
 * @date 2020/3/24 17:52
 */
@Data
@Entity
@Table(name = "t_Comment")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creatTime;
    @ManyToOne
    private Blog blog;
    @OneToMany(mappedBy = "parentComment")
    private List<Comment>replyComment=new ArrayList<>();
    @ManyToOne
    private Comment parentComment;
}
