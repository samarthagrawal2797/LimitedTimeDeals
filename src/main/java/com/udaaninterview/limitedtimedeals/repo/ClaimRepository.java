package com.udaaninterview.limitedtimedeals.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udaaninterview.limitedtimedeals.entity.Claim;

@Repository
public interface ClaimRepository extends CrudRepository<Claim, String>{

}
