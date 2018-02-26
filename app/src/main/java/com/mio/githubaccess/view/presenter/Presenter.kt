package com.mio.githubaccess.view.presenter

/**
 * Interface representing a Presenter in a model view presenter (MVP) pattern.
 */
interface Presenter<in T : PresentingView> {

  /**
   * Method that control the lifecycle of the view. It should be called in the view's (Activity or
   * Fragment) onDestroy() method.
   */
  fun detachView(view: T)

  /**
   * Get instance for view interface from presenting view

   * @param view to present to
   */
  fun attachView(view: T)

  companion object {

    const val VIEW_NULL_MSG = "View interface cannot be null!"
  }
}
