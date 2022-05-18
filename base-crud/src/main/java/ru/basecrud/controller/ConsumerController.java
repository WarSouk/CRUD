package ru.basecrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.basecrud.dto.ConsumerDTO;
import ru.basecrud.service.ConsumerService;


@Controller
@RequestMapping(value = "consumer")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;


    @Value("${api.key}")
    String key;

    @GetMapping
    public String getList(@RequestParam String apiKey,Model model){
        if(apiKey.equals(key)){
            model.addAttribute("consumers",consumerService.getUserList());
            return "index";
        }
        return "403";
    }

    @GetMapping(value = "create-user-page")
    public String createUserPage(@RequestParam String apiKey,Model model){
        if(apiKey.equals(key)){
            return "createUserPage";
        }
        return "403";
    }


    @GetMapping(value = "update-user-page/{id}")
    public String updateUserPage(@RequestParam String apiKey, Model model, @PathVariable String id){
        if(apiKey.equals(key)){
            return "updateUserPage";
        }
        return "403";
    }


    @PostMapping
    public RedirectView createUserRequest(@RequestBody ConsumerDTO consumerDTO){
        consumerService.createUser(consumerDTO);
        return new RedirectView("/consumer?apiKey="+key);
    }


    @PostMapping(value = "/update/{id}")
    public RedirectView updateUserRequest(@RequestBody ConsumerDTO consumerDTO, @PathVariable Long id){
        consumerService.updateUser(consumerDTO,id);
        return new RedirectView("/consumer?apiKey="+key);
    }


    @PostMapping("remove/{id}")
    public RedirectView removeUser(@PathVariable Long id){
        consumerService.removeUser(id);
        return new RedirectView("/consumer?apiKey="+key);
    }

}
