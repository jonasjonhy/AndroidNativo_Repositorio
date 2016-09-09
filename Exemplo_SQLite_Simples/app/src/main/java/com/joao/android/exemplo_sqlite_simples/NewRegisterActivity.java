package com.joao.android.exemplo_sqlite_simples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewRegisterActivity extends Activity {
    private Pessoa pessoa = new Pessoa();
    private EditText nomeEt;
    private EditText emailEt;
    private EditText cpfEt;
    private Button saveBt;
    private Button editBt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_register);

        nomeEt = (EditText) findViewById(R.id.nome);
        emailEt = (EditText) findViewById(R.id.email);
        cpfEt = (EditText) findViewById(R.id.cpf);
        saveBt = (Button) findViewById(R.id.button1);
        editBt = (Button) findViewById(R.id.button2);


        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){

                pessoa.setId(bundle.getLong("id"));
                pessoa.setNome(bundle.getString("nome"));
                pessoa.setEmail(bundle.getString("email"));
                pessoa.setCpf(bundle.getString("cpf"));

                nomeEt.setText(pessoa.getNome());
                emailEt.setText(pessoa.getEmail());
                cpfEt.setText(pessoa.getCpf());

                cpfEt.setVisibility(View.GONE);
                saveBt.setVisibility(View.GONE);
                editBt.setVisibility(View.VISIBLE);
            }
        }
    }

    public void salvarRegistro(View view){
        pessoa.setNome(nomeEt.getText().toString());
        pessoa.setEmail(emailEt.getText().toString());
        pessoa.setCpf(cpfEt.getText().toString());

        DAO bd = new DAO(this);
        bd.inserir(pessoa);

        Toast.makeText(this, "Usuário inserido com sucesso!", Toast.LENGTH_SHORT).show();
    }

    public void editarRegistro(View view){
        pessoa.setNome(nomeEt.getText().toString());
        pessoa.setEmail(emailEt.getText().toString());

        DAO bd = new DAO(this);
        bd.atualizar(pessoa);

        Toast.makeText(this, "Pessoa \""+pessoa.getNome()+"\" atuailizado com sucesso.", Toast.LENGTH_SHORT).show();
    }

}
