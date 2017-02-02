package com.miage.webservices.exo2.server;

import com.miage.webservices.exo1.server.CalculetteImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by anthony on 25/01/2017.
 */
public class SystemePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/saam", new SystemeAmendesImpl());
    }
}
