package com.example.reactasyncserver2.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// CORS 오류 : Cross Origin resource sharing 줄임말
// 동일한 주소내에서만 리소스를 공유할수 있음.
// 스프링에서는 CORS 허용을 위해서 @CrossOrigin 어노테이션을 사용하여 처리함
// @CrossOrigin 어노테이션을 사용하면 지정한 도메인에 대해서 접근을 허용한다.
// @CrossOrigin 어노테이션은 메소드, 클래스, configurer에 설정할 수 있다.
// 메서드에 사용 시 지정한 메서드만 접근을 허용한다.
// 클래스에 사용 시 지정한 컨트롤러에 대해서만 접근을 허용한다.
// configurer에 사용 시 모든곳에 접근을 허용한다.
// 옵션으로 origins에 접근할 서버의 주소를 입력함
@RequestMapping("/async") // 리퀘스트 매핑을 사용해서 공통으로 사용되는 url를 매핑시킬수 있다.
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4000"})
@RestController // 이 컨트롤러를 사용하면 데이터만 내려주는 컨트롤러가 된다.
public class AsyncServerController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() throws Exception {
        return "index";
    }
    
    // @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value = "/data1", method = RequestMethod.POST)
    public String asyncData1() throws Exception {
        return "서버와 통신 성공";
    }
    
    @RequestMapping(value = "/sendDataGet", method = RequestMethod.GET)
    public Object sendDataGet() throws Exception {
        Map<String, String> result = new HashMap<>();
        result.put("result", "success");
        result.put("data", "");
        
        return result;
    }
    
    @RequestMapping(value = "/sendDataPost", method = RequestMethod.POST)
    public Object sendDataPost(@RequestParam("id") String id, @RequestParam("pw") String pw) throws Exception {
        Map<String, Object> user = new HashMap<>();
        user.put("id", "test1");
        user.put("pw", "asdf1234");
        
        Map<String, Object> result = new HashMap<>();
        result.put("result", "success");
        result.put("data", user);
        
        return result;
    }
    
    @RequestMapping(value = "/sendDataUpdate", method = RequestMethod.PUT)
    public Object sendDataPut(@RequestParam("idx") int idx) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("result", "success");
        return result;
    }
    
    @RequestMapping(value = "/sendDataDelete", method = RequestMethod.DELETE)
    public Object sendDataDelete(@RequestParam("idx") int idx) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("result", "success");
        result.put("idx", idx);
        return result;
    }
}
