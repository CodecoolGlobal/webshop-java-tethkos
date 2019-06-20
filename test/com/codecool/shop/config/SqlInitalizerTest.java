package com.codecool.shop.config;




import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SqlInitalizerTest {

    @Test
    public void testSqlImplement()
    {

        SqlInitalizer sqlInitalizer = new SqlInitalizer();

        ArrayList<String> tesztList = new ArrayList<>();
        tesztList.add("tetko");
        tesztList.add("1000");
        tesztList.add("HUF");
        tesztList.add("king tetko");
        tesztList.add("Famous people");
        tesztList.add("Pony Wave");




        assertEquals(tesztList, sqlInitalizer.sqlTest(tesztList) );


    }


}