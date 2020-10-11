package io.minseok.mvrxsample

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext

data class CounterState(val items: List<String>): MvRxState

class CounterMvRxViewModel(initState: CounterState): BaseMvRxViewModel<CounterState>(initState, debugMode = false) {

    companion object : MvRxViewModelFactory<CounterMvRxViewModel, CounterState> {

        override fun initialState(viewModelContext: ViewModelContext): CounterState? {
            // Args are accessible from the context.
            // val foo = vieWModelContext.args<MyArgs>.foo

            // The owner is available too, if your state needs a value stored in a DI component, for example.
            return CounterState(listOf())
        }

    }

    fun add(item: String) = setState {
        val newItems = arrayListOf<String>()

        this.items.forEach {
            newItems.add(it)
        }

        newItems.add(item)
        copy(items = newItems)
    }


}