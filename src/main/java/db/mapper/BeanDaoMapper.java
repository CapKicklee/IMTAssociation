package db.mapper;

import db.bean.Bean;
import db.dao.DAO;
import errors.mapper.MapperError;
import errors.mapper.MapperErrorType;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import static errors.ErrorManagerUtils.manageMapperError;

/**
 * Classe utilitaire
 * Mapper permettant de passer objet {@link DAO} à un {@link Bean} et inversement
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public class BeanDaoMapper {

    /**
     * Permet l'instanciation d'un {@link DAO} à partir d'un {@link Bean}
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
     * Permet l'instanciation d'un {@link Bean} à partir d'un {@link DAO}
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

    /**
     * Permet l'instanciation d'un objet automatiquement
     * @param classe la classe à instancier
     * @param constructorTypes les types des paramètres du constructeur
     * @param params les paramètre à fournir au constructeur
     * @return un {@link MapperResult}
     */
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
            manageMapperError(mapperResult, MapperErrorType.SECURITY_EXCEPTION, "Erreur de sécurité" + classe, e);
        } catch (IllegalArgumentException e) {
            manageMapperError(mapperResult, MapperErrorType.ILLEGAL_ARGUMENT_EXCEPTION, "Erreur dans l'utilisation du constructeur de la classe " + classe, e);
        } catch (InstantiationException e) {
            manageMapperError(mapperResult, MapperErrorType.INSTANTIATION_EXCEPTION, "Classe concernée " + classe, e);
        } catch (IllegalAccessException e) {
            manageMapperError(mapperResult, MapperErrorType.ILLEGAL_ACCESS_EXCEPTION, "Classe concernée " + classe, e);
        } catch (NoSuchMethodException e) {
            manageMapperError(mapperResult, MapperErrorType.NO_SUCH_METHOD_EXCEPTION, "La classe " + classe + " n'a pas le constructeur recherché (avec les paramètres " + constructorTypes + ")", e);
        } catch (InvocationTargetException e) {
            manageMapperError(mapperResult, MapperErrorType.INVOCATION_TARGET_EXCEPTION, "Classe concernée " + classe, e);
        }

        mapperResult.setMapped(op);
        return mapperResult;
    }

}