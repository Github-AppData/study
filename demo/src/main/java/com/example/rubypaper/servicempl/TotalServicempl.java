package com.example.rubypaper.servicempl;

import com.example.rubypaper.mapper.TotalMapper;
import com.example.rubypaper.service.TotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TotalServicempl implements TotalService {

    @Autowired
    TotalMapper totalMapper;

    @Override
    public List<Map<String, Object>> basicSelect() throws Exception {
        return totalMapper.basicSelect();
    }
}