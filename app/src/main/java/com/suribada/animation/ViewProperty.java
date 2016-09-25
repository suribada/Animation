package com.suribada.animation;

/**
 * Created by horseridingking on 2016-09-25.
 */
public class ViewProperty {

    public static ViewProperty RIGHT_IN = new ViewProperty(AnimationType.TRANSLATION_X);
    public static ViewProperty LEFT_IN = new ViewProperty(AnimationType.TRANSLATION_X);
    public static ViewProperty RIGHT_OUT = new ViewProperty(AnimationType.TRANSLATION_X);
    public static ViewProperty LEFT_OUT = new ViewProperty(AnimationType.TRANSLATION_X);
    public static ViewProperty GROW = new ViewProperty(AnimationType.SCALE, 0.0f, 1.0f);
    public static ViewProperty SHRINK = new ViewProperty(AnimationType.SCALE, 1.0f, 0.0f);
    public static ViewProperty TRANSPARENT = new ViewProperty(AnimationType.ALPHA, 1.0f, 0.0f);
    public static ViewProperty OPAQUE = new ViewProperty(AnimationType.ALPHA, 0.0f, 1.0f);

    enum AnimationType {
        TRANSLATION_X, TRANSLATION_Y, SCALE, ALPHA, ROTATE
    }

    AnimationType animationType;
    float from;
    float to;

    private ViewProperty(AnimationType animationType, float from, float to) {
        this.animationType = animationType;
        this.from = from;
        this.to = to;
    }

    private ViewProperty(AnimationType animationType) {
        this.animationType = animationType;
    }

    static ViewProperty of(AnimationType animationType) {
        return new ViewProperty(animationType);
    }

    public ViewProperty from(float from) {
        this.from = from;
        return this;
    }

    public ViewProperty to(float to) {
        this.to = to;
        return this;
    }

}
