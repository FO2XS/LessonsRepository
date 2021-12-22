package client;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

import operation.TovarOperation;
import types.Tovar;

public class RunClient {

    public static void main(String[] argv) {
        try {

            TovarOperation tovarOperation = (TovarOperation) Naming.lookup("//localhost:1199/rmiTest02");

            List<Tovar> lstRet = new ArrayList<>();

            // 1 метод
            lstRet = tovarOperation.getListOfTovar();
            doVivod(lstRet);

            // 3 метод
            System.out.println("Общая сумма товара: " + tovarOperation.getSumOfTovar());

            // 2 метод
            Tovar tovar = new Tovar("Товар555", 55, 555);
            lstRet = tovarOperation.addNewTovar(tovar);
            doVivod(lstRet);

            // 3 метод
            System.out.println("Общая сумма товара: " + tovarOperation.getSumOfTovar());

        } catch (Exception e) {
            System.out.println("Message Client exception: " + e);
        }
    }

    public static void doVivod(List<Tovar> lst) {
        int i = 0;
        System.out.println("#\tНазвание\tЦена\tКол-во\tСумма");
        for (Tovar tovar : lst)
            System.out.println(++i + "\t" + tovar.getName() + "  \t" +
                    tovar.getPrice() + "\t" +
                    tovar.getKol() + " \t" +
                    tovar.getSumma());
        System.out.println();
        System.out.println();
    }
}


