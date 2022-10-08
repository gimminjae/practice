package com.example.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/page1")
    public String page1() {
        return "page1";
    }
    @GetMapping("/page2")
    public String page2() {
        return "page2";
    }
    @GetMapping("/page3")
    public String page3() {
        return "page3";
    }
    @GetMapping("/article/list")
    public String list(Model model) {
        List<Article> articleList = new LinkedList<>();
        for(long i = 1; i <= 10; i++) {
            articleList.add(new Article(i, i + "번째 제목", i + "번째 내용", LocalDateTime.now()));
        }
        model.addAttribute("articleList", articleList);
        return "article_list";
    }

    @GetMapping("/ajax")
    public String ajaxTest() {
        return "ajax_test";
    }
    @GetMapping("/ajax/test")
    @ResponseBody
    public String getAjaxTest(@RequestParam("testNum") long testNum, @RequestParam("testString") String testString) {
        String result = String.valueOf(testNum) + testString;
        return result;
    }
    @GetMapping("/test1")
    public String test1(Model model) {
        Article article = new Article(1L, "파이썬 vs 자바", "파이썬과 자바 중 어떤 언어가 코딩테스트에 유리할까?", LocalDateTime.now());
        model.addAttribute("article", article);
        return "article_detail";
    }
    @GetMapping("/map1")
    public String map1() {
        return "map1";
    }
}
