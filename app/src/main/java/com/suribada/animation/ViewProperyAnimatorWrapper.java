package com.suribada.animation;

import android.view.View;
import android.view.ViewGroup;
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
                   if (each == ViewProperty.LEFT_IN) {
                       target.setTranslationX(-target.getRight());
                        viewPropertyAnimator.translationX(0.0f);
                    } else if (each == ViewProperty.RIGHT_IN ) {
                       target.setTranslationX(getDistance(target));
                       viewPropertyAnimator.translationX(0.0f);
                   } else if (each ==ViewProperty.LEFT_OUT) {
                       target.setTranslationX(0.0f);
                       viewPropertyAnimator.translationX(-target.getRight());
                    } else if (each == ViewProperty.RIGHT_OUT) {
                        target.setTranslationX(0.0f);
                        viewPropertyAnimator.translationX(getDistance(target));
                    } else {
                        target.setTranslationX(each.from);
                        viewPropertyAnimator.translationX(each.to);
                    }
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

    private static int getDistance(View target) {
        ViewGroup parent = (ViewGroup) target.getParent();
        return  parent.getWidth() - target.getLeft();
    }

}
