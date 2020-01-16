package com.farias.estacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ação para o botão de entrar

        btnEntrar.setOnClickListener {
            val usuario = edtUsuario.text.toString().trim()
            val senha = edtSenha.text.toString().trim()


            // Condição para verificar o login

            if (usuario.isEmpty()) {
                txvResultado.text = "Usuário está vazio!"
            } else if (senha.isEmpty()) {
                txvResultado.text = "Senha está vazia!"
            } else if (usuario == "Guilherme" && senha == "batata") {
                txvResultado.text = "Usuário logado com sucesso!"

                Handler().postDelayed({
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))

                    finish()
                }, 2000)
            } else {
                Toast.makeText(
                    this@LoginActivity,
                    "Usuário e/ou Senha incorretos!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        btnCadastrar.setOnClickListener{
                startActivity(Intent(this@LoginActivity, CadastroActivity::class.java))

                finish()
        }    }
}
