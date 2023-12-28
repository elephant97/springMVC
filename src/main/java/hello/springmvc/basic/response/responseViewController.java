package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class responseViewController {
    @RequestMapping("/response-view-v1")
    public ModelAndView responseV1(){
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data","hello");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseV1(Model model){
        model.addAttribute("data","hello");
        return "response/hello";
    }

    @RequestMapping("/response/hello")
    public void responseV3(Model model){
        model.addAttribute("data","hello");
    }

}
