package database.services.results;

import java.util.List;
import java.util.Optional;

public class JPAResult {

    private Optional<Object> result;
    private List<JPAErrorTypes> jpaErrors;

    public Optional<Object> getResult() {
        return result;
    }

    public void setResult(Optional<Object> result) {
        this.result = result;
    }

    public List<JPAErrorTypes> getJPAErrorTypesTypes() {
        return jpaErrors;
    }

    public void setJPAErrorTypesTypes(List<JPAErrorTypes> JPAErrorTypesTypes) {
        this.jpaErrors = JPAErrorTypesTypes;
    }

    public boolean hasErrors() {
        return !jpaErrors.isEmpty();
    }

}
