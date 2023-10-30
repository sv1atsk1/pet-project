package com.viachaslausviatski.pet_project.controller;

import com.viachaslausviatski.pet_project.entity.Event;
import com.viachaslausviatski.pet_project.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {

    private final EventService eventService;

    @GetMapping ("/")
    public String allEvents(@RequestParam(name = "description",required = false) String decsription, Model model) {
        model.addAttribute("events",eventService.listOfEvents(decsription));
        return "events";
    }

    @GetMapping("/event/{id}")
    public String eventInfo(@PathVariable Long id, Model model){
        Event event = eventService.getEventById(id);
        model.addAttribute("event",event);
        model.addAttribute("images",event.getImages());
        return "event-info";

    }

    @PostMapping("/event/create")
    public String createEvent(@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2,
                              @RequestParam("file3") MultipartFile file3,Event event) throws IOException {
        eventService.saveEvent(event,file1,file2,file3);
        return "redirect:/";
    }

    @PostMapping("/event/delete/{id}")
    public String deleteEvent(@PathVariable Long id){
        eventService.deleteEvent(id);
        return "redirect:/";
    }

}
