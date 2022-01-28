package ru.gb.lesson3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson3.MessageProvider;
import ru.gb.lesson3.entity.Message;
import ru.gb.lesson3.service.MessageService;

@Controller
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;


    //форма создания сообщений
    @RequestMapping(path = "/create",method = RequestMethod.GET)
    public String showSimpleForm(Model model){
        Message message = new Message();
        model.addAttribute("message",message);
        return "create-message";
    }



    // обработчик формы создания и редактирования, /message/edit/{id}
    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public String processForm(Message message){
        if (message.getId() == null){
            messageService.save(message);
        } else {
            messageService.edit(message);
        }
        return "redirect:/message/all"; // ключевое слово перенаправления
    }


    // показать 1 элемент,
    @RequestMapping(path = "/{id}",method = RequestMethod.GET) // localhost:8080/spring/message/{id}?random=true
    public String getMessageById(Model model,
                                 @PathVariable Integer id,
                                 @RequestParam(name = "random", defaultValue = "false",
                                 required = false) Boolean isRandom){
        Message message;
        if (isRandom){
            message = messageService.getRandomMessage();
        } else {
            message = messageService.findById(id);
        }
        model.addAttribute("message",message);
        return "message";
    }
    // показать все элементов,
    @RequestMapping(path = "/all",method = RequestMethod.GET)
    public String getAllMessages(Model model){
        model.addAttribute("messages",messageService.findAll());
        return "message-list";
    }


    // удаление /message/delete/{id}
    @RequestMapping(path = "/delete",method = RequestMethod.GET)
    public String deleteByID(@RequestParam Integer id){
        messageService.deleteByID(id);
        return "redirect:/message/all";
    }

    @RequestMapping(path = "/edit",method = RequestMethod.GET)
    public String editById(Model model,@RequestParam Integer id){
        Message message = messageService.findById(id);
        model.addAttribute("message",message);
        return "create-message";
    }
//    @ModelAttribute("info")
//    public String addAttribute(){
//        return "тра-ла-ла";
//    }
}
