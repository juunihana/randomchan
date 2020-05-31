package org.projects.randomchan.controller;

import org.projects.randomchan.model.bean.PostBean;
import org.projects.randomchan.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class ThreadController {

    private final PostService postService;

    @Autowired
    public ThreadController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String getThreads(Model model) {
        model.addAttribute("threads", postService.findAll().stream()
                .filter(PostBean::isThreadStarter)
                .collect(Collectors.toList()));

        return "threads";
    }
}
