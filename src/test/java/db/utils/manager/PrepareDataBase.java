package db.utils.manager;

import db.dao.*;
import db.services.jpa.JPAResult;
import db.services.persistence.*;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class PrepareDataBase {

    public static final JPAPersistence adherentJPAPersistence = new AdherentJPAPersistence();
    public static final JPAPersistence adresseJPAPersistence = new AdresseJPAPersistence();
    public static final JPAPersistence articleJPAPersistence = new ArticleJPAPersistence();
    public static final JPAPersistence paysJPAPersistence = new PaysJPAPersistence();

    public static PaysDAO paysDAO = new PaysDAO("AT", "AUTRICHE");
    public static AdresseDAO adresseDAO = new AdresseDAO(1, "rue du puit", 44800, "Nantes", paysDAO);
    public static ArticleDAO articleDAO = new ArticleDAO("codeArticle1", "pull", "Super pull", 45.2, 45, "img/");
    public static AdherentDAO adherentDAO = new AdherentDAO("Dede", "hein", "Dede", "Guigui", adresseDAO);

    public static void prepare() {

        deleteAll();
        insertData();

    }

    private static void deleteAll() {

        JPAResult<List<AdherentDAO>> listAdherentRes = adherentJPAPersistence.loadAll();
        Assert.assertTrue(listAdherentRes.getResult().isPresent());
        for (AdherentDAO dao : listAdherentRes.getResult().get()) {
            JPAResult res = adherentJPAPersistence.delete(dao);
            Assert.assertTrue(res.getResult().isPresent());
        }

        JPAResult<List<AdresseDAO>> listAdresseRes = adresseJPAPersistence.loadAll();
        Assert.assertTrue(listAdresseRes.getResult().isPresent());
        for (AdresseDAO dao : listAdresseRes.getResult().get()) {
            JPAResult res = adresseJPAPersistence.delete(dao);
            Assert.assertTrue(res.getResult().isPresent());
        }

        JPAResult<List<PaysDAO>> listPaysRes = paysJPAPersistence.loadAll();
        Assert.assertTrue(listPaysRes.getResult().isPresent());
        for (PaysDAO dao : listPaysRes.getResult().get()) {
            JPAResult res = paysJPAPersistence.delete(dao);
            Assert.assertTrue(res.getResult().isPresent());
        }

        JPAResult<List<ArticleDAO>> listArticleRes = articleJPAPersistence.loadAll();
        Assert.assertTrue(listArticleRes.getResult().isPresent());
        for (ArticleDAO dao : listArticleRes.getResult().get()) {
            JPAResult res = articleJPAPersistence.delete(dao);
            Assert.assertTrue(res.getResult().isPresent());
        }


    }

    private static <T> void delete(JPAResult<List<T>> listRes, JPAPersistence jpaPersistence) {
        Assert.assertTrue(listRes.getResult().isPresent());
        for (T dao : listRes.getResult().get()) {
            JPAResult res = jpaPersistence.delete(dao);
            Assert.assertTrue(res.getResult().isPresent());
        }
    }

    private static void insertData() {

        List<PaysDAO> listPays = Arrays.asList(new PaysDAO("FR", "FRANCE"),
                new PaysDAO("AT", "AUTRICHE"),
                new PaysDAO("AR", "ARGENTINE"),
                new PaysDAO("BL", "BELGIQUE"),
                new PaysDAO("CH", "SUISSE"),
                new PaysDAO("ES", "ESPAGNE"),
                new PaysDAO("FI", "FINLANDE"),
                new PaysDAO("GB", "GRANDE BRETAGNE"),
                new PaysDAO("IT", "ITALIE"),
                new PaysDAO("NL", "PAYS-BAS"),
                new PaysDAO("NO", "NORVEGE"),
                new PaysDAO("PT", "PORTUGAL"),
                new PaysDAO("SE", "SUEDE"),
                new PaysDAO("US", "ETATS UNIS"));
        for (PaysDAO pays : listPays) {
            JPAResult res = paysJPAPersistence.insert(pays);
            //Assert.assertTrue(res.getResult().isPresent());
        }

        List<AdresseDAO> listAdresse = Arrays.asList(
                new AdresseDAO(1, "rue du puit", 44800, "Nantes", paysDAO),
                new AdresseDAO(2, "rue du poids", 44800, "Nantes", paysDAO),
                new AdresseDAO(3, "rue du coucou", 44800, "Nantes", paysDAO));
        for (AdresseDAO adresse : listAdresse) {
            JPAResult res = adresseJPAPersistence.insert(adresse);
            //Assert.assertTrue(res.getResult().isPresent());
        }

        List<AdherentDAO> listAdherent = Arrays.asList(
                new AdherentDAO("Dede", "hein", "Dede", "Guigui", adresseDAO),
                new AdherentDAO("Juju", "fouine", "Juju", "Guigui", adresseDAO),
                new AdherentDAO("Cloclo", "patate", "Cloclo", "Guigui", adresseDAO));
        for (AdherentDAO adherent : listAdherent) {
            JPAResult res = adherentJPAPersistence.insert(adherent);
            //Assert.assertTrue(res.getResult().isPresent());
        }

        List<ArticleDAO> listArticle = Arrays.asList(
                new ArticleDAO("ca1", "pull", "Super pull", 45.2, 45, "casquette.jpg"),
                new ArticleDAO("ca2", "sweet", "Super sweet", 41.0, 12, "articles.png")
                );
        for (ArticleDAO article : listArticle) {
            JPAResult res = articleJPAPersistence.insert(article);
            //Assert.assertTrue(res.getResult().isPresent());
        }

    }

}
