package com.helloworld.quickstart.service;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.entity.ItemEntity;
import com.helloworld.quickstart.mapper.QuickMapper;
import com.helloworld.quickstart.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

// 비지니스 로직 관리
@Service
@Slf4j
public class QuickService {

    @Autowired
    private QuickMapper quickMapper;

    @Autowired
    private ItemRepository itemRepository;

    // MyBatis와 JPA 주요 차이점
    /* MyBatis
        - XML 또는 어노테이션에 직접 작성하는 매퍼 기반 접근 방식
        - SQL 쿼리를 직접 작성함.
    */
    /* JPA
        - 엔티티와 리포지토리를 통해 겍체 지향적으로 데이터에 접근
        => 객체 중심으로 데이터에 접근
    */

    public boolean registerItem(ItemDto itemDto){
        // TODO: DB insert
        // MyBatis 버전
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", itemDto.getId());
//        paramMap.put("name", itemDto.getName());
//
//        quickMapper.registerItem(paramMap);

        // JPA 버전
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());

        itemRepository.save(itemEntity);

//        log.info("Service...");
        return true;
    }

    public ItemDto getItemById(String id){

        // Mybatis 버전
//        HashMap<String, Object> paramMap = new HashMap<>();
//        // id값을 넣음.
//        paramMap.put("id", id);
//
//        HashMap<String, Object> response = quickMapper.findById(paramMap);
//
//        ItemDto itemDto = new ItemDto();
//        itemDto.setId((String)response.get("ID"));
//        itemDto.setName((String)response.get("NAME"));
//
//        return itemDto;

        ItemEntity itemEntity = itemRepository.findById(id).get();

        ItemDto itemDto = new ItemDto();
        itemDto.setId(itemEntity.getId());
        itemDto.setName(itemEntity.getName());

        return itemDto;

    }
}
