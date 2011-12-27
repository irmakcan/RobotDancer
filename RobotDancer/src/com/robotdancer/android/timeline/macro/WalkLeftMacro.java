package com.robotdancer.android.timeline.macro;

import java.util.HashMap;

import com.robotdancer.android.robot.BodyPart;

public class WalkLeftMacro extends BaseMacro implements IMacro{
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	private int mDuration;
	// ===========================================================
	// Constructors
	// ===========================================================
	public WalkLeftMacro() {
		mDuration = 2; // TODO

		Float[] head = {new Float(-10), new Float(0)};
		Float[] mBodyRotation = {new Float(10), new Float(0)};
		Float[] mBodyPosition = {new Float(-100), new Float(-60)};
		Float[] mLeftForeArm = {new Float(-10), new Float(0)};
		Float[] mLeftUpperArm = {new Float(-20), new Float(0)};
		Float[] mRightForeArm = {new Float(10), new Float(0)};
		Float[] mRightUpperArm = {new Float(5), new Float(0)};
		Float[] mLeftUpperLeg = {new Float(-30), new Float(0)};
		Float[] mLeftLowerLeg = {new Float(-40), new Float(0)};
		Float[] mRightUpperLeg = {new Float(30), new Float(0)};
		Float[] mRightLowerLeg = {new Float(-30), new Float(0)};

		mMacroMap.put(BodyPart.BODY_MOVE, mBodyPosition);
		mMacroMap.put(BodyPart.BODY_ROTATE, mBodyRotation);
		mMacroMap.put(BodyPart.HEAD, head);
		mMacroMap.put(BodyPart.LEFT_FORE_ARM, mLeftForeArm);
		mMacroMap.put(BodyPart.LEFT_UPPER_ARM, mLeftUpperArm);
		mMacroMap.put(BodyPart.RIGHT_FORE_ARM, mRightForeArm);
		mMacroMap.put(BodyPart.RIGHT_UPPER_ARM, mRightUpperArm);
		mMacroMap.put(BodyPart.LEFT_UPPER_LEG, mLeftUpperLeg);
		mMacroMap.put(BodyPart.LEFT_FORE_LEG, mLeftLowerLeg);
		mMacroMap.put(BodyPart.RIGHT_UPPER_LEG, mRightUpperLeg);
		mMacroMap.put(BodyPart.RIGHT_FORE_LEG, mRightLowerLeg);
		
		
	}
	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================
	@Override
	public HashMap<BodyPart, Float[]> getMacro() {
		return mMacroMap;
	}
	@Override
	public int getDuration() {
		return mDuration;
	}
	
	@Override
	public String toString() {
		return "Walk Left (" + mDuration + " second)";
	}
	
	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}

