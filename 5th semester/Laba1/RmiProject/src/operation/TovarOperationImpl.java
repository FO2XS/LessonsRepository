package operation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import database.PgProvider;
import types.Tovar;

public class TovarOperationImpl extends UnicastRemoteObject implements TovarOperation{
    PgProvider provider = new PgProvider();
    static List<Tovar> lstTovar = new ArrayList<Tovar>();

    public TovarOperationImpl() throws RemoteException{
    }

    @Override
    public List<Tovar> getListOfTovar() throws RemoteException{
        lstTovar = provider.getProducts();
        return lstTovar;
    }

    @Override
    public List<Tovar> addNewTovar(Tovar tovar) throws RemoteException{
        provider.addProduct(tovar);
        return getListOfTovar();
    }

    @Override
    public int getSumOfTovar() throws RemoteException{

        int sum = 0;
        for(Tovar tovar: lstTovar)
            sum += tovar.getSumma();

        return sum;
    }

    @Override
    public boolean authentication(String login, String password) throws RemoteException {
        return provider.authentication(login, password);
    }
}

