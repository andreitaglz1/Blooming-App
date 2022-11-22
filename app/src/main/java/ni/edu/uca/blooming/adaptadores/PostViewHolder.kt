package ni.edu.uca.blooming.adaptadores

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.blooming.databinding.PostLayoutBinding

class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = PostLayoutBinding.bind(view)
    fun renderizar (posts: Posts) {
        binding.tvId.text = posts.id.toString()
        binding.tvTexto.text = posts.texto.toString()
    }

}