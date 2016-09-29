package com.suribada.animation;

/**
 * Created by horseridingking on 2016-09-25.
 */
public class ViewPropertyAnim {

	public static ViewPropertyAnim LEFT_IN = new ViewPropertyAnim(AnimationType.TRANSLATION_X);
	public static ViewPropertyAnim RIGHT_IN = new ViewPropertyAnim(AnimationType.TRANSLATION_X);
	public static ViewPropertyAnim LEFT_OUT = new ViewPropertyAnim(AnimationType.TRANSLATION_X);
	public static ViewPropertyAnim RIGHT_OUT = new ViewPropertyAnim(AnimationType.TRANSLATION_X);
	public static ViewPropertyAnim UP_IN = new ViewPropertyAnim(AnimationType.TRANSLATION_Y);
	public static ViewPropertyAnim DOWN_IN = new ViewPropertyAnim(AnimationType.TRANSLATION_Y);
	public static ViewPropertyAnim UP_OUT = new ViewPropertyAnim(AnimationType.TRANSLATION_Y);
	public static ViewPropertyAnim DOWN_OUT = new ViewPropertyAnim(AnimationType.TRANSLATION_Y);
    public static ViewPropertyAnim GROW = new ViewPropertyAnim(AnimationType.SCALE, 0.0f, 1.0f);
    public static ViewPropertyAnim SHRINK = new ViewPropertyAnim(AnimationType.SCALE, 1.0f, 0.0f);
    public static ViewPropertyAnim TRANSPARENT = new ViewPropertyAnim(AnimationType.ALPHA, 1.0f, 0.0f);
    public static ViewPropertyAnim OPAQUE = new ViewPropertyAnim(AnimationType.ALPHA, 0.0f, 1.0f);

    enum AnimationType {
        TRANSLATION_X, TRANSLATION_Y, SCALE, ALPHA, ROTATE
    }

    AnimationType animationType;
    float from;
    float to;

    private ViewPropertyAnim(AnimationType animationType, float from, float to) {
        this.animationType = animationType;
        this.from = from;
        this.to = to;
    }

    private ViewPropertyAnim(AnimationType animationType) {
        this.animationType = animationType;
    }

    static ViewPropertyAnim of(AnimationType animationType) {
        return new ViewPropertyAnim(animationType);
    }

    public ViewPropertyAnim from(float from) {
        this.from = from;
        return this;
    }

    public ViewPropertyAnim to(float to) {
        this.to = to;
        return this;
    }

}
