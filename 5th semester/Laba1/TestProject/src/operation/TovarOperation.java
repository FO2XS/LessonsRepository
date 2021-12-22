package operation;

import types.Tovar;

import java.util.List;

public interface TovarOperation {

    List<Tovar> getListOfTovar();
    List<Tovar> addNewTovar(Tovar item);
    int getSumOfTovar();
}
