package com.hibernate.crud.entity;

import com.hibernate.crud.enums.Gender;
import com.hibernate.crud.enums.PetType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="owner table")
public class Owner{
    //@GeneratedValue
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    //private int id;
    private UUID id;
    @Column(name="firstname",nullable=false)
    private String firstName;
    @Column(nullable=false)
    private String lastName;
    @Enumerated(value=EnumType.STRING)
    @Column(name="gender",nullable=false)
    private Gender gender;
    private String city;
    private String state;
    @Column(name="mobile number",nullable=false,unique=true,length=10)
    private String mobileNumber;
    @Column(name="emailId",nullable=false,unique=true)
    private String emailId;

    private int petId;
    private String petName;
    private LocalDate petBirthDate;
    private PetType petType;

    /*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public LocalDate getPetBirthDate() {
        return petBirthDate;
    }

    public void setPetBirthDate(LocalDate petBirthDate) {
        this.petBirthDate = petBirthDate;
    }


    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }
}