package com.mio.githubaccess.view.presenter.repos

import com.mio.githubaccess.domain.repos.GetRepositories
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNull
import org.junit.Test
import org.mockito.ArgumentMatchers

class ReposPresenterShould {

  private val view = mock<ReposView>()
  private val useCase = mock<GetRepositories>()

  private val presenter = ReposPresenter(useCase)

  @Test fun detachView() {
    presenter.detachView(view)
    verify(useCase, times(1)).dispose()
    assertNull(presenter.reposView)
  }

  @Test fun attachView() {
    presenter.attachView(view)
    assertEquals(view, presenter.reposView)
  }

  @Test(expected = IllegalArgumentException::class) fun getReposThrowExceptionWhenViewEmpty() {
    presenter.getReposBy("", "", "")
  }

  @Test fun getReposBy() {
    presenter.attachView(view)
    presenter.getReposBy("", "", "")
    verify(useCase, times(1)).setQueryParams("", "", "")
    verify(useCase, times(1)).execute(ArgumentMatchers.any())
    verify(view, times(1)).hideRetry()
    verify(view, times(1)).showLoading()
  }
}