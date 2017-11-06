package db.services.results;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
