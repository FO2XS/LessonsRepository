using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Server
{
    public interface ITovarOperation
    {
        List<Tovar> getListOfTovar();
        List<Tovar> addNewTovar(Tovar item);
        int getSumOfTovar();
        bool auth(string login, string password);
    }

}
