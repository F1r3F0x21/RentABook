package com.example.myapplication.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class SettingsActivity extends AppCompatActivity {
    private Switch switchNotifications;
    private Switch switchUpdates;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        switchNotifications = findViewById(R.id.switch_notifications);
        switchUpdates = findViewById(R.id.switch_updates);
        buttonSave = findViewById(R.id.button_save);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes guardar los cambios en las preferencias de la aplicación
                String message = "Notificaciones: " + (switchNotifications.isChecked() ? "Activadas" : "Desactivadas") +
                        "\nActualizaciones automáticas: " + (switchUpdates.isChecked() ? "Activadas" : "Desactivadas");
                Toast.makeText(SettingsActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}