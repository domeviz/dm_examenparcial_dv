package com.vizcarra.domenica.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.vizcarra.domenica.data.entities.Datos
import com.vizcarra.domenica.databinding.ActivityMainBinding
import com.vizcarra.domenica.logic.lists.listItems
import com.vizcarra.domenica.ui.adapters.EmailListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: EmailListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = EmailListAdapter(listItems().getData()) { item ->
            showDetailScreen(item)
        }
        binding.rvEmails.adapter = adapter
        binding.rvEmails.layoutManager = LinearLayoutManager(this)
    }

    private fun showDetailScreen(datos: Datos) {
        val intent = Intent(this, EmailDetailsActivity::class.java)
        intent.putExtra("datos", datos)
        startActivity(intent)
    }

}