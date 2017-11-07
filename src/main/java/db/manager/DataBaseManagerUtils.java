package db.manager;

import db.bean.Bean;
import db.dao.DAO;
import db.mapper.BeanDaoMapper;
import db.mapper.Mappable;
import db.mapper.MapperResult;
import db.services.persistence.JPAPersistence;
import db.services.jpa.JPAResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe utilitaire décrivant les méthodes générique d'accès à la base de données.
 *
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
class DataBaseManagerUtils {

    protected static <B extends Bean, D extends DAO> Optional<List<B>> loadAll(JPAPersistence jpaPersistence, HttpServletResponse response) throws IOException {
        List<B> beanList = null;
        JPAResult<List<D>> jpaRes = jpaPersistence.loadAll();
        if (jpaRes.hasErrors()) {
            response.sendRedirect("/imt.association/erreurDB");
        } else if (jpaRes.getResult().isPresent()) {
            beanList = new ArrayList<>();
            for (D dao : jpaRes.getResult().get()) {
                MapperResult mapRes = BeanDaoMapper.mapDAOToBean(dao);
                Optional<Mappable> map = mapRes.getMapped();
                if (mapRes.hasErrors()) {
                    response.sendRedirect("/imt.association/erreurDB");
                } else if (map.isPresent()) {
                    beanList.add((B) map.get());
                }
            }
        }
        return Optional.ofNullable(beanList);
    }

    protected static <B extends Bean, D extends DAO> Optional<B> load(String key, JPAPersistence jpaPersistence, HttpServletResponse response) throws IOException {
        JPAResult<D> jpaResultat = jpaPersistence.load(key);
        Optional<B> bean = Optional.empty();
        bean = manageDaoToBean(response, jpaResultat, bean);
        return bean;
    }

    protected static void insert(DAO dao, JPAPersistence jpaPersistence, HttpServletResponse response) throws IOException {
        JPAResult<Object> res = jpaPersistence.insert(dao);
        if (!res.getResult().isPresent()) {
            response.sendRedirect("/imt.association/erreurDB");
        }
    }

    protected static Optional<Long> countAll(JPAPersistence jpaPersistence, HttpServletResponse response) throws IOException {
        JPAResult<Long> jpaResult = jpaPersistence.countAll();
        if (jpaResult.hasErrors()) {
            response.sendRedirect("/imt.association/erreurDB");
        } else {
            return Optional.ofNullable(jpaResult.getResult().get());
        }
        return Optional.empty();
    }

    protected static <B extends Bean, D extends DAO> Optional<B> save(Bean daoToSave, JPAPersistence jpaPersistence, HttpServletResponse response) throws IOException {
        Optional<B> bean = Optional.empty();
        MapperResult beanToSaveMapRes = BeanDaoMapper.mapBeanToDAO(daoToSave);
        if (beanToSaveMapRes.hasErrors()) {
            response.sendRedirect("/imt.association/erreurDB");
        } else {
            DAO beanToSave = (D) beanToSaveMapRes.getMapped().get();
            JPAResult<D> jpaResultat = jpaPersistence.save(beanToSave);
            bean = manageDaoToBean(response, jpaResultat, bean);
        }
        return bean;
    }

    private static <B extends Bean, D extends DAO> Optional<B> manageDaoToBean(HttpServletResponse response, JPAResult<D> jpaResultat, Optional<B> bean) throws IOException {
        D dao;
        if (jpaResultat.hasErrors()) {
            response.sendRedirect("/imt.association/erreurDB");
        } else {
            if (jpaResultat.getResult().isPresent()) {
                dao = jpaResultat.getResult().get();
                MapperResult resMap = BeanDaoMapper.mapDAOToBean(dao);
                if (resMap.hasErrors()) {
                    response.sendRedirect("/imt.association/erreurDB");
                } else {
                    bean = Optional.ofNullable((B) resMap.getMapped().get());
                }
            }
        }
        return bean;
    }

}
