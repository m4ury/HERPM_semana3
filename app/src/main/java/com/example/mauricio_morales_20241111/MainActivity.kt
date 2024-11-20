package com.example.mauricio_morales_20241111

import android.app.AlertDialog
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Log.d("info", "La aplicación se ha abierto")

        val editName = findViewById<EditText>(R.id.editName)
        val editCount = findViewById<EditText>(R.id.editCount)
        val dateView = findViewById<TextView>(R.id.dateView)
        val buttonShow = findViewById<Button>(R.id.buttonShow)

        val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        dateView.text = currentDate

        buttonShow.setOnClickListener {
            val name = editName.text.toString()
            val count = editCount.text.toString()
            val date = dateView.text.toString()

            if (name.isNotEmpty() && count.isNotEmpty()) {
                val message = "Responsable: $name\nCantidad: $count\nFecha: $date"
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                Log.d("info", message)

                AlertDialog.Builder(this)
                    .setTitle("Detalles de la Reserva")
                    .setMessage(message)
                    .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    .show()
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT)
                    .show()
            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("info", "La aplicación se ha cerrado")
    }
}