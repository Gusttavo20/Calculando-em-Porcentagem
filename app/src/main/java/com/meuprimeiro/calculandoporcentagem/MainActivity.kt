package com.meuprimeiro.calculandoporcentagem

import android.graphics.MaskFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.meuprimeiro.calculandoporcentagem.databinding.ActivityMainBinding
import java.text.SimpleDateFormat


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.dataAnterior.mask("##/##/####")
        binding.dataAtual.mask("##/##/####")
        binding.editValorAtual.enzo()
        binding.editValorAnterior.enzo()

        binding.btCalcular.setOnClickListener {
            val valorAnteriorVazio = binding.editValorAnterior.text.toString()
            val valorAtualVazio= binding.editValorAtual.text.toString()

        if (valorAnteriorVazio.isEmpty() && valorAtualVazio.isEmpty()) {
                binding.textErro.setText("Preencha todos os dados!")
                    }else if (valorAnteriorVazio.isEmpty()){
                       binding.textErro.setText(" Informe o valor anterior!")
                    }
                    else if (valorAtualVazio.isEmpty()) {
                        binding.textErro.setText("Informe o valor atual!")
                    } else {
                       CalcularPorcentagem()
            }
        }
          binding.imageResetar.setOnTouchListener { v, event ->

                if (event.action == MotionEvent.ACTION_DOWN) {
                    binding.textErro.text = ""
                    binding.editValorAnterior.text.clear()
                    binding.editValorAtual.text.clear()
                    binding.dataAtual.text.clear()
                    binding.dataAnterior.text.clear()
                    binding.dataAtual.text.clear()
                    binding.textResultado.text = ""
                }
                false
            }

    }

    private fun CalcularPorcentagem() {
        var valorAnte = binding.editValorAnterior.text.toString().replace(",",".").toFloat()
        var valorAtu = binding.editValorAtual.text.toString().replace(",",".").toFloat()
        var resultado = binding.textResultado

        var diferenca = valorAtu / valorAnte -1
        var porcentagem = (diferenca * 100)

        resultado.setText("$porcentagem %")


    }




}
