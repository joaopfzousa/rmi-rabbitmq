package edu.ufp.inf.sd.rmi.diglib.server;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface DiglibFactoryRI extends Remote {
    public boolean register(String uname, String pw) throws RemoteException;
    public DiglibSessionRI login(String uname, String pw) throws RemoteException;
}
