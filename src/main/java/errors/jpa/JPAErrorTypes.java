package errors.jpa;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum JPAErrorTypes {

    PERSISTENCE_EXCEPTION("Erreur liée à la base de données");

    // Attributs
    private String errorInfo;

    // Constructeur
    /**
     * Constructeur de la classe {@link JPAErrorTypes}.
     *
     * @param errorInfo
     *            message explicatif de l'erreur
     */
    JPAErrorTypes(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    // Services

    /**
     * Permet la récupération du {@link JPAErrorTypes} à partir de son libellé.
     * Note : la recherche du libellé se fait en ignorant la casse
     *
     * @param lab
     *            le libellé de l'objet recherché
     * @return l'objet de l'énumération correspondant au libellé fourni
     *         si le libellé est inconnu
     */
    public static Optional<JPAErrorTypes> fromLabel(String lab) {
        return Optional.ofNullable(valuesAsList().stream().filter(m -> m.getLabel().equalsIgnoreCase(lab)).findAny().orElse(null));
    }

    /**
     * Permet d'obtenir une liste des valeurs de l'énumération
     * {@link JPAErrorTypes}.
     *
     * @return la liste des valeurs de l'énumération {@link JPAErrorTypes}
     */
    public static List<JPAErrorTypes> valuesAsList() {
        return Arrays.asList(values());
    }

    // Accesseurs

    public String getLabel() {
        return errorInfo;
    }

    // Services

    @Override
    public String toString() {
        return "JPAErrorTypes{" +
                "errorInfo='" + errorInfo + '\'' +
                '}';
    }

}
