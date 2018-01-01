package com.example.android.miwok;

/**
 * Created by neo on 31/12/2017.
 */

public class Word {
    private String mDefaultTranslation;
    private String mMiwokiTranslation;

    public Word(String miwoki_translation, String default_translation) {
        mDefaultTranslation = default_translation;
        mMiwokiTranslation = miwoki_translation;
    }

    public String getMiwoki() {
        return mMiwokiTranslation;
    }

    public String getDefault() {
        return mDefaultTranslation;
    }
}
