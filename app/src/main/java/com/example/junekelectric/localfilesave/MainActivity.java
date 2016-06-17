package com.example.junekelectric.localfilesave;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.junekelectric.musicplayertest.R;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    Button fileSaveButton;
    EditText inputText;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = (EditText)findViewById(R.id.input_text);
        fileSaveButton = (Button)findViewById(R.id.fileSave_button);
        fileSaveButton.setOnClickListener(this);
        }

    @Override
        public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fileSave_button:
                try {
                    //入力内容取得
                    String s = inputText.getText().toString();
                    //OutputStream取得
                    OutputStream out = openFileOutput("test.txt", MODE_PRIVATE);
                    PrintWriter writer = new PrintWriter(new OutputStreamWriter(out,"UTF-8"));
                    writer.append(s);
                    writer.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
}
