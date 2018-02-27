package com.mio.githubaccess.domain

import com.mio.githubaccess.domain.executor.PostExecutionThread
import com.mio.githubaccess.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).

 * By convention each UseCase implementation will return the result using a [ ]
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
abstract class UseCase<T>(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) {

  private var disposable: Disposable = Disposables.empty()

  /**
   * Builds an [Observable] which will be used when executing the current [UseCase].
   */
  abstract fun buildUseCaseObservable(): Observable<T>

  /**
   * Executes the current use case.
   * @param observer [DisposableObserver] which will be listening to the observable build
   */
  open fun execute(observer: DisposableObserver<T>?) {
    if (observer == null) {
      throw NullPointerException("Observer cannot be null!")
    }
    val observable = this.buildUseCaseObservable()
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.scheduler)
    disposable = observable.subscribeWith(observer)
  }

  /**
   * Dispose from current [CompositeDisposable].
   */
  fun dispose() {
    if (!disposable.isDisposed) {
      disposable.dispose()
    }
  }
}