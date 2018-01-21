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

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> families = new ArrayList<Word>();
        families.add(new Word("әpә", "father",
                R.drawable.family_father, R.raw.family_father));
        families.add(new Word("әṭa", "mother",
                R.drawable.family_mother, R.raw.family_mother));
        families.add(new Word("angsi", "son",
                R.drawable.family_son, R.raw.family_son));
        families.add(new Word("tune", "daughter",
                R.drawable.family_daughter, R.raw.family_daughter));
        families.add(new Word("taachi", "older brother",
                R.drawable.family_older_brother, R.raw.family_older_brother));
        families.add(new Word("chalitti", "younger brother",
                R.drawable.family_younger_brother, R.raw.family_younger_brother));
        families.add(new Word("teṭe", "older sister",
                R.drawable.family_older_sister, R.raw.family_older_sister));
        families.add(new Word("kolliti", "younger sister",
                R.drawable.family_younger_sister, R.raw.family_younger_sister));
        families.add(new Word("ama", "grandmother",
                R.drawable.family_grandmother, R.raw.family_grandmother));
        families.add(new Word("paapa", "grandfather",
                R.drawable.family_grandfather, R.raw.family_grandfather));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter adapter =
                new WordAdapter(this, families, R.color.category_family);

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
                if (families.get(i).hasSound()) {
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
                            getResources().openRawResourceFd(families.get(i).getWordSound());
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