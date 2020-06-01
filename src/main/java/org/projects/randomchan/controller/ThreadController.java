package org.projects.randomchan.controller;

import org.projects.randomchan.model.bean.PostBean;
import org.projects.randomchan.model.bean.ThreadBean;
import org.projects.randomchan.service.PostService;
import org.projects.randomchan.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class ThreadController {

    private final ThreadService threadService;
    private final PostService postService;

    @Autowired
    public ThreadController(ThreadService threadService,
                            PostService postService) {
        this.threadService = threadService;
        this.postService = postService;
    }

    @GetMapping
    public String getThreads(Model model) {
        model.addAttribute("threads", postService.findAll().stream()
                .filter(PostBean::isThreadStarter)
                .collect(Collectors.toList()));
        model.addAttribute("newThread", new PostBean());

        return "threads";
    }

    @PostMapping("newThread")
    public String newThread(@ModelAttribute PostBean postBean) {
        ThreadBean threadBean = new ThreadBean();
        postBean.setThread(threadBean);
        postBean.setThreadStarter(true);
        postBean.setTimePosted(LocalDateTime.now());
        threadService.save(threadBean);
        postService.save(postBean);

        return "redirect:/";
    }

    @GetMapping("thread/{id}")
    public String getThread(@PathVariable("id") long id, Model model) {
        model.addAttribute("posts", postService.findAllByThreadId(id).stream()
                .collect(Collectors.toList()));
        PostBean postBean = new PostBean();
        postBean.setThread(threadService.findById(id));
        model.addAttribute("newPost", postBean);

        return "thread";
    }

    @PostMapping("newPost/{id}")
    public String postToThread(@PathVariable("id") long id,
                               @ModelAttribute PostBean postBean) {
        postBean.setTimePosted(LocalDateTime.now());
        postBean.setThreadStarter(false);
        postBean.setThread(threadService.findById(id));
        postService.save(postBean);

        return "redirect:/thread/" + id;
    }
}
