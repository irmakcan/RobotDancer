package com.robotdancer.android.robot;

public enum BodyPart{
	// ===========================================================
	// Elements
	// ===========================================================
	
	LEFT_UPPER_ARM("Left Upper Arm"), LEFT_FORE_ARM("Left Fore Arm"), 
	RIGHT_UPPER_ARM("Right Upper Arm"), RIGHT_FORE_ARM("Right Fore Arm"),
	LEFT_UPPER_LEG("Left Upper Leg"), LEFT_FORE_LEG("Left Fore Leg"),
	RIGHT_UPPER_LEG("Right Upper Leg"), RIGHT_FORE_LEG("Right Fore Leg"),
	HEAD("Head"), BODY_ROTATE("Body Rotate"), BODY_MOVE("Body Position");
	
	// ===========================================================
	// Constants
	// ===========================================================
	
	// ===========================================================
	// Fields
	// ===========================================================
	final private String mTitle;
	// ===========================================================
	// Constructors
	// ===========================================================
	private BodyPart(String pTitle) {
		this.mTitle = pTitle;
	}
	// ===========================================================
	// Getter & Setter
	// ===========================================================
	
	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================
	@Override
	public String toString() {
		return this.mTitle;
	}
	// ===========================================================
	// Methods
	// ===========================================================
	
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
	
}
