package com.joao.android.exemplo_sqlite_simples;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getActivity(View view){
        Button bt = (Button) view;
        Intent intent;

        if(bt.getText().toString().equalsIgnoreCase("Novo registro")){
            intent = new Intent(this, NewRegisterActivity.class);
        }
        else{
            intent = new Intent(this, ListRegistersActivity.class);
        }

        startActivity(intent);
    }
}
