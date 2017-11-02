package database.mapper;

import database.bean.Bean;
import database.dao.DAO;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

/**
 * Mapper permettant de passer objet {@link DAO} à un {@link Bean} et inversement
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public class BeanDaoMapper {

    /**
     * Permet l'instanciation d'un dao à partir d'un {@link Bean}
     *
     * @param bean le {@link Bean} à partir duquel on veux créer un {@link DAO}
     * @return un dao crée à partir des informations du database.bean
     */
    public static Optional<DAO> mapBeanToDAO(Bean bean) {

        String beanClasseName = bean.getClass().getName();
        Object[] values = bean.getObjectValues();

        BeanDAOLinker beanDAOLinker = BeanDAOLinker.fromBeanClassName(beanClasseName);
        Class<?> daoClass = beanDAOLinker.getDaoImplementationClass();
        Class[] constructorDaoTypes = beanDAOLinker.getDaoConstructorTypes();

        DAO dao = (DAO) instantiate(daoClass, constructorDaoTypes, values).get();
        return Optional.of(dao);

    }

    /**
     * Permet l'instanciation d'un database.bean à partir d'un {@link DAO}
     *
     * @param dao le dao à partir duquel on veux créer un {@link Bean}
     * @return un {@link Bean} crée à partir des informations du {@link DAO}
     */
    public static Optional<Bean> mapDAOToBean(DAO dao) {

        String daoClasseName = dao.getClass().getName();
        Object[] values = dao.getObjectValues();

        BeanDAOLinker beanDAOLinker = BeanDAOLinker.fromDaoClassName(daoClasseName);
        Class<?> daoClass = beanDAOLinker.getBeanImplementationClass();
        Class[] constructorBeanTypes = beanDAOLinker.getBeanConstructorTypes();

        Bean bean = (Bean) instantiate(daoClass, constructorBeanTypes, values).get();
        return Optional.of(bean);

    }

    private static Optional<Object> instantiate(Class<?> classe, Class[] constructorTypes, Object[] params) {

        Optional<Object> op = Optional.empty();

        try {

            //Récupération du constructeur
            Constructor ct = classe.getConstructor(constructorTypes);

            // Instanciation de l'objet
            Object object = ct.newInstance(params);
            op = Optional.of(object);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Mauvais type de paramètre fournit au constructeur de la classe " + classe);
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("La classe " + classe + " est abstract ou est une interface");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("La classe " + classe + " n'est pas accessible");
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println("La classe " + classe + " n'a pas le constructeur recherché (avec les paramètres " + constructorTypes + ")");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("Exception déclenchée par le constructeur de la classe " + classe);
            e.printStackTrace();
        }

        return op;
    }
}