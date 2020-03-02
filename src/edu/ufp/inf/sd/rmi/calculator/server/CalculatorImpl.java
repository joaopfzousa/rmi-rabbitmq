package edu.ufp.inf.sd.rmi.calculator.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CalculatorImpl extends UnicastRemoteObject implements CalculatorRI {


    public CalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public int somar(int a, int b) throws RemoteException {
        System.out.println("Someone called me - somar(int a, int b)!");
        return a + b;
    }

    @Override
    public float somar(ArrayList<Float> list) throws RemoteException {
        float sum = 0;
        for(int i = 0; i < list.size(); i++)
            sum += list.get(i);
        System.out.println("Someone called me - somar(ArrayList<Float> list)!");
        return sum;
    }

    @Override
    public float moda(ArrayList<Float> list) throws RemoteException {
        float maxValue = 0, maxCount = 0;

        for (int i = 0; i < list.size(); ++i) {
            int count = 0;

            for (int j = 0; j < list.size(); ++j) {
                if (list.get(j).equals(list.get(i))) ++count;
                if (count > maxCount) {
                    maxCount = count;
                    maxValue = list.get(i);
                }
            }

        }
        System.out.println("Someone called me - moda(ArrayList<Float> list)!");
        return maxValue;
    }

    @Override
    public float media(ArrayList<Float> list) throws RemoteException {
        float sum = 0;
        for(int i = 0; i < list.size(); i++)
            sum += list.get(i);
        System.out.println("Someone called me - media(ArrayList<Float> list)!");
        return sum/list.size();
    }

    @Override
    public float mult(float a, float b) throws RemoteException {
        System.out.println("Someone called me - mult(float a, float b)!");
        return a * b;
    }

    @Override
    public int sub(int a, int b) throws RemoteException {
        System.out.println("Someone called me - sub(int a, int b)!");
        return a - b;
    }

    @Override
    public float power(float base, float exp) throws RemoteException {
        System.out.println("Someone called me - power(float base, float exp)!");
        return (float) Math.pow(base, exp);
    }

    @Override
    public float divisao(float numerador, float denominador) throws RemoteException {
        if(denominador == 0 )
            throw new ArithmeticException("Ó burro não dá para dividir por zero calhau");
        return numerador/denominador;
    }

    @Override
    public String methodName() throws RemoteException {
        System.out.println("Someone called me - methodName()!");
        return "Response from methodName!";
    }
}