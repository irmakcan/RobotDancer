package com.robotdancer.android.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.robotdancer.android.R;
import com.robotdancer.android.timeline.macro.ArmSliderMacro;
import com.robotdancer.android.timeline.macro.IMacro;
import com.robotdancer.android.timeline.macro.MacroManager;
import com.robotdancer.android.timeline.macro.MichealJacksonMacro;
import com.robotdancer.android.timeline.macro.RandomDanceMacro;
import com.robotdancer.android.timeline.macro.WalkLeftMacro;
import com.robotdancer.android.timeline.macro.WalkRightMacro;

public class MacroSelectionActivity extends Activity{
	// ===========================================================
	// Constants
	// ===========================================================
	
	// ===========================================================
	// Fields
	// ===========================================================
	
	private int mSelectedSecond = 0;
	
	private List<IMacro> mMacroList = new ArrayList<IMacro>();
	private List<String> mSecList = new ArrayList<String>();
	
	private ArrayAdapter<IMacro> mMacroAdapter = null;
	private ArrayAdapter<String> mSecAdapter = null;
	
	private TextView mSecondTextView;
	
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
		setContentView(R.layout.macro_selection);
		
		mSecondTextView = (TextView) findViewById(R.id.text_second);
		
		ListView secondList = (ListView)findViewById(R.id.list_second);
		mSecAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSecList);
		secondList.setAdapter(mSecAdapter);
		
		ListView macroList = (ListView) findViewById(R.id.list_macro);
		mMacroAdapter = new ArrayAdapter<IMacro>(this, android.R.layout.simple_list_item_1, mMacroList);
		macroList.setAdapter(mMacroAdapter);
		
		
		for(int i=0;i<TimeLineActivity.MAX_TIMELINE;i++){
			mSecAdapter.add("        " + String.valueOf(i) + "           ");
		}
		secondList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
				mSelectedSecond = position;
				mSecondTextView.setText(String.valueOf(position));
			}
		});
		mMacroAdapter.add(new ArmSliderMacro());
		mMacroAdapter.add(new MichealJacksonMacro());
		mMacroAdapter.add(new WalkLeftMacro());
		mMacroAdapter.add(new WalkRightMacro());
		mMacroAdapter.add(new RandomDanceMacro());
		macroList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
				IMacro bm = mMacroAdapter.getItem(position);
				if(bm instanceof RandomDanceMacro){
					bm = new RandomDanceMacro();
				}
				MacroManager.setTimeLine(mSelectedSecond, bm);
				Toast.makeText(getApplicationContext(), "Macro is set.", Toast.LENGTH_SHORT).show();
			}
		});
	}
	// ===========================================================
	// Methods
	// ===========================================================
	
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
