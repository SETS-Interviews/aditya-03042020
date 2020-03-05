package com.ibm.part.services;

import com.ibm.part.domain.PartNumber;
import com.ibm.part.repository.PartNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service implementation to encompass search business logic
 */
@Service
public class PartNumberServiceImpl implements PartNumberService {

    @Autowired
    private PartNumberRepository repository;

    /**
     * List all records but cap the results to 10
     */
    @Override
    public List<PartNumber> listAll() {
        final Pageable limit = PageRequest.of(0,10);
        final Page<PartNumber> pageData = repository.findAll(limit);
        return pageData.getContent();
    }

    /**
     * Fetch one unique record
     */
    @Override
    public PartNumber getById(String id) {
        return repository.findById(id).get();
    }

    /**
     * List all records matching search criteria but cap the result to 10
     */
    @Override
    public List<PartNumber> getAllById(String partNum) {
        final Pageable limit = PageRequest.of(0,10);
        return repository.findByPartNum(partNum, limit);
    }
}
