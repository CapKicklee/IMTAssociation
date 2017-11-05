package db.mapper;

import db.bean.Adherent;
import db.bean.Adresse;
import db.bean.Article;
import db.bean.Pays;
import db.bean.Bean;
import db.dao.*;

import java.sql.Blob;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Enumération liant les {@link Bean} à leur {@link DAO} et inversement
 *
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
enum BeanDAOLinker {

    ADHERENT("db.bean.Adherent", Adherent.class, new Class[]{String.class, String.class, String.class, String.class, AdresseDAO.class},
            "db.dao.AdherentDAO", AdherentDAO.class, new Class[]{String.class, String.class, String.class, String.class, Adresse.class}),
    ADRESSE("db.bean.Adresse", Adresse.class, new Class[]{Integer.class, String.class, Integer.class, String.class, PaysDAO.class},
            "db.dao.AdresseDAO", AdresseDAO.class, new Class[]{Integer.class, String.class, Integer.class, String.class, Pays.class}),
    ARTICLE("db.bean.Article", Article.class, new Class[]{String.class, String.class, String.class, Double.class, Integer.class, String.class},
            "db.dao.ArticleDAO", ArticleDAO.class, new Class[]{String.class, String.class, String.class, Double.class, Integer.class, Blob.class}),
    PAYS("db.bean.Pays", Pays.class, new Class[]{String.class, String.class},
            "db.dao.PaysDAO", PaysDAO.class, new Class[]{String.class, String.class});

    // Attributs
    private String beanClassName;
    private Class<?> beanImplementationClass;
    private Class[] beanConstructorTypes;
    private String daoClassName;
    private Class<?> daoImplementationClass;
    private Class[] daoConstructorTypes;

    // Constructeur

    /**
     * Constructeur de {@link BeanDAOLinker}
     *
     * @param beanClassName           nom de la classe {@link Bean}
     * @param beanImplementationClass classe d'implémentation du {@link Bean}
     * @param beanConstructorTypes    types des paramètres de constructeur du {@link Bean}
     * @param daoClassName            nom de la classe {@link DAO}
     * @param daoImplementationClass  classe d'implémentation du {@link DAO}
     * @param daoConstructorTypes     types des paramètres de constructeur du {@link DAO}
     */
    BeanDAOLinker(String beanClassName, Class<?> beanImplementationClass, Class[] beanConstructorTypes, String daoClassName, Class<?> daoImplementationClass, Class[] daoConstructorTypes) {
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
     * @return l'objet de l'énumération correspondant au libellé fournit
     * si le libellé est inconnu
     */
    public static Optional<BeanDAOLinker> fromBeanClassName(String lab) {
        return Optional.ofNullable(valuesAsList().stream().filter(m -> m.getBeanClassName().equalsIgnoreCase(lab)).findAny().orElse(null));
    }

    /**
     * Permet la récupération du {@link DAO} à partir de son libellé.
     * Note : la recherche du libellé se fait en ignorant la case
     *
     * @param lab le libellé de l'objet recherché
     * @return l'objet de l'énumération correspondant au libellé fournit
     * si le libellé est inconnu
     */
    public static Optional<BeanDAOLinker> fromDaoClassName(String lab) {
        return Optional.ofNullable(valuesAsList().stream().filter(m -> m.getDaoClassName().equalsIgnoreCase(lab)).findAny().orElse(null));
    }

    /**
     * Permet de récupérer la classe d'implémentation pour le nom de paramètre fourni.
     *
     * @param paramName nom du paramètre dont on souhaite récupérer la classe d'implémentation
     * @return la classe d'implémentation correspondant au type de paramètre fourni
     */
    public static Class<?> getClassForBeanClassName(String paramName) throws ClassNotFoundException {
        Class<?> implementationClass = BeanDAOLinker.fromBeanClassName(paramName).getClass();
        if (implementationClass == null) {
            throw new ClassNotFoundException();
        }
        return implementationClass;
    }

    /**
     * Permet de récupérer la classe d'implémentation pour le nom de paramètre fourni.
     *
     * @param paramName nom du paramètre dont on souhaite récupérer la classe d'implémentation
     * @return la classe d'implémentation correspondant au type de paramètre fourni
     */
    public static Class<?> getClassForDaoClassName(String paramName) throws ClassNotFoundException {
        Class<?> implementationClass = BeanDAOLinker.fromDaoClassName(paramName).getClass();
        if (implementationClass == null) {
            throw new ClassNotFoundException();
        }
        return implementationClass;
    }

    /**
     * Permet d'obtenir une liste des valeurs de l'énumération
     * {@link BeanDAOLinker}.
     *
     * @return la liste des valeurs de l'énumération {@link BeanDAOLinker}
     */
    public static List<BeanDAOLinker> valuesAsList() {
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