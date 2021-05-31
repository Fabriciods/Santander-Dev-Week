package com.fabricio.santanderdevweek.data.local

import com.fabricio.santanderdevweek.data.Cartao
import com.fabricio.santanderdevweek.data.Cliente
import com.fabricio.santanderdevweek.data.Conta

class FakeData {
    fun getLocalData(): Conta {
        val cliente = Cliente("Fabricio")
        val cartao = Cartao("41111111")
        return Conta(
            "456789-9",
            "6552-9",
            "R$ 3.250,00",
            "R$ 6.500,00",
            cliente,
            cartao
        )
    }
}