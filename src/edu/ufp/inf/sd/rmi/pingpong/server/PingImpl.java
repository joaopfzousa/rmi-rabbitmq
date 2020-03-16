package edu.ufp.inf.sd.rmi.pingpong.server;

import edu.ufp.inf.sd.rmi.pingpong.client.Ball;
import edu.ufp.inf.sd.rmi.pingpong.client.PongRI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class PingImpl extends UnicastRemoteObject implements PingRI {


    public PingImpl() throws RemoteException {
        super();
    }

    @Override
    public void ping(PongRI clientPongRI, Ball b) throws RemoteException {
        b.counting();
        System.out.println("Ping: Entry with Ball");
        clientPongRI.pong(b);
    }
}