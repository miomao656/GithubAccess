package com.mio.githubaccess.view.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mio.githubaccess.R
import com.mio.githubaccess.data.net.responses.Repo
import kotlinx.android.synthetic.main.item_repo.view.*

class ReposAdapter(private val repos: List<Repo>,
    private val itemClick: (Repo) -> Unit) : RecyclerView.Adapter<ReposAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_repo, parent, false)
    return ViewHolder(view, itemClick)
  }

  override fun getItemCount(): Int = repos.size

  override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
    holder?.bindRepo(repos[position])
  }

  class ViewHolder(view: View, private val itemClick: (Repo) -> Unit)
    : RecyclerView.ViewHolder(view) {

    fun bindRepo(repo: Repo) {
      with(repo) {
        itemView.repo_name.text = repo.name
        itemView.repo_desc.text = repo.description
        itemView.setOnClickListener { itemClick(this) }
      }
    }
  }
}


