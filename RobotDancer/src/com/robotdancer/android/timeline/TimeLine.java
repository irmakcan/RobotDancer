package com.robotdancer.android.timeline;

import java.util.HashMap;

import com.robotdancer.android.robot.BodyPart;

public class TimeLine {

	// ===========================================================
	// Constants
	// ===========================================================
	
	// ===========================================================
	// Fields
	// ===========================================================
	private static TimeLine mInstance;
	
	private HashMap<BodyPart, AbstractFrameHolder> mPartHolderMap = new HashMap<BodyPart, AbstractFrameHolder>();
	
	// ===========================================================
	// Constructors
	// ===========================================================

	
	// Singleton
	private TimeLine() {

	}
	
	// ===========================================================
	// Getter & Setter
	// ===========================================================
	
	public static TimeLine getInstance(){
		if(mInstance == null){
			mInstance = new TimeLine();
		}
		return mInstance;
	}
	
	public AbstractFrameHolder getFrameHolder(BodyPart pBodyPart){
		return mPartHolderMap.get(pBodyPart);
	}
	
	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================
	
	// ===========================================================
	// Methods
	// ===========================================================
	
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
	
}