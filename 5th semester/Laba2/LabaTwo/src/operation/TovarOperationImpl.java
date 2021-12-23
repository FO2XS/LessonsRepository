package operation;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import database.PgProvider;
import types.Tovar;

public class TovarOperationImpl implements TovarOperation{

    static List<Tovar> lstTovar = new ArrayList<Tovar>();
    PgProvider provider = new PgProvider();


    @Override
    public List<Tovar> getListOfTovar() {
        lstTovar = provider.getProducts();
        return lstTovar;
    }

    @Override
    public List<Tovar> addNewTovar(Tovar tovar){
        provider.addProduct(tovar);
        return getListOfTovar();
    }

    @Override
    public int getSumOfTovar(){

        int sum = 0;
        for(Tovar tovar: lstTovar)
            sum += tovar.getSumma();

        return sum;
    }

    @Override
    public boolean authentication(String login, String password) {
        return provider.authentication(login, password);
    }
}
