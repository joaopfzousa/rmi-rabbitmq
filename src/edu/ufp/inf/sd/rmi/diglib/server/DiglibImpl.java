package edu.ufp.inf.sd.rmi.diglib.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DiglibImpl extends UnicastRemoteObject implements DiglibRI {


    public DiglibImpl() throws RemoteException {
        super();
    }

    @Override
    public void print(String msg) throws RemoteException {
        System.out.println("CalculadorImpl - print(): someone called me with msg = "+ msg);
    }

    @Override
    public String methodName() throws RemoteException {
        System.out.println("Someone called me - methodName()!");
        return "Response from methodName!";
    }
}