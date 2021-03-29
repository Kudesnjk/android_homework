package com.example.homework

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ELEMENTS_NUMBER = "elems_num"
private const val PORTRAIT_COLUMNS_COUNT = 3
private const val LANDSCAPE_COLUMNS_COUNT = 4
private const val ITEMS_CACHE_SIZE = 10
private const val DEFAULT_ITEMS_COUNT = 100

class NumberList() : Fragment(), NumberClickListener {
    private var itemsCount = DEFAULT_ITEMS_COUNT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var columnsCount = PORTRAIT_COLUMNS_COUNT
        if (container?.resources?.configuration?.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            columnsCount = LANDSCAPE_COLUMNS_COUNT
        }

        val view = inflater.inflate(R.layout.fragment_number_list, container, false)
        val itemsRecycler = view.findViewById<RecyclerView>(R.id.numbers_recycler)
        itemsRecycler.setItemViewCacheSize(ITEMS_CACHE_SIZE)
        itemsRecycler.layoutManager = GridLayoutManager(view.context, columnsCount)

        restoreState(savedInstanceState)
        val dataSource = DataSource(itemsCount)
        val numberAdapter = NumberAdapter(dataSource, this)
        val addNumButton = view.findViewById<Button>(R.id.add_num_button)
        addNumButton.setOnClickListener {
            numberAdapter.notifyItemInserted(dataSource.addElem())
            itemsCount = dataSource.getElemsCount() - 1
        }
        itemsRecycler.adapter = numberAdapter

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(ELEMENTS_NUMBER, itemsCount)
        super.onSaveInstanceState(outState)
    }

    private fun restoreState(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            itemsCount = savedInstanceState.getInt(ELEMENTS_NUMBER)
        }
    }

    override fun onNumberClick(number: Int) {
        val fm = activity?.supportFragmentManager?.beginTransaction() ?: return
        fm.replace(R.id.fragment_wrapper, SingleNumber.getInstance(number))
        fm.addToBackStack(null)
        fm.commit()
    }
}