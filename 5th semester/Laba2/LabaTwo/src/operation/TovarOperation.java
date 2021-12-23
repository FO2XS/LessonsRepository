package operation;

import java.rmi.RemoteException;
import java.util.List;
import types.Tovar;

public interface TovarOperation{
    List<Tovar> getListOfTovar();
    List<Tovar> addNewTovar(Tovar tovar);
    int getSumOfTovar();
    boolean authentication(String login, String password);
}

