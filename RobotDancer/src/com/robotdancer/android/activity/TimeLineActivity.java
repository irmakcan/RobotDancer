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
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.robotdancer.android.R;
import com.robotdancer.android.gui.TimelineButton;
import com.robotdancer.android.robot.BodyPart;
import com.robotdancer.android.timeline.AbstractFrameHolder;
import com.robotdancer.android.timeline.BodyFrameHolder;
import com.robotdancer.android.timeline.TimeLine;

public class TimeLineActivity extends Activity {

	// ===========================================================
	// Constants
	// ===========================================================
	
	public static final int MAX_TIMELINE = 20;
	private static final int TEXT_SIZE = 18;
	
	// ===========================================================
	// Fields
	// ===========================================================
	
	private static HashMap<BodyPart, List<TextView>> mBodyPartButtonMap = new HashMap<BodyPart, List<TextView>>();
	
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
		
		// Start button
		Button b = (Button) findViewById(R.id.button_start);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(TimeLineActivity.this, RobotDancerActivity.class);
				startActivity(i);
			}
		});

		// Clear Button
		Button clearButton = (Button)findViewById(R.id.button_clear);
		clearButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				for(BodyPart bp:BodyPart.values()){
					AbstractFrameHolder fh = TimeLine.getInstance().getFrameHolder(bp);
					for(int i=0;i < MAX_TIMELINE;i++){
						fh.setAngleAt(i, 0);
					}
					TimeLine.getInstance().setFrameHolder(bp, fh);
					if(bp == BodyPart.BODY_MOVE){
						BodyFrameHolder bfh = (BodyFrameHolder)TimeLine.getInstance().getFrameHolder(bp);
						for(int i=0;i < MAX_TIMELINE;i++){
							bfh.setPositionAt(i, 0);
						}
						TimeLine.getInstance().setFrameHolder(bp, bfh);
					}
					
				}
			}
		});
		
		TableLayout tableLayout = (TableLayout)findViewById(R.id.timeline_table);
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_labels);
		
		// Timeline labels
		TableRow tableRow = new TableRow(getApplicationContext());
        for (int j = 0; j < MAX_TIMELINE; j++) {
        	TextView textView = new TextView(getApplicationContext());
            textView.setText(Integer.toString(j));
            textView.setTextSize(TEXT_SIZE);
            textView.setSingleLine(true);

            tableRow.addView(textView);
        }
        tableLayout.addView(tableRow);
        
        // Time Label
        TextView tLabel = new TextView(getApplicationContext());
        tLabel.setText("Time");
        tLabel.setTextSize(TEXT_SIZE);
        tLabel.setPadding(4, 0, 0, 0);
        tLabel.setSingleLine(true);
        linearLayout.addView(tLabel);

        
		// 
		for (BodyPart bodypart:BodyPart.values()) {
	    	tableRow = new TableRow(getApplicationContext());
	    	List<TextView> buttonList = new ArrayList<TextView>();
	        for (int j = 0; j < MAX_TIMELINE; j++) {
	        	
	        	TextView button = new TimelineButton(this, j, bodypart);
//	        	TextView button = new TextView(this);
	        	
	        	
	        	
	        	
	            button.setText("0      ");
	            button.setTextSize(TEXT_SIZE);
	            button.setSingleLine(true);
	            button.setPadding(6, 5, 15, 5);
	            tableRow.addView(button);
	            
	            buttonList.add(button);
	        }
	        mBodyPartButtonMap.put(bodypart, buttonList);
	        tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
	        tableLayout.addView(tableRow);
	        
	        // Add label
	        TextView textLabel = new TextView(getApplicationContext());
	        textLabel.setText(bodypart.toString());
	        textLabel.setTextSize(TEXT_SIZE);
	        textLabel.setPadding(6, 5, 15, 5);
	        textLabel.setSingleLine(true);
	        linearLayout.addView(textLabel);
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
	
	public static HashMap<BodyPart, List<TextView>> getButtonMap(){
		return mBodyPartButtonMap;
	}
	
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
	
}
