package com.miage.webservices.exo2.server;

import com.miage.webservices.exo2.radars.Amende;
import com.miage.webservices.exo2.radars.Voiture;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthony on 25/01/2017.
 */
public class SystemeAmendesImpl implements SystemeAmendes{
    List<Voiture> listVoitureEnregistrees = new ArrayList<>();
    List<Amende> listAmende = new ArrayList<>();

    @Override
    public void enregistrer(Voiture v) {
        listVoitureEnregistrees.add(v);
    }

    @Override
    public int signaler(String immatriculation, String modele, int tarif) {
        for(Voiture v : listVoitureEnregistrees){
            if(v.getImmatriculation().equals(immatriculation) && v.getModele().equals(modele)){
                listAmende.add(new Amende(immatriculation, tarif));
                return listAmende.get(listAmende.size() - 1).getNumero();
            }
        }
        return -1;
    }

    @Override
    public List<Amende> lister(String immatriculation) {
        List<Amende> amendes = new ArrayList<>();
        for(Voiture v : listVoitureEnregistrees){
            if(v.getImmatriculation().equals(immatriculation)){
                for(Amende a : listAmende){
                    if(a.getImmatriculation().equals(immatriculation)){
                         amendes.add(a);
                    }
                }
            }
        }
        if(!amendes.isEmpty())
            return amendes;
        else
            return null;
    }

    @Override
    public int payer(int numero, String nom, String prenom) {
        listAmende.remove(numero - 1);
        return 0;
    }
}
