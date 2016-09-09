package com.joao.android.exemplo_sqlite_simples;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by joao on 08/09/2016.
 */
public class BDCore extends SQLiteOpenHelper{

    private static final String NOME_BD = "exemplo";
    private static final int VERSAO_BD = 13;

    public BDCore(Context ctx){
        super(ctx, NOME_BD, null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table pessoa(_id integer primary key autoincrement, nome text not null, email text not null, cpf text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
        bd.execSQL("drop table usuario;");
        onCreate(bd);
    }

}
