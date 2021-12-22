package operation;

import types.Tovar;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface TovarOperation extends Remote{
    List<Tovar> getListOfTovar() throws RemoteException;
    List<Tovar> addNewTovar(Tovar tovar) throws RemoteException;
    int getSumOfTovar() throws RemoteException;
    boolean authentication(String login, String password) throws RemoteException;
}

