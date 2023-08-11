package study.ajax.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import study.ajax.dto.AjaxDto;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AjaxController {

    @GetMapping("/ex01")
    public String ex01(){
        System.out.println("AjaxController.ex01");
        // index.html에 작성된 내용을 가져다가 호출된 화면쪽으로 텍스트를 긁어왔다는 의미.
        return "index";
    }

    @PostMapping("/ex02")
    public @ResponseBody String ex02(){
        System.out.println("AjaxController.ex02");
        return "index"; // 리턴값이 그대로 출력됨. 즉, return하는 값을 body에다가 실어서 보내줌
    }

    @GetMapping("/ex03")
    public @ResponseBody String ex03(@RequestParam("param1") String param1,
                                     @RequestParam("param2") String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        return "ex03메서드 호출완료";

    }

    @PostMapping("/ex04")
    public @ResponseBody String ex04(@RequestParam("param1") String param1,
                                       @RequestParam("param2") String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        return "ex04 메서드 호출 완료";

    }

    @GetMapping("/ex05")
    public @ResponseBody AjaxDto ex05(@ModelAttribute AjaxDto ajaxDto){
        System.out.println("ajaxDto = " + ajaxDto);
        return ajaxDto;
    }

    @PostMapping("/ex06")
    public @ResponseBody AjaxDto ex06(@ModelAttribute AjaxDto ajaxDto){
        System.out.println("ajaxDto = " + ajaxDto);
        return ajaxDto;
    }

    @PostMapping("/ex07")
    public @ResponseBody AjaxDto ex07(@RequestBody AjaxDto ajaxDto){
        System.out.println("ajaxDto = " + ajaxDto);
        return ajaxDto;
    }

    private List<AjaxDto> DtoList(){
        List<AjaxDto> dtoList = new ArrayList<>();
        dtoList.add(new AjaxDto("data1", "data11"));
        dtoList.add(new AjaxDto("data2", "data22"));
        return dtoList;
    }

    @PostMapping("/ex08")
    public @ResponseBody List<AjaxDto> ex08(@RequestBody AjaxDto ajaxDto){
        System.out.println("ajaxDto = " + ajaxDto);
        List<AjaxDto> dtoList = DtoList();
        dtoList.add(ajaxDto);
        return dtoList;
    }

    // ResponseBody -> data만 리턴을 준다.
    // ResponseEntity -> body 뿐 아니라 header 부분에 대한 정보들

    @PostMapping("/ex09")
    public ResponseEntity ex09(@RequestBody AjaxDto ajaxDto){
        System.out.println("ajaxDto = " + ajaxDto);

        // data는 리턴하는게 아니라 status code만 리턴함
        return new ResponseEntity<>(ajaxDto, HttpStatus.OK);
    }

    @PostMapping("/ex10")
    public ResponseEntity ex10(@RequestBody AjaxDto ajaxDto){
        System.out.println("ajaxDto = " + ajaxDto);

        List<AjaxDto> dtoList = DtoList();
        dtoList.add(ajaxDto);
        // data는 리턴하는게 아니라 status code만 리턴함
        return new ResponseEntity<>(dtoList , HttpStatus.OK);
    }
}
