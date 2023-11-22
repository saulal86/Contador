package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PantallaRegister extends AppCompatActivity {
    EditText username, password, repassword;
    Button botonsignin, botonsignup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        botonsignin = findViewById(R.id.botonsignin);
        botonsignup = findViewById(R.id.botonsignup);
        DB = new DBHelper(this);

        botonsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals(""))
                    Toast.makeText(PantallaRegister.this, "Porfavor rellena todos los campos", Toast.LENGTH_SHORT).show();
                else if (user != ("") || pass != ("") || repass != ("")) {
                    if (pass.equals(repass)) {
                        boolean checkuser = DB.checkusername(user, pass);
                        if (checkuser == false) {
                            boolean insert = DB.insertaData(user, pass);
                            if (insert == true) {
                                Toast.makeText(PantallaRegister.this, "Registrado corectamente", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), PantallaInicio.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(PantallaRegister.this, "Registro fallido", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Toast.makeText(PantallaRegister.this, "Usuario existente, porfavor inicia sesión", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(PantallaRegister.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }
            }
        });
        botonsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PantallaLogin.class);
                startActivity(intent);
            }
        });


    }
}
