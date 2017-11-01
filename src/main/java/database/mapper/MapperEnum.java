package database.mapper;

import database.bean.Adherent;
import database.bean.Adresse;
import database.bean.Article;
import database.bean.Pays;
import database.bean.Bean;
import database.dao.DAO;

import java.util.Arrays;
import java.util.List;

/**
 * Enumération liant les database.bean à leur dao et inversement
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public enum MapperEnum {

    ADHERENT("database.bean.Adherent", Adherent.class, new Class[]{String.class, String.class, String.class, String.class, Adresse.class},
            "dao.Adherent", String.class, new Class[]{}),
    ADRESSE("database.bean.Adresse", Adresse.class, new Class[]{String.class, String.class, String.class, String.class, Pays.class},
            "dao.Adresse", String.class, new Class[]{}),
    ARTICLE("database.bean.Article", Article.class, new Class[]{String.class, String.class, String.class, String.class, String.class},
            "dao.Article", String.class, new Class[]{}),
    PAYS("database.bean.Pays", Pays.class, new Class[]{String.class, String.class},
            "dao.Pays", String.class, new Class[]{});

    // Attributs
    private String beanClassName;
    private Class<?> beanImplementationClass;
    private Class[] beanConstructorTypes;
    private String daoClassName;
    private Class<?> daoImplementationClass;
    private Class[] daoConstructorTypes;

    // Constructeur

    /**
     * Constructeur de {@link MapperEnum}
     * @param beanClassName nom de la classe {@link Bean}
     * @param beanImplementationClass classe d'implémentation du {@link Bean}
     * @param beanConstructorTypes types des paramètres de constructeur du {@link Bean}
     * @param daoClassName nom de la classe {@link DAO}
     * @param daoImplementationClass classe d'implémentation du {@link DAO}
     * @param daoConstructorTypes types des paramètres de constructeur du {@link DAO}
     */
    MapperEnum(String beanClassName, Class<?> beanImplementationClass, Class[] beanConstructorTypes, String daoClassName, Class<?> daoImplementationClass, Class[] daoConstructorTypes) {
        this.beanClassName = beanClassName;
        this.beanImplementationClass = beanImplementationClass;
        this.beanConstructorTypes = beanConstructorTypes;
        this.daoClassName = daoClassName;
        this.daoImplementationClass = daoImplementationClass;
        this.daoConstructorTypes = daoConstructorTypes;
    }


    // Services

    /**
     * Permet la récupération du {@link Bean} à partir de son libellé.
     * Note : la recherche du libellé se fait en ignorant la case
     *
     * @param lab le libellé de l'objet recherché
     * @return l'objet de l'énumération correspondant au libellé fournit ou null
     * si le libellé est inconnu
     */
    public static MapperEnum fromBeanClassName(String lab) {
        return valuesAsList().stream().filter(m -> m.getBeanClassName().equalsIgnoreCase(lab)).findAny().orElse(null);
    }

    /**
     * Permet la récupération du {@link DAO} à partir de son libellé.
     * Note : la recherche du libellé se fait en ignorant la case
     *
     * @param lab le libellé de l'objet recherché
     * @return l'objet de l'énumération correspondant au libellé fournit ou null
     * si le libellé est inconnu
     */
    public static MapperEnum fromDaoClassName(String lab) {
        return valuesAsList().stream().filter(m -> m.getDaoClassName().equalsIgnoreCase(lab)).findAny().orElse(null);
    }

    /**
     * Permet de récupérer la classe d'implémentation pour le nom de paramètre fourni.
     * @param paramName nom du paramètre dont on souhaite récupérer la classe d'implémentation
     * @return la classe d'implémentation correspondant au type de paramètre fourni
     */
    public static Class<?> getClassForBeanClassName(String paramName) throws ClassNotFoundException {
        Class<?> implementationClass = MapperEnum.fromBeanClassName(paramName).getClass();
        if (implementationClass == null) {
            throw new ClassNotFoundException();
        }
        return implementationClass;
    }

    /**
     * Permet de récupérer la classe d'implémentation pour le nom de paramètre fourni.
     * @param paramName nom du paramètre dont on souhaite récupérer la classe d'implémentation
     * @return la classe d'implémentation correspondant au type de paramètre fourni
     */
    public static Class<?> getClassForDaoClassName(String paramName) throws ClassNotFoundException {
        Class<?> implementationClass = MapperEnum.fromDaoClassName(paramName).getClass();
        if (implementationClass == null) {
            throw new ClassNotFoundException();
        }
        return implementationClass;
    }

    /**
     * Permet d'obtenir une liste des valeurs de l'énumération
     * {@link MapperEnum}.
     *
     * @return la liste des valeurs de l'énumération {@link MapperEnum}
     */
    public static List<MapperEnum> valuesAsList() {
        return Arrays.asList(values());
    }

    // Accesseurs

    public String getBeanClassName() {
        return beanClassName;
    }

    public Class<?> getBeanImplementationClass() {
        return beanImplementationClass;
    }

    public String getDaoClassName() {
        return daoClassName;
    }

    public Class<?> getDaoImplementationClass() {
        return daoImplementationClass;
    }

    public Class[] getBeanConstructorTypes() {
        return beanConstructorTypes;
    }

    public Class[] getDaoConstructorTypes() {
        return daoConstructorTypes;
    }

}