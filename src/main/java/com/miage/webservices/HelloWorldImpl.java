package com.miage.webservices;

/**
 * Created by anthony on 25/01/2017.
 */
import javax.jws.WebService;

@WebService(endpointInterface = "com.miage.webservices.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String bonjour(String name) {
        return "Bonjour "+name+"\n";
    }
}