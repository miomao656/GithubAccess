package com.mio.githubaccess.domain

import com.mio.githubaccess.domain.executor.PostExecutionThread
import com.mio.githubaccess.domain.executor.ThreadExecutor
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.TestScheduler
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class UseCaseShould {

  private var testObserver: TestDisposableObserver<Any>? = TestDisposableObserver()
  private var mockThreadExecutor = mock<ThreadExecutor>()
  private var mockPostExecutionThread = mock<PostExecutionThread> {
    on { scheduler } doReturn TestScheduler()
  }
  private var useCase: UseCaseTestClass? = UseCaseTestClass(mockThreadExecutor,
      mockPostExecutionThread)

  @Test
  fun testBuildUseCaseObservableReturnCorrectResult() {
    useCase!!.execute(testObserver)

    assertThat(testObserver!!.valuesCount).isZero()
  }

  @Test
  fun testSubscriptionWhenExecutingUseCase() {
    useCase!!.execute(testObserver)
    useCase!!.dispose()

    assertThat(testObserver!!.isDisposed).isTrue()
  }

  @Test(expected = NullPointerException::class)
  fun testShouldFailWhenExecuteWithNullObserver() {
    useCase!!.execute(null)
  }

  private class UseCaseTestClass internal constructor(threadExecutor: ThreadExecutor,
      postExecutionThread: PostExecutionThread) : UseCase<Any>(threadExecutor,
      postExecutionThread) {

    override fun buildUseCaseObservable(): Observable<Any> {
      return Observable.empty()
    }
  }

  private class TestDisposableObserver<T> : DisposableObserver<T>() {
    var valuesCount = 0

    override fun onNext(value: T) {
      valuesCount++
    }

    override fun onError(exception: Throwable) {
      // no-op by default.
    }

    override fun onComplete() {
      // no-op by default.
    }
  }
}