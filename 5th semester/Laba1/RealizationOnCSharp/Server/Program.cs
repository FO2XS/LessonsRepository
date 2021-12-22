using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Tcp;
using System.Text;
using System.Threading.Tasks;

namespace Server
{
    internal class Program
    {
        static void Main()
        {
            // Register channel
            TcpChannel channel = new TcpChannel(9000);
            ChannelServices.RegisterChannel(channel, false);

            // Register MyRemoteObject
            RemotingConfiguration.RegisterWellKnownServiceType(
                typeof(MyRemoteType),
                "Test",
                WellKnownObjectMode.Singleton);
            RemotingConfiguration.RegisterWellKnownServiceType(
                typeof(TovarOperation),
                "TalkIsGood",
                WellKnownObjectMode.Singleton);

            Console.WriteLine("Press enter to stop this process.");
            Console.ReadLine();
        }

    }
}
