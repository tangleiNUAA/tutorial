package com.vidi.tutorial.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author vidi
 */
public interface Warehouse extends Remote {
    double getPrice(String good) throws RemoteException;
}
