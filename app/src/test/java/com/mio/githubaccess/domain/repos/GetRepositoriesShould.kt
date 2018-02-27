package com.mio.githubaccess.domain.repos

import com.mio.githubaccess.domain.GitHubRepository
import com.mio.githubaccess.domain.executor.PostExecutionThread
import com.mio.githubaccess.domain.executor.ThreadExecutor
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import org.junit.Test

class GetRepositoriesShould {

  private val mockNotificationRepository = mock<GitHubRepository>()
  private val mockPostExecutionThread: PostExecutionThread = mock()
  private val mockThreadExecutor: ThreadExecutor = mock()
  private val updateNotification = GetRepositories(
      mockThreadExecutor, mockPostExecutionThread,
      mockNotificationRepository)

  @Test
  fun buildUseCaseObservable() {
    updateNotification.setQueryParams("", "", "")
    updateNotification.buildUseCaseObservable()
    verify(mockNotificationRepository).getRepos("", "", "")
    verifyNoMoreInteractions(mockNotificationRepository)
    verifyZeroInteractions(mockPostExecutionThread)
    verifyZeroInteractions(mockThreadExecutor)
  }

  @Test
  fun throwErrorWhenDataNotSet() {
    updateNotification.buildUseCaseObservable().test().assertError(
        IllegalArgumentException::class.java)
  }
}