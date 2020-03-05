package com.ibm.part.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PartNumberServiceImplTest {

    @Autowired
    PartNumberService partNumberService;

    @Test
    void testListAll() {
        assertNotNull(partNumberService.listAll());
    }

    @Test
    void testGetAllById() {
        assertNotNull(partNumberService.getAllById("sampleId"));
    }
}
