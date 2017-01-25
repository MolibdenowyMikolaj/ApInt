package pl.edu.wat.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.edu.wat.service.UserService;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public @ResponseBody
    String getTime() {

        List<Integer> amount = userService.getAmmount();
        String result = "[" + amount.get(0) + ".0," + (amount.get(1)) + ".0," + (amount.get(2)) + ".0," + (amount.get(3)) + ".0," + (amount.get(4)) + ".0" + "]";
        return result;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getIndexPage() {
        return "UserManagement";
    }

}
