package org.projects.randomchan.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardBean {

    private long id;

    private String name;

    private String description;

    private LocalDateTime timeCreated;
}
