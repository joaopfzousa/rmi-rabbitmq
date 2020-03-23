package edu.ufp.inf.sd.rmi.diglib.server;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class DiglibSessionImpl implements DiglibSessionRI {

    private DBMockup db;

    public DiglibSessionImpl(DBMockup db) {
        this.db = db;
    }

    @Override
    public Book[] search(String title, String author) throws RemoteException {
        return db.select(title,author);
    }

    @Override
    public void logout() throws RemoteException {

    }
}
