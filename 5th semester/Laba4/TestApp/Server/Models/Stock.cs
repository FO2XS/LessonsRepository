namespace Server.Models
{
    public class Stock
    {
        public string Figi { get; set; }
        public string Isin { get; set; }
        public string Ticker { get; set; }
        public string Title { get; set; }
        public Currency Currency { get; set; }
        public InstrumentType InstrumentType { get; set; }

        public override string ToString()
        {
            return $"Figi - {Figi}, Ticker - {Ticker}, Title - {Title}";
        }
    }
}
