package org.projects.randomchan.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tags")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tag_name")
    private String name;

    private String description;

    @ManyToOne(cascade = {CascadeType.ALL})
    private BoardEntity board;
}
