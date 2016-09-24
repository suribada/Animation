package com.suribada.animation;

import android.view.View;
import android.view.ViewPropertyAnimator;

/**
 * For removing redundant initialzed animation value.
 *
 * Created by horseridingking on 2016-09-25.
 */
public class ViewProperyAnimatorWrapper {

    public static ViewPropertyAnimator animate(View target, ViewProperty... viewProperties) {
        ViewPropertyAnimator viewPropertyAnimator = target.animate();
        for (ViewProperty each : viewProperties) {
            switch (each.animationType) {
                case  ALPHA:
                    target.setAlpha(each.from);
                    viewPropertyAnimator.alpha(each.to);
                    break;
                case TRANSLATION_X:
                    target.setTranslationX(each.from);
                    viewPropertyAnimator.translationX(each.to);
                    break;
                case TRANSLATION_Y:
                    target.setTranslationY(each.from);
                    viewPropertyAnimator.translationY(each.to);
                    break;
                case SCALE:
                    target.setScaleX(each.from);
                    target.setScaleY(each.from);
                    viewPropertyAnimator.scaleX(each.to);
                    viewPropertyAnimator.scaleY(each.to);
                    break;
            }
        }
        return viewPropertyAnimator;
    }

}
