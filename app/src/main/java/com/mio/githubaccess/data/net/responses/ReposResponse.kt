package com.mio.githubaccess.data.net.responses

import com.mio.githubaccess.view.ui.model.Repo

class ReposResponse {
  var total_count: Int? = null
  var incomplete_results: Boolean? = false
  var items: List<Repo>? = null
}