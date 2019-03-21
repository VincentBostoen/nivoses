import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.view.ViewGroup
import android.widget.TextView
import com.github.vincentbostoen.nivoses.MassifListAdapter
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MassifListAdapterInstrumentedTest {

    lateinit private var appContext: Context

    @Before
    fun setup() {
        appContext = InstrumentationRegistry.getTargetContext()
    }

    @Test
    fun holder_holds_a_textview() {
        val massifListAdapter = MassifListAdapter()

        val viewHolder = massifListAdapter.onCreateViewHolder(ViewGroupForTests(appContext), 42)

        assertNotNull(viewHolder.itemView)
    }

    @Test
    fun massif_name_is_bound_into_text_content() {
        val massifListAdapter = MassifListAdapter()

        val itemView = TextView(appContext)
        massifListAdapter.onBindViewHolder(MassifListAdapter.MassifViewHolder(itemView), 1)

        assertEquals("Ariège", itemView.text)

    }

    class ViewGroupForTests(context: Context) : ViewGroup(context) {
        override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
            TODO("not implemented in tests") //To change body of created functions use File | Settings | File Templates.
        }

    }
}