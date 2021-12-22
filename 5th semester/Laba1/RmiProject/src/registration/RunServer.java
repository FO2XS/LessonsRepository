package registration;

import operation.MessageImpl;
import operation.TovarOperationImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer {

    public static void main (String[] argv) {
        try {
            // создание экземпляров классов для регистрации
            MessageImpl message = new MessageImpl();
            TovarOperationImpl operationImpl = new TovarOperationImpl();

            // создаём реестр
            Registry registry = LocateRegistry.createRegistry(1199);

            // регистрация классов
            registry.bind("rmiTest01", message);
            registry.bind("rmiTest02", operationImpl);

            System.out.println ("Server is ready.");
        } catch (Exception e) {
            System.out.println ("Server failed: " + e);
        }
    }
}

