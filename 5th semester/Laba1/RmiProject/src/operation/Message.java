package operation;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Message extends Remote{
    public String getMessage() throws RemoteException;
}

