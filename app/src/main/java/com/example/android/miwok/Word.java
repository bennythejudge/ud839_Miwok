package com.example.android.miwok;

/**
 * Created by neo on 31/12/2017.
 */

public class Word {
    private String mDefaultTranslation;
    private String mMiwokiTranslation;
    private int mWordImageId = -1;
    private int mWordSoundId = -1;

    // here we have two constructors
    // one takes 2 arguments when the image is not needed
    // the second takes 3 arguments, including the image id
    // constructor overloading!!
    public Word(String miwoki_translation, String default_translation) {
        mDefaultTranslation = default_translation;
        mMiwokiTranslation = miwoki_translation;
    }

    public Word(String miwoki_translation, String default_translation, int drawableId) {
        mDefaultTranslation = default_translation;
        mMiwokiTranslation = miwoki_translation;
        mWordImageId = drawableId;
    }

    public Word(String miwoki_translation, String default_translation, int drawableId, int soundId) {
        mDefaultTranslation = default_translation;
        mMiwokiTranslation = miwoki_translation;
        mWordImageId = drawableId;
        mWordSoundId = soundId;
    }

    public String getMiwoki() {
        return mMiwokiTranslation;
    }

    public String getDefault() {
        return mDefaultTranslation;
    }

    public int getWordImage() { return mWordImageId; }

    public boolean hasImage() { return mWordImageId != -1; }

    public boolean hasSound() { return mWordSoundId != -1; }

    public int getAudioResourceId() { return mWordSoundId; }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokiTranslation='" + mMiwokiTranslation + '\'' +
                ", mWordImageId=" + mWordImageId +
                ", mWordSoundId=" + mWordSoundId +
                '}';
    }
}
