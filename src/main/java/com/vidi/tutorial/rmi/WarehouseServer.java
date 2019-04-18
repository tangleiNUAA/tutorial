package com.vidi.tutorial.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author vidi
 */
public class WarehouseServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        System.out.println("Construct server implementation...");
        Warehouse warehouse = new WarehouseImpl();
        System.out.println("Bind server implementation to registry...");

        Registry registry = LocateRegistry.createRegistry(1099);

        registry.bind("central_warehouse", warehouse);

        System.out.println("Waiting for invocation from clients.");
    }
}
