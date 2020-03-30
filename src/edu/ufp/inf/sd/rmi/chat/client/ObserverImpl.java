package edu.ufp.inf.sd.rmi.chat.client;

import edu.ufp.inf.sd.rmi.chat.server.State;
import edu.ufp.inf.sd.rmi.chat.server.ChatRI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObserverImpl extends UnicastRemoteObject implements ObserverRI{

    private String id;
    private State lastObserverState;
    protected ChatRI chatRI;
    protected ObserverGuiClient chatFrame;

    public ObserverImpl(String id, ObserverGuiClient f, ChatRI chatRI) throws RemoteException{
        super();
        this.id=id;
        this.chatFrame = f;
        this.lastObserverState =  new State(id,"");
        this.chatRI = chatRI;
        this.chatRI.attach(this);
    }

    @Override
    public void update() throws RemoteException{
        this.lastObserverState=chatRI.getState();
        this.chatFrame.updateTextArea();
    }

    protected State getLastObserverState(){
        return this.lastObserverState;
    }
}
