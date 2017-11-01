package DataBaseMapper;

import Bean.Bean;
import DAO.DAO;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Mapper permettant de passer objet {@link DAO} à un {@link Bean} et inversement
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public class BeanDAOMapper {

    /**
     * Permet l'instanciation d'un DAO à partir d'un {@link Bean}
     *
     * @param bean le {@link Bean} à partir duquel on veux créer un {@link DAO}
     * @return un DAO crée à partir des informations du Bean
     */
    public static DAO mapBeanToDAO(Bean bean) {

        String beanClasseName = bean.getClass().getName();
        Object[] values = bean.getObjectValues();

        MapperEnum mapperEnum = MapperEnum.fromBeanClassName(beanClasseName);
        Class<?> daoClass = mapperEnum.getDaoImplementationClass();
        Class[] constructorDaoTypes = mapperEnum.getDaoConstructorTypes();

        return (DAO) instantiate(daoClass, constructorDaoTypes, values);

    }

    /**
     * Permet l'instanciation d'un Bean à partir d'un {@link DAO}
     *
     * @param dao le dao à partir duquel on veux créer un {@link Bean}
     * @return un {@link Bean} crée à partir des informations du {@link DAO}
     */
    public static Bean mapDAOToBean(DAO dao) {

        String daoClasseName = dao.getClass().getName();
        Object[] values = dao.getObjectValues();

        MapperEnum mapperEnum = MapperEnum.fromDaoClassName(daoClasseName);
        Class<?> daoClass = mapperEnum.getBeanImplementationClass();
        Class[] constructorBeanTypes = mapperEnum.getBeanConstructorTypes();

        return (Bean) instantiate(daoClass, constructorBeanTypes, values);

    }

    private static Object instantiate(Class<?> classe, Class[] constructorTypes, Object[] params) {

        Object object = null;

        try {

            // Nouvelle instance de la classe dao correspondante au bean fournit
            Object o = classe.newInstance();

            //Récupération du constructeur
            Constructor ct = classe.getConstructor(constructorTypes);

            // Instanciation de l'objet
            object = ct.newInstance(params);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return object;
    }
}