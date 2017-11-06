package db.services.results;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JPAResult<R> {

    private Optional<R> result;
    private List<JPAErrorTypes> jpaErrors;
    

    public JPAResult ()  {
        this.jpaErrors = new ArrayList<JPAErrorTypes>();
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

    public List<JPAErrorTypes> getJPAErrorTypes() {
        return jpaErrors;
    }

    public void setJPAErrorTypesTypes(List<JPAErrorTypes> JPAErrorTypesTypes) {
        this.jpaErrors = JPAErrorTypesTypes;
    }

    public boolean hasErrors() {
        return !jpaErrors.isEmpty();
    }

}
