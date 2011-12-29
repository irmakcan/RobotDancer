package com.robotdancer.android.activity;

import java.io.IOException;

import org.anddev.andengine.audio.music.Music;
import org.anddev.andengine.audio.music.MusicFactory;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.anddev.andengine.util.Debug;

import android.view.KeyEvent;

import com.robotdancer.android.robot.BodyPart;
import com.robotdancer.android.robot.Brain;
import com.robotdancer.android.robot.Component;

public class RobotDancerActivity extends BaseGameActivity {

	// ===========================================================
	// Constants
	// ===========================================================

	private static final int CAMERA_WIDTH = 800;
	private static final int CAMERA_HEIGHT = 480;

	// ===========================================================
	// Fields
	// ===========================================================
	private static int mSongIndex = 0;

	private Camera mCamera;
	private BitmapTextureAtlas mBitmapTextureAtlas;
	private TiledTextureRegion mHeadTextureRegion;
	private TiledTextureRegion mBodyTextureRegion;

	private Component mBody;

	private TiledTextureRegion mLeftUpperArmTextureRegion;
	private TiledTextureRegion mRightUpperArmTextureRegion;
	private TiledTextureRegion mLeftLowerArmTextureRegion;
	private TiledTextureRegion mRightLowerArmTextureRegion;
	private TiledTextureRegion mLeftUpperLegTextureRegion;
	private TiledTextureRegion mRightUpperLegTextureRegion;
	private TiledTextureRegion mLeftLowerLegTextureRegion;
	private TiledTextureRegion mRightLowerLegTextureRegion;

	private Music mMusic;
	private TextureRegion mStageCurtainTextureRegion;
	private TextureRegion mStageTextureRegion;

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
		return new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.mCamera).setNeedsMusic(true));
	}

	@Override
	public void onLoadResources() {
		MusicFactory.setAssetBasePath("mfx/");
		try {
			String songName = "billie_jean.ogg";
			switch(mSongIndex){
			case 0: songName = "billie_jean.ogg"; mSongIndex++; break;
			case 1: songName = "lady_gaga_alejandro.ogg"; mSongIndex++; break;
			case 2: songName = "thats_all_right.ogg"; mSongIndex++; break;
			case 3: songName = "tarkan_dudu.ogg"; mSongIndex++; break;
			case 4: songName = "wagner_the_ride_of_the_valkyries.ogg"; mSongIndex=0; break;
			}
			this.mMusic = MusicFactory.createMusicFromAsset(this.mEngine.getMusicManager(), this, songName);
			this.mMusic.setLooping(true);
		} catch (final IOException e) {
			Debug.e(e);
		}

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

		// Load Stage Curtains
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(1024, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mStageCurtainTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "theater_curtains.png", 0, 0);

		this.mEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas);

		// Load Stage Curtains
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(1024, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mStageTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "stage.png", 0, 0);

		this.mEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas);
	}

	@Override
	public Scene onLoadScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());

		final Scene scene = new Scene();
		//		scene.setBackground(new ColorBackground(0.39804f, 0.6274f, 0.8784f));
		scene.setBackground(new ColorBackground(0.0f, 0.0f, 0.0f));
		scene.setPosition(scene.getX() + (CAMERA_WIDTH/2 - 63), scene.getX());

		scene.attachChild(new Sprite(-scene.getX(), scene.getY(), this.mStageTextureRegion));



		mBody = new Component(0, 120, mBodyTextureRegion, BodyPart.BODY_ROTATE);
		mBody.setPosition(CAMERA_WIDTH/2 - mBody.getWidth()/2, 160);

		// Insert head
		Component head = new Component(mBody.getWidth()/2-mHeadTextureRegion.getWidth()/2, 
				-mHeadTextureRegion.getHeight(), 
				mHeadTextureRegion, BodyPart.HEAD);
		head.setRotationCenter(head.getWidth()/2, head.getHeight());
		mBody.attachChild(head, head.getBodyPart());

		// Insert Upper Left Arm
		Component leftUpperArm = new Component(-70, 5, mLeftUpperArmTextureRegion, BodyPart.LEFT_UPPER_ARM);
		leftUpperArm.setRotationCenter(leftUpperArm.getWidth(), 3);
		mBody.attachChild(leftUpperArm, leftUpperArm.getBodyPart());

		// Insert Upper Right Arm
		Component rightUpperArm = new Component(mBody.getWidth() - 4, 7, mRightUpperArmTextureRegion, BodyPart.RIGHT_UPPER_ARM);
		rightUpperArm.setRotationCenter(0, 3);
		mBody.attachChild(rightUpperArm, rightUpperArm.getBodyPart());

		// Insert Fore Left Arm
		Component leftLowerArm = new Component(0, leftUpperArm.getHeight() - 10, mLeftLowerArmTextureRegion, BodyPart.LEFT_FORE_ARM);
		leftLowerArm.setRotationCenter(leftLowerArm.getWidth()/2, 0);
		leftUpperArm.attachChild(leftLowerArm, leftLowerArm.getBodyPart());

		// Insert Fore Left Arm
		Component rightLowerArm = new Component(rightUpperArm.getWidth() - 34, rightUpperArm.getHeight() - 10, mRightLowerArmTextureRegion, BodyPart.RIGHT_FORE_ARM);
		rightLowerArm.setRotationCenter(rightLowerArm.getWidth()/2, 0);
		rightUpperArm.attachChild(rightLowerArm, rightLowerArm.getBodyPart());

		// Insert Upper Left Leg
		Component leftUpperLeg = new Component(16, mBody.getHeight(), mLeftUpperLegTextureRegion, BodyPart.LEFT_UPPER_LEG);
		leftUpperLeg.setRotationCenter(leftUpperLeg.getWidth()/2, 0);
		mBody.attachChild(leftUpperLeg, leftUpperLeg.getBodyPart());

		// Insert Upper Right Leg
		Component rightUpperLeg = new Component(77, mBody.getHeight(), mRightUpperLegTextureRegion, BodyPart.RIGHT_UPPER_LEG);
		rightUpperLeg.setRotationCenter(rightUpperLeg.getWidth()/2, 0);
		mBody.attachChild(rightUpperLeg, rightUpperLeg.getBodyPart());

		// Insert Lower Left Leg
		Component leftLowerLeg = new Component(0, leftUpperLeg.getHeight(), mLeftLowerLegTextureRegion, BodyPart.LEFT_FORE_LEG);
		leftLowerLeg.setRotationCenter(leftLowerLeg.getWidth()/2, 0);
		leftUpperLeg.attachChild(leftLowerLeg, leftLowerLeg.getBodyPart());

		// Insert Lower Right Leg
		Component rightLowerLeg = new Component(0, rightUpperLeg.getHeight(), mRightLowerLegTextureRegion, BodyPart.RIGHT_FORE_LEG);
		rightLowerLeg.setRotationCenter(rightLowerLeg.getWidth()/2, 0);
		rightUpperLeg.attachChild(rightLowerLeg, rightLowerLeg.getBodyPart());


		mBody.setScale(0.8f);
		scene.attachChild(mBody);
		scene.attachChild(new Sprite(-scene.getX(), scene.getY(), this.mStageCurtainTextureRegion));

		mMusic.play();
		Brain.generateSequences(mBody);

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