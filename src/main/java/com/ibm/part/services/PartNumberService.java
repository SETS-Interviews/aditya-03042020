package com.ibm.part.services;

import com.ibm.part.domain.PartNumber;
import java.util.List;

public interface PartNumberService {

    List<PartNumber> listAll();

    PartNumber getById(String id);

    List<PartNumber> getAllById(String id);
}
