package io.minseok.mvrxsample

import android.util.Log
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext

data class CounterState(val count: Int): MvRxState

class CounterMvRxViewModel(initState: CounterState): BaseMvRxViewModel<CounterState>(initState, debugMode = false) {

    companion object : MvRxViewModelFactory<CounterMvRxViewModel, CounterState> {

        override fun initialState(viewModelContext: ViewModelContext): CounterState? {
            // Args are accessible from the context.
            // val foo = vieWModelContext.args<MyArgs>.foo

            // The owner is available too, if your state needs a value stored in a DI component, for example.
            return CounterState(0)
        }

    }


    fun countUp(count: Int) = setState {
        Log.d("TAG", count.toString())
        copy(count = count + 1)

    }

}