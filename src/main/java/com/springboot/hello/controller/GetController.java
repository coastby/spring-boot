package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/get-api")
@Slf4j
public class GetController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        log.info("hello로 요청이 들어왔습니다.");
        return "Hello World";
    }
    @GetMapping(value = "/name")
    public String getName(){
        return "Hoon";
    }
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        log.info("getVariable1로 요청이 들어왔습니다. variable : {}", variable);
        return variable;
    }
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    //10월 27일 실습
    @GetMapping(value = "/request1")
    public String getRequestParam(@RequestParam String name, @RequestParam String email, @RequestParam String organization){
        return String.format("%s %s %s", name, email, organization);
    }
    @GetMapping(value = "/request2")
    public String getRequestParam2 (@RequestParam Map<String, String> param){
        param.entrySet().forEach((map) -> {
            System.out.printf("key : %s, value : %s\n", map.getKey(), map.getValue());
        });
        return "호출이 완료되었습니다.";
    }
    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }

}
