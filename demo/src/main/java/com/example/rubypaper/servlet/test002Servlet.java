package com.example.rubypaper.servlet;

import com.example.rubypaper.service.TotalService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/test002Servlet")
public class test002Servlet extends HttpServlet {

    @Autowired
    TotalService totalService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 자바 객체
        List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();

        try {
            userList = totalService.basicSelect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("userList = " + userList);
        System.out.println(userList.getClass().getName());

        // ObjectMapper : 자바 객체와 JSON 데이터 간의 변환을 담당
        ObjectMapper objectMapper = new ObjectMapper();

        // userListStr : userList를 직렬화 한 String
        // objectMapper.writeValueAsString : 자바 객체를 JSON 문자열로 ! [{ }] - 직렬화
        String userListStr = objectMapper.writeValueAsString(userList);

        // TypeReference : 제네릭 타입 정보를 유지 하면서도, 객체를 역직렬화 할 수 있게 도와주는 도구이다.
        // 역 직렬화란 ? : 데이터를 직렬화 (객체나 데이터 구조를 유지한 상태에서, 바이트로 변환하는 과정 - 네트워크 전송을 편이하게)한 상태에서 다시 원래의 객체로 변환하는 과정
        // - 프로그램이나 언어에서 사용할 수 있는 형태로 변환하는 작
        List<Map<String, Object>> OuserList = objectMapper.readValue(userListStr, new TypeReference<List<Map<String, Object>>>() {});

        // List<Map<String, Object>> 에서 데이터를 꺼내오는 법.
        // 1. List, Map이 섞인 객체이기 때문에 꺼내는 방식도, List index를 먼저 접근 한 뒤에,
        // 2. Map의 프로퍼티를 이용해서 데이터를 꺼낸다.
        String name = OuserList.get(0).get("name").toString();
        System.out.println("name : "+ name);

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(userListStr); // - 클라이언트에게는 직렬화 된 것을 보낸다.
    }
}