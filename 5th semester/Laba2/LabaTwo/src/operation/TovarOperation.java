package operation;

import java.util.List;
import types.Tovar;

public interface TovarOperation{
    List<Tovar> getListOfTovar();
    List<Tovar> addNewTovar(Tovar tovar);
    int getSumOfTovar();
}

