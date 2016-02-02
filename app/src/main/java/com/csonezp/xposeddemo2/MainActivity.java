package com.csonezp.xposeddemo2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        edit = (EditText) findViewById(R.id.edit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a;
                try {
                    a = Integer.parseInt(edit.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Oh!No!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (isEquls(a)) {
                    Toast.makeText(MainActivity.this, "Yes!you got it!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Oh!No!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isEquls(int a) {
        if (a == 3) {
            return true;
        }
        return false;
    }
}
