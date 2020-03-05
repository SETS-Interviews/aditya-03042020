package com.ibm.part.repository;

import com.ibm.part.domain.PartNumber;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Repository configuration to perform CRUD operations
 * supporting the search requirement
 */
public interface PartNumberRepository extends CrudRepository<PartNumber, String> {

	public Page<PartNumber> findAll(Pageable pageable);

	@Query("{ 'id' : { $regex: ?0 } }")
	public List<PartNumber> findByPartNum(String regex, Pageable limit);
}
