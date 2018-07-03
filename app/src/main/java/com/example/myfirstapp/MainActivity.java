package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myfirstapp.dao.MembroDAO;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novolayout);

        Button continuar = (Button) findViewById(R.id.buttonContinuar);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MembroDAO dao = new MembroDAO(getBaseContext());
                EditText editNome = (EditText) findViewById(R.id.editTextNome);
                EditText editDtNascimento = (EditText) findViewById(R.id.editTextDataNascimento);
                EditText editEmail = (EditText) findViewById(R.id.editTextEmail);
                EditText editCelular = (EditText) findViewById(R.id.editTextCelular);
                String nome = editNome.getText().toString();
                String dtNascimento = editDtNascimento.getText().toString();
                String email = editEmail.getText().toString();
                String celular = editCelular.getText().toString();

                String resultado = dao.insereMembro(nome, dtNascimento, email, celular);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void tirarFoto(View view) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                Bitmap img = (Bitmap) bundle.get("data");

                ImageView image = (ImageView) findViewById(R.id.imageViewFoto);
                image.setImageBitmap(img);
            }
        }
    }
}
