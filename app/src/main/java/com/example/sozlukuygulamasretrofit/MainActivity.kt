package com.example.sozlukuygulamasretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sozlukuygulamasretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
  //private lateinit var kelimelerArrayList: ArrayList<Kelimeler>
    private val adapter: KelimelerAdapter = KelimelerAdapter()

  private lateinit var kdi: KelimelerDaoInterface
   // private lateinit var kdi : KelimelerDaoInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //toolbarın başlığı
        binding.toolbar.title = "Sözlük Uygulaması"
        //aktardık.
        setSupportActionBar(binding.toolbar)
        //recyclerview uzerınde card gorunumu fixlemek
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(this)

     kdi = ApiUtils.getKelimelerDoaInterface()
        tumKelimeler()
/*
        kelimelerArrayList = ArrayList()
        val k1 = Kelimeler("Dog", "1", "Köpek")
        val k2 = Kelimeler("Fish", "2", "Balık")
        val k3 = Kelimeler("Table", "3", "Masa")

        kelimelerArrayList = ArrayList<Kelimeler>()
        kelimelerArrayList.add(k1)
        kelimelerArrayList.add(k2)
        kelimelerArrayList.add(k3)*/



       // adapter.updateList(kelimelerArrayList)
   //     binding.rv.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {


        menuInflater.inflate(R.menu.toolbar_menu, menu)
        val item = menu?.findItem(R.id.actionAra)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            Log.e("Gönderilen arama", query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null) {
            Log.e("Harf girdikçe", newText)
        }
        return true
    }


    fun tumKelimeler() {
        kdi.tumKelimeler().enqueue(object : Callback<KelimelerCevap> {
            override fun onResponse(call: Call<KelimelerCevap>, response: Response<KelimelerCevap>
            ) {
                val liste= response.body()?.kelimeler
                if (liste != null) {
                    adapter.updateList(liste)
                }
                    binding.rv.adapter = adapter

            }

            override fun onFailure(call: Call<KelimelerCevap>, t: Throwable) {

            }
        })
    }
}
