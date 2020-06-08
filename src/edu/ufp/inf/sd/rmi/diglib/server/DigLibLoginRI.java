package edu.ufp.inf.sd.rmi.diglib.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DigLibLoginRI extends Remote {
    boolean register(String username, String password) throws  RemoteException;
    DigLibSessionRI login(String username, String password) throws RemoteException;
    DigLibSessionRI logout(String username) throws RemoteException;
}