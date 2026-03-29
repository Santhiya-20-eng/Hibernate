package com.hibernate.crud.service.impl;

import com.hibernate.crud.dto.OwnerDTO;
import com.hibernate.crud.entity.Owner;
import com.hibernate.crud.exceptions.DuplicateOwnerFoundException;
import com.hibernate.crud.exceptions.OwnerNotFoundException;
import com.hibernate.crud.repository.OwnerRepository;
import com.hibernate.crud.repository.impl.OwnerRepositoryImpl;
import com.hibernate.crud.service.OwnerService;
import com.hibernate.crud.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Service
public class OwnerServiceImpl implements OwnerService {
    private OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository){
        this.ownerRepository=ownerRepository;
    }
    @Override
    public void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerFoundException
    {
//        Owner owner = ownerRepository.findOwner(UUID.fromString(ownerDTO.getId()));
//        if (Objects.nonNull(owner)){
//            throw new DuplicateOwnerFoundException("Owner already exists");
//        }
        ownerRepository.saveOwner(MapperUtil.DTOtoEntity(ownerDTO));

    }
    @Override
    public OwnerDTO findOwner(String ownerId) throws OwnerNotFoundException{
        Owner owner = ownerRepository.findOwner(UUID.fromString(ownerId));
        if(Objects.isNull(owner)){
            throw new OwnerNotFoundException("Owner not found");
        }
        return MapperUtil. EntitytoDTO(owner);
    }

    @Override
    public void updatePetDetails(String ownerId, String petName) throws OwnerNotFoundException {
        Owner owner= ownerRepository.findOwner(UUID.fromString(ownerId));
        if(Objects.isNull(owner)){
            throw new OwnerNotFoundException("owner not found");
        }
        ownerRepository.updatePetDetails(UUID.fromString(ownerId),petName);
    }





    @Override
    public void deleteOwner(String ownerId) throws OwnerNotFoundException {
        Owner owner= ownerRepository.findOwner(UUID.fromString(ownerId));
        if(Objects.isNull(owner)){
            throw new OwnerNotFoundException("owner not found");
        }
        ownerRepository.deleteOwner(UUID.fromString(ownerId));

    }


    @Override
    public List<OwnerDTO> findAllOwners() {
        return List.of();
    }
}