using Server;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Tcp;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Client
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        TovarOperation tovarOperation = null;

        private void doVivod(List<Tovar> lstTovar)
        {
            lvList.Items.Clear();
            foreach (Tovar tovar in lstTovar)
            {
                lvList.Items.Add($"{tovar.Name}  Цена: {tovar.Price} Количество: {tovar.Kol} Сумма: {tovar.Price * tovar.Kol}");
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            try
            {
                TcpClientChannel chan = new TcpClientChannel();
                ChannelServices.RegisterChannel(chan, false);
                tovarOperation = (TovarOperation)Activator.GetObject(
                typeof(TovarOperation), "tcp://localhost:9000/TalkIsGood");

                doVivod(tovarOperation.getListOfTovar());
            }
            catch (Exception ex)
            {
                MessageBox.Show(this, "Ошибка соединения: +" + ex, "Сообщение об ошибке", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            frmAdd f = new frmAdd();
            f.ShowDialog();
            if (f.getTovar != null)
            {
                try
                {
                    doVivod(tovarOperation.addNewTovar(f.getTovar));
                }
                catch (Exception ex)
                {
                    MessageBox.Show(this, "Ошибка соединения: +" + ex, "Сообщение об ошибке", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
            if (txt.Text != "") btnDecide_Click(sender, e);

        }

        private void btnDecide_Click(object sender, EventArgs e)
        {
            try
            {
                txt.Text = tovarOperation.getSumOfTovar().ToString();
            }
            catch (Exception ex)
            {
                MessageBox.Show(this, "Ошибка: +" + ex, "Сообщение об ошибке", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            try
            {
                doVivod(tovarOperation.getListOfTovar());
            }
            catch (Exception ex)
            {
                MessageBox.Show(this, "Ошибка соединения: +" + ex, "Сообщение об ошибке", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

        }
    }
}
