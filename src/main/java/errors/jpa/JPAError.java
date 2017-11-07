package errors.jpa;

import java.util.ArrayList;
import java.util.List;

public class JPAError {

    private JPAErrorTypes jpaErrorType;
    private List<String> complements;

    public JPAError(JPAErrorTypes jpaErrorType) {
        this.jpaErrorType = jpaErrorType;
        complements = new ArrayList<>();
    }

    public JPAErrorTypes getJpaErrorType() {
        return jpaErrorType;
    }

    public void addComplement(String complement) {
        this.complements.add(complement);
    }

    @Override
    public String toString() {
        return "JPAError{" +
                "jpaErrorType=" + jpaErrorType +
                ", complements=" + complements +
                '}';
    }

}
