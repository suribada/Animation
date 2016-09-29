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

    public static ViewPropertyAnimator animate(View target, ViewPropertyAnim... viewProperties) {
        ViewPropertyAnimator viewPropertyAnimator = target.animate();
        for (ViewPropertyAnim each : viewProperties) {
            switch (each.animationType) {
                case  ALPHA:
                    target.setAlpha(each.from);
                    viewPropertyAnimator.alpha(each.to);
                    break;
                case TRANSLATION_X:
                   if (each == ViewPropertyAnim.LEFT_IN) {
                       target.setTranslationX(-target.getRight());
                        viewPropertyAnimator.translationX(0.0f);
                    } else if (each == ViewPropertyAnim.RIGHT_IN ) {
                       target.setTranslationX(getDistanceX(target));
                       viewPropertyAnimator.translationX(0.0f);
                   } else if (each == ViewPropertyAnim.LEFT_OUT) {
                       target.setTranslationX(0.0f);
                       viewPropertyAnimator.translationX(-target.getRight());
                    } else if (each == ViewPropertyAnim.RIGHT_OUT) {
                        target.setTranslationX(0.0f);
                        viewPropertyAnimator.translationX(getDistanceX(target));
                    } else {
                        target.setTranslationX(each.from);
                        viewPropertyAnimator.translationX(each.to);
                    }
                    break;
                case TRANSLATION_Y:
					if (each == ViewPropertyAnim.UP_IN) {
						target.setTranslationY(-target.getBottom());
						viewPropertyAnimator.translationY(0.0f);
					} else if (each == ViewPropertyAnim.DOWN_IN ) {
						target.setTranslationY(getDistanceY(target));
						viewPropertyAnimator.translationY(0.0f);
					} else if (each == ViewPropertyAnim.UP_OUT) {
						target.setTranslationY(0.0f);
						viewPropertyAnimator.translationY(-target.getBottom());
					} else if (each == ViewPropertyAnim.DOWN_OUT) {
						target.setTranslationY(0.0f);
						viewPropertyAnimator.translationY(getDistanceY(target));
					} else {
						target.setTranslationY(each.from);
						viewPropertyAnimator.translationY(each.to);
					}
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

    private static int getDistanceX(View target) {
        ViewGroup parent = (ViewGroup) target.getParent();
        return  parent.getWidth() - target.getLeft();
    }

	private static int getDistanceY(View target) {
        ViewGroup parent = (ViewGroup) target.getParent();
        return  parent.getHeight() - target.getTop();
    }

}
