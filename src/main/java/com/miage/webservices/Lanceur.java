package com.miage.webservices;

/**
 * Created by anthony on 25/01/2017.
 */
import javax.xml.ws.Endpoint;

public class Lanceur {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:4444/ws/bonjour", new HelloWorldImpl());
    }
}
