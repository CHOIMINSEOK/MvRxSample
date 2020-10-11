package io.minseok.mvrxsample

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.mvrx.viewModel
import com.airbnb.mvrx.withState
import io.minseok.mvrxsample.list.ListItemAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val counterViewModel: CounterMvRxViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.adapter = ListItemAdapter()
        list.layoutManager = LinearLayoutManager(this)

        counterViewModel.subscribe(this) {
            (list.adapter as ListItemAdapter).items = it.items
        }

        button.setOnClickListener {
            withState(counterViewModel) {
                counterViewModel.add("부엉이")
            }
        }

    }
}