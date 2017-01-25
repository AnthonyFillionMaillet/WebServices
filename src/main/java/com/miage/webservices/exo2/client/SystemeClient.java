package com.miage.webservices.exo2.client;

import com.miage.webservices.exo1.server.CalculetteInterface;
import com.miage.webservices.exo2.radars.Amende;
import com.miage.webservices.exo2.radars.Personne;
import com.miage.webservices.exo2.radars.Voiture;
import com.miage.webservices.exo2.server.SystemeAmendes;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * Created by anthony on 25/01/2017.
 */
public class SystemeClient {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:9999/ws/saam?wsdl");
        QName qname = new QName("http://server.exo2.webservices.miage.com/", "SystemeAmendesImplService");
        Service service = Service.create(url, qname);
        SystemeAmendes sys = service.getPort(SystemeAmendes.class);

        Voiture v1 = new Voiture("AB 123 CD", "Clio 3");
        sys.enregistrer(v1);
        Voiture v2 = new Voiture("AB 124 CD", "Punto");
        sys.enregistrer(v2);

        Personne p1 = new Personne("Sponge", "Bob", "");
        v1.setProprietaire(p1);
        Personne p2 = new Personne("Haddock", "Capitaine", "");
        v2.setProprietaire(p2);

        System.out.println("Voiture enregistrée\n" + v1.toString());
        System.out.println("Voiture enregistrée\n" + v2.toString());

        Amende a1 = new Amende("AB 123 CD", 90);
        int result = sys.signaler(a1.getImmatriculation(), v1.getModele(), 90);
        if(result != -1)
            System.out.println("Amende enregistrée\n" + a1.toString());

        Amende a2 = new Amende("AB 123 CD", 140);
        result = sys.signaler(a1.getImmatriculation(), "Tracteur", 90);
        if(result != -1)
            System.out.println("Amende enregistrée\n" + a1.toString());

        Amende a3 = new Amende("AB 123 CD", 140);
        result = sys.signaler(v1.getImmatriculation(), v1.getModele(), 90);
        if(result != -1)
            System.out.println("Amende enregistrée\n" + a1.toString());
    }
}
