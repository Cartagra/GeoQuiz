package com.bignerdranch.android.geoquiz;

import java.io.Serializable;

public class Question implements Serializable {
    private int mTextResId;
    private boolean mAnswerTrue;
    private boolean mCheater;

    public Question(int textResId, boolean answerTrue) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
        mCheater = false;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isCheater() {
        return mCheater;
    }

    public void setCheater(boolean cheater) {
        mCheater = cheater;
    }
}
