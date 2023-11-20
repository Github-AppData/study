package com.example.rubypaper.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TotalMapper
{
    public List<Map<String, Object>> basicSelect() throws Exception;
}