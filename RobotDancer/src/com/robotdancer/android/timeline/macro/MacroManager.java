package com.robotdancer.android.timeline.macro;

import com.robotdancer.android.robot.BodyPart;
import com.robotdancer.android.timeline.AbstractFrameHolder;
import com.robotdancer.android.timeline.BodyFrameHolder;
import com.robotdancer.android.timeline.TimeLine;

public class MacroManager {
	// ===========================================================
	// Constants
	// ===========================================================
	
	// ===========================================================
	// Fields
	// ===========================================================
	
	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================
	
	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================
	
	// ===========================================================
	// Methods
	// ===========================================================
	public static void setTimeLine(final int pSec, final IMacro pIMacro){
		for(BodyPart bp:BodyPart.values()){
			AbstractFrameHolder fh = TimeLine.getInstance().getFrameHolder(bp);
			Float[] f = pIMacro.getMacro().get(bp);
			for(int i=0;i < pIMacro.getDuration();i++){
				fh.setAngleAt(pSec+i, f[i]);
			}
			TimeLine.getInstance().setFrameHolder(bp, fh);
			if(bp == BodyPart.BODY_MOVE){
				BodyFrameHolder bfh = (BodyFrameHolder)TimeLine.getInstance().getFrameHolder(bp);
				Float[] fl = pIMacro.getMacro().get(bp);
				for(int i=0;i < pIMacro.getDuration();i++){
					bfh.setPositionAt(pSec+i, fl[i]);
				}
				TimeLine.getInstance().setFrameHolder(bp, bfh);
			}
			
		}
	}
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
