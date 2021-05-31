package com.fabricio.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fabricio.santanderdevweek.R
import com.fabricio.santanderdevweek.data.Conta

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
    }
    fun buscarContaCliente(){
        mainViewModel.buscarContaCliente().observe(this, Observer{result->
            bindOnView(result)

        })
    }
    fun bindOnView(conta: Conta){
        findViewById<TextView>(R.id.tv_agencia).text = "Ag, ${conta.agencia}"
        findViewById<TextView>(R.id.tv_conta_corrente).text = "Cc${conta.numero}"
        findViewById<TextView>(R.id.tv_saldo).text = conta.saldo
        findViewById<TextView>(R.id.tv_saldo_limite_value).text = conta.limite
        findViewById<TextView>(R.id.tv_User).text = "Olá,${conta.cliente.nome}"
        findViewById<TextView>(R.id.tv_cartao_final_value).text = conta.cartao.numeroCartao
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_1 -> {
                Toast.makeText(this,"Selecionado item 1",Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}