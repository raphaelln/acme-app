package com.raphaelln.acme.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.dao.DuplicateKeyException;
import com.raphaelln.acme.controller.AbstractCRUDController;
import com.raphaelln.acme.exception.AcmeBusinessException;
import com.raphaelln.acme.model.AbstractDocument;

public abstract class AbstractCRUDService<T extends AbstractDocument, K extends String> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCRUDController.class);

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
	public ResponseEntity<Boolean> delete(K id) {
		LOGGER.debug("Deleting document with id {}", id);
		this.getRepository().delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

	@Transactional
	public T findOne(K id) {
		LOGGER.debug("Finding document with id {}", id);
		return this.getRepository().findOne(id);
	}

	abstract MongoRepository<T, K> getRepository();

	public List<T> list() {
		return this.getRepository().findAll();
	}

	@Transactional
	public T update(K id, @RequestBody T document) {
		LOGGER.debug("Update document with id {}", id);
		return this.getRepository().save(document);
	}

}
