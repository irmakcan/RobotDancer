package com.robotdancer.android.timeline;

import com.robotdancer.android.robot.BodyPart;

public class BodyFrameHolder extends AbstractFrameHolder {

	// ===========================================================
	// Constants
	// ===========================================================
	
	// ===========================================================
	// Fields
	// ===========================================================
	
	private final float[] mEntityPosition = new float[TIMELINE_LIMIT];
	
	// ===========================================================
	// Constructors
	// ===========================================================
	public BodyFrameHolder(BodyPart pBodyPart) {
		super(pBodyPart);
		for(int i=0;i<mEntityPosition.length;i++){
			mEntityPosition[i] = 0;
		}
	}
	// ===========================================================
	// Getter & Setter
	// ===========================================================
	
	public void setPositionAt(int pSecond, float pAngle){
		mEntityPosition[pSecond] = pAngle;
	}
	public float getPositioneAt(int pSecond){
		return mEntityPosition[pSecond];
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
