/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer = null;

    public static String generateRandomHexToken(int byteLength) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[byteLength];
        secureRandom.nextBytes(token);
        return new BigInteger(1, token).toString(16); //hex encoding
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("minto wuksus", "Where are you going?",
                -1, R.raw.phrase_where_are_you_going));
        words.add(new Word("tinnә oyaase'nә", "What is your name?",
                -1, R.raw.phrase_what_is_your_name));
        words.add(new Word("oyaaset...", "My name is...",
                -1, R.raw.phrase_my_name_is));
        words.add(new Word("michәksәs?", "How are you feeling?",
                -1, R.raw.phrase_how_are_you_feeling));
        words.add(new Word("kuchi achit", "I’m feeling good.",
                -1, R.raw.phrase_im_feeling_good));
        words.add(new Word("әәnәs'aa?", "Are you coming?",
                -1, R.raw.phrase_are_you_coming));
        words.add(new Word("hәә’ әәnәm", "Yes, I’m coming.",
                -1, R.raw.phrase_are_you_coming));
        words.add(new Word("әәnәm", "’I'm coming.",
                -1, R.raw.phrase_yes_im_coming));
        words.add(new Word("әәnәm", "Let’s go.",
                -1, R.raw.phrase_lets_go));
        words.add(new Word("әnni'nem", "Come here.",
                -1, R.raw.phrase_come_here));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // play word sound when the list item is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("setOnItemClickListener",
                        "here I am " + String.valueOf(i) + " " + String.valueOf(l));
                if (words.get(i).hasSound()) {
                    Log.v("setOnItemClickListener",
                            "inside first if and mediaplayer: " + String.valueOf(mediaPlayer));
                    if (mediaPlayer == null) {
                        Log.v("setOnItemClickListener",
                                "about to create the mediaplayer");
                        mediaPlayer = new MediaPlayer();
                        Log.v("setOnItemClickListener",
                                "just created the mediaplayer");
                    }
                    Log.v("setOnItemClickListener",
                            "after creating mediaplayer");
                    mediaPlayer.reset();
                    AssetFileDescriptor sound =
                            getResources().openRawResourceFd(words.get(i).getWordSound());
                    Log.v("setOnItemClickListener", "sound: " + String.valueOf(sound));
                    try {
                        mediaPlayer.setDataSource(
                                sound.getFileDescriptor(),sound.getStartOffset(),sound.getLength());
                        mediaPlayer.prepare();
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                    mediaPlayer.start(); // no need to call prepare(); create() does that for you
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Sound file not found", Toast.LENGTH_SHORT).show();
                }
            }
        });



        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);
    }
}