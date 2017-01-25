package com.miage.webservices.exo2.server;

import com.miage.webservices.exo2.radars.Amende;
import com.miage.webservices.exo2.radars.Voiture;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by anthony on 25/01/2017.
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface SystemeAmendes {
    @WebMethod void enregistrer(Voiture v);
    @WebMethod int signaler(String immatriculation, String modele, int tarif);
    @WebMethod List<Amende> lister(String immatriculation);
    @WebMethod int payer(int numero, String nom, String prenom);
}