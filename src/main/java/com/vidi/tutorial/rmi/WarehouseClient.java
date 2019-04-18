package com.vidi.tutorial.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author vidi
 */
public class WarehouseClient {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("192.168.0.109", 1099);

        for (String s : registry.list()) {
            System.out.println(s);
        }

        Warehouse warehouse = (Warehouse) registry.lookup("central_warehouse");

        String good = "Pen";
        double price = warehouse.getPrice(good);
        System.out.println(good + ":" + price);
    }
}
