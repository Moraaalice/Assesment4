package com.example.assesment.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assesment.databinding.DetailsBinding
import com.example.assesment.model.Posts
import com.squareup.picasso.Picasso


class Adapter (var postDetails:List<Posts>,var context: Context):RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding = DetailsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var post = postDetails.get(position)
        var binding = holder.binding
        binding.userId.text=post.UserId.toString()
        binding.title.text = post.title
        binding.itBody.text = post.body

        holder.binding.userId.setOnClickListener {
            val intent = Intent(context,Posts::class.java)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return postDetails.size
    }
}
class PostViewHolder(var binding: DetailsBinding):RecyclerView.ViewHolder(binding.root)