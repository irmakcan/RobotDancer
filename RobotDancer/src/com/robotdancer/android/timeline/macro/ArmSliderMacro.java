package com.robotdancer.android.timeline.macro;

import java.util.HashMap;

import com.robotdancer.android.robot.BodyPart;
import com.robotdancer.android.timeline.AbstractFrameHolder;
import com.robotdancer.android.timeline.BodyFrameHolder;
import com.robotdancer.android.timeline.FrameHolder;

public class ArmSliderMacro extends BaseMacro implements IMacro {
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
	public ArmSliderMacro() {
		mDuration = 1; // TODO

		Float[] head = {new Float(30)};
		Float[] mBodyRotation = {new Float(20)};
		Float[] mBodyPosition = {new Float(20)};
		Float[] mLeftForeArm = {new Float(100)};
		Float[] mLeftUpperArm = {new Float(100)};
		Float[] mRightForeArm = {new Float(100)};
		Float[] mRightUpperArm = {new Float(100)};
		Float[] mLeftUpperLeg = {new Float(100)};
		Float[] mLeftLowerLeg = {new Float(0)};
		Float[] mRightUpperLeg = {new Float(0)};
		Float[] mRightLowerLeg = {new Float(0)};

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
		return "Arm Slider (" + mDuration + " second)";
	}
	
	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
