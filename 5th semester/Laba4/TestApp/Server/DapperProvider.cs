using Server.Models;
using Dapper;
using Npgsql;
using System;
using System.Collections.Generic;
using System.Data;

namespace Server
{
    /// <summary>
    /// Провайдер к БД через Dapper.
    /// </summary>
    public class DapperProvider
    {
        /// <summary>
        /// Единственный экземпляр сервиса.
        /// </summary>
        private static DapperProvider Instance;

        /// <summary>
        /// Строка подключения к БД.
        /// </summary>
        public string ConnectionString { get; }

        /// <summary>
        /// Инициализирует провайдера со строкой подключения.
        /// </summary>
        /// <param name="connectionString">Строка подключения.</param>
        private DapperProvider(string connectionString)
        {
            ConnectionString = connectionString;
        }

        /// <summary>
        /// Возвращает существующий или создает новый экземпляр провайдера.
        /// </summary>
        /// <param name="connectionString">Строка подключения.</param>
        /// <returns>Экземпляр провайдера.</returns>
        /// <exception cref="ArgumentNullException"></exception>
        public static DapperProvider GetInstance(string connectionString = "User ID=postgres;Password=admin;Host=localhost;Port=5432;Database=test_db;")
        {
            if (string.IsNullOrEmpty(connectionString))
            {
                throw new ArgumentNullException($"Пустая строка подключения {nameof(connectionString)}");
            }
            if (Instance != null)
            {
                return Instance;
            }

            Instance = new DapperProvider(connectionString);
            return Instance;
        }

        /// <summary>
        /// Возвращает ценную бумагу по её id.
        /// </summary>
        /// <param name="figi">Id ценной бумаги.</param>
        /// <returns>Ценная бумага.</returns>
        /// <exception cref="ArgumentNullException"></exception>
        public Stock GetStock(string figi)
        {
            if (string.IsNullOrEmpty(figi))
            {
                throw new ArgumentNullException($"Пустой аргумент {nameof(figi)}");
            }

            string query = "SELECT figi as \"Figi\", isin as \"Isin\", ticker as \"Ticker\", currency_id as \"Currency\", title as \"Title\", instrument_type_id as \"InstrumentType\"" +
                "FROM stock " +
                "WHERE figi = @Figi";

            using (IDbConnection db = new NpgsqlConnection(ConnectionString))
            {
                try
                {
                    return db.QuerySingle<Stock>(query, new { Figi = figi });
                }
                catch (Exception ex)
                {
                    throw;
                }
                
            }
        }

        public IEnumerable<Stock> GetStocks()
        {
            string query = "SELECT figi as \"Figi\", " +
                "isin as \"Isin\", " +
                "ticker as \"Ticker\", " +
                "currency_id as \"Currency\", " +
                "title as \"Title\", " +
                "instrument_type_id as \"InstrumentType\" " +
                "FROM stock ";

            using (IDbConnection db = new NpgsqlConnection(ConnectionString))
            {
                return db.Query<Stock>(query);
            }
        }

        public bool AddStock(Stock stock)
        {
            string query = "INSERT INTO stock (figi, isin, ticker, title, currency_id, instrument_type_id) " +
                "VALUES(@Figi, @Isin, @Ticker, @Title, @Currency, @InstrumentType)";

            using (IDbConnection db = new NpgsqlConnection(ConnectionString))
            {
                int result = db.Execute(query, 
                    new {Figi = stock.Figi, 
                    Isin = stock.Isin, 
                    Ticker = stock.Ticker,
                    Title = stock.Title,
                    Currency = stock.Currency,
                    InstrumentType = stock.InstrumentType});

                return result > 0;
            }
        }

        public bool UpdateStock(Stock stock)
        {
            string query = "UPDATE stock " +
                "SET isin = @Isin, " +
                "ticker = @Ticker, " +
                "title = @Title, " +
                "currency_id = @Currency, " +
                "instrument_type_id = @InstrumentType " +
                "WHERE figi = @Figi";

            using (IDbConnection db = new NpgsqlConnection(ConnectionString))
            {
                int result = db.Execute(query,
                    new
                    {
                        Figi = stock.Figi,
                        Isin = stock.Isin,
                        Ticker = stock.Ticker,
                        Title = stock.Title,
                        Currency = stock.Currency,
                        InstrumentType = stock.InstrumentType
                    });

                return result > 0;
            }
        }

        public bool DeleteStock(string figi)
        {
            string query = "DELETE FROM stock " +
                "WHERE figi = @Figi";

            using (IDbConnection db = new NpgsqlConnection(ConnectionString))
            {
                int result = db.Execute(query,
                    new
                    {
                        Figi = figi
                    });

                return result > 0;
            }
        }
    }
}
