package com.robotdancer.android.timeline;

import com.robotdancer.android.robot.BodyPart;

public abstract class AbstractFrameHolder {

	// ===========================================================
	// Constants
	// ===========================================================
	
	protected static final int TIMELINE_LIMIT = 30; 
	
	// ===========================================================
	// Fields
	// ===========================================================

	private final float[] mEntityAngle = new float[TIMELINE_LIMIT];

	private final BodyPart mBodyPart;
	
	// ===========================================================
	// Constructors
	// ===========================================================

	public AbstractFrameHolder(BodyPart pBodyPart) {
		this.mBodyPart = pBodyPart;
		for(int i=0;i<mEntityAngle.length;i++){
			mEntityAngle[i] = 0;
		}
	}
	
	// ===========================================================
	// Getter & Setter
	// ===========================================================
	
	public void setAngleAt(int pSecond, float pAngle){
		mEntityAngle[pSecond] = pAngle;
	}
	public float getAngleAt(int pSecond){
		return mEntityAngle[pSecond];
	}
	
	public BodyPart getmBodyPart() {
		return mBodyPart;
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
