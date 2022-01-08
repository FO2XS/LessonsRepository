using Apiv2.Models;
using Dapper;
using Npgsql;
using System;
using System.Collections.Generic;
using System.Data;

namespace Apiv2.Providers
{
    public class UserProvider
    {
        /// <summary>
        /// Единственный экземпляр сервиса.
        /// </summary>
        private static UserProvider Instance;

        public List<string> AuthTokens { get; set; }

        /// <summary>
        /// Строка подключения к БД.
        /// </summary>
        public string ConnectionString { get; }

        /// <summary>
        /// Инициализирует провайдера со строкой подключения.
        /// </summary>
        /// <param name="connectionString">Строка подключения.</param>
        private UserProvider(string connectionString)
        {
            ConnectionString = connectionString;
            AuthTokens = new List<string>();

            //Для тестирования
            AuthTokens.Add("AVb5pLKYZg5KDNBCc10arzih2fk31bRH");
        }

        /// <summary>
        /// Возвращает существующий или создает новый экземпляр провайдера.
        /// </summary>
        /// <param name="connectionString">Строка подключения.</param>
        /// <returns>Экземпляр провайдера.</returns>
        /// <exception cref="ArgumentNullException"></exception>
        public static UserProvider GetInstance(string connectionString = "User ID=postgres;Password=admin;Host=localhost;Port=5432;Database=test_db;")
        {
            if (string.IsNullOrEmpty(connectionString))
            {
                throw new ArgumentNullException($"Пустая строка подключения {nameof(connectionString)}");
            }
            if (Instance != null)
            {
                return Instance;
            }

            Instance = new UserProvider(connectionString);
            return Instance;
        }

        public User Authorization(string login, string password)
        {
            if (string.IsNullOrEmpty(login) || string.IsNullOrEmpty(password))
            {
                throw new ArgumentNullException($"Пустой аргумент");
            }

            string query = "SELECT  id as \"Id\", " +
                "login as \"Login\"," +
                "password as \"Password\"" +
                "FROM users " +
                "WHERE login = @Login AND password = @Password";

            using (IDbConnection db = new NpgsqlConnection(ConnectionString))
            {
                try
                {
                    return db.QuerySingle<User>(query, new { Login = login, Password = password });
                }
                catch (Exception ex)
                {
                    throw;
                }

            }
        }

        /// <summary>
        /// Возвращает все Guid'ы пользователей.
        /// </summary>
        /// <returns></returns>
        public List<Guid> GetUsersId()
        {

            string query = "SELECT id as \"Id\"" +
                "FROM users";

            using (IDbConnection db = new NpgsqlConnection(ConnectionString))
            {
                try
                {
                    return db.Query<Guid>(query).AsList();
                }
                catch (Exception ex)
                {
                    throw;
                }

            }
        }

        public bool CheckToken(string userToken)
        {
            return AuthTokens.Contains(userToken);
        }
    }
}
