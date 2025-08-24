package com.helloworld.quickstart.controller;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.dto.ResponseItemDto;
import com.helloworld.quickstart.service.QuickService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// RESTful 웹 서비스를 처리하며, 메소드의 반환 값이 HTTP 응답 본문으로 직접 전송.
// => 데이터 반환
@RestController
// 로깅 프레임워크
@Slf4j
public class QuickController {
    // Service 인스턴스(객체) 주입
    // 의존성 주입 => 원래는 생성자 주입으로 해줘야됨.
    @Autowired
    private QuickService quickService;

    // '/dummy' 경로를 get으로 요청할 때 dummy 메서드가 호출됨.
    @GetMapping("/dummy")
    public String dummy(){
        log.info("dummy");
        return "{}";
    }

    // '/dummy2' 경로를 get으로 요청할 때 dummy2 메서드가 호출됨.
    @GetMapping("/dummy2")
    public String dummy2(){
        log.info("dummy2");
        return "dummy2";
    }

    // 파라미터(@RequestParam("변수명"))를 통해 값을 받고 출력
    @GetMapping("/member")
    public String getMember(@RequestParam("empNo") String empNo, @RequestParam("year") int year){
        log.info("empNo: {}", empNo);
        log.info("year: {}", year);
        return "ok";
    }

    // 경로(@PathVariable("변수명"))
    @GetMapping("/company/{id}")
    public String getCompany(@PathVariable("id") String id){
        log.info("id: {}", id);
        return "ok";
    }

    // POST는 주로 클라이언트가 보낸 데이터를 body(HTTP 본문)에 담아 보냄. -> 데이터 생성/수정 요청
    // body(@RequestBody)로 값을 전달.
    @PostMapping("/item")
    public String registerItem(@RequestBody String item){
        log.info("item: {}", item);
        return "ok";
    }

    // body를 json형태(dto 클래스 사용) 값으로 전달 후 json 형태값으로 응답 받기
    @PostMapping("/item2")
    public ResponseItemDto registerItem2(@RequestBody ItemDto itemDto){
        log.info("itemDto: {}", itemDto);

        // new ResponseDto(); -> 커서 갖다대고 alt + enter를 누르면 자동으로 만들어짐.
        ResponseItemDto response = new ResponseItemDto();
        // 응답 message를 "ok"로 설정.
        response.setMessage("ok");
        return response;
    }

    // '/item2'를 모듈화(= 레이어드 아키텍쳐)
    // -> Controller: 클라이언트 요청처리, Service: 비지니스 로직
    @PostMapping("/item3")
    public ResponseItemDto registerItem3(@RequestBody ItemDto itemDto){
        log.info("itemDto2: {}", itemDto);

        ResponseItemDto response = new ResponseItemDto();

        boolean b = quickService.registerItem(itemDto);
        // 성공시
        if(b){
            response.setMessage("ok");
            return response;
        }

        // 실패시
        response.setMessage("fail");
        return response;
    }

    @GetMapping("/item4")
    public ItemDto getItem(@RequestParam("id") String id){
        return quickService.getItemById(id);
    }




}
