package com.hibernate.crud.util;

import com.hibernate.crud.dto.OwnerDTO;
import com.hibernate.crud.enums.Gender;
import com.hibernate.crud.enums.PetType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class InputUtil {
    public static void menus(){
        System.out.println("1.save Owner");
        System.out.println("2.find Owner");
        System.out.println("3.update Pet Details");
        System.out.println("4.delete Owmer");
        System.out.println("5. find all Owner ");

    }
    public static int getInput(Scanner sc){
        int option=sc.nextInt();
        if(option ==1|| option==2||option ==3|| option==4||option ==5){
            return option;
        }else{
            return getInput(sc);
        }
    }
    public static boolean wantToContinue(Scanner sc) {
        System.out.println("Y TO CONTINUE N TO EXIT");
        char options = sc.next().toUpperCase().charAt(0);
        return options == 'Y';
    }
    public static OwnerDTO getOwner(Scanner sc) {
        OwnerDTO ownerDTO = new OwnerDTO();
        System.out.println("Enter Owner Id");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter First Name:");
        String firstName = sc.nextLine();
        System.out.println("Enter Last Name:");
        String lastName = sc.nextLine();
        System.out.println("Enter Gender:" + Arrays.asList(Gender.values()));
        String gender = sc.nextLine().toUpperCase();
        System.out.println("Enter City");
        String city = sc.nextLine();
        System.out.println("Enter State");
        String state = sc.nextLine();
        System.out.println("Enter MobileNumber");
        String mobileNumber = sc.nextLine();
        System.out.println("Enter EmailId");
        String emailId = sc.nextLine();
        System.out.println("Enter PetId");
        int petId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Pet Name");
        String petName = sc.nextLine();
        System.out.println("Enter pet BirthDate");
        String petBirthDate = sc.nextLine();
        System.out.println("Enter petType:" + Arrays.asList(PetType.values()));
        String petType = sc.nextLine().toUpperCase();
        try{
            ownerDTO.setId(id);
            ownerDTO.setFirstName(firstName);
            ownerDTO.setLastName(lastName);
            ownerDTO.setGender(Gender.valueOf(gender));
            ownerDTO.setCity(city);
            ownerDTO.setState(state);
            ownerDTO.setMobileNumber(mobileNumber);
            ownerDTO.setEmailId(emailId);
            ownerDTO.setPetId(petId);
            ownerDTO.setPetName(petName);
            ownerDTO.setPetBirthDate(convertDate(petBirthDate));
            ownerDTO.setPetType(PetType.valueOf(petType));

            return ownerDTO;
        }
        catch(Exception e){
            System.out.println("Enter valid Details "+e.getMessage());
            return getOwner(sc);
        }
    }
    public static LocalDate convertDate(String petBirthDate){
        DateTimeFormatter format =DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(petBirthDate, format);
    }

    public static int getOwnerId(Scanner sc) {
        System.out.println("Enter the id");
        int ownerId = sc.nextInt();
        if (ownerId < 1) {
            return ownerId;
        }else{
            return ownerId;

        }
    }

    public static String getPetName(Scanner sc) {
        sc.nextLine();
        System.out.println("Enter PetName");
        return sc.nextLine();
    }
}

//         String option=sc.next().toUpperCase();
//         if(option=="Y"){
//             return true;
//
//         } else if (option=="N") {
//             return false;
//         } else{
//             return wantToContinue(sc);
//         }
