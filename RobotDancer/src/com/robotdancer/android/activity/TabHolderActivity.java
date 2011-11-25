package com.robotdancer.android.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.robotdancer.android.R;

public class TabHolderActivity extends TabActivity{
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

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
		setContentView(R.layout.main);

		TabHost tabHost = getTabHost();
		TabHost.TabSpec spec;
		Intent intent;

		// Timeline
		intent = new Intent().setClass(this, TimeLineActivity.class);

		spec = tabHost.newTabSpec("Timeline").setIndicator("Timeline").setContent(intent);
		tabHost.addTab(spec);

		// Macro
		intent = new Intent().setClass(this, MacroSelectionActivity.class);

		spec = tabHost.newTabSpec("Macros").setIndicator("Macros").setContent(intent);
		tabHost.addTab(spec);
		
		tabHost.setCurrentTab(0);
	}
	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
