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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

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
        ArrayList<Word> words = new ArrayList<Word>();
//        for (int x=0; x<2000; x++) {
//            String s1 = generateRandomHexToken(16);
//            String s2 = generateRandomHexToken(16);
//            words.add(new Word(s1, s2));
//        }
        words.add(new Word("lutti", "one", R.drawable.number_one));
        words.add(new Word("otiiko", "two", R.drawable.number_two));
        words.add(new Word("tolookosu", "three", R.drawable.number_three));
        words.add(new Word("oyyisa", "four", R.drawable.number_four));
        words.add(new Word("massokka", "five", R.drawable.number_five ));
        words.add(new Word("temmokka", "six", R.drawable.number_six));
        words.add(new Word("kenekaku", "seven", R.drawable.number_seven));
        words.add(new Word("kawinta", "eight", R.drawable.number_eight));
        words.add(new Word("wo'e", "nine", R.drawable.number_nine));
        words.add(new Word("na'aacha", "ten", R.drawable.number_ten));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter adapter =
                new WordAdapter(this, words,
                        R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);
    }
}