package com.miage.webservices.exo1.server;

import org.testng.annotations.*;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

import static org.testng.Assert.*;

/**
 * Created by anthony on 25/01/2017.
 */
public class CalculetteImplTest {
    private CalculetteInterface calc;

    @BeforeClass
    public void setUp() throws Exception {
        URL url = new URL("http://localhost:9999/ws/calc?wsdl");
        QName qname = new QName("http://server.exo1.webservices.miage.com/", "CalculetteImplService");
        Service service = Service.create(url, qname);
        calc = service.getPort(CalculetteInterface.class);
    }

    @AfterClass
    public void tearDown() throws Exception {
        calc = null;
    }

    @Test
    public void testAjouter() throws Exception {
        assertEquals(calc.ajouter(2,3),5.0);
    }

    @Test
    public void testSoustraire() throws Exception {
        assertEquals(calc.soustraire(2,3),-1.0);
    }

}