package com.example.androidstreaming;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class RadiochannelActivity extends Activity{
	
	 GridView grid;

	 //DECLARATION FOR VARIABLES USED IN WEBSERVICE FUNCTION
	 int count;
	String Channel;
	int ImageID;
	String channelurl;
	ArrayList<String> mychannellist = new ArrayList<String>();
	ArrayList<String> mychannelurllist = new ArrayList<String>();
	int[] mychannelimagelist=new int[getCount()];
	
	
	//DEFAULT VALUES USED FOR UI
		//PLEASE USE THE NECESSARY FUNCTIONS TO GET THE VALUE OF NAME AND IMAGE OF THE CHANNEL
		
		 String[] channels = {"SURYAN FM","RADIOMIRCHI"} ;
		  int[] imageId = {
		      R.drawable.suryanfm,
		      R.drawable.radiomirchi,
		  };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radio);
		
		
		
		
		
		
		//CALL THE FUNCTION addChannelDetailsToList() to ADD THE CHANNEL NAME AND THEIR IMAGE ID
		//TO VARAIABLES TO BE PASSED
		
		/*
		 * addChanneltolist()
		 * 
		 * */
		
		/*USE THESE FUNCTIONS TO CALL THE GRID ADAPTER
		 * 
		 * CustomGrid adapter = new CustomGrid(TvchannelActivity.this, mychannellist, mychannelimagelist);
	    grid=(GridView)findViewById(R.id.tvgrid);
	        grid.setAdapter(adapter);
	        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	                @Override
	                public void onItemClick(AdapterView<?> parent, View view,
	                                        int position, long id) {
	                  
	                }
	            });
	  } 
		 * */
		
		
		
		
		
		CustomGrid adapter = new CustomGrid(RadiochannelActivity.this, channels, imageId);
	    grid=(GridView)findViewById(R.id.tvgrid);
	        grid.setAdapter(adapter);
	        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	                @Override
	                public void onItemClick(AdapterView<?> parent, View view,
	                                        int position, long id) {
	                	
	                	Intent intent = new Intent(RadiochannelActivity.this, RadioDisplayActivity.class);
	                	
	              	/*
	                	 * to PASS THE URL TO THE DISPLAY SCREEN USE THIS FUNCTION
	                	 * String channelurl=getChannelURL(position);  
	                	  String name=getChannelName(position); //position is passed to identify which channel it is
	                	 *   intent.putExtra(channelurl, "URL");
	                	 * 
	                	 * */
	                	

	                		intent.putExtra("NAME", channels[position]);
	                		intent.putExtra("image_url",imageId[position]);
	                    startActivity(intent);
	                }
	            });
		
		
		
	}

	public int getCount()
	{
	
		/*function to get the no of channels provided using WEBSERVICE*/
		
		return count;
	}
	
	public String getChannelName(int no)
	{
	
		/*function to get the name of channel for the no specified  using WEBSERVICE*/
		
		return Channel;
	}
	
	public int getChannelImageID(int no)
	{
	
		/*function to get the id of channel logo provided using WEBSERVICE*/
		
		return ImageID;
	}


	public String getChannelURL(int no)
	{
	
		/*function to get the id of channel streaming url provided using WEBSERVICE*/
		
		return channelurl;
	}

	//ADDING CHANNEL  TO a list
	public ArrayList<String> addChannelDetailsToList()
	{
		
		
	
		for(int i=0;i<count;i++)
		{
			String channelName=getChannelName(i);
			mychannellist.add(channelName);
			String channelURL=getChannelURL(i);
			mychannelurllist.add(channelURL);
			mychannelimagelist[i]=getChannelImageID(i);
			
			
		}
		return mychannellist;
	}
	

		

}
