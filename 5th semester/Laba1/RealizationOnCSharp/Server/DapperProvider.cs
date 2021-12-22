using Dapper;
using Npgsql;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Server
{
    internal class DapperProvider
    {
        private string _connectionString;

        public DapperProvider(string connectionString)
        {
            _connectionString = connectionString;
        }

        public List<Tovar> GetProducts()
        {
            string query = "SELECT title as \"Name\", price as \"Price\", count as \"Kol\"" +
                "FROM products";

            using (IDbConnection db = new NpgsqlConnection(_connectionString))
            {
                return db.Query<Tovar>(query).ToList();
            }
        }

        public void AddProduct(Tovar tovar)
        {
            string query = "INSERT INTO products (title, count, price) VALUES (@Name, @Kol, @Price)";

            using (IDbConnection db = new NpgsqlConnection(_connectionString))
            {
                if(db.Execute(query, tovar) < 1)
                {
                    Console.WriteLine("Не добавлена строка");
                }
                
            }
        }

        public bool Auth(string login, string password)
        {
            string query = "SELECT COUNT(*) FROM users WHERE login = @Login AND password = @Password";

            using (IDbConnection db = new NpgsqlConnection(_connectionString))
            {
                var result = db.QueryFirst<int>(query, new { Login = login, Password = password });

                return result == 1;
            }
        }
    }
}
