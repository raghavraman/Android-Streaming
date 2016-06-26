package com.example.androidstreaming;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class RadioDisplayActivity extends Activity{

	ImageView imageview;
	String name;
	TextView textview;
	static MediaPlayer mPlayer;
	Button buttonPlay;
	Button buttonStop;
	String url = "http://www.hrupin.com/wp-content/uploads/mp3/testsong_20_sec.mp3"; 
	protected void onCreate(Bundle savedInstanceState) {
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radiochannel);
		
		imageview=(ImageView)findViewById(R.id.RadioImage);
		textview=(TextView)findViewById(R.id.RadioHeader);
		
		//URL TO BE SPECIFED GOT FROM INTENT
		
				/*Intent intent = getIntent();
				 url = intent.getStringExtra("URL");
				name=intent.getStringExtra("NAME");
    			int image_link = getIntent().getIntExtra("image_url", R.drawable.default);
    			imageView.setImageResource(image_link);
				*/
		Intent intent = getIntent();
		name=intent.getStringExtra("NAME");
		int image_link = getIntent().getIntExtra("image_url", R.drawable.radiomirchi);
		imageview.setImageResource(image_link);
		textview.setText(name);
		
		buttonPlay = (Button) findViewById(R.id.play);
		buttonPlay.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				mPlayer = new MediaPlayer();
				mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
				try {
					mPlayer.setDataSource(url);
				} catch (IllegalArgumentException e) {
					Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
				} catch (SecurityException e) {
					Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
				} catch (IllegalStateException e) {
					Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
						  public void onPrepared(MediaPlayer mp) {
						      mp.start();
						  }
						});
						mPlayer.prepareAsync();
				} catch (IllegalStateException e) {
					Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
				} //catch (IOException e) {
					//Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
				//}
				
			}
		});
		
		buttonStop = (Button) findViewById(R.id.stop);
		buttonStop.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(mPlayer!=null && mPlayer.isPlaying()){
					mPlayer.stop();
				}
			}
		});
	}
		
		
	
	protected void onDestroy() {
		super.onDestroy();
		// TODO Auto-generated method stub
		if (mPlayer != null) {
			mPlayer.release();
			mPlayer = null;
		}
	}
}
