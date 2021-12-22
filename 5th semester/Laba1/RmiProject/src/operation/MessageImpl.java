package operation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MessageImpl extends UnicastRemoteObject implements Message {

    public MessageImpl () throws RemoteException {
    }
    public String getMessage() throws RemoteException {
        return "Сообщение от сервера";
    }
}

