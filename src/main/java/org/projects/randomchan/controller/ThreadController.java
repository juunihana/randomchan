package org.projects.randomchan.controller;

import org.projects.randomchan.model.bean.BoardBean;
import org.projects.randomchan.model.bean.PostBean;
import org.projects.randomchan.model.bean.ThreadBean;
import org.projects.randomchan.service.BoardService;
import org.projects.randomchan.service.PostService;
import org.projects.randomchan.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class ThreadController {

    private final ThreadService threadService;
    private final PostService postService;
    private final BoardService boardService;

    @Autowired
    public ThreadController(ThreadService threadService,
                            PostService postService,
                            BoardService boardService) {
        this.threadService = threadService;
        this.postService = postService;
        this.boardService = boardService;
    }

    /**
     * Main page
     * TODO move to board controller maybe
     * @return view
     */
    @GetMapping
    public String index() {
        return "index";
    }

    /**
     * Thread list
     * TODO move to board controller maybe
     * @param board board name
     * @param model model
     * @return view
     */
    @GetMapping("/board/{board}")
    public String getThreads(@PathVariable("board") String board,
                             Model model) {
        List<ThreadBean> threadsByBoard = threadService.findAllByBoard(boardService.findByName(board).getId());
        List<PostBean> postsByBoard = new ArrayList<>();
        threadsByBoard.forEach(thread -> postsByBoard.addAll(postService.findAllByThreadId(thread.getId()).stream()
                .filter(PostBean::isThreadStarter)
                .collect(Collectors.toList())));
        model.addAttribute("threads", postsByBoard);
        model.addAttribute("newThread", new PostBean());
        model.addAttribute("board", boardService.findByName(board));

        return "board/threads";
    }

    /**
     * Create new thread on board
     * @param board board
     * @param postBean OP message
     * @return view
     */
    @PostMapping("/newThread")
    public String newThread(@ModelAttribute("board") String board,
            @ModelAttribute PostBean postBean) {
        ThreadBean threadBean = new ThreadBean();
        threadBean.setBoard(boardService.findByName(board));
        postBean.setThread(threadBean);
        postBean.setThreadStarter(true);
        postBean.setTimePosted(LocalDateTime.now());
        long threadId = postService.save(postBean).getThread().getId();

        return "redirect:/" + board + "/" + threadId;
    }

    /**
     * Particular thread on board
     * @param id thread id
     * @param model model
     * @return view
     */
    @GetMapping("/board/{board}/{id}")
    public String getThread(@PathVariable("board") String board,
                            @PathVariable("id") long id,
                            Model model) {
        model.addAttribute("posts", postService.findAllByThreadId(id));
        model.addAttribute("newPost", new PostBean());
        model.addAttribute("board", boardService.findByName(board));
        model.addAttribute("threadId", threadService.findById(id).getId());

        return "board/thread/thread";
    }

    /**
     * Post message to thread
     * @param postBean message
     * @param threadId thread id
     * @return view
     */
    @PostMapping("/newPost")
    public String postToThread(@ModelAttribute PostBean postBean,
                               @ModelAttribute("board") BoardBean board,
                               @ModelAttribute("threadId") long threadId) {
        postBean.setTimePosted(LocalDateTime.now());
        postBean.setThreadStarter(false);
        postBean.setThread(threadService.findById(threadId));
        postService.save(postBean);

        return "redirect:/" + board.getName() + "/" + threadId;
    }
}
