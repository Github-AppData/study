package com.example.rubypaper.servlet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/test003Servlet")
public class test003Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder list = new StringBuilder();
        String line;

        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            list.append(line);
        }

        String jsonData = list.toString();
        System.out.println("jsonData : "+jsonData);
        ObjectMapper objectMapper = new ObjectMapper();

        // objectMapper.readTree : JSON 데이터를 'JsonNode' 객체로 변환하는 메서드.
        JsonNode rootNode = objectMapper.readTree(jsonData);

        // JsonNode 객체 데이터를 추출하는 방법
        String name = rootNode.get(0).asText();

        System.out.println("name : "+name);
    }
}