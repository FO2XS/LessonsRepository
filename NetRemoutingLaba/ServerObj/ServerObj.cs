using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ServerObj
{
    public class ServerObj : MarshalByRefObject
    {
        public double ServerMethod(int a1, int a2)
        {
            Console.WriteLine("Вызов метода 1");
            return a1 + Math.Sqrt(a2);
        }
    }
}
