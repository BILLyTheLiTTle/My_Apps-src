package tts.universal;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class MyExpandableListAdapter extends BaseExpandableListAdapter {

	//private String[] groups = { "  Select Language" };
	//private String[][] children = { { "Ελληνικά" },{"Test"} };
	 private String[] groups = { "  Parent1", "  Parent2",
     "  Parent3" };
 private String[][] children = { { "  Child1" , "  Child2" }, 
		 { "  Child3" , "  Child4" }, 
		 { "  Child5" } };
	private TestEngineActivity activity=null;
	
	public MyExpandableListAdapter(TestEngineActivity activity){
		this.activity=activity;
	}
	
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return children[groupPosition][childPosition];
	}

	
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		TextView textView = getGenericView();
		textView.setTextColor(Color.GREEN);
        textView.setText(getChild(groupPosition, childPosition).toString());
        return textView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		int i = 0;
        try {
        	i = children[groupPosition].length;
        } 
        catch (Exception e) {}

        return i;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return groups[groupPosition];
	}
	
	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return groups.length;
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
        TextView textView = getGenericView();
        textView.setTextColor(Color.CYAN);
        textView.setText(getGroup(groupPosition).toString());
        return textView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}
	
	 public TextView getGenericView() {
	        // Layout parameters for the ExpandableListView
	        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
	            ViewGroup.LayoutParams.FILL_PARENT, 64);

	        TextView textView = new TextView(activity);
	        textView.setLayoutParams(lp);
	        // Center the text vertically
	        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
	        // Set the text starting position
	        textView.setPadding(36, 0, 0, 0);
	        return textView;
	    }
}
