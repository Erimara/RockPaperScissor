package org.example.entities.opponent;

import org.example.entities.Opponent;
import org.example.entities.opponentBehaviour.KlockisBehaviour;
import org.example.entities.opponentBehaviour.NamnisBehaviour;
import org.example.entities.opponentBehaviour.SlumpisBehaviour;

import java.util.ArrayList;
import java.util.List;

public class AllOpponents {
    private static final AllOpponents instance = new AllOpponents();
    List<Opponent> entities = new ArrayList<>();
    public AllOpponents(){

        Opponent klockis = new Klockis("Klockis", new KlockisBehaviour());
        Opponent namnis = new Namnis("Namnis", new NamnisBehaviour());
        Opponent slumpis = new Slumpis("Slumpis", new SlumpisBehaviour());
        entities.add(klockis);
        entities.add(namnis);
        entities.add(slumpis);
    }

    public static AllOpponents getInstance(){
        return instance;
    }
    public List<Opponent> getOpponents(){
        return entities;
    }
}
