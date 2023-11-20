package com.example.rubypaper.controller;

import com.example.rubypaper.service.TotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class SampleController3 {

    @Autowired
    TotalService totalService;

    @GetMapping("/001")
    public String my001(Model model)
    {
        List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();

        try {
            userList = totalService.basicSelect();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("userList = " + userList);

        model.addAttribute("list", userList);
        return "001";
    }
}