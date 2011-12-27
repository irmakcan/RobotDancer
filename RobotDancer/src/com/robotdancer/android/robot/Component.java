package com.robotdancer.android.robot;

import java.util.HashMap;

import org.anddev.andengine.entity.IEntity;
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
	protected HashMap<BodyPart, IEntity> mChildMap = new HashMap<BodyPart, IEntity>(); 
	
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
	public void attachChild(IEntity pEntity, BodyPart pBodyPart){
		this.attachChild(pEntity);
		this.mChildMap.put(pBodyPart, pEntity);
	}
	
	public void detachChild(IEntity pEntity, BodyPart pBodyPart){
		this.detachChild(pEntity);
		this.mChildMap.remove(pBodyPart);
	}
	
	public HashMap<BodyPart, IEntity> getChildMap(){
		return this.mChildMap;
	}
	
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
