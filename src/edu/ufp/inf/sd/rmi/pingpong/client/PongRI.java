package edu.ufp.inf.sd.rmi.pingpong.client;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface PongRI extends Remote {
    public void pong(Ball b) throws RemoteException;
}