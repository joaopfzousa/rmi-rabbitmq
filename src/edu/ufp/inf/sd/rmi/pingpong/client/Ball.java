package edu.ufp.inf.sd.rmi.pingpong.client;

import java.io.Serializable;

public class Ball implements Serializable {

    private int playerId;
    private int counter=0;

    public Ball(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerId() {
        return playerId;
    }
    public void counting(){
        this.counter++;
    }

    public int getCounter(){
        return this.counter;
    }
}
