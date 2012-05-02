package com.google.plus.bt115987123050471593055;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.*;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.*;

public class Activity3D extends Activity {
	
	private int screenWidth,screenHeight, i=0;
	private TextView textView,mirror_textView;
	private ImageView imageView,mirror_imageView;
	private Button button, mirror_button;
	private Thread thr;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //get screen size
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth=dm.widthPixels;
        screenHeight=dm.heightPixels;
        Log.e("DIMENSIONS", "W="+screenWidth+" H="+screenHeight);
        
        //place the Drop-down menu
     /* Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        MarginLayoutParams marginParams = new MarginLayoutParams(spinner.getLayoutParams());
        marginParams.setMargins(screenWidth/4, screenHeight/8, 0, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginParams);
        spinner.setLayoutParams(layoutParams);
        Spinner mirror_spinner = (Spinner) findViewById(R.id.mirror_spinner);
        ArrayAdapter<CharSequence> mirror_adapter = ArrayAdapter.createFromResource(
                this, R.array.planets_array, android.R.layout.simple_spinner_item);
        mirror_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mirror_spinner.setAdapter(mirror_adapter);
        marginParams = new MarginLayoutParams(mirror_spinner.getLayoutParams());
        marginParams.setMargins(3*screenWidth/4, screenHeight/8, 0, 0);
        layoutParams = new RelativeLayout.LayoutParams(marginParams);
        mirror_spinner.setLayoutParams(layoutParams);
        
        //place the buttons
        Button button=(Button) findViewById(R.id.button);
        marginParams = new MarginLayoutParams(button.getLayoutParams());
        marginParams.setMargins(screenWidth/4, 3*screenHeight/8, 0, 0);
        layoutParams = new RelativeLayout.LayoutParams(marginParams);
        button.setLayoutParams(layoutParams);
        Button mirror_button=(Button) findViewById(R.id.mirror_button);
        marginParams = new MarginLayoutParams(mirror_button.getLayoutParams());
        marginParams.setMargins(3*screenWidth/4, 3*screenHeight/8, 0, 0);
        layoutParams = new RelativeLayout.LayoutParams(marginParams);
        mirror_button.setLayoutParams(layoutParams);
     
        
        //place the TextViews
        TextView textView=(TextView) findViewById(R.id.textView);
        MarginLayoutParams marginParams = new MarginLayoutParams(textView.getLayoutParams());
        marginParams.setMargins(screenWidth/4, 5*screenHeight/8, 0, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginParams);
        textView.setLayoutParams(layoutParams);
        TextView mirror_textView=(TextView) findViewById(R.id.mirror_textView);
        marginParams = new MarginLayoutParams(mirror_textView.getLayoutParams());
        marginParams.setMargins(3*screenWidth/4, 5*screenHeight/8, 0, 0);
        layoutParams = new RelativeLayout.LayoutParams(marginParams);
        mirror_textView.setLayoutParams(layoutParams);
     */
        
        //Second 3D attempt!!!I hope it will be better
        imageView=(ImageView)findViewById(R.id.image);
        MarginLayoutParams marginParams = new MarginLayoutParams(imageView.getLayoutParams());
        marginParams.setMargins(0, 0, screenWidth/2, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginParams);
        imageView.setLayoutParams(layoutParams);
        //imageView.setScaleType(ImageView.ScaleType.)
        mirror_imageView=(ImageView) findViewById(R.id.mirror_image);
        marginParams = new MarginLayoutParams(mirror_imageView.getLayoutParams());
        marginParams.setMargins(screenWidth/2, 0, 0, 0);
        layoutParams = new RelativeLayout.LayoutParams(marginParams);
        mirror_imageView.setLayoutParams(layoutParams);
        
        textView=(TextView) findViewById(R.id.textView);
        marginParams = new MarginLayoutParams(textView.getLayoutParams());
        marginParams.setMargins(screenWidth/4, screenHeight/8, 0, 0);
        layoutParams = new RelativeLayout.LayoutParams(marginParams);
        textView.setLayoutParams(layoutParams);
        mirror_textView=(TextView) findViewById(R.id.mirror_textView);
        marginParams = new MarginLayoutParams(mirror_textView.getLayoutParams());
        marginParams.setMargins(3*screenWidth/4, screenHeight/8, 0, 0);
        layoutParams = new RelativeLayout.LayoutParams(marginParams);
        mirror_textView.setLayoutParams(layoutParams);
        
        button=(Button) findViewById(R.id.button);
        marginParams = new MarginLayoutParams(button.getLayoutParams());
        marginParams.setMargins(screenWidth/4, screenHeight/8, 0, 0);
        layoutParams = new RelativeLayout.LayoutParams(marginParams);
        button.setLayoutParams(layoutParams);
        mirror_button=(Button) findViewById(R.id.mirror_button);
        marginParams = new MarginLayoutParams(mirror_button.getLayoutParams());
        marginParams.setMargins(3*screenWidth/4, screenHeight/8, 0, 0);
        layoutParams = new RelativeLayout.LayoutParams(marginParams);
        mirror_button.setLayoutParams(layoutParams);
                
        thr=new Thread(){
        	public void run(){
        		for(;;){
        			i++;
        			Log.e("THREAD", "No "+i);
        			if(i==8)
        				i=0;
        			button.post(new Runnable(){
        				public void run(){        					
        					MarginLayoutParams marginParams = new MarginLayoutParams(button.getLayoutParams());
        			        marginParams.setMargins(screenWidth/4, (i+1)*screenHeight/8, 0, 0);
        			        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginParams);
        			        button.setLayoutParams(layoutParams);
        			        marginParams = new MarginLayoutParams(mirror_button.getLayoutParams());
        			        marginParams.setMargins(3*screenWidth/4, (i+1)*screenHeight/8, 0, 0);
        			        layoutParams = new RelativeLayout.LayoutParams(marginParams);
        			        mirror_button.setLayoutParams(layoutParams);
        				}
        			});
        			try{
        				Thread.sleep(3000);
        			}
        			catch (Exception e){}
        			textView.post(new Runnable(){
        				public void run(){        					
        					MarginLayoutParams marginParams = new MarginLayoutParams(textView.getLayoutParams());
        			        marginParams.setMargins(screenWidth/4, (i+1)*screenHeight/8, 0, 0);
        			        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginParams);
        			        textView.setLayoutParams(layoutParams);
        			        marginParams = new MarginLayoutParams(mirror_textView.getLayoutParams());
        			        marginParams.setMargins(3*screenWidth/4, (i+1)*screenHeight/8, 0, 0);
        			        layoutParams = new RelativeLayout.LayoutParams(marginParams);
        			        mirror_textView.setLayoutParams(layoutParams);
        				}
        			});
        			try{
        				Thread.sleep(3000);
        			}
        			catch (Exception e){}
        		}
        	}
        };
        thr.start();
        
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent mevt){
    	finish();
		System.runFinalizersOnExit(true);
		System.exit(0);
    	return true;
    }
}