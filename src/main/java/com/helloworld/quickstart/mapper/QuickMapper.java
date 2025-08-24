package com.helloworld.quickstart.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

// @Mapper를 통해 .xml파일에 있는 쿼리문 실행이 됨.
@Mapper
public interface QuickMapper {
    // Id를 통해 조회한 결과값을 HashMap으로 가져옴.
    HashMap<String, Object> findById(HashMap<String, Object> paramMap);

    void registerItem(HashMap<String, Object> paramMap);
}
