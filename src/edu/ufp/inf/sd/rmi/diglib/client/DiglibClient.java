package edu.ufp.inf.sd.rmi.diglib.client;

import edu.ufp.inf.sd.rmi.diglib.server.DiglibRI;
import edu.ufp.inf.sd.rmi.util.rmisetup.SetupContextRMI;
import edu.ufp.inf.sd.rmi.diglib.server.DiglibSessionRI;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class  DiglibClient {


    private SetupContextRMI contextRMI;
    private  DiglibRI myRI;

    public static void main(String[] args) {
        if (args != null && args.length < 2) {
            System.exit(-1);
        } else {
            DiglibClient clt = new DiglibClient(args);
            clt.lookupService();
            clt.playService();
        }
    }

    public DiglibClient(String[] args) {
        try {
            String registryIP   = args[0];
            String registryPort = args[1];
            String serviceName  = args[2];
            contextRMI = new SetupContextRMI(this.getClass(), registryIP, registryPort, new String[]{serviceName});
        } catch (RemoteException e) {
            Logger.getLogger(DiglibClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private Remote lookupService() {
        try {
            Registry registry = contextRMI.getRegistry();
            if (registry != null) {
                String serviceUrl = contextRMI.getServicesUrl(0);
                myRI = (DiglibRI) registry.lookup(serviceUrl);
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "registry not bound (check IPs). :(");
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return myRI;
    }

    private void playService() {
        try {
            DiglibSessionRI sessionRI = this.diglibFactoryRI.login("guest","ufp");
            if(sessionRI != null){
                Book[] books = sessionRI.search("Distributed","Tanenbaum");
                for (Book b : books){
                    System.out.println(b.toString());
                }
            }
            System.out.println("going to finish, bye. ;)");
            /*
            String msg=this.myRI.methodName();
            System.out.println("methodName: "+msg);*/
        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
}
