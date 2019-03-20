package cm.github.vincentbostoen.nivoses.nivoses

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsyncResult
import org.jetbrains.anko.onComplete
import java.net.URL


class NivoseActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    var nivoses: MutableList<Nivose> = ArrayList()
    var nivoseListAdapter = NivosesListAdapter(nivoses)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipeRefreshLayout.setOnRefreshListener(this)

        initRecyclerView()

        fetchNivoses()
    }

    private fun fetchNivosesImagesURLs(): List<Nivose> {
        val nivoses: MutableList<Nivose> = ArrayList()
        var zones: Array<String>? = resources.getStringArray(R.array.zones)
        for (zone in zones!!) {
            val url: String = getString(R.string.nivose_by_zone_url, zone)
            nivoses.add(Nivose(zone,  getString(R.string.nivose_gif_url) + URL(url).readText().removeSurrounding("\"")))
        }

        nivoseListAdapter.updateList(nivoses)
        return nivoses
    }

    override fun onRefresh() {
        fetchNivoses()
    }

    private fun fetchNivoses() {
        doAsync {
            fetchNivosesImagesURLs()
            onComplete {
                swipeRefreshLayout.isRefreshing = false
            }
        }.get()
    }

    private fun initRecyclerView() {
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = nivoseListAdapter
    }
}