package com.vidi.tutorial.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * @author vidi
 */
public class WarehouseImpl extends UnicastRemoteObject implements Warehouse {

    private Map<String, Double> prices;

    public WarehouseImpl() throws RemoteException {
        prices = new HashMap<>();
        prices.put("Pen", 24.95);
        prices.put("Book", 49.95);
    }

    @Override
    public double getPrice(String good) throws RemoteException {
        Double price = prices.get(good);
        return price == null ? 0 : price;
    }
}
