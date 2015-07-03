package com.bellingham.guy.anagramapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import static com.bellingham.guy.anagramapp.R.id.anagramList;
import static com.bellingham.guy.anagramapp.R.layout.simple_list_item;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class AnagramActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anagram);

        Intent intent = getIntent();
        String theWord = intent.getStringExtra(DisplayActivity.THE_WORD);

        Set<String> anagrams = getCombinations(theWord);
        String[] anagramArray = anagrams.toArray(new String[anagrams.size()]);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,simple_list_item,anagramArray);

        // Add the data adapter to the list view
        ListView listView = (ListView) findViewById(R.id.anagramList);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_anagram, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected Set<String> getCombinations(String word) {
        Set<String> anagrams = new HashSet<String>();
        if(word.length()<2){
            anagrams.add(word);
        } else {
            char[] arr = word.toCharArray();
            int max = (arr.length - 1);
            Set<String> subAnagrams = null;
            for (int i = 0; i < arr.length; i++) {
                char wordChar = word.charAt(i);
                String sub = null;
                if(i == 0) {
                    sub = word.substring(1);
                } else
                if(i == max) {
                    sub = word.substring(0, max);
                } else {
                    sub = word.substring(0, i) + word.substring(i+1);
                }
                subAnagrams = getCombinations(sub);
                Iterator<String> itr = subAnagrams.iterator();
                while (itr.hasNext()) {
                    anagrams.add(wordChar + itr.next());
                }
            }
        }
        return anagrams;
    }

}
