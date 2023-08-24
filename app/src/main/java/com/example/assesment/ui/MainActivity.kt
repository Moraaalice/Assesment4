package com.example.assesment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assesment.api.ApiClient
import com.example.assesment.api.ApiInterface
import com.example.assesment.databinding.ActivityMainBinding
import com.example.assesment.model.Posts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onResume() {
        super.onResume()
        getDetails()
    }

    fun getDetails(){
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = retrofit.getTitle()
        request.enqueue(object :Callback<List<Posts>>{
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if (response.isSuccessful){
                    var postings = response.body()
                    Toast.makeText(baseContext,"${postings!!.size}postings",Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
            }
        })
    }
}
