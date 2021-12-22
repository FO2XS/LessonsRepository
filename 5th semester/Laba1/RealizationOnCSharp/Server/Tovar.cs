using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Server
{
    [Serializable]
    public class Tovar
    {
        private String name;
        private int kol;
        private int price;
        public Tovar()
        {
            this.name = "";
            this.kol = 0;
            this.price = 0;
        }
        public Tovar(String name, int kol, int price)
        {
            this.name = name;
            this.kol = kol;
            this.price = price;
        }
        public String Name
        {
            get { return name; }
            set { name = value; }
        }
        public int Kol
        {
            get { return kol; }
            set { kol = value; }
        }
        public int Price
        {
            get { return price; }
            set { price = value; }
        }

    }

}
