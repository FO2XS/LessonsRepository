using System;

namespace ServerObj
{
    public class TaskClass : MarshalByRefObject
    {
        /// <summary>
        /// Вычисляет сумму квадратов целых чисел начиная с переданного до 50.
        /// </summary>
        /// <param name="start">Начальное число.</param>
        /// <returns>Сумма квадратов.</returns>
        public int SumSquare(int start)
        {
            var result = 0;

            for (var i = start; i <= 50; i++)
            {
                result += i * i;
            }

            return result;
        }

        /// <summary>
        /// Вычленяет из переданного текста буквы "м" и "н" в порядке их появления в тексте.
        /// </summary>
        /// <param name="text">Текст.</param>
        /// <returns>Вычлененная последовательность.</returns>
        public string SubstringChars(string text)
        {
            string result = "";

            foreach(var c in text)
            {
                if(c.ToString().ToUpper() == "М" || c.ToString().ToUpper() == "Н")
                {
                    result += c;
                }
            }

            return result;
        }
    }
}
