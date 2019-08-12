package com.hfad.pizza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

public class PastaDetailActivity extends Activity {
    public static final String EXTRA = "ex";
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pasta_detail);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        int pasta = (Integer) getIntent().getExtras().get(EXTRA);
        String name = Pasta.pastas[pasta].getName();
        TextView textView = findViewById(R.id.pasta_text);
        textView.setText(name);
        int ID = Pasta.pastas[pasta].getResourceID();
        ImageView view = findViewById(R.id.pasta_image);
        view.setImageResource(ID);
        view.setContentDescription(name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        TextView textView = findViewById(R.id.pasta_text);
        CharSequence pastaName = textView.getText();
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, pastaName);
        shareActionProvider.setShareIntent(intent);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_create_order:
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
