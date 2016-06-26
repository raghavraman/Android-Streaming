package com.example.androidstreaming;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
public class CustomGrid extends BaseAdapter{
	//VARIABLES TO E USED
	private Context mContext;
	private ArrayList<String> channels;
	 private  int[] Imageid;
	
	 
	 //DEFAULT VALUES USED
    private  String[] web;
   
    
    
    
    
      public CustomGrid(Context c,String[] web,int[] Imageid ) {
          mContext = c;
          this.Imageid = Imageid;
          this.web = web;
      }
      
      public CustomGrid(Context c,ArrayList<String> channels,int[] Imageid ) {
          mContext = c;
          this.Imageid = Imageid;
          this.channels = channels;
      }
    @Override
    public int getCount() {
      // TODO Auto-generated method stub
      return web.length;
    }
    @Override
    public Object getItem(int position) {
      // TODO Auto-generated method stub
      return null;
      
    }
    @Override
    public long getItemId(int position) {
      // TODO Auto-generated method stub
      return 0;
    }
    
    
    
    
    /*USE THE FUNCTIONS FOR USING ARRAYLIST OF STRING
     * 
     *  @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      // TODO Auto-generated method stub
      View grid;
      LayoutInflater inflater = (LayoutInflater) mContext
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          if (convertView == null) {
            grid = new View(mContext);
        grid = inflater.inflate(R.layout.single_gridcell, null);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            imageView.setImageResource(Imageid[position]);
          } else {
            grid = (View) convertView;
          }
      return grid;
    }
  */
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      // TODO Auto-generated method stub
      View grid;
      LayoutInflater inflater = (LayoutInflater) mContext
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          if (convertView == null) {
            grid = new View(mContext);
        grid = inflater.inflate(R.layout.single_gridcell, null);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            imageView.setImageResource(Imageid[position]);
          } else {
            grid = (View) convertView;
          }
      return grid;
    }
}