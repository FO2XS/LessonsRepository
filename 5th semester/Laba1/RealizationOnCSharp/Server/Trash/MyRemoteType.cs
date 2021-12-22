using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Server
{
    public class MyRemoteType : MarshalByRefObject, IMyRemoteType
    {
        private String msg = "";

        public String GetMessage()
        {
            return msg = msg + "Hello, world! ";
        }
    }

}
