package db.manager;

import db.bean.*;
import db.dao.*;
import db.services.persistence.*;
import db.services.persistence.AdherentJPAPersistence;
import db.services.persistence.AdresseJPAPersistence;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static db.manager.DataBaseManagerUtils.*;


/**
 * Classe utilitaire donnant d'accès à la base de données.
 *
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public class DataBaseManager {

    public static final AdherentJPAPersistence jpaAdherent = new AdherentJPAPersistence();
    public static final AdresseJPAPersistence jpaAdresse = new AdresseJPAPersistence();
    public static final ArticleJPAPersistence jpaArticle = new ArticleJPAPersistence();
    public static final PaysJPAPersistence jpaPays = new PaysJPAPersistence();

    //====================================================================
    //---------------------------ADHERENT---------------------------------
    //====================================================================

    public static void insertAdherent(AdherentDAO adherent, HttpServletResponse response) throws IOException {
        insert(adherent, jpaAdherent, response);
    }

    public static Optional<Long> countAllAdherent(HttpServletResponse response) throws IOException {
        return countAll(jpaAdherent, response);
    }

    public static Optional<AdherentBean> loadAdherent(String login, HttpServletResponse response) throws IOException {
        return load(login, jpaAdherent, response);
    }

    public static Optional<Boolean> deleteAdherent(AdherentDAO adherent) {
        throw new RuntimeException("Not implemented");
    }

    public static Optional<Boolean> deleteAdherent(String login) {
        throw new RuntimeException("Not implemented");
    }

    public static Optional<AdherentBean> saveAdherent(AdherentBean adherent, HttpServletResponse response) throws IOException {
        return save(adherent, jpaAdresse, response);
    }

    public static Optional<Long> countAllAdherent() {
        throw new RuntimeException("Not implemented");
    }

    //====================================================================
    //---------------------------ADRESSE----------------------------------
    //====================================================================


    public static void insertAdresse(AdresseDAO adresseDAO, HttpServletResponse response) throws IOException {
        insert(adresseDAO, jpaAdresse, response);
    }

    public static Optional<Long> countAllAdresse(HttpServletResponse response) throws IOException {
        return countAll(jpaAdresse, response);
    }

    public static Optional<Boolean> deleteAdresse(AdresseDAO adresse) {
        throw new RuntimeException("Not implemented");
    }

    public static Optional<Boolean> deleteAdresse(Integer id) {
        throw new RuntimeException("Not implemented");

    }

    public static Optional<Boolean> insertAdresse(AdresseDAO adresse) {
        throw new RuntimeException("Not implemented");
    }

    public static Optional<AdresseBean> loadAdresse(Integer id) {
        throw new RuntimeException("Not implemented");

    }

    public static Optional<AdresseBean> saveAdresse(AdresseBean adresse, HttpServletResponse response) throws IOException {
        return save(adresse, jpaAdresse, response);
    }

    public static Optional<Long> countAllAdresse() {
        throw new RuntimeException("Not implemented");
    }

    //====================================================================
    //---------------------------ARTICLE----------------------------------
    //====================================================================

    public static Optional<List<ArticleBean>> loadAllArticles(HttpServletResponse response) throws IOException {
        return loadAll(jpaArticle, response);
    }

    public static Optional<Long> countAllArticles(HttpServletResponse response) throws IOException {
        return countAll(jpaArticle, response);
    }

    public static Optional<ArticleBean> loadArticle(String code, HttpServletResponse response) throws IOException {
        return load(code, jpaArticle, response);
    }

    public static Optional<Boolean> deleteArticle(ArticleDAO article) {
        throw new RuntimeException("Not implemented");

    }

    public static Optional<Boolean> deleteArticle(String code) {
        throw new RuntimeException("Not implemented");
    }

    public static Optional<Boolean> insertArticle(ArticleDAO article) {
        throw new RuntimeException("Not implemented");
    }

    public static Optional<ArticleBean> saveArticle(ArticleBean article, HttpServletResponse response) throws IOException {
        return save(article, jpaArticle, response);
    }

    public static Optional<Long> countAllArticle() {
        throw new RuntimeException("Not implemented");
    }

    //====================================================================
    //-----------------------------PAYS-----------------------------------
    //====================================================================

    public static Optional<List<PaysBean>> loadAllPays(HttpServletResponse response) throws IOException {
        return loadAll(jpaPays, response);
    }

    public static Optional<Long> countAllPays(HttpServletResponse response) throws IOException {
        return countAll(jpaPays, response);
    }

    public static Optional<PaysBean> loadPays(String login, HttpServletResponse response) throws IOException {
        return load(login, jpaPays, response);
    }

    public static Optional<Boolean> deletePays(PaysDAO pays) {
        throw new RuntimeException("Not implemented");
    }

    public static Optional<Boolean> deletePays(String code) {
        throw new RuntimeException("Not implemented");
    }

    public static Optional<Boolean> insertPays(PaysDAO pays) {
        throw new RuntimeException("Not implemented");
    }

    public static Optional<Boolean> loadPays(String code) {
        throw new RuntimeException("Not implemented");
    }

    public static Optional<PaysBean> savePays(PaysBean pays, HttpServletResponse response) throws IOException {
        return save(pays, jpaPays, response);
    }

    public static Optional<Long> countAllPays() {
        throw new RuntimeException("Not implemented");
    }


}
