package com.viachaslausviatski.pet_project.controller;

import com.viachaslausviatski.pet_project.entity.Event;
import com.viachaslausviatski.pet_project.entity.User;
import com.viachaslausviatski.pet_project.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {

    private final EventService eventService;

    @GetMapping("/")
    public String allEvents(@RequestParam(name = "searchWord", required = false) String description, Model model,
                            Principal principal) {
        model.addAttribute("events", eventService.listOfEvents(description));
        model.addAttribute("user", eventService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", description);
        return "events";
    }

    @GetMapping("/event/{id}")
    public String eventInfo(@PathVariable Long id, Model model, Principal principal) {
        Event event = eventService.getEventById(id);
        model.addAttribute("user", eventService.getUserByPrincipal(principal));
        model.addAttribute("event", event);
        model.addAttribute("images", event.getImages());
        model.addAttribute("eventAuthor", event.getUser());
        return "event-info";

    }

    @PostMapping("/event/create")
    public String createEvent(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                              @RequestParam("number_of_visitors") int numberOfVisitors,
                              @RequestParam("file3") MultipartFile file3, Event event,
                              Principal principal) throws IOException {
        event.setNumberOfVisitors(numberOfVisitors);
        eventService.saveEvent(principal, event, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/event/delete/{id}")
    public String deleteEvent(@PathVariable Long id, Principal principal) {
        eventService.deleteEvent(eventService.getUserByPrincipal(principal), id);
        return "redirect:/my/events";
    }

    @GetMapping("/my/events")
    public String userEvents(Principal principal, Model model) {
        User user = eventService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        model.addAttribute("events", user.getEvents());
        return "my-events";
    }

    @GetMapping("/static/css/style.css")
    public String css() {
            return"redirect:/";
    }
}