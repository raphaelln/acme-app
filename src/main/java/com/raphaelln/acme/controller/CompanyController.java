package com.raphaelln.acme.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raphaelln.acme.exception.AcmeBusinessException;
import com.raphaelln.acme.model.Company;
import com.raphaelln.acme.service.AbstractCRUDService;
import com.raphaelln.acme.service.CompanyService;

@RestController()
@RequestMapping("/api/company")
public class CompanyController extends AbstractCRUDController<Company, String> {

    @Autowired
    private CompanyService companyService;

    @Override
    AbstractCRUDService<Company, String> getService() {
        return companyService;
    }

    @RequestMapping(value = "{id}/owner", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> addOwner(@PathVariable("id") String id, @RequestBody @Valid String owner) {

        try {
            companyService.addOwner(id, owner);
        } catch (AcmeBusinessException e1) {
            return new ResponseEntity<String>(e1.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(String.format("Owner %s included with success", owner), HttpStatus.OK);
    }

}
