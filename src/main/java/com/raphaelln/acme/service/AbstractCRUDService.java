package com.raphaelln.acme.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.raphaelln.acme.controller.AbstractCRUDController;
import com.raphaelln.acme.exception.AcmeBusinessException;
import com.raphaelln.acme.model.AbstractDocument;

public abstract class AbstractCRUDService<T extends AbstractDocument, K extends String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCRUDController.class);

    public abstract String getModelName();

    @Transactional
    public T save(T entity) throws AcmeBusinessException {

        try {
            LOGGER.debug("Retrieving document {} from database with id {}", entity.getClass().getName(),
                    (entity.getId()));
            return this.getRepository().save(entity);
        } catch (DuplicateKeyException e) {
            throw new AcmeBusinessException("Duplicate object in database.");
        } catch (Exception e) {
            throw new AcmeBusinessException("Ops, unexpected error has occurred, please contact the system manager.");
        }
    }

    @Transactional
    public void delete(K id) throws AcmeBusinessException {
        LOGGER.debug("Deleting document with id {}", id);
        
        if (this.getRepository().exists(id)) {
            this.getRepository().delete(id);
        } else {
            throw new AcmeBusinessException(String.format("%s with id %s does not exists.", getModelName(), id));
        }
    }

    @Transactional
    public T findOne(K id) throws AcmeBusinessException {
        LOGGER.debug("Finding document with id {}", id);
        if (this.getRepository().exists(id)) {
            return this.getRepository().findOne(id);
        } else {
            throw new AcmeBusinessException(String.format("%s with id %s does not exists.", getModelName(), id));
        }
    }

    abstract MongoRepository<T, K> getRepository();

    public List<T> list() {
        return this.getRepository().findAll();
    }

    @Transactional
    public T update(K id, @RequestBody T document) throws AcmeBusinessException {
        LOGGER.debug("Update document with id {}", id);
        if (this.getRepository().exists(id)) {
            return this.getRepository().save(document);
        } else {
            throw new AcmeBusinessException(String.format("%s with id %s does not exists.", getModelName(), id));
        }
    }

}
