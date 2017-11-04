package db.mapper;

import db.bean.*;
import db.dao.*;
import db.mapper.classes.MaAbstractBeanClasse;
import db.mapper.classes.MaBeanClasse;
import db.mapper.classes.MaExceptionContructorBeanClasse;

import org.junit.Assert;
import org.junit.Test;

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

        MapperResult paysDAOMapRes = BeanDaoMapper.mapBeanToDAO(paysBean);
        Assert.assertEquals(paysDAO, paysDAOMapRes.getMapped().get());
        Assert.assertTrue(paysDAOMapRes.getMapperErrors().isEmpty());

    }

    @Test
    public void mapBeanToDAO_Adherent() {

        MapperResult adhMapRes = BeanDaoMapper.mapBeanToDAO(adherentBean);
        Assert.assertEquals(adherentDAO, adhMapRes.getMapped().get());
        Assert.assertTrue(adhMapRes.getMapperErrors().isEmpty());

    }

    @Test
    public void mapBeanToDAO_Adresse() {

        MapperResult adMapRes = BeanDaoMapper.mapBeanToDAO(adresseBean);
        Assert.assertEquals(adresseDAO, adMapRes.getMapped().get());
        Assert.assertTrue(adMapRes.getMapperErrors().isEmpty());

    }

    @Test
    public void mapBeanToDAO_Article() {

        MapperResult arMapRes = BeanDaoMapper.mapBeanToDAO(articleBean);
        Assert.assertEquals(articleDAO, arMapRes.getMapped().get());
        Assert.assertTrue(arMapRes.getMapperErrors().isEmpty());

    }

    @Test
    public void mapDAOToBean_Adherent() {

        MapperResult adhMapRes = BeanDaoMapper.mapDAOToBean(adherentDAO);
        Assert.assertEquals(adherentBean, adhMapRes.getMapped().get());
        Assert.assertTrue(adhMapRes.getMapperErrors().isEmpty());

    }

    @Test
    public void mapDAOToBean_Adresse() {

        MapperResult adrMapRes = BeanDaoMapper.mapDAOToBean(adresseDAO);
        Assert.assertEquals(adresseBean, adrMapRes.getMapped().get());
        Assert.assertTrue(adrMapRes.getMapperErrors().isEmpty());

    }

    @Test
    public void mapDAOToBean_Article() {

        MapperResult adrMapRes = BeanDaoMapper.mapDAOToBean(articleDAO);
        Assert.assertEquals(articleBean, adrMapRes.getMapped().get());
        Assert.assertTrue(adrMapRes.getMapperErrors().isEmpty());

    }

    @Test
    public void mapDAOToBean_Pays() {

        MapperResult adrMapRes = BeanDaoMapper.mapDAOToBean(paysDAO);
        Assert.assertEquals(paysBean, adrMapRes.getMapped().get());
        Assert.assertTrue(adrMapRes.getMapperErrors().isEmpty());

    }

    @Test
    public void mapBeanToDAO_BEAN_DAO_LINKER_EXCEPTION() {

        MapperResult arMapRes = BeanDaoMapper.mapBeanToDAO(new MaBeanClasse("hey", 0));
        Assert.assertFalse(arMapRes.getMapperErrors().isEmpty());
        Assert.assertEquals(1, arMapRes.getMapperErrors().size());
        Assert.assertEquals(MapperErrorType.BEAN_DAO_LINKER_EXCEPTION, arMapRes.getMapperErrors().get(0).getMapperErrorType());

        System.out.println(arMapRes);

    }

    @Test
    public void mapDAOToBean_instantiate_ILLEGAL_ARGUMENT_EXCEPTION() {

        MapperResult mapperResult = BeanDaoMapper.instantiate(MaBeanClasse.class, new Class[]{String.class, Integer.class}, new Object[]{"coucou", "coucou"});
        Assert.assertFalse(mapperResult.getMapped().isPresent());
        Assert.assertFalse(mapperResult.getMapperErrors().isEmpty());
        Assert.assertEquals(1, mapperResult.getMapperErrors().size());
        System.out.println(mapperResult);
        Assert.assertEquals(MapperErrorType.ILLEGAL_ARGUMENT_EXCEPTION, mapperResult.getMapperErrors().get(0).getMapperErrorType());

        System.out.println(mapperResult);

    }

    @Test
    public void mapDAOToBean_instantiate_INSTANTIATION_EXCEPTION() {

        MapperResult mapperResult = BeanDaoMapper.instantiate(MaAbstractBeanClasse.class, new Class[]{String.class, Integer.class}, new Object[]{"coucou", new Integer(2)});
        Assert.assertFalse(mapperResult.getMapped().isPresent());
        Assert.assertFalse(mapperResult.getMapperErrors().isEmpty());
        Assert.assertEquals(1, mapperResult.getMapperErrors().size());
        Assert.assertEquals(MapperErrorType.INSTANTIATION_EXCEPTION, mapperResult.getMapperErrors().get(0).getMapperErrorType());

        System.out.println(mapperResult);

    }

    @Test
    public void mapDAOToBean_instantiate_NO_SUCH_METHOD_EXCEPTION() {

        MapperResult mapperResult = BeanDaoMapper.instantiate(MaBeanClasse.class, new Class[]{String.class, String.class}, new Object[]{"coucou", 2});
        Assert.assertFalse(mapperResult.getMapped().isPresent());
        Assert.assertFalse(mapperResult.getMapperErrors().isEmpty());
        Assert.assertEquals(1, mapperResult.getMapperErrors().size());
        Assert.assertEquals(MapperErrorType.NO_SUCH_METHOD_EXCEPTION, mapperResult.getMapperErrors().get(0).getMapperErrorType());

        System.out.println(mapperResult);

    }

    @Test
    public void mapDAOToBean_instantiate_INVOCATION_TARGET_EXCEPTION() {

        MapperResult mapperResult = BeanDaoMapper.instantiate(MaExceptionContructorBeanClasse.class, new Class[]{String.class, Integer.class}, new Object[]{"coucou", 2});
        Assert.assertFalse(mapperResult.getMapped().isPresent());
        Assert.assertFalse(mapperResult.getMapperErrors().isEmpty());
        Assert.assertEquals(1, mapperResult.getMapperErrors().size());
        Assert.assertEquals(MapperErrorType.INVOCATION_TARGET_EXCEPTION, mapperResult.getMapperErrors().get(0).getMapperErrorType());

        System.out.println(mapperResult);

    }


}