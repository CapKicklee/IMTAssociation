package DataBaseMap;

import Bean.Adherent;
import Bean.Adresse;
import Bean.Article;
import Bean.Pays;

import java.util.Arrays;
import java.util.List;

/**
 * Enumération des types de paramètres pouvant être affectés à un EG
 * @author Chloé GUILBAUD, Léo PARIS, Kendall FOREST, Mathieu GUYOT
 */
public enum MapperEnum {

    ADHERENT("Bean.Adherent", Adherent.class, new Class[]{String.class, String.class, String.class, String.class, Adresse.class},
            "DAO.Adherent", String.class, new Class[]{}),
    ADRESSE("Bean.Adresse", Adresse.class, new Class[]{String.class, String.class, String.class, String.class, Pays.class},
            "DAO.Adresse", String.class, new Class[]{}),
    ARTICLE("Bean.Article", Article.class, new Class[]{String.class, String.class, String.class, String.class, String.class},
            "DAO.Article", String.class, new Class[]{}),
    PAYS("Bean.Pays", Pays.class, new Class[]{String.class, String.class},
            "DAO.Pays", String.class, new Class[]{});

    // Attributs
    private String beanClassName;
    private Class<?> beanImplementationClass;
    private Class[] beanConstructorTypes;
    private String daoClassName;
    private Class<?> daoImplementationClass;
    private Class[] daoConstructorTypes;

    // Constructeur

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
     * Permet la récupération du {@link ParamTypes} à partir de son libellé.
     * Note : la recherche du libellé se fait en ignorant la case
     *
     * @param lab le libellé de l'objet recherché
     * @return l'objet de l'énumération correspondant au libellé fournit ou null
     * si le libellé est inconnu
     */
    public static MapperEnum fromBeanClassName(String lab) {
        return valuesAsList().stream().filter(m -> m.getBeanClassName().equalsIgnoreCase(lab)).findAny().orElse(null);
    }

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
     * {@link ParamTypes}.
     *
     * @return la liste des valeurs de l'énumération {@link ParamTypes}
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