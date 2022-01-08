namespace Apiv2.Models
{
    public class Stock
    {
        public string Figi { get; set; }
        public string Isin { get; set; }
        public string Ticker { get; set; }
        public string Title { get; set; }
        public Currency Currency { get; set; }
        public InstrumentType InstrumentType { get; set; }
    }
}
