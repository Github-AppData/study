package com.example.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SampleController {

    @GetMapping("/001")
    public String my001()
    {
        return "001";
    }

}