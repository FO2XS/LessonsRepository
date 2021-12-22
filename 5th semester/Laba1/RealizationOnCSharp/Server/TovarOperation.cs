using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Server
{
    public class TovarOperation : MarshalByRefObject, ITovarOperation
    {
        DapperProvider provider;
        public static List<Tovar> lstTovar = new List<Tovar>();

        public TovarOperation()
        {
            provider = new DapperProvider("User ID=postgres;Password=admin;Host=localhost;Port=5432;Database=for_zemcov;");
        }

        public List<Tovar> getListOfTovar()
        {
            lstTovar = provider.GetProducts();
            return lstTovar;
        }
        public List<Tovar> addNewTovar(Tovar item)
        {
            provider.AddProduct(item);
            return getListOfTovar();
        }
        public int getSumOfTovar()
        {
            int sum = 0;
            foreach (Tovar tovar in lstTovar)
                sum += tovar.Kol * tovar.Price;
            return sum;
        }

        public bool auth(string login, string password)
        {
            return provider.Auth(login, password);
        }
    }

}
