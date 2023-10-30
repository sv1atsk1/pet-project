//package com.viachaslausviatski.pet_project.entity;
//
////import jakarta.persistence.*;
//import java.sql.Timestamp;
//import java.util.List;
//
////@Entity
////@Table(name = "request")
//public class Request {
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    @Column(name = "id")
//    private int id;
//
////    @Column(name = "name_of_object")
//    private String nameOfObject;
//
////    @Column(name = "start_date")
//    private Timestamp startDate;
//
////    @Column(name = "name_of_event")
//    private String nameOfEvent;
//
////    @Column(name = "type_of_event")
//    private String typeOfEvent;
//
////    @Column(name = "full_name_of_user")
//    private String fullNameOfUser;
//
////    @OneToOne(mappedBy = "request")
//    private Event event;
//
////    @ManyToMany(mappedBy = "requests")
//    private List<Object> objects;
//
//    public Request() {
//    }
//
//    public Request(String nameOfObject, Timestamp startDate, String nameOfEvent, String typeOfEvent, String fullNameOfUser,
//                   Event event,List<Object> objects) {
//        this.nameOfObject = nameOfObject;
//        this.startDate = startDate;
//        this.nameOfEvent = nameOfEvent;
//        this.typeOfEvent = typeOfEvent;
//        this.fullNameOfUser = fullNameOfUser;
//        this.event = event;
//        this.objects = objects;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getNameOfObject() {
//        return nameOfObject;
//    }
//
//    public void setNameOfObject(String nameOfObject) {
//        this.nameOfObject = nameOfObject;
//    }
//
//    public Timestamp getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Timestamp startDate) {
//        this.startDate = startDate;
//    }
//
//    public String getNameOfEvent() {
//        return nameOfEvent;
//    }
//
//    public void setNameOfEvent(String nameOfEvent) {
//        this.nameOfEvent = nameOfEvent;
//    }
//
//    public String getTypeOfEvent() {
//        return typeOfEvent;
//    }
//
//    public void setTypeOfEvent(String typeOfEvent) {
//        this.typeOfEvent = typeOfEvent;
//    }
//
//    public String getFullNameOfUser() {
//        return fullNameOfUser;
//    }
//
//    public void setFullNameOfUser(String fullNameOfUser) {
//        this.fullNameOfUser = fullNameOfUser;
//    }
//
//    public Event getEvent() {
//        return event;
//    }
//
//    public void setEvent(Event event) {
//        this.event = event;
//    }
//
//    public List<Object> getObjects() {
//        return objects;
//    }
//
//    public void setObjects(List<Object> objects) {
//        this.objects = objects;
//    }
//
//    @Override
//    public String toString() {
//        return "Request{" +
//                "id=" + id +
//                ", nameOfObject='" + nameOfObject + '\'' +
//                ", startDate=" + startDate +
//                ", nameOfEvent='" + nameOfEvent + '\'' +
//                ", typeOfEvent='" + typeOfEvent + '\'' +
//                ", fullNameOfUser='" + fullNameOfUser + '\'' +
//                ", event=" + event +
//                ", objects=" + objects +
//                '}';
//    }
//}
