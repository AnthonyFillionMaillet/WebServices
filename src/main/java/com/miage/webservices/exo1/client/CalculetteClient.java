package com.miage.webservices.exo1.client;

/**
 * Created by anthony on 25/01/2017.
 */

import com.miage.webservices.exo1.server.CalculetteInterface;

import javax.xml.namespace.QName;
import java.net.URL;
import javax.xml.ws.Service;

public class CalculetteClient {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:9999/ws/calc?wsdl");
        QName qname = new QName("http://server.exo1.webservices.miage.com/", "CalculetteImplService");
        Service service = Service.create(url, qname);
        CalculetteInterface calc = service.getPort(CalculetteInterface.class);
        System.out.println("Ajout : " + calc.ajouter(1.2, 4.5));
        System.out.println("Soustraction : " + calc.soustraire(4.2, 2));
    }
}