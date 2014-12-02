using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TicTac
{
    public partial class Form1 : Form
    {
        String turn = "X";
        int count = 0;
        bool singlePlyer = false;
        SqlConnection connection;
         
         Button[] buttn=new Button[9];
        Button[,] squares=new Button[3,3];
        public Form1()
        {
            
            
            InitializeComponent();
           
            
        }
       
      /* private void button1_Click(object sender, EventArgs e)
        {


            squares[0, 0] = button1;
            squares[0, 1] = button2;
            squares[0, 2] = button3;
            squares[1, 0] = button4;
            squares[1, 1] = button5;
            squares[1, 2] = button6;
            squares[2, 0] = button7;
            squares[2, 1] = button8;
            squares[2, 2] = button9;


            /* count++;
            Button b = (Button)sender;
            
            
                if (turn)
                {
                    b.Text = "X";
                   // ckeckWins();
                }
                else
                {
                    b.Text = "O";
                   // ckeckWins();
                }
                turn = !turn;
            
        }
        bool check_cnt() {

            if (count < 10)
                return true;
            else
            {
                if(count==9)
                    MessageBox.Show("Draw");

                foreach (Button c in Controls)
                {

                    Button b = (Button)c;
                    b.Enabled = false;
                }
                btnnewGame.Enabled = true;
                btn_exit.Enabled = true;
                btn_single.Enabled = true;
                btn_Two.Enabled = true;
                count = 0;
                return false;
            }
        }*/


        

        private void btnnewGame_Click(object sender, EventArgs e)
        { 
           MessageBox.Show("Welcome to Tic Tac Toe.\n");

           for (int i = 0; i < 9; i++)
           {
               buttn[i].Text = ".";
               buttn[i].Enabled = true;
           }
          // play(0,0,"X");
            Console.WriteLine("Game over.");
        

            
            /* foreach (Button c in Controls)
            {
                Button b = (Button)c;
                b.Enabled = true;
                if((b.Text!="New Game")&&(b.Text!="EXIT")&&(b.Text!="Two Player")&&(b.Text!="Single Player"))
                    b.ResetText();
            }*/
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            try
            {
                connection.getCon();
            }
            catch (Exception ex) {
                Console.Write(ex);
            }
            squares[0,0] = button1;
            squares[0, 1] = button2;
            squares[0, 2] = button3;
            squares[1, 0] = button4;
            squares[1, 1] = button5;
            squares[1, 2] = button6;
            squares[2, 0] = button7;
            squares[2, 1] = button8;
            squares[2, 2] = button9;
            buttn[0]= button1;
            buttn[1]= button2;
            buttn[2]=button3;  
            buttn[3]=button4;
            buttn[4]=button5;
            buttn[5]=button6; 
            buttn[6]=button7;
            buttn[7]=button8;
            buttn[8]=button9;

            for (int i = 0; i < 9; i++) {
                buttn[i].Text = ".";
                buttn[i].Enabled = false;
            }
            btnnewGame.Enabled = false;
            
        }

        private void btn_exit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void ckeckWins()
        {
            bool winner = false; ;
            String sym = null;

            //horizontal
            if ((button1.Text == button2.Text) && (button2.Text == button3.Text) && (button1.Text != ""))
            {
                winner = true;
                sym = button1.Text;
            }
            else if ((button4.Text == button5.Text) && (button5.Text == button6.Text) && (button4.Text != ""))
            {
                winner = true;
                sym = button4.Text;
            }
            else if ((button7.Text == button8.Text) && (button8.Text == button9.Text) && (button7.Text != ""))
            {
                winner = true;
                sym = button7.Text;
            }
            //vertical
            else if ((button1.Text == button4.Text) && (button4.Text == button7.Text) && (button1.Text != ""))
            {
                winner = true;
                sym = button1.Text;
            }
            else if ((button2.Text == button5.Text) && (button5.Text == button8.Text) && (button2.Text != ""))
            {
                winner = true;
                sym = button2.Text;
            }
            else if ((button3.Text == button6.Text) && (button6.Text == button9.Text) && (button3.Text != ""))
            {
                winner = true;
                sym = button3.Text;
            }
            //
            else if ((button1.Text == button5.Text) && (button5.Text == button9.Text) && (button1.Text != ""))
            {
                winner = true;
                sym = button1.Text;
            }
            else if ((button3.Text == button5.Text) && (button5.Text == button7.Text) && (button3.Text != ""))
            {
                winner = true;
                sym = button3.Text;
            }

            if (sym == "X" || sym == "O")
            {
                if (winner)
                {
                    MessageBox.Show(sym+" wins");
                    for (int i = 0; i < 9; i++)
                    {
                        buttn[i].Text = ".";
                        buttn[i].Enabled = false;
                    }


                    save("","",sym);
                }
            }
           
        }

        

        /** Return true if the game is over. */
        public bool gameOver()
        {
            if (myscore() != 0)
            {
                return true;
            }
            for (int row = 0; row < 3; row++)
            {
                for (int column = 0; column < 3; column++)
                {
                    if (squares[row,column].Text == ".")
                    {
                        return false;
                    }
                }
            }
            return true;
        }

        /** Return the value of the current position if it is O's turn. */
        protected int minimaxForO()
        {
            int score = myscore();
            if (gameOver())
            {
                return score;
            }
            int bestScore = 2;
            for (int row = 0; row < 3; row++)
            {
                for (int column = 0; column < 3; column++)
                {
                    if (squares[row,column].Text == ".")
                    {
                        squares[row,column].Text = "O";
                        score = minimaxForX();
                        if (score < bestScore)
                        {
                            bestScore = score;
                        }
                        squares[row,column].Text = ".";
                    }
                }
            }
            return bestScore;
        }

        /** Return the value of the current position if it is X's turn. */
        protected int minimaxForX()
        {
            int score = myscore();
            if (gameOver())
            {
                return score;
            }
            int bestScore = -2;
            for (int row = 0; row < 3; row++)
            {
                for (int column = 0; column < 3; column++)
                {
                    if (squares[row,column].Text == ".")
                    {
                        squares[row,column].Text = "X";
                        score = minimaxForO();
                        if (score > bestScore)
                        {
                            bestScore = score;
                        }
                        squares[row,column].Text = ".";
                    }
                }
            }
            return bestScore;
        }

        /** Play one game. */
        public void play(int rw,int colom,String plr)
        {
            String player = plr;
                for (int i = 0; i < 2; i++)
                {

                    if (gameOver())
                    {
                        return;
                    }
                    if (player == "X")
                    {
                        playBestMove();
                        player = "O";
                        break;
                    }
                    else
                    {

                        int row = rw;
                        int column = colom;
                        squares[row, column].Text = "O";
                        player = "X";
                    }
                }
            
        }

        /** Find the best move for X and play it on the board. */
        protected void playBestMove()
        {
            int score;
            int bestScore = -2;
            int bestRow = -1;
            int bestColumn = -1;
            for (int row = 0; row < 3; row++)
            {
                for (int column = 0; column < 3; column++)
                {
                    if (squares[row, column].Text == ".")
                    {
                        squares[row, column].Text ="X";
                        score = minimaxForO();
                        if (score > bestScore)
                        {
                            bestScore = score;
                            bestRow = row;
                            bestColumn = column;
                        }
                        squares[row,column].Text = ".";
                    }
                }
            }
            squares[bestRow,bestColumn].Text = "X";
        }

        /** Return 1 if X has won, -1 if O has won, and 0 otherwise. */
        public int myscore()
        {
            int lineScore;
            for (int i = 0; i < 3; i++)
            {
                lineScore = scoreLine(squares[i,0].Text,
                                     squares[i,1].Text,
                                     squares[i,2].Text);
                if (lineScore != 0)
                {
                    return lineScore;
                }
                lineScore = scoreLine(squares[0,i].Text,
                                     squares[1,i].Text,
                                     squares[2,i].Text);
                if (lineScore != 0)
                {
                    return lineScore;
                }
            }
            lineScore = scoreLine(squares[0,0].Text,
                                 squares[1,1].Text,
                                 squares[2,2].Text);
            if (lineScore != 0)
            {
                return lineScore;
            }
            return scoreLine(squares[0,2].Text, squares[1,1].Text, squares[2,0].Text);
        }

        /** 
         * Return 1 if all three characters are 'X', -1 if they are all 'O', 
         * and 0 otherwise. 
         */
        protected int scoreLine(String a, String b, String c)
        {
            if ((a == "X") && (b =="X") && (c == "X")) {

               
                return 1; }
            if ((a == "O") && (b == "O") && (c == "O")) {
               
                return -1; }
            return 0;
        }

        public String toString()
        {
            String result = "";
            for (int row = 0; row < 3; row++)
            {
                for (int column = 0; column < 3; column++)
                {
                    result += squares[row,column];
                }
                result += "\n";
            }
            return result;
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            if (singlePlyer == true)
                play(0, 0, "O");
            else
            {
                button1.Text = turn;
                if (turn == "X")
                    turn = "O";
                else
                    turn = "X";
            }
            ckeckWins();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (singlePlyer == true)
                play(0, 1, "O");
            else
            {
                button2.Text = turn;
                if (turn == "X")
                    turn = "O";
                else
                    turn = "X";
            }
            ckeckWins();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (singlePlyer == true)
                play(0, 2, "O");
            else
            {
                button3.Text = turn;
                if (turn == "X")
                    turn = "O";
                else
                    turn = "X";
            }
            ckeckWins();
           
        }

        private void button4_Click(object sender, EventArgs e)
        {
            if (singlePlyer == true)
                play(1, 0, "O");
            else
            {
                button4.Text = turn;
                if (turn == "X")
                    turn = "O";
                else
                    turn = "X";
            }
            ckeckWins();
           
        }

        private void button5_Click(object sender, EventArgs e)
        {
            if (singlePlyer == true)
                play(1, 1, "O");
            else
            {
                button5.Text = turn;
                if (turn == "X")
                    turn = "O";
                else
                    turn = "X";
            }
            ckeckWins();
           
        }

        private void button6_Click(object sender, EventArgs e)
        {
            if (singlePlyer == true)
                play(1, 2, "O");
            else
            {
                button6.Text = turn;
                if (turn == "X")
                    turn = "O";
                else
                    turn = "X";
            }
            ckeckWins();
           
        }

        private void button7_Click(object sender, EventArgs e)
        {
            if (singlePlyer == true)
                play(2, 0, "O");
            else
            {
                button7.Text = turn;
                if (turn == "X")
                    turn = "O";
                else
                    turn = "X";
            }
            ckeckWins();
           
        }

        private void button8_Click(object sender, EventArgs e)
        {
            if (singlePlyer == true)
                play(2, 1, "O");
            else
            {
                button8.Text = turn;
                if (turn == "X")
                    turn = "O";
                else
                    turn = "X";
            }
            ckeckWins();
           
        }

        private void button9_Click(object sender, EventArgs e)
        {
            if (singlePlyer == true)
                play(2, 2, "O");
            else
            {
                button9.Text = turn;
                if (turn == "X")
                    turn = "O";
                else
                    turn = "X";
            }
            ckeckWins();
           
        }

        private void btn_Two_Click(object sender, EventArgs e)
        {
            singlePlyer = false;
            btnnewGame.Enabled = true;

        }

        private void btn_single_Click(object sender, EventArgs e)
        {
            singlePlyer = true;
            btnnewGame.Enabled = true;

        }

        private void btrn_Click(object sender, EventArgs e)
        {
            if(singlePlyer==true)
                squares[1,1].Text = "X";
        }

       

    }
}
   


   
