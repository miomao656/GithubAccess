package com.mio.githubaccess.view.ui

import android.os.Bundle
import com.mio.githubaccess.R
import com.mio.githubaccess.data.net.responses.Repo
import com.mio.githubaccess.view.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_repo_details.*

class RepoDetailsActivity : BaseActivity() {

  var repo: Repo? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_repo_details)

    intent?.let {
      repo = it.getParcelableExtra(REPO_DETAILS)
    }

    repo?.let {
      repo_details.text = it.toString()
    }
  }

  override fun onConnectionChange(isOnline: Boolean) {
    // handle connection
  }

  companion object {
    const val REPO_DETAILS = "repo_details"
  }
}
