package com.robotdancer.android.timeline.macro;

import java.util.HashMap;
import java.util.Random;

import com.robotdancer.android.robot.BodyPart;

public class RandomDanceMacro extends BaseMacro implements IMacro{
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
	public RandomDanceMacro() {
		mDuration = 3;

		Random r = new Random();
		
		Float[] head = {(r.nextInt(60))-30f, (r.nextInt(60))-30f, (r.nextInt(60))-30f};
		Float[] mBodyRotation = {(r.nextInt(60))-30f, (r.nextInt(60))-30f, (r.nextInt(60))-30f};
		Float[] mBodyPosition = {new Float(0), new Float(0), new Float(0)};
		Float[] mLeftForeArm = {(r.nextInt(360))-180f, (r.nextInt(360))-180f, (r.nextInt(360))-180f};
		Float[] mLeftUpperArm = {(r.nextInt(180))-90f, (r.nextInt(180))-90f, (r.nextInt(180))-90f};
		Float[] mRightForeArm = {(r.nextInt(360))-180f, (r.nextInt(360))-180f, (r.nextInt(360))-180f};
		Float[] mRightUpperArm = {(r.nextInt(180))-90f, (r.nextInt(180))-90f, (r.nextInt(180))-90f};
		Float[] mLeftUpperLeg = {(r.nextInt(120))-60f, (r.nextInt(120))-60f, (r.nextInt(120))-60f};
		Float[] mLeftLowerLeg = {(r.nextInt(120))-60f, (r.nextInt(120))-60f, (r.nextInt(120))-60f};
		Float[] mRightUpperLeg = {(r.nextInt(120))-60f, (r.nextInt(120))-60f, (r.nextInt(120))-60f};
		Float[] mRightLowerLeg = {(r.nextInt(120))-60f, (r.nextInt(120))-60f, (r.nextInt(120))-60f};

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
		return "Random Dance (" + mDuration + " second)";
	}
	
	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
