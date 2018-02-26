package com.mio.githubaccess.view.presenter

/**
 * Interface representing a View that will use to load data.
 */
interface LoadDataView : PresentingView {
  /**
   * Show a view with a progress bar indicating a loading process.
   */
  fun showLoading()

  /**
   * Hide a loading view.
   */
  fun hideLoading()

  /**
   * Show a retry view in case of an error when retrieving data.
   */
  fun showRetry()

  /**
   * Hide a retry view shown if there was an error when retrieving data.
   */
  fun hideRetry()

  /**
   * Show an error message

   * @param errorMessage A string representing an error.
   */
  fun showError(errorMessage: String)
}