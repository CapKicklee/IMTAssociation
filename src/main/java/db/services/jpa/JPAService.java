/*
 * Created on 1 nov. 2017 ( Date ISO 2017-11-01 - Time 17:25:42 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package db.services.jpa;

import db.services.persistence.PersistenceConfig;
import db.services.results.JPAError;
import db.services.results.JPAErrorTypes;
import db.services.results.JPAResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.criteria.Predicate;

/**
 * Generic JPA service operations <br>
 * Provided by Telosys Tools for JPA testing
 *
 * @param <T>  Entity type
 * @param <PK> Primary key type
 */
@SuppressWarnings("unchecked")
public abstract class JPAService<T, PK extends java.io.Serializable> {

    private static final boolean TRANSACTIONAL = true;

    private static final Predicate[] VOID_PREDICATE_ARRAY = {};

    /**
     * The class of the entity managed by the concrete service
     */
    private final Class<T> persistentClass;

    /**
     * Constructor
     *
     * @param persistentClass
     */
    public JPAService(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    /**
     * Executes a NON TRANSACTIONAL JPA operation with a specific EntityManager <br>
     * ( created at the beginning of the execution and closed at the end )
     *
     * @param operation the operation to be executed
     * @return result
     * @throws PersistenceException
     */
    protected final Object execute(JPAOperation operation) throws PersistenceException {
        return execute(operation, false);
    }

    /**
     * Executes a JPA operation ( TRANSACTIONAL or NOT ) with a specific EntityManager <br>
     * ( created at the beginning of the execution and closed at the end )
     *
     * @param operation     the operation to be executed
     * @param transactional true for a TRANSACTIONAL operation, false for NOT TRANSACTIONAL
     * @return result
     * @throws PersistenceException
     */
    protected final Object execute(JPAOperation operation, boolean transactional) throws PersistenceException { // pb connexion à la base de données
        JPAEnvironment JPAEnvironment = JPAEnvironments.getInstance().getJpaEnvironment(PersistenceConfig.JPA_PERSISTENCE_UNIT_NAME);
        if (transactional) {
            return JPAEnvironment.executeWithTransaction(operation);
        } else {
            return JPAEnvironment.executeWithoutTransaction(operation);

        }
    }

    /**
     * Find entity by Primary Key
     *
     * @param primaryKey
     * @return
     */
    public JPAResult<T> load(final PK primaryKey) {
        // JPA operation definition
        JPAOperation operation = new JPAOperation() {
            @Override
            public Object exectue(EntityManager em) throws PersistenceException {
                return em.find(persistentClass, primaryKey);
            }
        };

        JPAResult jpaResult = new JPAResult();
        try {
            T res = (T) execute(operation);
            jpaResult.setResult(Optional.ofNullable(res));
        } catch (PersistenceException e) {
            saveError(jpaResult, e, "load");
        }

        // JPA operation execution
        return jpaResult;
    }

    /**
     * Load all entities
     *
     * @param <T>
     * @param query
     * @return
     */
    public JPAResult<List<T>> loadAll() {


        // JPA operation definition
        JPAOperation operation = new JPAOperation() {
            @Override
            public Object exectue(EntityManager em) throws PersistenceException {
                final Query query = em.createQuery("from " + persistentClass.getName());
                return query.getResultList();
            }
        };

        JPAResult jpaResult = new JPAResult();
        try {
            List<T> res = (List<T>) execute(operation);
            jpaResult.setResult(Optional.ofNullable(res));
        } catch (PersistenceException e) {
            saveError(jpaResult, e, "loadAll()");
        }
        // JPA operation execution
        return jpaResult;
    }

    /**
     * Insert entity ( TRANSACTIONAL )
     *
     * @param <T>
     * @return
     */
    public JPAResult<Object> insert(final T entity) {
        // JPA operation definition
        JPAOperation operation = new JPAOperation() {
            @Override
            public Object exectue(EntityManager em) throws PersistenceException {
                em.persist(entity);
                return null;
            }
        };

        JPAResult jpaResult = new JPAResult();
        try {
            Object res = execute(operation, TRANSACTIONAL);
            jpaResult.setResult(Optional.ofNullable(res));
        } catch (PersistenceException e) {
            saveError(jpaResult, e, "insert()");
        }
        // JPA operation execution
        return jpaResult;

    }

    /**
     * Save the given entity ( TRANSACTIONAL )
     *
     * @param <T>
     * @param entity
     * @return
     */
    public JPAResult<T> save(final T entityToSave) {
        // JPA operation definition
        JPAOperation operation = new JPAOperation() {
            @Override
            public Object exectue(EntityManager em) throws PersistenceException {
                T managedEntity = em.merge(entityToSave);
                return managedEntity;
            }
        };

        JPAResult jpaResult = new JPAResult();
        try {
            T res = (T) execute(operation, TRANSACTIONAL);
            jpaResult.setResult(Optional.ofNullable(res));
        } catch (PersistenceException e) {
            saveError(jpaResult, e, "save()");
        }
        // JPA operation execution
        return jpaResult;
    }

    /**
     * Delete entity by primary key ( TRANSACTIONAL )
     *
     * @param primaryKey
     */
    public JPAResult<Boolean> delete(final PK primaryKey) {
        // JPA operation definition
        JPAOperation operation = new JPAOperation() {
            @Override
            public Object exectue(EntityManager em) throws PersistenceException {
                final T entity = em.find(persistentClass, primaryKey);
                if (entity != null) {
                    em.remove(entity);
                    return Boolean.TRUE;
                } else {
                    return Boolean.FALSE;
                }
            }
        };

        JPAResult jpaResult = new JPAResult();
        try {
            Boolean res = (Boolean) execute(operation, TRANSACTIONAL);
            jpaResult.setResult(Optional.ofNullable(res));
        } catch (PersistenceException e) {
            saveError(jpaResult, e, "delete()");
        }

        // JPA operation execution
        return jpaResult;
    }


    public static void saveError(JPAResult jpaResult, PersistenceException e, String srcException) {
        jpaResult.setResult(Optional.empty());
        JPAError jpaError = new JPAError(JPAErrorTypes.PERSISTENCE_EXCEPTION);
        jpaError.addComplement("Source : " + srcException);
        jpaError.addComplement(e.getMessage());
        jpaResult.addJPAError(jpaError);
        e.printStackTrace();
    }

}
