package com.example.odev6.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.odev6.R
import com.example.odev6.data.entity.Cicekler
import com.example.odev6.databinding.CardTasarimBinding
import com.google.android.material.snackbar.Snackbar

class CiceklerAdapter(var mContext: Context, var ciceklerListesi:List<Cicekler>)
    : RecyclerView.Adapter<CiceklerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {//0,1,2
        val cicekler = ciceklerListesi.get(position)
        val t = holder.tasarim

        t.imageViewCicek.setImageResource(
            mContext.resources.getIdentifier(cicekler.cicekResim,"drawable",mContext.packageName))

        t.textViewCicekIsim.text = cicekler.cicekIsim

        t.textViewCicekIndirimFiyat.text = String.format("%.2f TL",cicekler.cicekIndirimFiyat.toFloat())

        t.textViewCicekFiyat.text = String.format("%.2f TL",cicekler.cicekFiyat.toFloat())

        if(cicekler.degerlendirmeSayisi>=99999){
            t.textViewDegerlendirmeSayisi.text = "(${cicekler.degerlendirmeSayisi}+)"
        }else{
            t.textViewDegerlendirmeSayisi.text = "(${cicekler.degerlendirmeSayisi})"
        }

        t.textViewCicekIndirimYuzde.text = "%${cicekler.CicekIndirimYuzde}"

        val yildizSayisi = cicekler.cicekYildiz

        if(yildizSayisi == 5.0f){
            t.imageViewYildiz1.visibility = View.VISIBLE
            t.imageViewYildiz2.visibility = View.VISIBLE
            t.imageViewYildiz3.visibility = View.VISIBLE
            t.imageViewYildiz4.visibility = View.VISIBLE
            t.imageViewYildiz5.visibility = View.VISIBLE
        }

        if(yildizSayisi == 4.5f){
            t.imageViewYildiz1.visibility = View.VISIBLE
            t.imageViewYildiz2.visibility = View.VISIBLE
            t.imageViewYildiz3.visibility = View.VISIBLE
            t.imageViewYildiz4.visibility = View.VISIBLE
            t.imageViewYildiz5.setImageResource(R.drawable.yarim_yildiz_image)
        }

        if(yildizSayisi == 4.0f){
            t.imageViewYildiz1.visibility = View.VISIBLE
            t.imageViewYildiz2.visibility = View.VISIBLE
            t.imageViewYildiz3.visibility = View.VISIBLE
            t.imageViewYildiz4.visibility = View.VISIBLE
            t.imageViewYildiz5.setImageResource(R.drawable.sifir_yildiz_image)
        }

        if(yildizSayisi == 3.5f){
            t.imageViewYildiz1.visibility = View.VISIBLE
            t.imageViewYildiz2.visibility = View.VISIBLE
            t.imageViewYildiz3.visibility = View.VISIBLE
            t.imageViewYildiz4.setImageResource(R.drawable.yarim_yildiz_image)
            t.imageViewYildiz5.setImageResource(R.drawable.sifir_yildiz_image)
        }

        if(yildizSayisi == 3.0f){
            t.imageViewYildiz1.visibility = View.VISIBLE
            t.imageViewYildiz2.visibility = View.VISIBLE
            t.imageViewYildiz3.visibility = View.VISIBLE
            t.imageViewYildiz4.setImageResource(R.drawable.sifir_yildiz_image)
            t.imageViewYildiz5.setImageResource(R.drawable.sifir_yildiz_image)
        }

        if(yildizSayisi == 2.5f){
            t.imageViewYildiz1.visibility = View.VISIBLE
            t.imageViewYildiz2.visibility = View.VISIBLE
            t.imageViewYildiz3.setImageResource(R.drawable.yarim_yildiz_image)
            t.imageViewYildiz4.setImageResource(R.drawable.sifir_yildiz_image)
            t.imageViewYildiz5.setImageResource(R.drawable.sifir_yildiz_image)
        }

        if(yildizSayisi == 2.0f){
            t.imageViewYildiz1.visibility = View.VISIBLE
            t.imageViewYildiz2.visibility = View.VISIBLE
            t.imageViewYildiz3.setImageResource(R.drawable.sifir_yildiz_image)
            t.imageViewYildiz4.setImageResource(R.drawable.sifir_yildiz_image)
            t.imageViewYildiz5.setImageResource(R.drawable.sifir_yildiz_image)
        }

        if(yildizSayisi == 1.5f){
            t.imageViewYildiz1.visibility = View.VISIBLE
            t.imageViewYildiz2.setImageResource(R.drawable.yarim_yildiz_image)
            t.imageViewYildiz3.setImageResource(R.drawable.sifir_yildiz_image)
            t.imageViewYildiz4.setImageResource(R.drawable.sifir_yildiz_image)
            t.imageViewYildiz5.setImageResource(R.drawable.sifir_yildiz_image)
        }

        if(yildizSayisi == 1.0f){
            t.imageViewYildiz1.visibility = View.VISIBLE
            t.imageViewYildiz2.setImageResource(R.drawable.sifir_yildiz_image)
            t.imageViewYildiz3.setImageResource(R.drawable.sifir_yildiz_image)
            t.imageViewYildiz4.setImageResource(R.drawable.sifir_yildiz_image)
            t.imageViewYildiz5.setImageResource(R.drawable.sifir_yildiz_image)
        }

        if(yildizSayisi == 0.0f){
            t.imageViewYildiz1.setImageResource(R.drawable.yarim_yildiz_image)
            t.imageViewYildiz2.setImageResource(R.drawable.sifir_yildiz_image)
            t.imageViewYildiz3.setImageResource(R.drawable.sifir_yildiz_image)
            t.imageViewYildiz4.setImageResource(R.drawable.sifir_yildiz_image)
            t.imageViewYildiz5.setImageResource(R.drawable.sifir_yildiz_image)
        }

        if(yildizSayisi == 0.0f){
            t.imageViewYildiz1.setImageResource(R.drawable.sifir_yildiz_image)
            t.imageViewYildiz2.setImageResource(R.drawable.sifir_yildiz_image)
            t.imageViewYildiz3.setImageResource(R.drawable.sifir_yildiz_image)
            t.imageViewYildiz4.setImageResource(R.drawable.sifir_yildiz_image)
            t.imageViewYildiz5.setImageResource(R.drawable.sifir_yildiz_image)
        }

    }

    override fun getItemCount(): Int {
        return ciceklerListesi.size
    }

    fun filtrelenmisliste(filtrelenmis_List :ArrayList<Cicekler>){
        this.ciceklerListesi = filtrelenmis_List
        notifyDataSetChanged()

    }
}