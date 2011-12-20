package com.robotdancer.android.activity;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.entity.modifier.ParallelEntityModifier;
import org.anddev.andengine.entity.modifier.RotationByModifier;
import org.anddev.andengine.entity.modifier.RotationModifier;
import org.anddev.andengine.entity.modifier.ScaleModifier;
import org.anddev.andengine.entity.modifier.SequenceEntityModifier;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.anddev.andengine.util.modifier.IModifier;

import android.view.KeyEvent;
import android.widget.Toast;

import com.robotdancer.android.robot.BodyPart;
import com.robotdancer.android.robot.Component;

public class RobotDancerActivity extends BaseGameActivity {

	// ===========================================================
	// Constants
	// ===========================================================

	private static final int CAMERA_WIDTH = 720;
	private static final int CAMERA_HEIGHT = 480;

	// ===========================================================
	// Fields
	// ===========================================================

	private Camera mCamera;
	private BitmapTextureAtlas mBitmapTextureAtlas;
//	private TiledTextureRegion mFaceTextureRegion;
	private TiledTextureRegion mHeadTextureRegion;
	private TiledTextureRegion mBodyTextureRegion;
	
	Component mBody; // TODO
	
	private TiledTextureRegion mLeftUpperArmTextureRegion;
	private TiledTextureRegion mRightUpperArmTextureRegion;
	private TiledTextureRegion mLeftLowerArmTextureRegion;
	private TiledTextureRegion mRightLowerArmTextureRegion;
	private TiledTextureRegion mLeftUpperLegTextureRegion;
	private TiledTextureRegion mRightUpperLegTextureRegion;
	private TiledTextureRegion mLeftLowerLegTextureRegion;
	private TiledTextureRegion mRightLowerLegTextureRegion;

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public Engine onLoadEngine() {
		this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.mCamera));
	}

	@Override
	public void onLoadResources() {
		// Load Head
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(128, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		this.mHeadTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this, "kafa.png", 0, 0, 1, 1);

		this.mEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas);
		// Load Body
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(128, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mBodyTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this, "robot_body.png", 0, 0, 1, 1);

		this.mEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas);
		
		//Load Left Upper Arm
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(128, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mLeftUpperArmTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this, "left_upper_arm.png", 0, 0, 1, 1);

		this.mEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas);
		
		//Load Right Upper Arm
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(128, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mRightUpperArmTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this, "right_upper_arm.png", 0, 0, 1, 1);
		this.mEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas);
		
		//Load Left Lower Arm
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(64, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mLeftLowerArmTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this, "lower_arm.png", 0, 0, 1, 1);

		this.mEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas);
		
		//Load Right Lower Arm
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(64, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mRightLowerArmTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this, "lower_arm.png", 0, 0, 1, 1);
		this.mEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas);
		
		//Load Left Upper Leg
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(64, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mLeftUpperLegTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this, "upper_leg.png", 0, 0, 1, 1);

		this.mEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas);
		//Load Right Upper Leg
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(64, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mRightUpperLegTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this, "upper_leg.png", 0, 0, 1, 1);

		this.mEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas);
		//Load Left Lower Leg
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(64, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mLeftLowerLegTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this, "lower_leg.png", 0, 0, 1, 1);
		this.mEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas);
		
		//Load Right Lower Leg
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(64, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mRightLowerLegTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this, "lower_leg.png", 0, 0, 1, 1);

		this.mEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas);
	}

	@Override
	public Scene onLoadScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());

		final Scene scene = new Scene();
		scene.setBackground(new ColorBackground(0.39804f, 0.6274f, 0.8784f));

		
		mBody = new Component(100, 120, mBodyTextureRegion, BodyPart.BODY);
		
		// Insert head
		Component head = new Component(mBody.getWidth()/2-mHeadTextureRegion.getWidth()/2, 
				-mHeadTextureRegion.getHeight(), 
				mHeadTextureRegion, BodyPart.HEAD);
		head.setRotationCenter(head.getWidth()/2, head.getHeight());
		mBody.attachChild(head);
		
		// Insert Upper Left Arm
		Component leftUpperArm = new Component(-70, 5, mLeftUpperArmTextureRegion, BodyPart.LEFT_UPPER_ARM);
		leftUpperArm.setRotationCenter(leftUpperArm.getWidth(), 3);
		mBody.attachChild(leftUpperArm);
		
		// Insert Upper Right Arm
		Component rightUpperArm = new Component(mBody.getWidth() - 4, 7, mRightUpperArmTextureRegion, BodyPart.RIGHT_UPPER_ARM);
		rightUpperArm.setRotationCenter(0, 3);
		mBody.attachChild(rightUpperArm);
		
		// Insert Fore Left Arm
		Component leftLowerArm = new Component(0, leftUpperArm.getHeight() - 10, mLeftLowerArmTextureRegion, BodyPart.LEFT_FORE_ARM);
		leftLowerArm.setRotationCenter(leftLowerArm.getWidth()/2, 0);
		leftUpperArm.attachChild(leftLowerArm);
		
		// TODO Insert Fore Left Arm
		Component rightLowerArm = new Component(rightUpperArm.getWidth() - 34, rightUpperArm.getHeight() - 10, mRightLowerArmTextureRegion, BodyPart.RIGHT_FORE_ARM);
		rightLowerArm.setRotationCenter(rightLowerArm.getWidth()/2, 0);
		rightUpperArm.attachChild(rightLowerArm);
		
		// Insert Upper Left Leg
		Component leftUpperLeg = new Component(16, mBody.getHeight(), mLeftUpperLegTextureRegion, BodyPart.LEFT_UPPER_LEG);
		leftUpperLeg.setRotationCenter(leftUpperLeg.getWidth()/2, 0);
		mBody.attachChild(leftUpperLeg);
		
		// Insert Upper Right Leg TODO
		Component rightUpperLeg = new Component(77, mBody.getHeight(), mRightUpperLegTextureRegion, BodyPart.RIGHT_UPPER_LEG);
		rightUpperLeg.setRotationCenter(rightUpperLeg.getWidth()/2, 0);
		mBody.attachChild(rightUpperLeg);
		
		// Insert Lower Left Leg
		Component leftLowerLeg = new Component(0, leftUpperLeg.getHeight(), mLeftLowerLegTextureRegion, BodyPart.LEFT_FORE_LEG);
		leftLowerLeg.setRotationCenter(leftLowerLeg.getWidth()/2, 0);
		leftUpperLeg.attachChild(leftLowerLeg);
		
		// Insert Lower Right Leg
		Component rightLowerLeg = new Component(0, rightUpperLeg.getHeight(), mRightLowerLegTextureRegion, BodyPart.RIGHT_FORE_LEG);
		rightLowerLeg.setRotationCenter(rightLowerLeg.getWidth()/2, 0);
		rightUpperLeg.attachChild(rightLowerLeg);
		
		scene.attachChild(mBody);
//		final AnimatedSprite kafa1 = new AnimatedSprite(30, 30, mKafaTextureRegion);
		
//		final SequenceEntityModifier entitiyModifer1 = new SequenceEntityModifier(
//			new RotationModifier(10, kafa1.getRotation(), 3600)
//		);
//		kafa1.registerEntityModifier(entitiyModifer1);
//		scene.attachChild(kafa1);
		
//		final AnimatedSprite face1 = new AnimatedSprite(centerX - 100, centerY, this.mFaceTextureRegion);
//		face1.setRotationCenter(0, 0);
//		face1.setScaleCenter(0, 0);
//		face1.animate(100);
//
//		final AnimatedSprite face2 = new AnimatedSprite(centerX + 100, centerY, this.mFaceTextureRegion);
//		face2.animate(100);

		
		final SequenceEntityModifier entityModifier = new SequenceEntityModifier(
				new IEntityModifierListener() {
					@Override
					public void onModifierStarted(final IModifier<IEntity> pModifier, final IEntity pItem) {
						RobotDancerActivity.this.runOnUiThread(new Runnable() {
							@Override
							public void run() {
								Toast.makeText(RobotDancerActivity.this, "Sequence started.", Toast.LENGTH_LONG).show();
							}
						});
					}

					@Override
					public void onModifierFinished(final IModifier<IEntity> pEntityModifier, final IEntity pEntity) {
						RobotDancerActivity.this.runOnUiThread(new Runnable() {
							@Override
							public void run() {
								Toast.makeText(RobotDancerActivity.this, "Sequence finished.", Toast.LENGTH_LONG).show();
							}
						});
					}
				},
//				new ScaleModifier(2, 1.0f, 0.75f, 1.0f, 2.0f),
//				new ScaleModifier(2, 0.75f, 2.0f, 3.0f, 1.25f),
//				new ParallelEntityModifier(
//						new ScaleModifier(3, 2.0f, 5.0f, 1.25f, 5.0f),
//						new RotationByModifier(3, 180)
//				),
//				new ParallelEntityModifier(
//						new ScaleModifier(3, 5, 1),
//						new RotationModifier(3, 180, 0)
//				)
				new RotationModifier(8, 0, 3000)
		);
		final SequenceEntityModifier entityModifier2 = new SequenceEntityModifier(new RotationModifier(6, 0, 3000));
		rightUpperArm.registerEntityModifier(entityModifier2);
		
		rightLowerArm.registerEntityModifier(entityModifier);
		
		final SequenceEntityModifier entityModifier3 = new SequenceEntityModifier(
				new RotationModifier(1, 0, 30),
				new RotationModifier(1, 0, -30),
				new RotationModifier(1, 0, 30),
				new RotationModifier(1, 0, -30),
				new RotationModifier(1, 0, 30),
				new RotationModifier(1, 0, -30),
				new RotationModifier(1, 0, 30),
				new RotationModifier(1, 0, -30)
		);
		
		rightUpperLeg.registerEntityModifier(entityModifier3);
//		face1.registerEntityModifier(entityModifier);
//		face2.registerEntityModifier(entityModifier.deepCopy());

//		scene.attachChild(face1);
//		scene.attachChild(face2);

		/* Create some not-modified sprites, that act as fixed references to the modified ones. */
//		final AnimatedSprite face1Reference = new AnimatedSprite(centerX - 100, centerY, this.mFaceTextureRegion);
//		final AnimatedSprite face2Reference = new AnimatedSprite(centerX + 100, centerY, this.mFaceTextureRegion);
//
//		scene.attachChild(face1Reference);
//		scene.attachChild(face2Reference);

		return scene;
	}

	@Override
	public void onLoadComplete() {

	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(KeyEvent.KEYCODE_MENU == keyCode){
			mBody.setPosition(mBody.getX() + 5, mBody.getY());
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}