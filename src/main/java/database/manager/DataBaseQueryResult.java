package database.manager;

import database.mapper.MapperResult;
import database.services.results.JPAErrorTypes;
import database.services.results.JPAResult;

import java.util.List;
import java.util.Optional;

/**
 * Classe représentant le résultat d'une requête de base de données comprenand le résultat ainsi que les
 * éventuelles erreurs rencontrées.
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public class DataBaseQueryResult {

    private MapperResult mapperResult;
    private JPAResult jpaResult;


    public JPAResult getJPAResult() {
        return jpaResult;
    }

    public MapperResult getMapperResult() {
        return mapperResult;
    }

    public void setMapperResult(MapperResult mapperResult) {
        this.mapperResult = mapperResult;
    }

    public JPAResult getJpaResult() {
        return jpaResult;
    }

    public void setJpaResult(JPAResult jpaResult) {
        this.jpaResult = jpaResult;
    }

    public boolean hasMapperErrors() {
        return this.mapperResult.hasErrors();
    }

    public boolean hasJpaErrors() {
        return this.jpaResult.hasErrors();
    }

}
