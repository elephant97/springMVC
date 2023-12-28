package hello.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class requestBodyJsonController {
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("request-body-json-v1")
    public void requstBodyJsonV1(HttpServletResponse response, HttpServletRequest request) throws IOException{
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}",messageBody);

        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("usernaem={}, age ={}",helloData.getUsername(),helloData.getAge());

        response.getWriter().write("ok");
    }

    @ResponseBody
    @PostMapping("request-body-json-v2")
    public String requstBodyJsonV2(@RequestBody String messageBody) throws IOException{

        log.info("messageBody={}",messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("usernaem={}, age ={}",helloData.getUsername(),helloData.getAge());

        return "ok";
    }

    @ResponseBody
    @PostMapping("request-body-json-v3")
    public String requstBodyJsonV3(@RequestBody HelloData helloData) {

        log.info("usernaem={}, age ={}",helloData.getUsername(),helloData.getAge());

        return "ok";
    }

    @ResponseBody
    @PostMapping("request-body-json-v4")
    public String requstBodyJsonV4(HttpEntity<HelloData> data){
        HelloData helloData = data.getBody();
        log.info("usernaem={}, age ={}",helloData.getUsername(),helloData.getAge());

        return "ok";
    }

    @ResponseBody
    @PostMapping("request-body-json-v5")
    public HelloData requstBodyJsonV5(@RequestBody HelloData data){
        log.info("usernaem={}, age ={}",data.getUsername(),data.getAge());

        return data;
    }

}
