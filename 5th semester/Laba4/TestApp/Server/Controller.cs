using Server.Models;

namespace Server
{
    public class Controller
    {
        DapperProvider provider = DapperProvider.GetInstance();
        public Stock GetStock(string figi)
        {
            return provider.GetStock(figi);
        }

        public bool methodUpdate(string figi, string title)
        {
            var beforeUpdate = GetStock(figi);

            beforeUpdate.Title = title;


            return provider.UpdateStock(beforeUpdate);
        }
    }
}
