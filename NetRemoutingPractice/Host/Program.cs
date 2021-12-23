using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Tcp;
using System.Text;
using System.Threading.Tasks;

namespace Host
{
    public class Program
    {
        static void Main(string[] args)
        {
            /*
            TcpChannel tcpCan = new TcpChannel(11000);
            ChannelServices.RegisterChannel(tcpCan);

            RemotingConfiguration.RegisterWellKnownServiceType(
                typeof(ServerObj.ServerObj), "met1", WellKnownObjectMode.SingleCall);

            RemotingConfiguration.RegisterWellKnownServiceType(
                typeof(ServerObj.UdalObj), "met2", WellKnownObjectMode.SingleCall);

            Console.WriteLine("Ожидание подключения...");
            Console.ReadLine();
            */

            TimeServer server = new TimeServer();
            server.Start();
        }
    }
}
