package com.miage.webservices.exo1.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by anthony on 25/01/2017.
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CalculetteInterface {
    @WebMethod double ajouter(double a, double b);
    @WebMethod double soustraire(double a, double b);
}