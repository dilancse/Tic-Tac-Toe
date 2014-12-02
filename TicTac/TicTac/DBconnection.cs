using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace TicTac
{
    class DBconnection
    {
        private SqlConnection conn;

        private DBconnection() { 
            
        }

        public SqlConnection getCon() {
           
           if (conn == null)
           { 
               try
               {
                    conn = new SqlConnection("Data Source=thilina\\sqlexpress;Initial Catalog=Tic_Tac_NewDB;Integrated Security=True");
                    conn.Open();
                    MessageBox.Show("Connection Open ! ");
                    //conn.Close();
               }
                catch (Exception ex)
                 {
                     MessageBox.Show(ex + "Can not open connection ! ");
                }
           }
            return conn;
            
        }

       
    }

}
