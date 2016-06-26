package com.example.androidstreaming;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.MediaController;
import android.widget.VideoView;

public class TvDisplayActivity extends Activity {
	
	VideoView videoview;
	String vidAddress;
	Uri vidUri;
	android.widget.MediaController mediacontroller;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tvchannel);
	
		//URL TO BE SPECIFED GOT FROM INTENT
		
		/*Intent intent = getIntent();
		String url = intent.getStringExtra("URL");
		
		vidUri = Uri.parse(url);*/
		
		
		videoview = (VideoView)findViewById(R.id.VideoView);

		
		
		
		vidAddress ="http://bglive-a.bitgravity.com/ndtv/247lo/live/native";
		vidUri = Uri.parse(vidAddress);
		
		
		
		Log.e("value",vidUri.getPath());
		videoview.setVideoURI(vidUri);
		
		MediaController vidControl = new MediaController(this);
		vidControl.setAnchorView(videoview);
		videoview.setMediaController(vidControl);
	  videoview.start();
	  
	  
	  
	  
	  
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
}
