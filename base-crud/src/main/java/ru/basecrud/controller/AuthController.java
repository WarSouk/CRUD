package ru.basecrud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.view.RedirectView;
import ru.basecrud.dto.AuthDTO;

@Controller
public class AuthController {


    @Value("${api.key}")
    String apiKey;

    @GetMapping(value = "/auth")
    public String getPage(){
        return "auth";
    }

    @PostMapping(value = "auth")
    public RedirectView auth(@ModelAttribute AuthDTO authDTO){
        if(authDTO.getLogin().equals("admin")&& authDTO.getPassword().equals("admin")){
            return new RedirectView("/consumer?apiKey="+apiKey);
        }
        else {
            return null;
        }
    }
}
