package edu.ufp.inf.sd.rmi.diglib.server;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface DiglibRI extends Remote {
    public void print(String msg) throws RemoteException;
    public String methodName() throws RemoteException;
}