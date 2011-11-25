package com.robotdancer.android.robot;

import org.anddev.andengine.entity.sprite.AnimatedSprite;

public abstract class Component {

	// ===========================================================
	// Constants
	// ===========================================================
	
	// ===========================================================
	// Fields
	// ===========================================================
	
	protected AnimatedSprite mAnimatedSprite;
	protected BodyPart mBodyPart;
	
	// ===========================================================
	// Constructors
	// ===========================================================
	public Component(AnimatedSprite pAnimatedSprite, BodyPart pBodyPart) {
		this.mAnimatedSprite = pAnimatedSprite;
		this.mBodyPart = pBodyPart;
	
	}
	// ===========================================================
	// Getter & Setter
	// ===========================================================
	public AnimatedSprite getAnimatedSprite() {
		return mAnimatedSprite;
	}

	public BodyPart getBodyPart() {
		return mBodyPart;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================
	
	// ===========================================================
	// Methods
	// ===========================================================
//	public void rotate(float pAngle){
//		mAnimatedSprite.
//	}
	
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
	

	
}
