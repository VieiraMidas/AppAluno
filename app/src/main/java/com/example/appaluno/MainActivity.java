package com.example.appaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //Criar BD
            SQLiteDatabase bd = openOrCreateDatabase("dbAlunoCriar", MODE_PRIVATE, null);

            //Criar Tabela
            bd.execSQL("CREATE TABLE IF NOT EXISTS tbAluno(nome VARCHAR, email VARCHAR, telefone VARCHAR)");

            //Inserção de dados
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone) VALUES ('Fernando','fernandinho123@gmail.com','(11)5661-9502')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone) VALUES ('Maria','mariadaconceicao@gmail.com','(11)5662-7922')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone) VALUES ('Fátima','fatty226@gmail.com','(11)5662-4174')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone) VALUES ('Ricardo','ricardinhogameplays@gmail.com','(15)5663-0083')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone) VALUES ('Beatriz','biiatora@gmail.com','(27)5661-7228')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone) VALUES ('Ana','garotagamerana@gmail.com','(13)5662-6602')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone) VALUES ('Manuel','xxdestroyermoonxx@gmail.com','(11)5663-4469')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone) VALUES ('Nicole','djnicolexx@gmail.com','(11)5661-1120')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone) VALUES ('Lucas','luc45m4nue1@gmail.com','(11)5662-7712')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone) VALUES ('Gustavo','guzinhoemail@gmail.com','(11)5663-9644')");

            Cursor cursor = bd.rawQuery("SELECT nome, email, telefone FROM tbAluno", null);

            int indiceNome = cursor.getColumnIndex("nome");
            int indiceEmail = cursor.getColumnIndex("email");
            int indiceTelefone = cursor.getColumnIndex("telefone");

            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("Resultado - nome", cursor.getString(indiceNome));
                Log.i("Resultado - email", cursor.getString(indiceEmail));
                Log.i("Resultado - telefone", cursor.getString(indiceTelefone));

                cursor.moveToNext();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}










