package errors;

import db.mapper.MapperResult;
import db.services.jpa.JPAResult;
import errors.jpa.JPAError;
import errors.jpa.JPAErrorTypes;
import errors.mapper.MapperError;
import errors.mapper.MapperErrorType;

import javax.persistence.PersistenceException;
import java.util.Optional;

/**
 * Classe utilitaire permettant l'enregistrement des erreurs liés à la base de données ou au map.
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public class ErrorManagerUtils {

    public static void manageJPAError(JPAResult jpaResult, PersistenceException e, String srcException) {
        jpaResult.setResult(Optional.empty());
        JPAError jpaError = new JPAError(JPAErrorTypes.PERSISTENCE_EXCEPTION);
        jpaError.addComplement("Source : " + srcException);
        jpaError.addComplement(e.getMessage());
        jpaResult.addJPAError(jpaError);
        e.printStackTrace();
    }

    public static void manageMapperError(MapperResult mapperResult, MapperErrorType invocationTargetException, String complement, Exception e) {
        MapperError mapperError = new MapperError(invocationTargetException);
        mapperError.addComplement(complement);
        mapperError.addComplement(e.getMessage());
        mapperResult.addMapError(mapperError);
        e.printStackTrace();
    }

}
