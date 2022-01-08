using NETCore.Encrypt;
using System;
using System.Text;
using System.Security.Cryptography;

namespace Apiv2.Providers
{
    public class Crypter
    {
        public static string GetCryptString(string s)
        {
            return EncryptProvider.Base64Encrypt(s);
        }

        public static string GetDecryptString(string s)
        {
            return EncryptProvider.Base64Decrypt(s);
        }

        public static string GenerateKey()
            => EncryptProvider.CreateAesKey().Key;

        /// <summary>
        /// Получает хэш из строки.
        /// </summary>
        /// <param name="s">Строка.</param>
        /// <returns>Полученный хэш.</returns>
        public static string GetHashString(string s)
        {
            //переводим строку в байт-массим
            byte[] bytes = Encoding.Unicode.GetBytes(s);

            //создаем объект для получения средст шифрования
            MD5CryptoServiceProvider CSP =
                new MD5CryptoServiceProvider();

            //вычисляем хеш-представление в байтах
            byte[] byteHash = CSP.ComputeHash(bytes);

            string hash = string.Empty;

            //формируем одну цельную строку из массива
            foreach (byte b in byteHash)
                hash += string.Format("{0:x2}", b);

            return hash;
        }
    }
}
