package db.mapper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import db.bean.Bean;
import db.dao.DAO;

/**
 * Classe utilitaire
 * Mapper permettant de passer objet {@link DAO} à un {@link Bean} et inversement
 *
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public class BeanDaoMapper {

    /**
     * Permet l'instanciation d'un dao à partir d'un {@link Bean}
     *
     * @param bean le {@link Bean} à partir duquel on veux créer un {@link DAO}
     * @return un résultat de mapping comprenant le {@link DAO} résultat et les éventuelles erreurs de traitement
     */
    public static MapperResult mapBeanToDAO(Bean bean) {

        String beanClasseName = bean.getClass().getName();
        Object[] values = bean.getObjectValues();

        MapperResult mapperResultDao = new MapperResult();

        Optional<BeanDAOLinker> beanDAOLinker = BeanDAOLinker.fromBeanClassName(beanClasseName);
        if (beanDAOLinker.isPresent()) {

            Class<?> daoClass = beanDAOLinker.get().getDaoImplementationClass();
            Class[] constructorDaoTypes = beanDAOLinker.get().getDaoConstructorTypes();

            mapperResultDao = instantiate(daoClass, constructorDaoTypes, values);

        } else {
            MapperError mapperError = new MapperError(MapperErrorType.BEAN_DAO_LINKER_EXCEPTION);
            mapperError.addComplement("Classe concernée : " + beanClasseName);
            mapperResultDao.addMapError(mapperError);
        }
        return mapperResultDao;

    }

    /**
     * Permet l'instanciation d'un database.bean à partir d'un {@link DAO}
     *
     * @param dao le dao à partir duquel on veux créer un {@link Bean}
     * @return un résultat de mapping comprenant le {@link Bean} résultat et les éventuelles erreurs de traitement
     */
    public static MapperResult mapDAOToBean(DAO dao) {

        String daoClasseName = dao.getClass().getName();
        Object[] values = dao.getObjectValues();

        Optional<BeanDAOLinker> beanDAOLinker = BeanDAOLinker.fromDaoClassName(daoClasseName);
        MapperResult mapperResultBean = new MapperResult();

        if (beanDAOLinker.isPresent()) {

            Class<?> daoClass = beanDAOLinker.get().getBeanImplementationClass();
            Class[] constructorBeanTypes = beanDAOLinker.get().getBeanConstructorTypes();

            mapperResultBean = instantiate(daoClass, constructorBeanTypes, values);

        } else {
            MapperError mapperError = new MapperError(MapperErrorType.BEAN_DAO_LINKER_EXCEPTION);
            mapperError.addComplement("Classe concernée : " + daoClasseName);
            mapperResultBean.addMapError(mapperError);
        }

        return mapperResultBean;

    }

    protected static MapperResult instantiate(Class<?> classe, Class[] constructorTypes, Object[] params) {

        Optional<Mappable> op = Optional.empty();

        MapperResult mapperResult = new MapperResult();

        try {

            //Récupération du constructeur
            Constructor ct = classe.getConstructor(constructorTypes);

            // Instanciation de l'objet
            Mappable object = (Mappable) ct.newInstance(params);
            op = Optional.of(object);

        } catch (SecurityException e) {
            MapperError mapperError = new MapperError(MapperErrorType.SECURITY_EXCEPTION);
            mapperError.addComplement(e.getMessage());
            mapperResult.addMapError(mapperError);
        } catch (IllegalArgumentException e) {
            MapperError mapperError = new MapperError(MapperErrorType.ILLEGAL_ARGUMENT_EXCEPTION);
            mapperError.addComplement("Erreur dans l'utilisation du constructeur de la classe " + classe);
            mapperError.addComplement(e.getMessage());
            mapperResult.addMapError(mapperError);
        } catch (InstantiationException e) {
            MapperError mapperError = new MapperError(MapperErrorType.INSTANTIATION_EXCEPTION);
            mapperError.addComplement("Classe concernée " + classe);
            mapperError.addComplement(e.getMessage());
            mapperResult.addMapError(mapperError);
        } catch (IllegalAccessException e) {
            MapperError mapperError = new MapperError(MapperErrorType.ILLEGAL_ACCESS_EXCEPTION);
            mapperError.addComplement("Classe concernée " + classe);
            mapperError.addComplement(e.getMessage());
            mapperResult.addMapError(mapperError);
        } catch (NoSuchMethodException e) {
            MapperError mapperError = new MapperError(MapperErrorType.NO_SUCH_METHOD_EXCEPTION);
            mapperError.addComplement("La classe " + classe + " n'a pas le constructeur recherché (avec les paramètres " + constructorTypes + ")");
            mapperError.addComplement(e.getMessage());
            mapperResult.addMapError(mapperError);
        } catch (InvocationTargetException e) {
            MapperError mapperError = new MapperError(MapperErrorType.INVOCATION_TARGET_EXCEPTION);
            mapperError.addComplement("Classe concernée " + classe);
            mapperError.addComplement(e.getMessage());
            mapperResult.addMapError(mapperError);
        }

        mapperResult.setMapped(op);
        return mapperResult;
    }
}