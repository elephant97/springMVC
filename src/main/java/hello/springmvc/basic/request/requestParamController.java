package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class requestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username ={}, age ={}",username,age);

        response.getWriter().write("ok");
    }


    @RequestMapping("/request-param-v2")
    @ResponseBody
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge){
        log.info("username ={}, age ={}",memberName,memberAge);

        return "OK";
    }

    @RequestMapping("/request-param-v3")
    @ResponseBody
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age){
        log.info("username ={}, age ={}",username,age);

        return "OK";
    }

    @RequestMapping("/request-param-v4")
    @ResponseBody
    public String requestParamV4(String username, int age){
        log.info("username ={}, age ={}",username,age);

        return "OK";
    }

    @RequestMapping("/request-param-required")
    @ResponseBody
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age) // required를 통해 필수 파라미터를 조절 할 수 있음
    {
        log.info("username ={}, age ={}",username,age);

        return "OK";
    }

    @RequestMapping("/request-param-default")
    @ResponseBody
    public String requestParamDefualt(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") Integer age) // required를 통해 필수 파라미터를 조절 할 수 있음
    {
        log.info("username ={}, age ={}",username,age);

        return "OK";
    }

    @RequestMapping("/request-param-map")
    @ResponseBody
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) // required를 통해 필수 파라미터를 조절 할 수 있음
    {
        log.info("username ={}, age ={}",paramMap.get("username"),paramMap.get("age"));

        return "OK";
    }

    @RequestMapping("/model-attribute-v1")
    @ResponseBody
    public String modelAttributeV1(@ModelAttribute HelloData helloData) // required를 통해 필수 파라미터를 조절 할 수 있음
    {
        log.info("username ={}, age ={}",helloData.getUsername(), helloData.getAge());
        return "OK";
    }

    @RequestMapping("/model-attribute-v2")
    @ResponseBody
    public String modelAttributeV2(HelloData helloData) // required를 통해 필수 파라미터를 조절 할 수 있음
    {
        log.info("username ={}, age ={}",helloData.getUsername(), helloData.getAge());
        return "OK";
    }

}
