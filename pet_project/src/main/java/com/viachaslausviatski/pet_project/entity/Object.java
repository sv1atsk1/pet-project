//package com.viachaslausviatski.pet_project.entity;
//
//import jakarta.persistence.*;
//import java.security.Timestamp;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//
//@Entity
//@Table(name = "object")
//public class Object {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "number_of_seats")
//    private int numberOfSeats;
//
//    @Column(name = "address")
//    private String address;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "type")
//    private String type;
//
//    @ManyToOne
//    @JoinColumn(name = "owner_id")
//    private OwnerInformation owner;
//
//    @Column(name = "opening_date")
//    private Date openingDate;
//
//    @Column(name = "work_status")
//    private Timestamp workStatus;
//
//    @Column(name = "popularity")
//    private int popularity;
//
//    @ManyToMany
//    @JoinTable(
//            name = "eventObject",
//            joinColumns = @JoinColumn(name = "object_id"),
//            inverseJoinColumns = @JoinColumn(name = "request_id")
//    )
//    private List<Request> requests = new ArrayList<>();
//
//    @ManyToOne
//    @JoinColumn(name = "event_id")
//    private Event event;
//
//    public Object() {
//    }
//
//    public Object(int numberOfSeats, String address, String name, String type, OwnerInformation owner,
//                  Date openingDate, Timestamp workStatus, int popularity, List<Request> requests, Event event) {
//        this.numberOfSeats = numberOfSeats;
//        this.address = address;
//        this.name = name;
//        this.type = type;
//        this.owner = owner;
//        this.openingDate = openingDate;
//        this.workStatus = workStatus;
//        this.popularity = popularity;
//        this.requests = requests;
//        this.event = event;
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
//    public int getNumberOfSeats() {
//        return numberOfSeats;
//    }
//
//    public void setNumberOfSeats(int numberOfSeats) {
//        this.numberOfSeats = numberOfSeats;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public OwnerInformation getOwner() {
//        return owner;
//    }
//
//    public void setOwner(OwnerInformation owner) {
//        this.owner = owner;
//    }
//
//    public Date getOpeningDate() {
//        return openingDate;
//    }
//
//    public void setOpeningDate(Date openingDate) {
//        this.openingDate = openingDate;
//    }
//
//    public Timestamp getWorkStatus() {
//        return workStatus;
//    }
//
//    public void setWorkStatus(Timestamp workStatus) {
//        this.workStatus = workStatus;
//    }
//
//    public int getPopularity() {
//        return popularity;
//    }
//
//    public void setPopularity(int popularity) {
//        this.popularity = popularity;
//    }
//
//    public List<Request> getRequests() {
//        return requests;
//    }
//
//    public void setRequests(List<Request> requests) {
//        this.requests = requests;
//    }
//
//    public Event getEvent() {
//        return event;
//    }
//
//    @Override
//    public String toString() {
//        return "Object{" +
//                "id=" + id +
//                ", numberOfSeats=" + numberOfSeats +
//                ", address='" + address + '\'' +
//                ", name='" + name + '\'' +
//                ", type='" + type + '\'' +
//                ", owner=" + owner +
//                ", openingDate=" + openingDate +
//                ", workStatus=" + workStatus +
//                ", popularity=" + popularity +
//                ", requests=" + requests +
//                ", event=" + event +
//                '}';
//    }
//
//    public void setEvent(Event event) {
//        this.event = event;
//    }
//}
