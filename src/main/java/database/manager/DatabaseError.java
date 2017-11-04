package db.manager;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Enumération listant les erreurs possibles propres aux intéractions avec la base de données.
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 *
 */
public enum DatabaseError {

    DATABASE_CONNEXION("Impossible de se connecter à la base de données."),
    DATABASE_COMMIT("Impossible d'enregistrer les informations en base de données."),
    ROW_ALREADY_IN_DATABASE("L'enregistrement est déjà en base de données.");


    // Attributs
    private String errorInfo;
    private List<String> complements;

    // Constructeur
    /**
     * Constructeur de la classe {@link DatabaseError}.
     *
     * @param errorInfo
     *            message explicatif de l'erreur
     */
    DatabaseError(String errorInfo) {
        this.errorInfo = errorInfo;
        this.complements = new ArrayList<>();
    }

    // Services

    /**
     * Permet la récupération du {@link DatabaseError} à partir de son libellé.
     * Note : la recherche du libellé se fait en ignorant la casse
     *
     * @param lab
     *            le libellé de l'objet recherché
     * @return l'objet de l'énumération correspondant au libellé fourni
     *         si le libellé est inconnu
     */
    public static Optional<DatabaseError> fromLabel(String lab) {
        return Optional.ofNullable(valuesAsList().stream().filter(m -> m.getLabel().equalsIgnoreCase(lab)).findAny().orElse(null));
    }

    /**
     * Permet d'obtenir une liste des valeurs de l'énumération
     * {@link DatabaseError}.
     *
     * @return la liste des valeurs de l'énumération {@link DatabaseError}
     */
    public static List<DatabaseError> valuesAsList() {
        return Arrays.asList(values());
    }

    // Accesseurs

    public String getLabel() {
        return errorInfo;
    }

    // Services

    public void resetComplements() {
        this.complements = new ArrayList<>();
    }

    public void addComplement(String complement) {
        this.complements.add(complement);
    }

    /**
     * Permet l'impression le type de l'erreur de traitement du fichier de configuration XML.
     * @return une chaîne de caractèe comprenant le type de l'erreur de traitement de fichier
     */
    public String printError() {
        String str = "";
        for(String s : complements) {
            str += "\n-" + s;
        }
        return this.getLabel() + str;
    }


}

