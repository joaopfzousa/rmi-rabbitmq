package edu.ufp.inf.sd.rmi.pingpong.server;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface PingpongRI extends Remote {
    public String methodName() throws RemoteException;
}