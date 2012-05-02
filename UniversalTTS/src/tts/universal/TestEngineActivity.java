package tts.universal;

import java.util.Locale;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class TestEngineActivity extends Activity implements TextToSpeech.OnInitListener{
	
	ExpandableListAdapter mAdapter;
	ExpandableListView epView;
	TextToSpeech tts;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Initialize the objects for the ExpandableListView        
        epView = (ExpandableListView) findViewById(R.id.expandableListView);
        mAdapter = new MyExpandableListAdapter(this);
        epView.setAdapter(mAdapter);
        epView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent,
                    View v, int groupPosition, int childPosition,
                    long id) {
                TextView view=(TextView) v;
                view.setTextColor(Color.MAGENTA);
                return false;
            }
            });
    }
    
    public void speak(View view){
    	//Log.e("TEST", ""+epView.getSelectedItem());
    	tts= new TextToSpeech(this, this);
    }
    
    public void say(String text2say){
    	tts.speak(text2say, TextToSpeech.QUEUE_FLUSH, null);
    	}
    public void onInit(int status) {
    	say("Wǎnshàng hǎo");
    }
}