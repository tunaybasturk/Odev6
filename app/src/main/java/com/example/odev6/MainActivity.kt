package com.example.odev6

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.odev6.data.entity.Cicekler
import com.example.odev6.databinding.ActivityMainBinding
import com.example.odev6.ui.adapter.CiceklerAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var ciceklerListesi : ArrayList<Cicekler>
    private lateinit var ciceklerAdapter:CiceklerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ciceklerListesi = ArrayList()
        cicekEkle()
        cicekAra()

        ciceklerAdapter = CiceklerAdapter(this,ciceklerListesi)

        binding.ciceklerRv.adapter= ciceklerAdapter
        binding.ciceklerRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        binding.editTextUrunArama.setOnClickListener {
            binding.editTextUrunArama.isFocusableInTouchMode = true
            binding.editTextUrunArama.requestFocus()
        }

        binding.imageViewAramaIkon.setOnClickListener {
            binding.editTextUrunArama.isFocusableInTouchMode = true
            binding.editTextUrunArama.requestFocus()
        }
    }


    fun cicekEkle(){
        ciceklerListesi.add(Cicekler(1,"siyah_cizgili_beyaz_papatya","Siyah Çizgili Vazoda Beyaz Papatyalar",4.0f,677,349,379,8))
        ciceklerListesi.add(Cicekler(2,"kirmizi_gerberalar_beyaz_papatyalar","Kırmızı Gerberalar & Beyaz Papatlar Çiçek Buketi",4.5f,313,329,399,18))
        ciceklerListesi.add(Cicekler(3,"pasabahce_akvaryum_vazoda_kirmizi_gul","Paşabahçe Akvaryum Vazoda 7 Kırmızı Gül",4.5f,99999,399,449,11))
        ciceklerListesi.add(Cicekler(4,"lotuslu_hindistan_cevizli_ve_findikli_lezzet_dunyasi","Lotuslu Hindistan Cevizli ve Fındıklı Lezzet Dünyası",5.0f,3055,299,349,14))
        ciceklerListesi.add(Cicekler(5,"bej_cizgili_vazoda_beyaz_papatyalar","Bej Çizgili Vazoda Beyaz Papatyalar",4.0f,1144,369,399,8))
        ciceklerListesi.add(Cicekler(6,"beyaz_papatya_ve_kirmizi_cicek_buketi","Beyaz Papatya ve Kırmızı Gerbera Çiçek Buketi",4.5f,161,329,399,18))
        ciceklerListesi.add(Cicekler(7,"pasabahce_vazoda_papatya_bahcesi","Paşabahçe Vazoda Papatya Bahçesi",4.5f,22042,379,399,5))
        ciceklerListesi.add(Cicekler(8,"kitkat_suslemeli_truf_ve_keklerle_bir_buket_lezzet","KitKat Süslemeli Trüf ve Keklerle Bir Buket Lezzet",5.0f,288,399,449,11))


    }

    fun cicekAra(){
        binding.editTextUrunArama.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?,start: Int, before: Int, count: Int) {
                cicekFiltrele(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

    fun cicekFiltrele(text:String){
        val filtrelenmis_liste = ArrayList<Cicekler>()

        for(item in ciceklerListesi){
            if(item.cicekIsim.lowercase().contains(text.lowercase())){
                filtrelenmis_liste.add(item)
            }
        }

        ciceklerAdapter.filtrelenmisliste(filtrelenmis_liste)

        if(filtrelenmis_liste.isEmpty()){
            Toast.makeText(this,"Arama Bulunamadı", Toast.LENGTH_SHORT).show()
        }
    }
}