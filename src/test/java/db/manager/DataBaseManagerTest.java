package db.manager;

import org.junit.Test;

import db.manager.DataBaseManager;

import static org.junit.Assert.*;

public class DataBaseManagerTest {
    @Test
    public void loadAllAdherents() throws Exception {

        System.out.println(DataBaseManager.loadAllAdherents());

    }

}