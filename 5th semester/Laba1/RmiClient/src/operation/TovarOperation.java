package operation;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import types.Tovar;

public interface TovarOperation extends Remote{
    List<Tovar> getListOfTovar() throws RemoteException;
    List<Tovar> addNewTovar(Tovar tovar) throws RemoteException;
    int getSumOfTovar() throws RemoteException;
}

