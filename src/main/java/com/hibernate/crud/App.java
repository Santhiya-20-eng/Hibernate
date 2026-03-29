package com.hibernate.crud;

import com.hibernate.crud.dto.OwnerDTO;
import com.hibernate.crud.service.OwnerService;
import com.hibernate.crud.util.InputUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;



@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private OwnerService ownerService;
    private static final Logger LOGGER= LoggerFactory.getLogger(App.class);


    public App(OwnerService ownerService){
        this.ownerService=ownerService;

    }
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
    @Override
    public void run(String... args) throws  Exception{
        try(Scanner sc=new Scanner(System.in)){
            do {
                InputUtil.menus();
                int option=InputUtil.getInput(sc);
                switch (option){
                    case 1:
                        ownerService.saveOwner(InputUtil.getOwner(sc));
                        LOGGER.info("Owner saved successfully");
                        break;
                    case 2:
                        OwnerDTO ownerDTO=ownerService.findOwner(InputUtil.getOwnerId(sc));
                        LOGGER.info("Owner found successfully {}",ownerDTO);
                        break;
                    case 3:
                        String ownerId=InputUtil.getOwnerId(sc);
                        String petname=InputUtil.getPetName(sc);
                        ownerService.updatePetDetails(ownerId,petname);
                        LOGGER.info("Updated name successfully");
                        break;
                    case 4:
                        ownerId=InputUtil.getOwnerId(sc);
                        ownerService.deleteOwner(ownerId);
                        LOGGER.info("Owner deleted successfully");
                        break;
                    case 5:
                        List<OwnerDTO> ownerDTOList=ownerService.findAllOwners();
                        ownerDTOList.forEach( owner ->{ LOGGER.info("Owner Details {}", owner);
                        });
                        break;
                    default:
                        LOGGER.info("Invalid option");
                }
            }while(InputUtil.wantToContinue(sc));

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }



}