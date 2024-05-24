package kr.cloudscape.android.criminalintent

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {

    @Test
    fun checkTitleInCrimeWithEditText() {
        val scenario = launchFragmentInContainer<CrimeDetailFragment>()
        scenario.onFragment { fragment ->
            assertThat(fragment.binding.crimeTitle.text.toString()).isEqualTo("")
            assertThat(fragment.binding.crimeDate.text.toString()).isNotNull()

            println("EditText: " + fragment.binding.crimeTitle.text.toString())
            println("Date: " + fragment.binding.crimeDate.text.toString())

            println("(before) crime.title: " + fragment.crime.title)
            fragment.binding.crimeTitle.setText("This is a test")
            assertThat("This is a test").isEqualTo(fragment.crime.title)
            println("(after) crime.title: " + fragment.crime.title)
        }
    }

    @Test
    fun checkFlaginCrimeWithCheckBox() {
        val scenario = launchFragmentInContainer<CrimeDetailFragment>()
        scenario.onFragment { fragment ->
            assertThat(fragment.binding.crimeSolved.isChecked).isFalse()
            fragment.binding.crimeSolved.isChecked = true
            assertThat(fragment.binding.crimeSolved.isChecked).isEqualTo(fragment.crime.isSolved)
        }
    }
}
