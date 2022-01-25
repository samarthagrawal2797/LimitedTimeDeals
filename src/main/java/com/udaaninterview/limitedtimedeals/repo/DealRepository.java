package com.udaaninterview.limitedtimedeals.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udaaninterview.limitedtimedeals.entity.Deal;

@Repository
public interface DealRepository extends CrudRepository<Deal, String>{
	//spring rest taking care of crud
}
