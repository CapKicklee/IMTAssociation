package db.mapper;

import db.bean.Bean;
import db.dao.DAO;

/**
 * Interface utilisé pour les éléments possible de mapper ({@link Bean} et {@link DAO})
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public interface Mappable {

    Object[] getObjectValues();

}
