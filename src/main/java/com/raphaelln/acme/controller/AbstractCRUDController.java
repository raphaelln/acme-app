package com.raphaelln.acme.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raphaelln.acme.exception.AcmeBusinessException;
import com.raphaelln.acme.model.AbstractDocument;
import com.raphaelln.acme.service.AbstractCRUDService;

@RestController()
public abstract class AbstractCRUDController<T extends AbstractDocument, K extends String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCRUDController.class);

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public T create(@RequestBody @Valid T entity) throws AcmeBusinessException {
        LOGGER.debug("Retrieving document {} from database with id {}", entity.getClass().getName(), (entity.getId()));
        return this.getService().save(entity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") K id) {
        LOGGER.debug("Deleting document with id {}", id);

        try {
            this.getService().delete(id);
        } catch (AcmeBusinessException e) {
            LOGGER.error("Error to delete the document", e);
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Boolean>(Boolean.TRUE,HttpStatus.OK); 
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> get(@PathVariable("id") K id) {
        LOGGER.debug("Finding document with id {}", id);
        try {
            return new ResponseEntity<T>(this.getService().findOne(id), HttpStatus.OK); 
        } catch (AcmeBusinessException e) {
            LOGGER.error("Error to get the document.", e);
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    abstract AbstractCRUDService<T, K> getService();

    @RequestMapping(method = RequestMethod.GET)
    public List<T> list() {
        return this.getService().list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public T update(@PathVariable("id") K id, @RequestBody @Valid T document) throws AcmeBusinessException {
        LOGGER.debug("Update document with id {}", id);
        return this.getService().save(document);
    }
}
