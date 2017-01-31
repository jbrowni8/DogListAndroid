package csc472.project2.browningjamesprogrammingassignment6;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DogActivity extends Activity {

    private static final String TAG = "DogActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
        Intent intent = getIntent();
        if (intent != null) {
            TextView name = (TextView) findViewById(R.id.textView2);
            TextView description = (TextView) findViewById(R.id.textView3);
            description.setMovementMethod(new ScrollingMovementMethod());
            ImageView icon = (ImageView) findViewById(R.id.imageView);
            Dog dog = intent.getParcelableExtra("Dog");
            name.setText(dog.getBreed());
            description.setText(dog.getLongDescription());
            icon.setImageResource(Dog.getIconResourceDetail(dog.getBreed()));
        }
    }


}


