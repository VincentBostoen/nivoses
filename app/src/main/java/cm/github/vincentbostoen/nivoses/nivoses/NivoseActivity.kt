package cm.github.vincentbostoen.nivoses.nivoses

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsyncResult
import org.jetbrains.anko.onComplete
import java.net.URL


class NivoseActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    var nivoseURLfromZone: String? = null
    var nivoseGifURL: String? = null
    var zones: Array<String>? = null
    var zonePlaceholder: String? = null
    var zoneNamePrefix: String? = null

    var nivoses: MutableList<Nivose> = ArrayList()
    var nivoseListAdapter = NivosesListAdapter(nivoses)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadProperties()

        swipeRefreshLayout.setOnRefreshListener(this)

        initRecyclerView()

        doAsyncResult {
            fetchNivosesImagesURLs()
        }.get()
    }

    private fun fetchNivosesImagesURLs(): List<Nivose> {
        val nivoses: MutableList<Nivose> = ArrayList()
        for (zone in zones!!) {
            val url: String = nivoseURLfromZone!!.replace(zonePlaceholder!!, zoneNamePrefix + zone)
            nivoses.add(Nivose(zone, nivoseGifURL + URL(url).readText().removeSurrounding("\"")))
        }

        nivoseListAdapter.updateList(nivoses)
        return nivoses
    }

    override fun onRefresh() {
        doAsyncResult {
            onComplete {
                swipeRefreshLayout.isRefreshing = false
            }
            fetchNivosesImagesURLs()
        }.get()
    }

    private fun loadProperties() {
        nivoseURLfromZone = getString(R.string.nivose_by_zone_url)
        nivoseGifURL = getString(R.string.nivose_gif_url)
        zones = resources.getStringArray(R.array.zones)
        zonePlaceholder = getString(R.string.zone_placeholder)
        zoneNamePrefix = getString(R.string.zone_name_prefix)
    }

    private fun initRecyclerView() {
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.setLayoutManager(mLayoutManager)
        recyclerView.setItemAnimator(DefaultItemAnimator())
        recyclerView.setAdapter(nivoseListAdapter)
    }
}