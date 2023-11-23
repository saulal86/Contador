package com.example.contador;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PantallaLogin extends AppCompatActivity {

    EditText username, password;
    Button botonlogin;
    ToggleButton togglePasswordVisibility;  // Agregado
    DBHelper DB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_login);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        botonlogin = findViewById(R.id.botonsignin1);
        togglePasswordVisibility = findViewById(R.id.togglePasswordVisibility);  // Agregado
        DB = new DBHelper(this);

        // Agregado para gestionar la visibilidad de la contraseña
        togglePasswordVisibility.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int inputType = isChecked ?
                        android.text.InputType.TYPE_CLASS_TEXT :
                        android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD;

                password.setInputType(inputType);
                password.setSelection(password.length());
            }
        });

        // Agregado: TextWatcher para mantener el estado del interruptor actualizado
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                boolean passwordVisible = (password.getInputType() & android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) > 0;
                togglePasswordVisibility.setChecked(passwordVisible);
            }
        });

        botonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(PantallaLogin.this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show();
                else {
                    boolean checkuserpass = DB.checkusername(user, pass);
                    if (checkuserpass) {
                        Toast.makeText(PantallaLogin.this, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), PantallaInicio.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(PantallaLogin.this, "Credenciales inválidas", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
