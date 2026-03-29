package com.hibernate.crud.util;

import com.hibernate.crud.dto.OwnerDTO;
import com.hibernate.crud.entity.Owner;

public class MapperUtil {
    public static Owner DTOtoEntity(OwnerDTO ownerDTO1) {
        Owner owner = new Owner();
        //owner.setId(ownerDTO1.getId();
        owner.setFirstName(ownerDTO1.getFirstName());
        owner.setLastName(ownerDTO1.getLastName());
        owner.setGender(ownerDTO1.getGender());
        owner.setCity(ownerDTO1.getCity());
        owner.setState(ownerDTO1.getState());
        owner.setEmailId(ownerDTO1.getEmailId());
        owner.setMobileNumber(ownerDTO1.getMobileNumber());
        owner.setPetId(ownerDTO1.getPetId());
        owner.setPetType(ownerDTO1.getPetType());
        owner.setPetName(ownerDTO1.getPetName());
        owner.setPetBirthDate(ownerDTO1.getPetBirthDate());
        return owner;

    }

    public static OwnerDTO EntitytoDTO(Owner owner) {
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(owner.getId().toString());
        ownerDTO.setFirstName(owner.getFirstName());
        ownerDTO.setLastName(owner.getLastName());
        ownerDTO.setGender(owner.getGender());
        ownerDTO.setCity(owner.getCity());
        ownerDTO.setState(owner.getState());
        ownerDTO.setEmailId(owner.getEmailId());
        ownerDTO.setMobileNumber(owner.getMobileNumber());
        ownerDTO.setPetId(owner.getPetId());
        ownerDTO.setPetType(owner.getPetType());
        ownerDTO.setPetName(owner.getPetName());
        ownerDTO.setPetBirthDate(owner.getPetBirthDate());
        return ownerDTO;
    }
}