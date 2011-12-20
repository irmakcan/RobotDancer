package com.robotdancer.android.robot;

import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

public class Component extends AnimatedSprite{

	// ===========================================================
	// Constants
	// ===========================================================
	
	// ===========================================================
	// Fields
	// ===========================================================
	
//	protected AnimatedSprite mAnimatedSprite;
	protected BodyPart mBodyPart;
	
	// ===========================================================
	// Constructors
	// ===========================================================
	public Component(final float pX, final float pY, final TiledTextureRegion pTiledTextureRegion, BodyPart pBodyPart) {
		super(pX, pY, pTiledTextureRegion);
		this.mBodyPart = pBodyPart;
	}
//	public Component(AnimatedSprite pAnimatedSprite, BodyPart pBodyPart) {
//		this.mAnimatedSprite = pAnimatedSprite;
//		this.mBodyPart = pBodyPart;
//	
//	}
	// ===========================================================
	// Getter & Setter
	// ===========================================================
//	public AnimatedSprite getAnimatedSprite() {
//		return mAnimatedSprite;
//	}

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
