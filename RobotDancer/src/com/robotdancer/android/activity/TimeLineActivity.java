package com.robotdancer.android.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.robotdancer.android.R;
import com.robotdancer.android.gui.TimelineButton;
import com.robotdancer.android.robot.BodyPart;

public class TimeLineActivity extends Activity {

	// ===========================================================
	// Constants
	// ===========================================================
	
	private static final int MAX_TIMELINE = 20;
	
	// ===========================================================
	// Fields
	// ===========================================================
	
	private static HashMap<BodyPart, List<Button>> mBodyPartButtonMap = new HashMap<BodyPart, List<Button>>();
	
	// ===========================================================
	// Constructors
	// ===========================================================
	
	// ===========================================================
	// Getter & Setter
	// ===========================================================
	
	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timeline);
		
		Button b = (Button) findViewById(R.id.button_start);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(TimeLineActivity.this, RobotDancerActivity.class);
				startActivity(i);
			}
		});

		TableLayout tableLayout = (TableLayout)findViewById(R.id.timeline_table);

		// Timeline labels
		TableRow tableRow = new TableRow(getApplicationContext());
        for (int j = 0; j < MAX_TIMELINE; j++) {
        	TextView textView = new TextView(getApplicationContext());
            textView.setText(Integer.toString(j));
            textView.setTextSize(11);
            textView.setSingleLine(true);

            tableRow.addView(textView);
        }
        tableLayout.addView(tableRow);

		// 
		for (BodyPart bodypart:BodyPart.values()) {
	    	tableRow = new TableRow(getApplicationContext());
	    	List<Button> buttonList = new ArrayList<Button>();
	        for (int j = 0; j < MAX_TIMELINE; j++) {
	        	
	        	TextView button = new TimelineButton(this, j, bodypart);
//	        	TextView button = new TextView(this);
	        	
	        	
	        	
//	        	buttonList.add(button);
	            button.setText("0");
	            button.setTextSize(11);
	            button.setSingleLine(true);
	            button.setPadding(6, 5, 15, 5);
	            //	            textView.setBackgroundColor(Color.RED);
	            tableRow.addView(button);
	        }
	        mBodyPartButtonMap.put(bodypart, buttonList);
	        tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
	        tableLayout.addView(tableRow);
	    }
	    
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		// Update buttons
	}
	// ===========================================================
	// Methods
	// ===========================================================
	
	public static HashMap<BodyPart, List<Button>> getButtonMap(){
		return mBodyPartButtonMap;
	}
	
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
	
}
