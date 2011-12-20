package com.robotdancer.android.timeline;

import android.widget.Button;

import com.robotdancer.android.activity.TimeLineActivity;
import com.robotdancer.android.robot.BodyPart;

public class FrameHolder extends AbstractFrameHolder {

	public FrameHolder(BodyPart pBodyPart) {
		super(pBodyPart);
	}

	@Override
	public void setAngleAt(int pSecond, float pAngle) {
		super.setAngleAt(pSecond, pAngle);
		Button b = TimeLineActivity.getButtonMap().get(getBodyPart()).get(pSecond);
		b.setText(Float.toString(pAngle));
	}
}
