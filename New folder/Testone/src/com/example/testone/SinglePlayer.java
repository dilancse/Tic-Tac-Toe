package com.example.testone;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class SinglePlayer extends ActionBarActivity implements View.OnClickListener {
private	Boolean singlePlyer=true;
private String player;
String turn = "X";
int count = 0;
private	Button[] but= new Button[9];
private Button[][] sqbut =new Button[3][3];
private AlertDialog.Builder dialogbuilder;

/*public void PlayerNew(){
	dialogbuilder = new AlertDialog.Builder(this);
	EditText textinput = new EditText(this);
	String show = "Enter Your Name: ";
	
	dialogbuilder.setTitle("Enter");
	dialogbuilder.setMessage("Enter Your Name");
	dialogbuilder.setView(textinput);
	dialogbuilder.setPositiveButton("Single Player", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			player= textinput.getText().toString();
			Display();
			
		}
	});
}*/



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_player);
		
			
		/*       final Dialog dialog = new Dialog(MainActivity.this);
		dialog.setContentView(R.layout.dialogbox);
		//dialog.setTitle("Title...");

		// set the custom dialog components - text, image and button
		final Button btnSinglePlayer=(Button)findViewById(R.id.btn_singlePlayer);
		final Button btnDoublePlayer=(Button)findViewById(R.id.btn_doublePlayer);
		// if button is clicked, close the custom dialog
		dialog.show();
		
		btnSinglePlayer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	
		*/
		
		
		    but[0]=(Button)findViewById(R.id.button1);
	        but[1]=(Button)findViewById(R.id.button2);
	        but[2]=(Button)findViewById(R.id.button3);
	        but[3]=(Button)findViewById(R.id.button4);
	        but[4]=(Button)findViewById(R.id.button5);
	        but[5]=(Button)findViewById(R.id.button6);
	        but[6]=(Button)findViewById(R.id.button7);
	        but[7]=(Button)findViewById(R.id.button8);
	        but[8]=(Button)findViewById(R.id.button9);
	        
	        sqbut[0][0] = but[0];
	        sqbut[0][1] = but[1];
	        sqbut[0][2] = but[2];
	        sqbut[1][0] = but[3];
	        sqbut[1][1] = but[4];
	        sqbut[1][2] = but[5];
	        sqbut[2][0] = but[6];
	        sqbut[2][1] = but[7];
	        sqbut[2][2] = but[8];
	        
	
			

	        
	        for(int i=0;i<9;i++){
	        	but[i].setText(" ");
	        }
	        
	       
	       Toast.makeText(getBaseContext(), "Start Game",Toast.LENGTH_LONG).show();
	  
	        
	        
	       
	      
	      
	       but[0].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (singlePlyer == true)
	                play(0, 0, "O");
	            else
	            {
	                but[0].setText(turn);
	                if (turn == "X")
	                    turn = "O";
	                else
	                    turn = "X";
	            }
	            checkWins();

				but[0].setEnabled(false);
				
			}
		});
	        but[1].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (singlePlyer == true)
						play(0, 1, "O");
		            else
		            {
		                but[0].setText(turn);
		                if (turn == "X")
		                    turn = "O";
		                else
		                    turn = "X";
		            }
		            checkWins();
		            but[1].setEnabled(false);
					
				}
			});
	        but[2].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (singlePlyer == true)
						play(0, 2, "O");
		            else
		            {
		                but[0].setText(turn);
		                if (turn == "X")
		                    turn = "O";
		                else
		                    turn = "X";
		            }
		            checkWins();
		            but[2].setEnabled(false);
					
				}
			});
	        but[3].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (singlePlyer == true)
						play(1, 0, "O");
		            else
		            {
		                but[0].setText(turn);
		                if (turn == "X")
		                    turn = "O";
		                else
		                    turn = "X";
		            }
		            checkWins();
		            but[3].setEnabled(false);
				}
			});
	        but[4].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (singlePlyer == true)
						play(1, 0, "O");
		            else
		            {
		                but[0].setText(turn);
		                if (turn == "X")
		                    turn = "O";
		                else
		                    turn = "X";
		            }
		            checkWins();
		            but[4].setEnabled(false);
					
				}
			});
	        but[5].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (singlePlyer == true)
						play(1, 2, "O");
		            else
		            {
		                but[0].setText(turn);
		                if (turn == "X")
		                    turn = "O";
		                else
		                    turn = "X";
		            }
		            checkWins();
		            but[5].setEnabled(false);
					
				}
			});
	        but[6].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (singlePlyer == true)
						play(2, 0, "O");
		            else
		            {
		                but[0].setText(turn);
		                if (turn == "X")
		                    turn = "O";
		                else
		                    turn = "X";
		            }
		            checkWins();
		            but[6].setEnabled(false);
					
				}
			});
	        but[7].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (singlePlyer == true)
						play(2, 1, "O");
		            else
		            {
		                but[0].setText(turn);
		                if (turn == "X")
		                    turn = "O";
		                else
		                    turn = "X";
		            }
		            checkWins();
		            but[7].setEnabled(false);
					
				}
			});
	        but[8].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (singlePlyer == true)
						play(2, 2, "O");
		            else
		            {
		                but[0].setText(turn);
		                if (turn == "X")
		                    turn = "O";
		                else
		                    turn = "X";
		            }
		            checkWins();
		            but[7].setEnabled(false);
				}
			});
	        
	       
	        
	        
	}
	
	public void checkWins(){
		boolean winner =false;
		String sym = null;
		
		if((but[0].getText()==but[1].getText()) && (but[1].getText()==but[2].getText()) && but[0].getText()!= null){
			winner = true;
			sym = (String) but[0].getText();
		}
		else if((but[3].getText()==but[4].getText()) && (but[4].getText()==but[5].getText()) && but[3].getText()!= null){
			winner = true;
			sym = (String) but[3].getText();
		}
		else if((but[6].getText()==but[7].getText()) && (but[7].getText()==but[8].getText()) && but[6].getText()!= null){
			winner = true;
			sym = (String) but[6].getText();
		}
		else if((but[0].getText()==but[3].getText()) && (but[3].getText()==but[6].getText()) && but[0].getText()!= null){
			winner = true;
			sym = (String) but[0].getText();
		}
		else if((but[1].getText()==but[4].getText()) && (but[4].getText()==but[7].getText()) && but[1].getText()!= null){
			winner = true;
			sym = (String) but[1].getText();
		}
		else if((but[2].getText()==but[5].getText()) && (but[5].getText()==but[8].getText()) && but[2].getText()!= null){
			winner = true;
			sym = (String) but[2].getText();
		}
		else if((but[0].getText()==but[4].getText()) && (but[4].getText()==but[8].getText()) && but[0].getText()!= null){
			winner = true;
			sym = (String) but[0].getText();
		}
		else if((but[2].getText()==but[4].getText()) && (but[4].getText()==but[6].getText()) && but[2].getText()!= null){
			winner = true;
			sym = (String) but[2].getText();
		}
		
		if(sym == "X" || sym == "O"){
			if(winner){
				 Toast.makeText(getBaseContext(), "player "+sym+" Wins",Toast.LENGTH_LONG).show();
				// for(int i=0;i<9;i++){
				//	 but[i].setText(" ");
				// }
				 
				 for(int i=0;i<9;i++){
					 but[i].setEnabled(false);
				 }
			}
		}
		
		
	}
	
	
	public int scoreLine(String a, String b, String c)
    {
        if ((a == "X") && (b =="X") && (c == "X")) {

           
            return 1; }
        if ((a == "O") && (b == "O") && (c == "O")) {
           
            return -1; }
        return 0;
    }

    public int myscore()
    {
        int lineScore;
        for (int i = 0; i < 3; i++)
        {
            lineScore = scoreLine((String)sqbut[i][0].getText(),
            		(String)sqbut[i][1].getText(),
            		(String)sqbut[i][2].getText());
            if (lineScore != 0)
            {
                return lineScore;
            }
            lineScore = scoreLine((String)sqbut[0][i].getText(),
            		(String)sqbut[1][i].getText(),
            		(String)sqbut[2][i].getText());
            if (lineScore != 0)
            {
                return lineScore;
            }
        }
        lineScore = scoreLine((String)sqbut[0][0].getText(),
        		(String)sqbut[1][1].getText(),
        		(String)sqbut[2][2].getText());
        if (lineScore != 0)
        {
            return lineScore;
        }
        return scoreLine((String)sqbut[0][2].getText(), (String)sqbut[1][1].getText(), (String)sqbut[2][0].getText());
    }
    
    

    public int minimaxForO()
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
                if ((String)sqbut[row][column].getText() == " ")
                {
                    sqbut[row][column].setText("O");
                    score = minimaxForX();
                    if (score < bestScore)
                    {
                        bestScore = score;
                    }
                    sqbut[row][column].setText(" ");
                }
            }
        }
        return bestScore;
    }
    
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
                if (sqbut[row][column].getText() == " ")
                {
                    sqbut[row][column].setText("X");
                    score = minimaxForO();
                    if (score > bestScore)
                    {
                        bestScore = score;
                    }
                    sqbut[row][column].setText(" ");
                }
            }
        }
        return bestScore;
    }


    
    public boolean gameOver()
    {
        if (myscore() != 0)
        {
            return true;
        }
        for (int row = 0; row < 3; row++)
        {
            for (int column = 0; column < 3; column++)
            {
                if (sqbut[row][column].getText() == " ")
                {
                    return false;
                }
            }
        }
        return true;
    }


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
                    sqbut[row][column].setText("O");
                    player = "X";
                }
            }
        
    }


    public void playBestMove()
    {
        int score;
        int bestScore = -2;
        int bestRow = -1;
        int bestColumn = -1;
        for (int row = 0; row < 3; row++)
        {
            for (int column = 0; column < 3; column++)
            {
                if (sqbut[row][column].getText() == " ")
                {
                    sqbut[row][column].setText("X");
                    score = minimaxForO();
                    if (score > bestScore)
                    {
                        bestScore = score;
                        bestRow = row;
                        bestColumn = column;
                    }
                    sqbut[row][column].setText(" ");
                }
            }
        }
        sqbut[bestRow][bestColumn].setText("X");
    }

    


	

	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}



	/*@Override
	public void onClick(View v) {
		Button button=(Button) v;
		
		
		if(player){
			button.setText("O");
			player=false;
			
		}
		else{
			button.setText("X");
			player=true;
		}
		button.setEnabled(false);
	}*/
	
}


