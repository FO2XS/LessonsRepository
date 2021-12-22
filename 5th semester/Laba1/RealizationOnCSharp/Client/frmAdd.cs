using Server;
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
    public partial class frmAdd : Form
    {
        public frmAdd()
        {
            InitializeComponent();
        }
        Tovar tovar = null;
        public Tovar getTovar
        {
            get
            {
                return tovar;
            }
        }
        private void btnAddTovar_Click(object sender, EventArgs e)
        {

            tovar = new Tovar();
            tovar.Name = textBox1.Text;
            tovar.Kol = (int)numericUpDown2.Value;
            tovar.Price = (int)numericUpDown1.Value;

            this.Close();

        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }



    }
}
