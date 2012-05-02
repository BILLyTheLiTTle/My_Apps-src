package example.provider;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ExampleProviderActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        new DatabaseHelper(this, (TextView)findViewById(R.id.text));
    }


private class DatabaseHelper extends SQLiteOpenHelper{
	SQLiteDatabase db;
	TextView tv;
	DatabaseHelper(Context ctx, TextView tv){
		super(ctx,"ExampleDB.db",null,1);
		this.tv=tv;
		//db = openOrCreateDatabase(
		//		"ExampleDB.db"
		//		, SQLiteDatabase.CREATE_IF_NECESSARY
		//		, null
		//		);
		/*I have to find out what's the difference between
		 * getReadableDatabase and getWritableDatabase.
		 * I updated the db using the object returned 
		 * by the getReadableDatabase method. 
		 */
		db = getReadableDatabase();
		//db = getWritableDatabase();
		Log.e("CONSTRUCTOR","OK");
		//onCreate(db);
	}

	@Override
	public void onOpen(SQLiteDatabase db){
		Log.e("ONOPEN","OK");
		Cursor c=db.rawQuery("select name from persons_data where _id=1;",null);
        c.moveToFirst();
		String str=c.getString(0);
        String list=c.getColumnName(0);
        c.close();
        tv.setText(str);
        Log.e("DATA",str);
        Log.e("COLUMN",list);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.e("ONCREATE","OK");
		db.execSQL("CREATE TABLE persons_data (_id INTEGER PRIMARY KEY, name TEXT, year INTEGER);");
		db.execSQL("INSERT INTO persons_data VALUES (1, \"Bill\", 1986);");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.e("ONUPGRADE","OK");
		db.execSQL("INSERT INTO persons_data VALUES (2, \"Jim\", 1993);");
		//onCreate(db);
	}
}
}