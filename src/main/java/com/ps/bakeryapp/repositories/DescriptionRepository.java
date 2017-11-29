package com.ps.bakeryapp.repositories;

import com.ps.bakeryapp.models.Description;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DescriptionRepository extends CrudRepository<Description, Long> {


}
