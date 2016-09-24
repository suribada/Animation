package com.suribada.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.suribada.animation.ViewProperty.AnimationType;

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
                        ViewProperyAnimatorWrapper.animate(target, ViewProperty.LEFT_TO_RIGHT).setDuration(1500);
                        break;
                    case 1:
                        ViewProperyAnimatorWrapper.animate(target, ViewProperty.RIGTH_TO_LEFT).setDuration(1500);
                        break;
                    case 2:
                        ViewProperyAnimatorWrapper.animate(target, ViewProperty.GROW).setDuration(1500);
                        break;
                    case 3:
                        ViewProperyAnimatorWrapper.animate(target, ViewProperty.SHRINK).setDuration(1500);
                        break;
                    case 4:
                        ViewProperyAnimatorWrapper.animate(target, ViewProperty.TRANSPARENT).setDuration(1500);
                        break;
                    case 5:
                        ViewProperyAnimatorWrapper.animate(target, ViewProperty.OPAQUE).setDuration(1500);
                        break;
                    case 6:
                        ViewProperyAnimatorWrapper.animate(target, ViewProperty.LEFT_TO_RIGHT, ViewProperty.OPAQUE).setDuration(1500);
                        break;
                    case 7:
                        ViewProperyAnimatorWrapper.animate(target, ViewProperty.of(AnimationType.ALPHA).from(0.5f).to(1.0f)).setDuration(1500);
                        break;
                    case 8:
                        target.animate().translationX(2.0f).setDuration(1500);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

}
