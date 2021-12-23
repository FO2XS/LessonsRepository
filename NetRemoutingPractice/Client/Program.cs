namespace Client
{
    public class Program
    {
        static void Main(string[] args)
        {
            /*
            TcpChannel tcpCanK = new TcpChannel();
            ChannelServices.RegisterChannel(tcpCanK);

            ServerObj.ServerObj obj1 = Activator.GetObject(
                typeof(ServerObj.ServerObj), "tcp://localhost:11000/met1") 
                as ServerObj.ServerObj;
            tcpCanK.StopListening(obj1);

            ServerObj.UdalObj obj2 = Activator.GetObject(
                typeof(ServerObj.UdalObj), "tcp://localhost:11000/met2")
                as ServerObj.UdalObj;
            tcpCanK.StartListening(obj2);

            Console.WriteLine($"Результат вычислений: {obj1.ServerMethod(5, 4)}");
            Console.WriteLine(obj2.Hello());
            Console.WriteLine(obj2.Greeting("Гриша"));

            Console.ReadLine();
            */
            TimeClient timeClient = new TimeClient();
            timeClient.GetSumSquare();
            timeClient.GetSubstringString();
        }
    }
}
