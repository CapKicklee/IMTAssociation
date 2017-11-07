package db.services.jpa;

import db.utils.manager.PrepareDataBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class JPAServiceTest {

    @Test
    public void testServiceJPA() {
        PrepareDataBase.prepare();
    }

}