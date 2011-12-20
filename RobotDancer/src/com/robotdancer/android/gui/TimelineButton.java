package com.robotdancer.android.gui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.robotdancer.android.robot.BodyPart;
import com.robotdancer.android.timeline.AbstractFrameHolder;
import com.robotdancer.android.timeline.TimeLine;

public class TimelineButton extends TextView{
	// ===========================================================
	// Constants
	// ===========================================================
	
	// ===========================================================
	// Fields
	// ===========================================================
	private Context mContext;
	private int mSec;
	private BodyPart mBodyPart;
	// ===========================================================
	// Constructors
	// ===========================================================
	public TimelineButton(Context pContext, int pSec, BodyPart pBodyPart) {
		super(pContext);
		this.mContext = pContext;
		this.mSec = pSec;
		this.mBodyPart = pBodyPart;
		OnClickListener onClickListener = null;
		switch(pBodyPart){
		case BODY: onClickListener = mBodyButtonListener; break;
		case HEAD: onClickListener = mHeadButtonListener; break;
		case RIGHT_FORE_ARM:
		case LEFT_FORE_ARM: onClickListener = mForeArmButtonListener; break;
		case LEFT_UPPER_ARM:
		case RIGHT_UPPER_ARM: onClickListener = mUpperArmButtonListener; break;
		case RIGHT_UPPER_LEG:
		case LEFT_UPPER_LEG: onClickListener = mUpperLegButtonListener; break;
		case RIGHT_FORE_LEG:
		case LEFT_FORE_LEG: onClickListener = mLowerLegButtonListener; break;
		}
		this.setOnClickListener(onClickListener);
	}
	// ===========================================================
	// Getter & Setter
	// ===========================================================
	
	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================
	
	// ===========================================================
	// Methods
	// ===========================================================
	
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
	OnClickListener mUpperArmButtonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			

			
			
			AlertDialog dialog;

			final CharSequence[] items = new CharSequence[37];
			int j = -90;
			for(int i=0;i<items.length;i++){
				items[i] = Integer.toString(j);
				j+=5;
			}
			AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
	        builder.setTitle("Upper Arm Angle at " + TimelineButton.this.mSec);
	        builder.setItems(items, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
//					fh.setAngleAt(mSec, Float.parseFloat(items[which].toString()));
					Toast.makeText(mContext, items[which], Toast.LENGTH_SHORT).show();
					final AbstractFrameHolder fh = TimeLine.getInstance().getFrameHolder(mBodyPart);
					fh.setAngleAt(mSec, Float.parseFloat(items[which].toString()));
				}
			});
	        
	        dialog=builder.create();
	        dialog.show();
		}
	};
	OnClickListener mForeArmButtonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			final AbstractFrameHolder fh = TimeLine.getInstance().getFrameHolder(mBodyPart);

			AlertDialog dialog;

			final CharSequence[] items = new CharSequence[37];
			int j = -180;
			for(int i=0;i<items.length;i++){
				items[i] = Integer.toString(j);
				j+=10;
			}
			AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
	        builder.setTitle("Fore Arm Angle at " + TimelineButton.this.mSec);
	        builder.setItems(items, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
//					fh.setAngleAt(mSec, Float.parseFloat(items[which].toString()));
					Toast.makeText(mContext, items[which], Toast.LENGTH_SHORT).show();
				}
			});
	        
	        dialog=builder.create();
	        dialog.show();
		}
	};

	OnClickListener mBodyButtonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			final AbstractFrameHolder fh = TimeLine.getInstance().getFrameHolder(mBodyPart);

			AlertDialog dialog;

			final CharSequence[] items = new CharSequence[21];
			int j = -200;
			for(int i=0;i<items.length;i++){
				items[i] = Integer.toString(j);
				j+=20;
			}
			AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
	        builder.setTitle("Body Position at " + TimelineButton.this.mSec);
	        builder.setItems(items, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
//					fh.setAngleAt(mSec, Float.parseFloat(items[which].toString()));
					Toast.makeText(mContext, items[which], Toast.LENGTH_SHORT).show();
				}
			});
	        
	        dialog=builder.create();
	        dialog.show();
		}
	};
	OnClickListener mHeadButtonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			final AbstractFrameHolder fh = TimeLine.getInstance().getFrameHolder(mBodyPart);

			AlertDialog dialog;

			final CharSequence[] items = new CharSequence[13];
			int j = -30;
			for(int i=0;i<items.length;i++){
				items[i] = Integer.toString(j);
				j+=5;
			}
			AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
	        builder.setTitle("Head Angle at " + TimelineButton.this.mSec);
	        builder.setItems(items, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
//					fh.setAngleAt(mSec, Float.parseFloat(items[which].toString()));
					Toast.makeText(mContext, items[which], Toast.LENGTH_SHORT).show();
				}
			});
	        
	        dialog=builder.create();
	        dialog.show();
		}
	};
	OnClickListener mUpperLegButtonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			final AbstractFrameHolder fh = TimeLine.getInstance().getFrameHolder(mBodyPart);

			AlertDialog dialog;

			final CharSequence[] items = new CharSequence[13];
			int j = -60;
			for(int i=0;i<items.length;i++){
				items[i] = Integer.toString(j);
				j+=10;
			}
			AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
	        builder.setTitle("Upper Leg Angle at " + TimelineButton.this.mSec);
	        builder.setItems(items, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
//					fh.setAngleAt(mSec, Float.parseFloat(items[which].toString()));
					Toast.makeText(mContext, items[which], Toast.LENGTH_SHORT).show();
				}
			});
	        
	        dialog=builder.create();
	        dialog.show();
		}
	};

	OnClickListener mLowerLegButtonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			final AbstractFrameHolder fh = TimeLine.getInstance().getFrameHolder(mBodyPart);

			AlertDialog dialog;

			final CharSequence[] items = new CharSequence[13];
			int j = -60;
			for(int i=0;i<items.length;i++){
				items[i] = Integer.toString(j);
				j+=10;
			}
			AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
	        builder.setTitle("Lower Leg Angle at " + TimelineButton.this.mSec);
	        builder.setItems(items, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
//					fh.setAngleAt(mSec, Float.parseFloat(items[which].toString()));
					Toast.makeText(mContext, items[which], Toast.LENGTH_SHORT).show();
				}
			});
	        
	        dialog=builder.create();
	        dialog.show();
		}
	};

}
