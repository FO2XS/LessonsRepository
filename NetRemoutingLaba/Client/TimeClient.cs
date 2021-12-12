using ServerObj;
using System;
using System.IO;

namespace Client
{
    public class TimeClient
    {
        public void Start()
        {
            IRemoteTime rt = Activator.GetObject(
                typeof(IRemoteTime), 
                "http://localhost:888/RemoteTimeHost/rt") 
                as IRemoteTime;

            Console.WriteLine($"Current time is : {rt.CurrentTime}");
            Console.ReadLine();
        }

        public void SaveConnectTimeWithServer()
        {
            IRemoteTime rt = Activator.GetObject(
                typeof(IRemoteTime),
                "http://localhost:888/RemoteTimeHost/rt")
                as IRemoteTime;

            using (StreamWriter sw = new StreamWriter("test.txt", true, System.Text.Encoding.Default))
            {
                sw.WriteLine(rt.CurrentTime);
            }
        }

        public void GetSumSquare()
        {
            var rt = Activator.GetObject(
                typeof(TaskClass),
                "http://localhost:888/TaskClass")
                as TaskClass;

            var argument = 0;
            Console.WriteLine("Введите число: ");
            int.TryParse(Console.ReadLine(), out argument);

            Console.WriteLine("Сумма квадратов: " + rt.SumSquare(argument));

            Console.ReadLine();
        }

        public void GetSubstringString()
        {
            var rt = Activator.GetObject(
                typeof(TaskClass),
                "http://localhost:888/TaskClass")
                as TaskClass;

            Console.WriteLine("Введите строку: ");
            var argument = Console.ReadLine();

            Console.WriteLine("Полученная последовательность букв: " + rt.SubstringChars(argument));

            Console.ReadLine();
        }
    }
}
