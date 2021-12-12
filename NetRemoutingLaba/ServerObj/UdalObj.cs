using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ServerObj
{
    public class UdalObj : MarshalByRefObject
    {
        public string Hello()
        {
            Console.WriteLine("Вызов метода 2");
            return "Привет!";
        }

        public string Greeting(string name)
        {
            Console.WriteLine("Вызов приветствия");
            return "Привет " + name;
        }
    }
}
