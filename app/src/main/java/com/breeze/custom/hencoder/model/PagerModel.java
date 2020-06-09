package com.breeze.custom.hencoder.model;

import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;

public class PagerModel {
    @LayoutRes
    int sampleLayoutRes;
    @StringRes
    int titleRes;
    @LayoutRes
    int practiceLayoutRes;

    public int getSampleLayoutRes() {
        return sampleLayoutRes;
    }

    public void setSampleLayoutRes(int sampleLayoutRes) {
        this.sampleLayoutRes = sampleLayoutRes;
    }

    public int getTitleRes() {
        return titleRes;
    }

    public void setTitleRes(int titleRes) {
        this.titleRes = titleRes;
    }

    public int getPracticeLayoutRes() {
        return practiceLayoutRes;
    }

    public void setPracticeLayoutRes(int practiceLayoutRes) {
        this.practiceLayoutRes = practiceLayoutRes;
    }

    public PagerModel(int sampleLayoutRes, int titleRes, int practiceLayoutRes) {
        this.sampleLayoutRes = sampleLayoutRes;
        this.titleRes = titleRes;
        this.practiceLayoutRes = practiceLayoutRes;
    }
}
