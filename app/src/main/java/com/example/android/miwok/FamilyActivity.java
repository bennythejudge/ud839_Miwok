package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        // Create a list of words
        ArrayList<Word> families = new ArrayList<Word>();
        families.add(new Word("әpә", "father", R.drawable.family_father));
        families.add(new Word("әṭa", "mother", R.drawable.family_mother));
        families.add(new Word("angsi", "son", R.drawable.family_son));
        families.add(new Word("tune", "daughter", R.drawable.family_daughter));
        families.add(new Word("taachi", "older brother", R.drawable.family_older_brother));
        families.add(new Word("chalitti", "younger brother", R.drawable.family_younger_brother));
        families.add(new Word("teṭe", "older sister", R.drawable.family_older_sister));
        families.add(new Word("kolliti", "younger sister", R.drawable.family_younger_sister));
        families.add(new Word("ama", "grandmother", R.drawable.family_grandmother));
        families.add(new Word("paapa", "grandfather", R.drawable.family_grandfather));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter adapter =
                new WordAdapter(this, families);

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