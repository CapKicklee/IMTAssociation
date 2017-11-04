package db.manager;

import java.util.List;

/**
 * Classe représentant le résultat d'une requête de base de données comprenand le résultat ainsi que les
 * éventuelles erreurs rencontrées.
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public class DataBaseResult {

    private List<DatabaseError> databaseQueryErrors;

    public DataBaseResult(List<DatabaseError> databaseQueryErrors) {
        this.databaseQueryErrors = databaseQueryErrors;
    }


}
