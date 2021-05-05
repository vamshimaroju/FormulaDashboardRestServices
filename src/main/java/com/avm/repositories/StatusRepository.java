package com.avm.repositories;

import java.util.List;

import com.avm.entities.Status;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface StatusRepository extends CrudRepository<Status, String>{

List<Status> findByStatusId(String statusId);
    
}