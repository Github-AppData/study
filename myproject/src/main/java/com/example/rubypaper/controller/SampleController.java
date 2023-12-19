package com.example.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("test1")
    public String test01()
    {
        return "test/test1";
    }

    @GetMapping("test2")
    public String test02()
    {
        return "test/test2";
    }

    @GetMapping("test3")
    public String test03()
    {
        return "test/test3";
    }
}