package edu.ufp.inf.sd.rmi.chat.server;

import edu.ufp.inf.sd.rmi.chat.client.ObserverRI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class ChatImpl extends UnicastRemoteObject implements ChatRI {


    private State subjectState;

    private ArrayList<ObserverRI> observers = new ArrayList<>();


    protected ChatImpl() throws RemoteException {
        super();
        this.subjectState = new State("","");
    }

    @Override
    public void attach(ObserverRI obsRI) {
        if(!this.observers.contains(obsRI)) this.observers.add(obsRI);
    }

    @Override
    public void detach(ObserverRI obsRI) {
        this.observers.remove(obsRI);
    }

    @Override
    public State getState() {
        return this.subjectState;
    }

    @Override
    public void setState(State state) {
        this.subjectState = state;
        this.notifyAllObservers();
    }

    public void notifyAllObservers() {
        for(ObserverRI obs : observers){
            try{
                obs.update();
            } catch (RemoteException ex){
                System.out.println(ex.toString());
            }
        }
    }
}