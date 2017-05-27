package com.anwesome.ui.verticalbuttongrouplist;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

/**
 * Created by anweshmishra on 27/05/17.
 */

public class AnimationController extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
    private ValueAnimator animator = ValueAnimator.ofFloat(0,1);
    private AnimationHandler animationHandler;
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if(animationHandler!=null) {
            animationHandler.update();
        }
    }
    public void onAnimationEnd(Animator animator) {
        if(animationHandler!=null) {
            animationHandler.end();
        }
    }
    public AnimationController(int duration,AnimationHandler animationHandler) {
        animator.setDuration(duration);
        animator.addUpdateListener(this);
        animator.addListener(this);
        this.animationHandler = animationHandler;

    }
    public interface AnimationHandler {
        void update();
        void end();
    }
    public void start() {
        animator.start();
    }
}
