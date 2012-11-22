package com.example.viewflipperexample;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

public class ViewFlipperActivity extends Activity implements OnClickListener{

	private Animation inAnimRight, outAnimLeft, inAnimLeft, outAnimRight;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_flipper);
		init();
	}

	private void init() {
		inAnimRight = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.slide_in_right);
		outAnimLeft = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.slide_out_left);
		inAnimLeft = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.slide_in_left);
		outAnimRight = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.slide_out_right);

		Button prev = (Button) findViewById(R.id.previous);
		prev.setOnClickListener(this);
		Button next = (Button) findViewById(R.id.next);
		next.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);
		switch (v.getId()) {
		case R.id.previous:
			viewFlipper.setInAnimation(inAnimLeft);
			viewFlipper.setOutAnimation(outAnimRight);
			if (viewFlipper.getDisplayedChild() > 0)
				viewFlipper.showPrevious();
			break;

		case R.id.next:
			viewFlipper.setInAnimation(inAnimRight);
			viewFlipper.setOutAnimation(outAnimLeft);
			if (viewFlipper.getDisplayedChild() < (viewFlipper.getChildCount() - 1))
				viewFlipper.showNext();
			break;
		}
	}
}