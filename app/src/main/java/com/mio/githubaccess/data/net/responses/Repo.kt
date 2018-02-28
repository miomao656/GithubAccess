package com.mio.githubaccess.data.net.responses

import android.os.Parcel
import com.mio.githubaccess.util.KParcelable
import com.mio.githubaccess.util.parcelableCreator
import com.mio.githubaccess.util.readDate
import com.mio.githubaccess.util.writeDate
import java.util.Date

data class Repo(
    val id: Long?,
    val name: String?,
    val full_name: String?,
    val url: String?,
    val description: String?,
    val created_at: Date?,
    val homepage: String?,
    val language: String?,
    val watchers_count: Long?
) : KParcelable {

  private constructor(p: Parcel) : this(
      p.readLong(),
      p.readString(),
      p.readString(),
      p.readString(),
      p.readString(),
      p.readDate(),
      p.readString(),
      p.readString(),
      p.readLong()
  )

  override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
    writeLong(id ?: 0)
    writeString(name)
    writeString(full_name)
    writeString(url)
    writeString(description)
    writeDate(created_at)
    writeString(homepage)
    writeString(language)
    writeLong(watchers_count ?: 0)
  }


  @Suppress("unused")
  companion object {
    @JvmField val CREATOR = parcelableCreator(::Repo)
  }

}

//{
//  "id": 943149,
//  "name": "d3",
//  "full_name": "d3/d3",
//  "owner": {
//  "login": "d3",
//  "id": 1562726,
//  "avatar_url": "https://avatars1.githubusercontent.com/u/1562726?v=4",
//  "gravatar_id": "",
//  "url": "https://api.github.com/users/d3",
//  "html_url": "https://github.com/d3",
//  "followers_url": "https://api.github.com/users/d3/followers",
//  "following_url": "https://api.github.com/users/d3/following{/other_user}",
//  "gists_url": "https://api.github.com/users/d3/gists{/gist_id}",
//  "starred_url": "https://api.github.com/users/d3/starred{/owner}{/repo}",
//  "subscriptions_url": "https://api.github.com/users/d3/subscriptions",
//  "organizations_url": "https://api.github.com/users/d3/orgs",
//  "repos_url": "https://api.github.com/users/d3/repos",
//  "events_url": "https://api.github.com/users/d3/events{/privacy}",
//  "received_events_url": "https://api.github.com/users/d3/received_events",
//  "type": "Organization",
//  "site_admin": false
//},
//  "private": false,
//  "html_url": "https://github.com/d3/d3",
//  "description": "Bring data to life with SVG, Canvas and HTML. :bar_chart::chart_with_upwards_trend::tada:",
//  "fork": false,
//  "url": "https://api.github.com/repos/d3/d3",
//  "forks_url": "https://api.github.com/repos/d3/d3/forks",
//  "keys_url": "https://api.github.com/repos/d3/d3/keys{/key_id}",
//  "collaborators_url": "https://api.github.com/repos/d3/d3/collaborators{/collaborator}",
//  "teams_url": "https://api.github.com/repos/d3/d3/teams",
//  "hooks_url": "https://api.github.com/repos/d3/d3/hooks",
//  "issue_events_url": "https://api.github.com/repos/d3/d3/issues/events{/number}",
//  "events_url": "https://api.github.com/repos/d3/d3/events",
//  "assignees_url": "https://api.github.com/repos/d3/d3/assignees{/user}",
//  "branches_url": "https://api.github.com/repos/d3/d3/branches{/branch}",
//  "tags_url": "https://api.github.com/repos/d3/d3/tags",
//  "blobs_url": "https://api.github.com/repos/d3/d3/git/blobs{/sha}",
//  "git_tags_url": "https://api.github.com/repos/d3/d3/git/tags{/sha}",
//  "git_refs_url": "https://api.github.com/repos/d3/d3/git/refs{/sha}",
//  "trees_url": "https://api.github.com/repos/d3/d3/git/trees{/sha}",
//  "statuses_url": "https://api.github.com/repos/d3/d3/statuses/{sha}",
//  "languages_url": "https://api.github.com/repos/d3/d3/languages",
//  "stargazers_url": "https://api.github.com/repos/d3/d3/stargazers",
//  "contributors_url": "https://api.github.com/repos/d3/d3/contributors",
//  "subscribers_url": "https://api.github.com/repos/d3/d3/subscribers",
//  "subscription_url": "https://api.github.com/repos/d3/d3/subscription",
//  "commits_url": "https://api.github.com/repos/d3/d3/commits{/sha}",
//  "git_commits_url": "https://api.github.com/repos/d3/d3/git/commits{/sha}",
//  "comments_url": "https://api.github.com/repos/d3/d3/comments{/number}",
//  "issue_comment_url": "https://api.github.com/repos/d3/d3/issues/comments{/number}",
//  "contents_url": "https://api.github.com/repos/d3/d3/contents/{+path}",
//  "compare_url": "https://api.github.com/repos/d3/d3/compare/{base}...{head}",
//  "merges_url": "https://api.github.com/repos/d3/d3/merges",
//  "archive_url": "https://api.github.com/repos/d3/d3/{archive_format}{/ref}",
//  "downloads_url": "https://api.github.com/repos/d3/d3/downloads",
//  "issues_url": "https://api.github.com/repos/d3/d3/issues{/number}",
//  "pulls_url": "https://api.github.com/repos/d3/d3/pulls{/number}",
//  "milestones_url": "https://api.github.com/repos/d3/d3/milestones{/number}",
//  "notifications_url": "https://api.github.com/repos/d3/d3/notifications{?since,all,participating}",
//  "labels_url": "https://api.github.com/repos/d3/d3/labels{/name}",
//  "releases_url": "https://api.github.com/repos/d3/d3/releases{/id}",
//  "deployments_url": "https://api.github.com/repos/d3/d3/deployments",
//  "created_at": "2010-09-27T17:22:42Z",
//  "updated_at": "2018-02-26T19:04:02Z",
//  "pushed_at": "2018-02-07T18:56:21Z",
//  "git_url": "git://github.com/d3/d3.git",
//  "ssh_url": "git@github.com:d3/d3.git",
//  "clone_url": "https://github.com/d3/d3.git",
//  "svn_url": "https://github.com/d3/d3",
//  "homepage": "https://d3js.org",
//  "size": 35864,
//  "stargazers_count": 72817,
//  "watchers_count": 72817,
//  "language": "JavaScript",
//  "has_issues": true,
//  "has_projects": false,
//  "has_downloads": true,
//  "has_wiki": true,
//  "has_pages": false,
//  "forks_count": 18795,
//  "mirror_url": null,
//  "archived": false,
//  "open_issues_count": 3,
//  "license": {
//  "key": "bsd-3-clause",
//  "name": "BSD 3-Clause \"New\" or \"Revised\" License",
//  "spdx_id": "BSD-3-Clause",
//  "url": "https://api.github.com/licenses/bsd-3-clause"
//},
//  "forks": 18795,
//  "open_issues": 3,
//  "watchers": 72817,
//  "default_branch": "master",
//  "score": 19.288713
//}