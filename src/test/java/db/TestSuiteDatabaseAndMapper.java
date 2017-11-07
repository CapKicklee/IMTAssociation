package db;

import db.manager.DataBaseManagerUtilsTest;
import db.mapper.BeanDaoMapperTest;
import db.services.jpa.JPAServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        DataBaseManagerUtilsTest.class,
        BeanDaoMapperTest.class,
        JPAServiceTest.class
})

public class TestSuiteDatabaseAndMapper {
}
