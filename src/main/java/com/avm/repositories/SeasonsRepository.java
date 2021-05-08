package com.avm.repositories;

import com.avm.entities.Seasons;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SeasonsRepository extends CrudRepository<Seasons,Long>{
    
}
