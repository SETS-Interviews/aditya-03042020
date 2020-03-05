package com.ibm.part.controllers;


import com.ibm.part.domain.PartNumber;
import com.ibm.part.domain.PartNumberForm;
import com.ibm.part.services.PartNumberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

/**
 * This is the main controller for serching the data
 * /partNumber is the controller url context path
 */
@Controller
@RequestMapping("/partNumber")
public class PartNumberController {

    @Autowired
    private PartNumberService partNumberService;

    @GetMapping("/")
    public String index(Model model) {
        final List<PartNumber> partNumbers = partNumberService.listAll();
        model.addAttribute("partNumbers", partNumbers);
        model.addAttribute("partNumberForm", new PartNumberForm());
        return "list";
    }

    @PostMapping("/search")
    public String searchSubmit(Model model, @ModelAttribute PartNumberForm partNumberForm) {
        List<PartNumber> partNumbers;
        if(!StringUtils.isBlank(partNumberForm.getPartNumber())) {
            partNumbers = partNumberService.getAllById(partNumberForm.getPartNumber());
        } else {
            partNumbers = partNumberService.listAll();
        }
        model.addAttribute("partNumbers", partNumbers);
        return "list";
    }

    @GetMapping("/{partNumber}")
    public String getPartNumber(Model model, @PathVariable("partNumber") String partNumber) {
        final PartNumber partNumberObj = partNumberService.getById(partNumber);
        model.addAttribute("partNumber", partNumberObj);
        return "show";
    }
}
