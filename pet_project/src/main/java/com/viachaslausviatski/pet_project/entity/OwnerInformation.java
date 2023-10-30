//package com.viachaslausviatski.pet_project.entity;
//
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "owner_information")
//public class OwnerInformation {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "owner_name")
//    private String ownerName;
//
//    @Column(name = "organisation_name")
//    private String organisationName;
//
//    @Column(name = "phone_number_of_the_owner")
//    private String phoneNumberOfTheOwner;
//
//    @Column(name = "full_owner_name")
//    private String fullOwnerName;
//
//    @OneToMany(mappedBy = "owner")
//    private List<Object> objects;
//
//    public OwnerInformation() {
//    }
//
//
//    public OwnerInformation(String ownerName, String organisationName, String phoneNumberOfTheOwner, String fullOwnerName,
//                            List<Object> objects) {
//        this.ownerName = ownerName;
//        this.organisationName = organisationName;
//        this.phoneNumberOfTheOwner = phoneNumberOfTheOwner;
//        this.fullOwnerName = fullOwnerName;
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
//    public String getOwnerName() {
//        return ownerName;
//    }
//
//    public void setOwnerName(String ownerName) {
//        this.ownerName = ownerName;
//    }
//
//    public String getOrganisationName() {
//        return organisationName;
//    }
//
//    public void setOrganisationName(String organisationName) {
//        this.organisationName = organisationName;
//    }
//
//    public String getPhoneNumberOfTheOwner() {
//        return phoneNumberOfTheOwner;
//    }
//
//    public void setPhoneNumberOfTheOwner(String phoneNumberOfTheOwner) {
//        this.phoneNumberOfTheOwner = phoneNumberOfTheOwner;
//    }
//
//    public String getFullOwnerName() {
//        return fullOwnerName;
//    }
//
//    public void setFullOwnerName(String fullOwnerName) {
//        this.fullOwnerName = fullOwnerName;
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
//        return "OwnerInformation{" +
//                "id=" + id +
//                ", ownerName='" + ownerName + '\'' +
//                ", organisationName='" + organisationName + '\'' +
//                ", phoneNumberOfTheOwner='" + phoneNumberOfTheOwner + '\'' +
//                ", fullOwnerName='" + fullOwnerName + '\'' +
//                ", objects=" + objects +
//                '}';
//    }
//}
