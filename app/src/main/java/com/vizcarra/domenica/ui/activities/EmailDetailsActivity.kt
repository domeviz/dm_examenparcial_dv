package com.vizcarra.domenica.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.vizcarra.domenica.data.entities.Datos
import com.vizcarra.domenica.databinding.ActivityEmailDetailsBinding

class EmailDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmailDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datos = intent.getParcelableExtra<Datos>("datos")
        if (datos != null) {
            binding.tvSenderName.text = datos.nombre
            binding.tvSubject.text = datos.asunto
            Picasso.get().load(datos.imagen).into(binding.ivSenderImage)
        }
    }
}