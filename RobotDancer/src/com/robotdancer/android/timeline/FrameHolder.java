package com.robotdancer.android.timeline;

import android.widget.TextView;

import com.robotdancer.android.activity.TimeLineActivity;
import com.robotdancer.android.robot.BodyPart;

public class FrameHolder extends AbstractFrameHolder {

	public FrameHolder(BodyPart pBodyPart) {
		super(pBodyPart);
	}

	@Override
	public void setAngleAt(int pSecond, float pAngle) {
		super.setAngleAt(pSecond, pAngle);
		
		TextView b = TimeLineActivity.getButtonMap().get(getBodyPart()).get(pSecond);
		b.setText(Integer.toString((int)pAngle));
		
	}
}
