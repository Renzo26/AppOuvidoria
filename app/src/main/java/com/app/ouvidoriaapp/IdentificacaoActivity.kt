package com.app.ouvidoriaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class IdentificacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identificacao)

        val etNome = findViewById<EditText>(R.id.et_nome)
        val etEmail = findViewById<EditText>(R.id.et_email)
        val etTelefone = findViewById<EditText>(R.id.et_telefone)
        val btnProximo = findViewById<Button>(R.id.btn_proximo_identificacao)

        btnProximo.setOnClickListener {
            val nome = etNome.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val telefone = etTelefone.text.toString().trim()

            if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            DadosManifestacao.nomeCompleto = nome
            DadosManifestacao.email = email
            DadosManifestacao.telefone = telefone

            // Proxima tela (vamos criar depois)
            val intent = Intent(this, EnderecoActivity::class.java)
            startActivity(intent)
        }
    }
}
