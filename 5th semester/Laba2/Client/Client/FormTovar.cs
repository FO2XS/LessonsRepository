using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Client
{
    public partial class FormTovar : Form
    {
        public FormTovar()
        {
            InitializeComponent();
        }

        localhostTovarService.TovarServiceService service = new localhostTovarService.TovarServiceService();
        localhostTovarService.tovar[] arrTovar;


        private void getTovars_Click(object sender, EventArgs e)
        {
            arrTovar = service.getAllTovar();

            dataGridView1.Rows.Clear();

            foreach (localhostTovarService.tovar el in arrTovar)
            {
                object[] buffer = new object[4];

                buffer[0] = el.name;
                buffer[1] = el.price;
                buffer[2] = el.kol;
                buffer[3] = el.price * el.kol;

                dataGridView1.Rows.Add(buffer);
            }

        }

        private void CalculateSum_Click(object sender, EventArgs e)
        {
            textBox1.Text = service.getSumOfTovar().ToString();
        }
    }
}
