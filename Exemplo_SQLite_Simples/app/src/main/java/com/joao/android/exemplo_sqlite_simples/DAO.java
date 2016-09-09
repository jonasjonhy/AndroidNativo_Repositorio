package com.joao.android.exemplo_sqlite_simples;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joao on 08/09/2016.
 */
public class DAO {
    private SQLiteDatabase banco;

    public DAO(Context context){
        BDCore auxBd = new BDCore(context);
        banco = auxBd.getWritableDatabase();
    }

    public void inserir( Pessoa p){
        ContentValues valores = new ContentValues();
        valores.put("nome", p.getNome());
        valores.put("email", p.getEmail());
        valores.put("cpf", p.getCpf());

        banco.insert("pessoa", null, valores);
    }

    public void atualizar(Pessoa p){
        ContentValues valores = new ContentValues();
        valores.put("nome", p.getNome());
        valores.put("email", p.getEmail());

        banco.update("pessoa", valores, "_id = ?", new String[]{""+p.getId()});
    }


    public void deletar(Pessoa p){
        banco.delete("pessoa", "_id = "+p.getId(), null);
    }

    public List<Pessoa> buscar(){
        List<Pessoa> list = new ArrayList<Pessoa>();
        String[] colunas = new String[]{"_id", "nome", "email", "cpf"};

        Cursor cursor = banco.query("pessoa", colunas, null, null, null, null, "nome ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{

                Pessoa p = new Pessoa();
                p.setId(cursor.getLong(0));
                p.setNome(cursor.getString(1));
                p.setEmail(cursor.getString(2));
                p.setCpf(cursor.getString(3));
                list.add(p);

            }while(cursor.moveToNext());
        }

        return(list);
    }

}
