package com.miage.webservices.exo1.server;

/**
 * Created by anthony on 25/01/2017.
 */
import javax.jws.WebService;

@WebService(endpointInterface = "com.miage.webservices.exo1.server.CalculetteInterface")
public class CalculetteImpl implements CalculetteInterface {

    @Override
    public double ajouter(double a, double b) {
        return a + b;
    }

    @Override
    public double soustraire(double a, double b) {
        return a - b;
    }
}