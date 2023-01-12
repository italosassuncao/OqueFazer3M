package com.example.oquefazer3m

import android.R
import android.app.ListActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.oquefazer3m.databinding.ActivityMainBinding

class MainActivity : ListActivity() {
    private lateinit var binding: ActivityMainBinding
    private val tarefas = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        tarefas.add("Comprar Passagens");
        tarefas.add("Pagar Aluguel");
        tarefas.add("Concluir Aulas");
        tarefas.add("Demonstrar APP");

        atualizaListaTarefas();
        limpaTarefa();

        binding.btnInsert.setOnClickListener {
            val tarefa: String = binding.edtTarefa.text.toString()
            if (tarefa != null && tarefa != "") {
                tarefas.add(binding.edtTarefa.text.toString())
                limpaTarefa()
                atualizaListaTarefas()
            }
        }

    }

    override fun onListItemClick(lista: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(lista, v, position, id)

        val obj = this.listAdapter.getItem(position)
        val elementoClicado = obj.toString()

        Toast.makeText(this, "Você clicou em: $elementoClicado", Toast.LENGTH_SHORT).show()

        tarefas.removeAt(position);
        atualizaListaTarefas();
    }

    private fun limpaTarefa() {
        binding.edtTarefa.setText("")
        binding.edtTarefa.requestFocus()
    }

    private fun atualizaListaTarefas() {
        val arrayAdapter = ArrayAdapter(this, R.layout.simple_list_item_1, tarefas)
        setListAdapter(arrayAdapter);
    }
}