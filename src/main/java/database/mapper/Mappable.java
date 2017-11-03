package database.mapper;

import database.bean.Bean;
import database.dao.DAO;

/**
 * Interface utilisé pour les éléments possible de mapper ({@link Bean} et {@link DAO})
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public interface Mappable {

    Object[] getObjectValues();

}
