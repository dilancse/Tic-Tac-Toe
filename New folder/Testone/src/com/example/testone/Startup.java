package com.example.testone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Startup extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startup);
		
		Thread start_up = new Thread(){
			public void run(){
				try{
					sleep(2000);
				}catch(InterruptedException e){
					e.printStackTrace();
					
				}finally{
					Intent game_start = new Intent("com.example.testone.MAINACTIVITY");
					startActivity(game_start);
				}
			}
			
		};
		
		start_up.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
