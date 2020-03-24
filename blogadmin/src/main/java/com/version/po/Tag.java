package com.version.po;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author version
 * @version 1.0
 * @date 2020/3/24 17:50
 */
@Entity
@Table(name = "t_Tag")
@Data
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "tags")
    private List<Blog>blogs=new ArrayList<>();
}
