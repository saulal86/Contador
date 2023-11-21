package com.example.contador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PantallaLogin extends AppCompatActivity {

    EditText username, password;
    Button botonlogin;
    DBHelper DB;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        botonlogin = findViewById(R.id.botonsignin1);
        DB = new DBHelper(this);

        botonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(PantallaLogin.this, "Porfavor rellena todos los campos", Toast.LENGTH_SHORT).show();
                else {
                    boolean checkuserpass = DB.checkusername(user, pass);
                    if (checkuserpass == true){
                        Toast.makeText(PantallaLogin.this, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), PantallaInicio.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(PantallaLogin.this, "Credenciales invalidas", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }
}
