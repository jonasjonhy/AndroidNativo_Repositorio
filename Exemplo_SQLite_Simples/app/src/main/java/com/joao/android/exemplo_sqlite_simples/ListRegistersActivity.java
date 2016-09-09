package com.joao.android.exemplo_sqlite_simples;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class ListRegistersActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_users);

        DAO bd = new DAO(this);

        List<Pessoa> list = bd.buscar();
        setListAdapter(new PessoaAdapter(this, list));
    }
}
