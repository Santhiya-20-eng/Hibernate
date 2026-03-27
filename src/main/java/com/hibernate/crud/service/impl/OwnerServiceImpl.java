package com.hibernate.crud.service.impl;

import com.hibernate.crud.dto.OwnerDTO;
import com.hibernate.crud.entity.Owner;
import com.hibernate.crud.exceptions.DuplicateOwnerFoundException;
import com.hibernate.crud.exceptions.OwnerNotFoundException;
import com.hibernate.crud.repository.OwnerRepository;
import com.hibernate.crud.repository.impl.OwnerRepositoryImpl;
import com.hibernate.crud.service.OwnerService;
import com.hibernate.crud.util.MapperUtil;

import java.util.List;
import java.util.Objects;


public class OwnerServiceImpl implements OwnerService {
    private OwnerRepository ownerRepository ;
    public OwnerServiceImpl(){
        this.ownerRepository=new OwnerRepositoryImpl();
    }
    @Override
    public void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerFoundException {
        Owner owner=ownerRepository.findOwner(ownerDTO.getId());
        if(Objects.nonNull(owner)){
            throw new DuplicateOwnerFoundException("Owner already exists");
        }
        ownerRepository
                .saveOwner(MapperUtil.DTOtoEntity(ownerDTO));


    }

    @Override
    public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
        Owner owner=ownerRepository.findOwner(ownerId);
        if(Objects.isNull(owner)){
            throw new OwnerNotFoundException("Owner not found");
        }
        return MapperUtil.EntitytoDTO(owner);

    }

    @Override
    public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
        Owner owner =ownerRepository.findOwner(ownerId);
        if(Objects.isNull(owner)){
            throw new OwnerNotFoundException("Owner not found");
        }
        ownerRepository.updatePetDetails(ownerId,petName);

    }





    @Override
    public void deleteOwner(int ownerId) throws OwnerNotFoundException {
        Owner owner=ownerRepository.findOwner(ownerId);
        if(Objects.isNull(owner)){
            throw new OwnerNotFoundException("Owner not found");
        }
        ownerRepository.deleteOwner(ownerId);


    }

    @Override
    public List<OwnerDTO> findAllOwners() {

        return ownerRepository .findAllOwners()
                .stream()
                .map(owner->MapperUtil.EntitytoDTO(owner)).toList();
    }
}
