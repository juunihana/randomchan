package org.projects.randomchan.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @ManyToOne
//    private ThreadEntity thread;

    private String title;

    private String content;

    private boolean threadStarter;
}
