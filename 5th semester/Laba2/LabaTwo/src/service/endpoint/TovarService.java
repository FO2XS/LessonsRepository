package service.endpoint;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import operation.TovarOperationImpl;
import types.ListOfTovar;
import types.Tovar;

@WebService()
public class TovarService {

    static TovarOperationImpl obj = new TovarOperationImpl();

    @WebMethod()
    public ListOfTovar getAllTovar(){
        ListOfTovar lstRet = null;

        List<Tovar> lst = obj.getListOfTovar();
        if(lst != null){
            lstRet = new ListOfTovar();
            lstRet.setItem(lst);
        }
        return lstRet;
    }

    @WebMethod()
    public ListOfTovar setNewTovar(Tovar tovar){
        ListOfTovar lstRet = null;

        List<Tovar> lst = obj.addNewTovar(tovar);
        if(lst != null){
            lstRet = new ListOfTovar();
            lstRet.setItem(lst);
        }
        return lstRet;
    }

    @WebMethod()
    public int getSumOfTovar(){
        return obj.getSumOfTovar();
    }
}
