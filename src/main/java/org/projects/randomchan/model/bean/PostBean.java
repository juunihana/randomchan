package org.projects.randomchan.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostBean {

    private long id;

    private ThreadBean thread;

    private String title;

    private String content;

    private boolean threadStarter;

    private LocalDateTime timePosted;
}
