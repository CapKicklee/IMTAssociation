package database.mapper;

import database.bean.*;
import database.dao.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class BeanDaoMapperTest {

    private final Pays paysBean = new Pays("FR", "France");
    private final PaysDAO paysDAO = new PaysDAO("FR","France");

    private final Adresse adresseBean = new Adresse(156646578, "uneRue", 44000, "uneVille", paysBean);
    private final AdresseDAO adresseDAO = new AdresseDAO(156646578, "uneRue", 44000, "uneVille", paysDAO);

    private final Adherent adherentBean = new Adherent("unLog", "unMdp", "unName", "unPrenom", adresseBean);
    private final AdherentDAO adherentDAO = new AdherentDAO("unLog", "unMdp", "unName", "unPrenom", adresseDAO);

    private final Article articleBean = new Article("unCode", "unNom", new Double(4578), 78, null);
    private final ArticleDAO articleDAO = new ArticleDAO("unCode", "unNom", "uneDescription",new Double(4578), 78, null);

    @Test
    public void mapBeanToDAO_Pays() {

        Optional<DAO> paysDAOOp = BeanDaoMapper.mapBeanToDAO(paysBean);
        Assert.assertEquals(paysDAO, paysDAOOp.get());

    }

    @Test
    public void mapBeanToDAO_Adherent() {

        Optional<DAO> adh = BeanDaoMapper.mapBeanToDAO(adherentBean);
        Assert.assertEquals(adherentDAO, adh.get());

    }

    @Test
    public void mapBeanToDAO_Adresse() {

        Optional<DAO> ad = BeanDaoMapper.mapBeanToDAO(adresseBean);
        Assert.assertEquals(adresseDAO, ad.get());

    }

    @Test
    public void mapBeanToDAO_Article() {

        Optional<DAO> ar = BeanDaoMapper.mapBeanToDAO(articleBean);
        Assert.assertEquals(articleDAO, ar.get());

    }

    @Test
    public void mapDAOToBean_Adherent() {

        Optional<Bean> adh = BeanDaoMapper.mapDAOToBean(adherentDAO);
        Assert.assertEquals(adherentBean, adh.get());

    }

    @Test
    public void mapDAOToBean_Adresse() {

        Optional<Bean> adr = BeanDaoMapper.mapDAOToBean(adresseDAO);
        Assert.assertEquals(adresseBean, adr.get());

    }

    @Test
    public void mapDAOToBean_Article() {

        Optional<Bean> adr = BeanDaoMapper.mapDAOToBean(articleDAO);
        Assert.assertEquals(articleBean, adr.get());

    }

    @Test
    public void mapDAOToBean_Pays() {

        Optional<Bean> adr = BeanDaoMapper.mapDAOToBean(paysDAO);
        Assert.assertEquals(paysBean, adr.get());

    }

}