package org.projects.randomchan.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThreadBean {

    private long id;

    private BoardBean board;

    private TagBean tag;
}
