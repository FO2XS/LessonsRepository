using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;
using NETCore.Encrypt;

namespace TestCrypt
{
    internal class Program
    {
        private static string Key = "6taHeZKUrdNtFlzhwmmHJSFdVKm8FZRV";
        private static string encryptedString = "�Xt>���9�Qw*��Xt>���9�Qw*��~+�J���G�?h�";
        static void Main(string[] args)
        {
            var hashLogin = GetHashString("admin");
            var hashPassword = GetHashString("qwerty");
            var newGuid = Guid.NewGuid();

            var encLogin = EncryptProvider.Base64Encrypt("admin");
            var encPassword = EncryptProvider.Base64Encrypt("qwerty");
            Console.ReadLine();
        }

        static string GetHashString(string s)
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

        static string GetCryptString(string s)
        {
            //var crypt_pas = Crypter.Blowfish.Crypt(s, DEFAULT_SALT);
            //Console.WriteLine("Зашифрованный пароль: " + Crypter.Blowfish.Crypt(s, DEFAULT_SALT));

            var aesKey = EncryptProvider.CreateAesKey();
            var aesByteKey = EncryptProvider.CreateAesKey();
            var key = "c0XKtvqIgEhAQpugQpTlr6Fuk7ye9LNU";

            var srcString = "admin";
            var encrypted = EncryptProvider.AESEncrypt(srcString, key);
            Console.WriteLine("Зашифрованный пароль: " + encrypted);

            var decrypted = EncryptProvider.AESDecrypt(encrypted, key);

            Console.WriteLine("Расшифрованный пароль: " + decrypted);
            return null;
        }
    }
}
