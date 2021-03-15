package changhwan.experiment.experiencechili

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import kotlinx.android.synthetic.main.activity_main.*
import lv.chi.photopicker.PhotoPickerFragment

class MainActivity : AppCompatActivity(), PhotoPickerFragment.Callback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener { openPicker() }
        textView.movementMethod = ScrollingMovementMethod()
    }

    override fun onImagesPicked(photos: ArrayList<Uri>) {
        textView.text = photos.joinToString(separator = "\n") { it.toString() }
    }

    private fun openPicker() {
        PhotoPickerFragment.newInstance(
                multiple = false,
                allowCamera = true,
                maxSelection = 5,
                theme = R.style.ChiliPhotoPicker_Dark
        ).show(supportFragmentManager, "picker")
    }
}