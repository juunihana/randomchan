package org.projects.randomchan.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageBean {

    private long id;

    private String path;

    private boolean isNsfw;

    private PostBean post;
}
