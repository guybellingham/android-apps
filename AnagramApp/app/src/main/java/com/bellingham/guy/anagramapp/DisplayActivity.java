package com.bellingham.guy.anagramapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import static com.bellingham.guy.anagramapp.R.id.anagraminput;


public class DisplayActivity extends Activity {

    public static final String THE_WORD = "com.bellingham.guy.anagramapp.THE_WORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void openSearch() {
        System.out.println("DisplayActivity.openSearch MenuItem clicked!");
        ActionBar actionBar = getActionBar();
//        actionBar.hide();
//        Drawable background = getResources().getDrawable(R.drawable.bg_orange,getTheme());
//        actionBar.setBackgroundDrawable(background);
    }
    public void openSettings() {
        System.out.println("DisplayActivity.openSettings MenuItem clicked!");
    }
    /**
     * Called when the user clicks the List Anagrams button
     */
    public void createAnagrams(View view) {
        EditText editText = (EditText) findViewById(anagraminput);
        String theWord = editText.getText().toString();
        //TODO IF the word length > 10 report an error!
        System.out.println("DisplayActivity.createAnagrams starting AnagramActivity for "+theWord);
        Intent intent = new Intent(this, AnagramActivity.class);
        intent.putExtra(THE_WORD,theWord);
        startActivity(intent);
    }
}
