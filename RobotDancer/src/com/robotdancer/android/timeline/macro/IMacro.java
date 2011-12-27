package com.robotdancer.android.timeline.macro;

import java.util.HashMap;

import com.robotdancer.android.robot.BodyPart;
import com.robotdancer.android.timeline.AbstractFrameHolder;

public interface IMacro {
	// ===========================================================
	// Final Fields
	// ===========================================================
	
	// ===========================================================
	// Methods
	// ===========================================================
	public HashMap<BodyPart, Float[]> getMacro();
	public int getDuration();
}
