using ServerObj;
using System;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Http;

namespace Host
{
    public class TimeServer
    {
        public void Start()
        {
            ChannelServices.RegisterChannel(new HttpChannel(888));

            RemotingConfiguration.RegisterWellKnownServiceType(
                typeof(RemoteTime), "RemoteTimeHost/rt", WellKnownObjectMode.Singleton);

            RemotingConfiguration.RegisterWellKnownServiceType(
                typeof(TaskClass), "TaskClass", WellKnownObjectMode.Singleton);

            Console.WriteLine("Удаленный time сервер запущен.");
            Console.WriteLine("Нажмите Enter для выхода");
            Console.ReadLine();
        }
    }
}
