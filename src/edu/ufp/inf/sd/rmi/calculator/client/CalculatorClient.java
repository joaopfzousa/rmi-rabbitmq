package edu.ufp.inf.sd.rmi.calculator.client;

import  edu.ufp.inf.sd.rmi.calculator.server.CalculatorRI;
import edu.ufp.inf.sd.rmi.util.rmisetup.SetupContextRMI;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class  CalculatorClient {


    private SetupContextRMI contextRMI;
    private  CalculatorRI myRI;

    public static void main(String[] args) {
        if (args != null && args.length < 2) {
            System.exit(-1);
        } else {
            CalculatorClient clt = new CalculatorClient(args);
            clt.lookupService();
            clt.playService();
        }
    }

    public CalculatorClient(String[] args) {
        try {
            String registryIP   = args[0];
            String registryPort = args[1];
            String serviceName  = args[2];
            contextRMI = new SetupContextRMI(this.getClass(), registryIP, registryPort, new String[]{serviceName});
        } catch (RemoteException e) {
            Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private Remote lookupService() {
        try {
            Registry registry = contextRMI.getRegistry();
            if (registry != null) {
                String serviceUrl = contextRMI.getServicesUrl(0);
                myRI = (CalculatorRI) registry.lookup(serviceUrl);
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

            ArrayList<Float> floats = new ArrayList<Float>();

            floats.add(1.6f);
            floats.add(1.2f);
            floats.add(2.5f);
            floats.add(2.5f);
            floats.add(1.2f);
            floats.add(2.5f);
            floats.add(2.5f);
            floats.add(1.2f);
            floats.add(2.5f);
            floats.add(2.5f);
            floats.add(1.2f);
            floats.add(2.5f);
            floats.add(2.5f);

            int sum = this.myRI.somar(1,2);
            System.out.println("sum a+b: " + sum);

            float sumFloats = this.myRI.somar(floats);
            System.out.println("sum arrayList: " + sumFloats);

            float msg = this.myRI.moda(floats);
            System.out.println("moda: " + msg);

            float media = this.myRI.media(floats);
            System.out.println("media: " + media);

            float mult = this.myRI.mult(1.2f, 2.6f);
            System.out.println("mult: " + mult);

            int sub = this.myRI.sub(6,3);
            System.out.println("sub a-b: " + sub);

            float pow = this.myRI.power(2f, 2f);
            System.out.println("pow: " + pow);

            float divisao = this.myRI.divisao(6f, 3f);
            System.out.println("divisao: " + divisao);

        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
}
