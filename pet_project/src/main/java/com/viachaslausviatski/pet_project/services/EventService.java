package com.viachaslausviatski.pet_project.services;

import com.viachaslausviatski.pet_project.entity.Event;
import com.viachaslausviatski.pet_project.entity.Images;
import com.viachaslausviatski.pet_project.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventService {

    @Autowired
    private final EventRepository eventRepository;
    private List<Event> events = new ArrayList<>();


    public List<Event> listOfEvents(String description) {
        List<Event> event = eventRepository.findAll();
        if(description != null) return eventRepository.findByDescription(description);
        return eventRepository.findAll();
    }

    public void saveEvent(Event event, MultipartFile file1, MultipartFile file2,MultipartFile file3) throws IOException {
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

    private Images toImageEntity(MultipartFile file) throws IOException {
        Images image = new Images();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteEvent(Long id){

       eventRepository.deleteById(id);
    }

    public Event getEventById(Long id){

        return eventRepository.findById(id).orElse(null);
    }

}
