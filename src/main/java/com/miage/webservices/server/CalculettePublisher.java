package com.miage.webservices.server;

/**
 * Created by anthony on 25/01/2017.
 */
import javax.xml.ws.Endpoint;

public class CalculettePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/calc", new CalculetteImpl());
    }
}
