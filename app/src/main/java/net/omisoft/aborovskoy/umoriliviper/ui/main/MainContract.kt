package net.omisoft.aborovskoy.umoriliviper.ui.main

import io.reactivex.Single
import net.omisoft.aborovskoy.umoriliviper.app.model.Joke

interface MainContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun publishData(data: List<Joke>)
        fun showMessage(msg: String)
    }

    interface Presenter {

        fun bindView(view: MainContract.View)

        fun unbindView()

        fun onViewCreated()

        fun onItemClicked(joke: Joke)

        fun onBackClicked()
    }

    interface Interactor {
        fun getJokes(onSuccess: (List<Joke>) -> Unit, onError: (Throwable) -> Unit)
    }

    interface Router {
        fun finish()
        fun openFullJoke(joke: Joke)
    }

    interface Repo {
        fun getJokes(): Single<List<Joke>>
    }
}