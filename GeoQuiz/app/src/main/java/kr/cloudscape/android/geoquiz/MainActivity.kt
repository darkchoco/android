package kr.cloudscape.android.geoquiz

import android.os.Bundle
import android.view.View
import android.widget.Button
//import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        trueButton.setOnClickListener { view: View ->
            Snackbar.make(
                view,
                R.string.correct_toast,
                Snackbar.LENGTH_SHORT
            ).show()
        }

        falseButton.setOnClickListener { view: View ->
            Snackbar.make(
                view,
                R.string.incorrect_toast,
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }
}