package DataBaseMap;

import Bean.Bean;
import DAO.DAO;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BeanDAOMapper {

    public static DAO mapBeanToDAO(String beanClasseName, Object[] values) {

            MapperEnum mapperEnum = MapperEnum.fromBeanClassName(beanClasseName);
            Class<?> daoClass = mapperEnum.getDaoImplementationClass();
            Class[] constructorDaoTypes = mapperEnum.getDaoConstructorTypes();
        return (DAO) instantiate(daoClass, constructorDaoTypes, values);

    }

    public static Bean mapDAOToBean(String beanClasseName, Object[] values) {

        MapperEnum mapperEnum = MapperEnum.fromDaoClassName(beanClasseName);
        Class<?> daoClass = mapperEnum.getBeanImplementationClass();
        Class[] constructorBeanTypes = mapperEnum.getBeanConstructorTypes();
        return (Bean) instantiate(daoClass, constructorBeanTypes, values);

    }

    private static Object instantiate(Class<?> classe, Class[] constructorTypes, Object[] params) {

        Object object = null;

        try {

            // Nouvelle instance de la classe dao correspondante au bean fournit
            Object o = classe.newInstance();

            //On récupère le constructeur avec les deux paramètres
            Constructor ct = classe.getConstructor(constructorTypes);

            //On instancie l'objet avec le constructeur surchargé !
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