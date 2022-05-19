package com.example.sozlukuygulamasretrofit

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sozlukuygulamasretrofit.databinding.CardTasarimBinding

class KelimelerAdapter : RecyclerView.Adapter<KelimelerAdapter.KelimelerHolder>() {


    private val kelimeList= arrayListOf<Kelimeler>()
    class KelimelerHolder(
        private val cardTasarimBinding: CardTasarimBinding
    ) : RecyclerView.ViewHolder(cardTasarimBinding.root) {
        fun find(kelime:Kelimeler){
            with(cardTasarimBinding){
                textViewIngilizce.text=kelime.ingilizce
                textViewTurkce.text=kelime.turkce
                kelimeCard.setOnClickListener {
                    val intent = Intent(cardTasarimBinding.root.context,DetayActivity::class.java)
                    intent.putExtra("nesne",kelime)
                    cardTasarimBinding.root.context.startActivity(intent)
                }
            }
        }


    }
/* tasarımı aktarmak ıcın onCreateViewHolder kullanılır...*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KelimelerHolder {
        var layout=
            CardTasarimBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return KelimelerHolder(layout)
    }
             /*Hangı alana hangı kelıme ışlenecek onun ıcın kullanılır. id1-id1 e id2=id2 */
    override fun onBindViewHolder(holder: KelimelerHolder, position: Int) {
        val kelime = kelimeList[position]
              holder.find(kelime)

    }
        /*Kaç veri işlenecek ,veri küme sayısnı belirtmek için*/
    override fun getItemCount(): Int {
        return kelimeList.size
    }

    fun updateList(list:List<Kelimeler>){
        kelimeList.clear()
        kelimeList.addAll(list)
        notifyDataSetChanged()
    }
}