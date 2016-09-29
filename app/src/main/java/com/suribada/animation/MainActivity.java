package com.suribada.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.suribada.animation.ViewPropertyAnim.AnimationType;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private View target;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        target = findViewById(R.id.target);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        ViewProperyAnimatorWrapper.animate(target, ViewPropertyAnim.LEFT_IN).setDuration(1500);
                        break;
                    case 1:
                        ViewProperyAnimatorWrapper.animate(target, ViewPropertyAnim.RIGHT_IN).setDuration(1500);
                        break;
                    case 2:
                        ViewProperyAnimatorWrapper.animate(target, ViewPropertyAnim.LEFT_OUT).setDuration(1500);
                        break;
                    case 3:
                        ViewProperyAnimatorWrapper.animate(target, ViewPropertyAnim.RIGHT_OUT).setDuration(1500);
                        break;
					case 4:
						ViewProperyAnimatorWrapper.animate(target, ViewPropertyAnim.UP_IN).setDuration(1500);
						break;
					case 5:
						ViewProperyAnimatorWrapper.animate(target, ViewPropertyAnim.DOWN_IN).setDuration(1500);
						break;
					case 6:
						ViewProperyAnimatorWrapper.animate(target, ViewPropertyAnim.UP_OUT).setDuration(1500);
						break;
					case 7:
						ViewProperyAnimatorWrapper.animate(target, ViewPropertyAnim.DOWN_OUT).setDuration(1500);
						break;
                    case 8:
                        ViewProperyAnimatorWrapper.animate(target, ViewPropertyAnim.GROW).setDuration(1500);
                        break;
                    case 9:
                        ViewProperyAnimatorWrapper.animate(target, ViewPropertyAnim.SHRINK).setDuration(1500);
                        break;
                    case 10:
                        ViewProperyAnimatorWrapper.animate(target, ViewPropertyAnim.TRANSPARENT).setDuration(1500);
                        break;
                    case 11:
                        ViewProperyAnimatorWrapper.animate(target, ViewPropertyAnim.OPAQUE).setDuration(1500);
                        break;
                    case 12:
                        ViewProperyAnimatorWrapper.animate(target, ViewPropertyAnim.LEFT_IN, ViewPropertyAnim.OPAQUE).setDuration(1500);
                        break;
                    case 13:
                        ViewProperyAnimatorWrapper.animate(target, ViewPropertyAnim.of(AnimationType.ALPHA).from(0.5f).to(1.0f)).setDuration(1500);
                        break;
                    case 14:
                        target.animate().translationX(100).setDuration(1500);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

}
