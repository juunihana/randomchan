package org.projects.randomchan.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagBean {

    private long id;

    private String name;

    private String description;

    private BoardBean board;
}
