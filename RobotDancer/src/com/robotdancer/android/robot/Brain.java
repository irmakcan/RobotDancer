package com.robotdancer.android.robot;

import java.util.HashMap;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier;
import org.anddev.andengine.entity.modifier.MoveXModifier;
import org.anddev.andengine.entity.modifier.ParallelEntityModifier;
import org.anddev.andengine.entity.modifier.RotationModifier;
import org.anddev.andengine.entity.modifier.SequenceEntityModifier;

import com.robotdancer.android.activity.TimeLineActivity;
import com.robotdancer.android.timeline.AbstractFrameHolder;
import com.robotdancer.android.timeline.BodyFrameHolder;
import com.robotdancer.android.timeline.TimeLine;

public class Brain {
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
	public static void generateSequences(Component pComponent){
		if(pComponent.getBodyPart() == BodyPart.BODY_ROTATE){
			BodyFrameHolder bfh = (BodyFrameHolder)TimeLine.getInstance().getFrameHolder(BodyPart.BODY_MOVE);
			IEntityModifier[] bodyModifierList = new IEntityModifier[TimeLineActivity.MAX_TIMELINE];
			float fromPosition = 0;
			float toPosition = 0;
			for(int i=0;i<TimeLineActivity.MAX_TIMELINE;i++){
				toPosition += bfh.getPositioneAt(i);
				bodyModifierList[i] = new MoveXModifier(1, fromPosition, toPosition);
				fromPosition = toPosition;
			}
			
			AbstractFrameHolder fh = TimeLine.getInstance().getFrameHolder(pComponent.getBodyPart());
			IEntityModifier[] modifierList = new IEntityModifier[TimeLineActivity.MAX_TIMELINE];
			float fromRotation = 0;
			for(int i=0;i<TimeLineActivity.MAX_TIMELINE;i++){
				modifierList[i] = new RotationModifier(1, fromRotation, fh.getAngleAt(i));
				fromRotation = fh.getAngleAt(i);
			}
			// Register modifiers
			pComponent.registerEntityModifier(new ParallelEntityModifier(
					new SequenceEntityModifier(modifierList),
					new SequenceEntityModifier(bodyModifierList)
					)
			);
			
			
			
		}else{
			AbstractFrameHolder fh = TimeLine.getInstance().getFrameHolder(pComponent.getBodyPart());
			IEntityModifier[] modifierList = new IEntityModifier[TimeLineActivity.MAX_TIMELINE];
			float fromRotation = 0;
			for(int i=0;i<TimeLineActivity.MAX_TIMELINE;i++){
				modifierList[i] = new RotationModifier(1, fromRotation, fh.getAngleAt(i));
				fromRotation = fh.getAngleAt(i);
			}
			// Register modifiers
			pComponent.registerEntityModifier(new SequenceEntityModifier(modifierList));
		}
		
		
		
		HashMap<BodyPart, IEntity> map = pComponent.getChildMap();
		
		for(IEntity entity:map.values()){
			Brain.generateSequences((Component) entity);
		}
		
		
	}
	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================
	
	// ===========================================================
	// Methods
	// ===========================================================
	
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
