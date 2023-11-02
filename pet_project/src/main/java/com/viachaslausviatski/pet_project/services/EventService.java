package com.viachaslausviatski.pet_project.services;

import com.viachaslausviatski.pet_project.entity.Event;
import com.viachaslausviatski.pet_project.entity.Images;
import com.viachaslausviatski.pet_project.entity.User;
import com.viachaslausviatski.pet_project.repositories.EventRepository;
import com.viachaslausviatski.pet_project.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    private final UserRepository userRepository;
    private List<Event> events = new ArrayList<>();


    public List<Event> listOfEvents(String description) {
        if (description != null) return eventRepository.findByDescription(description);
        return eventRepository.findAll();
    }

    public void saveEvent(Principal principal, Event event, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        event.setUser(getUserByPrincipal(principal));
        Images image1;
        Images image2;
        Images image3;
        if(file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            event.addImageToEvent(image1);
        }
        if(file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            event.addImageToEvent(image2);
        }
        if(file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            event.addImageToEvent(image3);
        }
        log.info("Saving new Event. Description: {}; Name: {} ",event.getDescription(),event.getName());
        Event eventFromDB = eventRepository.save(event);
        eventFromDB.setPreviewImageId(eventFromDB.getImages().get(0).getId());
        eventRepository.save(event);
    }
    public User getUserByPrincipal(Principal principal)
    {
        if(principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    private Images toImageEntity(MultipartFile file) throws IOException {
        Images image = new Images();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteEvent(User user, Long id) {
        Event event = eventRepository.findById(id)
                .orElse(null);
        if (event != null) {
            if (event.getUser().getId().equals(user.getId())) {
                eventRepository.delete(event);
                log.info("Event with id = {} was deleted", id);
            } else {
                log.error("User: {} haven't this event with id = {}", user.getEmail(), id);
            }
        } else {
            log.error("Event with id = {} is not found", id);
        }    }

    public Event getEventById(Long id){

        return eventRepository.findById(id).orElse(null);
    }

}
