package edu.ufp.inf.sd.rmi.pingpong.client;

import edu.ufp.inf.sd.rmi.pingpong.server.PingRI;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.Random;


public class PongImpl implements PongRI {

    private PingRI pingRI;

    public PongImpl(PingRI myRI) throws RemoteException {
        super();
        this.pingRI = myRI;
    }

    @Override
    public void pong(Ball b) throws RemoteException {
        Random r = new Random();
        int low = 10;
        int high = 100;
        int result = r.nextInt(high-low) + low;

        System.out.println("Pong: ball counting = "+ b.getCounter());
        if(result <= 50)
        {
            this.pingRI.ping((PongRI) this, b);
            System.out.println("Pong: result = " + result);
        }else{
            System.out.println("Pong: Já ardeste, o result foi = " + result);
        }
    }

    public void startPlaying() throws RemoteException {
        Ball b = new Ball(1);
        Remote exportObject = java.rmi.server.UnicastRemoteObject.exportObject((Remote) this, 0);
        this.pingRI.ping((PongRI) this, b);
    }
}