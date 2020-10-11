package io.minseok.mvrxsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.mvrx.viewModel
import com.airbnb.mvrx.withState
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val counterViewModel: CounterMvRxViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterViewModel.subscribe(this) {
            count.text = it.count.toString()
        }

        button.setOnClickListener {
            withState(counterViewModel) {
                counterViewModel.countUp(it.count)
            }
        }

    }
}