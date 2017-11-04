package database.manager;

import database.bean.Adresse;
import database.dao.AdherentDAO;
import database.dao.AdresseDAO;
import database.dao.DAO;
import database.mapper.BeanDaoMapper;
import database.mapper.MapperResult;
import database.services.commons.GenericJpaService;
import database.services.interfaces.AdressePersistence;
import database.services.persistenceJPA.AdherentPersistenceJPA;
import database.services.persistenceJPA.AdressePersistenceJPA;
import database.services.results.JPAResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe utilitaire donnant accès à la base de données.
 */
public class DataBaseManager {

    public static final AdherentPersistenceJPA jpaAdherent = new AdherentPersistenceJPA();
    public static final AdressePersistenceJPA jpaAdresse = new AdressePersistenceJPA();

    public static DataBaseQueryResult loadAllAdherents() {

        // Requête de la base de données
        JPAResult jpaResult = jpaAdherent.loadAll();
        Optional<Object> adherentDAOOp = jpaResult.getResult();

        // Enregistrement du résultat
        DataBaseQueryResult dataBaseQueryResult = new DataBaseQueryResult();
        dataBaseQueryResult.setJpaResult(jpaResult);

        // Si des erreurs sont recontrées au moment du requetage de la base de données
        // le mapping ne peux pas se faire
        if (adherentDAOOp.isPresent()) {
            List<MapperResult> beanAdherentList = new ArrayList();
            for (AdherentDAO aderent : (List<AdherentDAO>) adherentDAOOp.get()) {
                MapperResult mapperResult = BeanDaoMapper.mapDAOToBean(aderent);
                beanAdherentList.add(mapperResult);
                dataBaseQueryResult.setMapperResult(mapperResult);
            }
        }

        return dataBaseQueryResult;

    }

    public static DataBaseQueryResult loadAllAdresses() {

        // Requête de la base de données
        JPAResult jpaResult = jpaAdresse.loadAll();
        Optional<Object> adresseDAOOp = jpaResult.getResult();

        // Enregistrement du résultat
        DataBaseQueryResult dataBaseQueryResult = new DataBaseQueryResult();
        dataBaseQueryResult.setJpaResult(jpaResult);

        // Si des erreurs sont recontrées au moment du requetage de la base de données
        // le mapping ne peux pas se faire
        if (adresseDAOOp.isPresent()) {
            List<MapperResult> beanAdherentList = new ArrayList();
            for (AdresseDAO adresse : (List<AdresseDAO>) adresseDAOOp.get()) {
                MapperResult mapperResult = BeanDaoMapper.mapDAOToBean(adresse);
                beanAdherentList.add(mapperResult);
                dataBaseQueryResult.setMapperResult(mapperResult);
            }
        }

        return dataBaseQueryResult;

    }

    public static void tes(JPAResult jpaResult) {



    }

}
