package db.manager;

import db.bean.Bean;
import db.bean.PaysBean;
import db.dao.DAO;
import db.dao.PaysDAO;
import db.mapper.BeanDaoMapper;
import db.utils.manager.PrepareDataBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class DataBaseManagerUtilsTest {

    @Before
    public void before() {
        PrepareDataBase.prepare();
    }

    @Test
    public void testLoadAll() throws Exception {
        try {
            Optional<List<Bean>> res = DataBaseManagerUtils.loadAll(PrepareDataBase.paysJPAPersistence, null);
            Assert.assertTrue(res.isPresent());
            Assert.assertEquals(14, res.get().size());
        } catch (NullPointerException ex) {
            fail("Erreur base de données");
        }
    }

    @Test
    public void testLoad() throws Exception {
        try {
            Optional<Bean> res = DataBaseManagerUtils.load("FR", PrepareDataBase.paysJPAPersistence, null);
            Assert.assertTrue(res.isPresent());
        } catch (NullPointerException ex) {
            fail("Erreur base de données");
        }
    }

    @Test
    public void testInsert() throws Exception {
        try {
            DAO paysDAO = new PaysDAO("IE", "IRELAND");
            DataBaseManagerUtils.insert(paysDAO, PrepareDataBase.paysJPAPersistence, null);
        } catch (NullPointerException ex) {
            fail("Erreur base de données");
        }
    }

    @Test
    public void testInsert_() throws Exception {
        try {
            DataBaseManagerUtils.insert(PrepareDataBase.paysDAO, PrepareDataBase.paysJPAPersistence, null);
        } catch (NullPointerException ex) {
            assertTrue(true); // "Redirection - pays déjà en base "
        }
    }

    @Test
    public void testCountAll() throws Exception {
        try {
            Optional<Long> res = DataBaseManagerUtils.countAll(PrepareDataBase.paysJPAPersistence, null);
            Assert.assertTrue(res.isPresent());
            Assert.assertEquals(new Long(14), res.get());
        } catch (NullPointerException ex) {
            fail("Erreur base de données");
        }
    }

    @Test
    public void testSave() throws Exception {
        PaysDAO paysDAO = new PaysDAO("AT", "AUTRISHE");
        try {

            Optional<PaysBean> res = DataBaseManagerUtils.save(paysDAO, PrepareDataBase.paysJPAPersistence, null);
            Assert.assertTrue(res.isPresent());
            Assert.assertEquals(res.get(), BeanDaoMapper.mapDAOToBean(paysDAO).getMapped().get());

            res = DataBaseManagerUtils.load("AT", PrepareDataBase.paysJPAPersistence, null);
            Assert.assertTrue(res.isPresent());
            Assert.assertEquals(res.get().getCode(), ((PaysBean) BeanDaoMapper.mapDAOToBean(paysDAO).getMapped().get()).getCode());
            Assert.assertEquals(res.get().getNom(), ((PaysBean) BeanDaoMapper.mapDAOToBean(paysDAO).getMapped().get()).getNom());

        } catch (NullPointerException ex) {
            fail("Erreur base de données");
        }
    }

}