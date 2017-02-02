package com.miage.webservices.exo2.server;

import com.miage.webservices.exo2.radars.Amende;
import com.miage.webservices.exo2.radars.Voiture;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthony on 25/01/2017.
 */
import javax.jws.WebService;

@WebService(endpointInterface = "com.miage.webservices.exo2.server.SystemeAmendes")
public class SystemeAmendesImpl implements SystemeAmendes{
    List<Voiture> listVoitureEnregistrees = new ArrayList<>();
    List<Amende> listAmende = new ArrayList<>();

    @Override
    public void enregistrer(Voiture v) {
        listVoitureEnregistrees.add(v);
        System.out.println("Voiture enregistrée\n" + v.toString());
    }

    @Override
    public int signaler(String immatriculation, String modele, int tarif) {
        for(Voiture v : listVoitureEnregistrees){
            if(v.getImmatriculation().equals(immatriculation) && v.getModele().equals(modele)){
                Amende a = new Amende(immatriculation, tarif);
                listAmende.add(a);
                System.out.println("Amende enregistrée\n" + a.toString());
                return listAmende.get(listAmende.size() - 1).getNumero();
            }
        }
        return -1;
    }

    @Override
    public Amende[] lister(String immatriculation) {
        int i = 0;
        Amende[] amendes = new Amende[80];
        for(Voiture v : listVoitureEnregistrees){
            if(v.getImmatriculation().equals(immatriculation)){
                for(Amende a : listAmende){
                    if(a.getImmatriculation().equals(immatriculation)){
                        amendes[i] = a;
                        i++;
                    }
                }
            }
        }

        return amendes;
    }

    @Override
    public void payer(int numero, String nom, String prenom) {
        Amende amende = listAmende.get(numero - 1);

        for(Voiture v : listVoitureEnregistrees){
            if(amende.getImmatriculation().equals(v.getImmatriculation())){
                if(v.getProprietaire().getNom().equals(nom)
                        && v.getProprietaire().getPrenom().equals(prenom)){
                    System.out.println("Amende payée\n" + amende.toString());
                    listAmende.remove(numero - 1);
                }
            }
        }
    }
}
