package kr.cloudscape.android.criminalintent

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kr.cloudscape.android.criminalintent.databinding.ListItemCrimeBinding

class CrimeHolder(private val binding: ListItemCrimeBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "${crime.title} clicked!", Toast.LENGTH_SHORT)
                .show()
        }
    }
}
