package db.mapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

enum MapperErrorType {

    SECURITY_EXCEPTION("SECURITY_EXCEPTION"),
    ILLEGAL_ARGUMENT_EXCEPTION("Mauvais types de paramètre fourni au constructeur"),
    INSTANTIATION_EXCEPTION("Tentative d'instanciation de classe abstraite"),
    ILLEGAL_ACCESS_EXCEPTION("Classe non accessible"),
    NO_SUCH_METHOD_EXCEPTION("Contructeur inexistant - aucun constructeur ne présente les types de paramètres attendus"),
    INVOCATION_TARGET_EXCEPTION("Exception déclenchée par le constructeur de la classe"),
    BEAN_DAO_LINKER_EXCEPTION("La classe demandée n'a pas de correspondance dans le BeanDAOLinker");

    // Attributs
    private String errorInfo;

    // Constructeur
    /**
     * Constructeur de la classe {@link MapperErrorType}.
     *
     * @param errorInfo
     *            message explicatif de l'erreur
     */
    MapperErrorType(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    // Services

    /**
     * Permet la récupération du {@link MapperErrorType} à partir de son libellé.
     * Note : la recherche du libellé se fait en ignorant la casse
     *
     * @param lab
     *            le libellé de l'objet recherché
     * @return l'objet de l'énumération correspondant au libellé fourni
     *         si le libellé est inconnu
     */
    public static Optional<MapperErrorType> fromLabel(String lab) {
        return Optional.ofNullable(valuesAsList().stream().filter(m -> m.getLabel().equalsIgnoreCase(lab)).findAny().orElse(null));
    }

    /**
     * Permet d'obtenir une liste des valeurs de l'énumération
     * {@link MapperErrorType}.
     *
     * @return la liste des valeurs de l'énumération {@link MapperErrorType}
     */
    public static List<MapperErrorType> valuesAsList() {
        return Arrays.asList(values());
    }

    // Accesseurs

    public String getLabel() {
        return errorInfo;
    }

    // Services

   /* public String printError() {
        String str = "";
        for(String s : complements) {
            str += "\n-" + s;
        }
        return this.getLabel() + str;
    }
*/

    @Override
    public String toString() {
        return "MapperErrorType{" +
                "errorInfo='" + errorInfo + '\'' +
                '}';
    }

}
