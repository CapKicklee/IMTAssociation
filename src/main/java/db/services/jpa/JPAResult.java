package db.services.jpa;

import errors.jpa.JPAError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe représentant le résultat de requête à la base de données
 * ainsi que les éventuelles erreurs rencontrées
 *
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 * @param <R> le type de l'objet retourné par la requête faite à la base de données
 */
public class JPAResult<R> {

    private Optional<R> result;
    private List<JPAError> jpaErrors;
    

    public JPAResult ()  {
        this.jpaErrors = new ArrayList<JPAError>();
    }

    public JPAResult (Optional<R> result) {
        this();
        this.result = result;
    }

    public Optional<R> getResult() {
        return result;
    }

    public void setResult(Optional<R> result) {
        this.result = result;
    }

    public List<JPAError> getJPAErrorTypes() {
        return jpaErrors;
    }

    public void setJPAErrorTypesTypes(List<JPAError> JPAErrorTypesTypes) {
        this.jpaErrors = JPAErrorTypesTypes;
    }

    public void addJPAError(JPAError jpaError) {
        this.jpaErrors.add(jpaError);
    }

    public boolean hasErrors() {
        return !jpaErrors.isEmpty();
    }

    @Override
    public String toString() {
        return "JPAResult{" +
                "result=" + result +
                ", jpaErrors=" + jpaErrors +
                '}';
    }

}
