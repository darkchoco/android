package kr.cloudscape.android.criminalintent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.cloudscape.android.criminalintent.databinding.ListItemCrimeBinding

class CrimeListAdapter(private val crime: List<Crime>): RecyclerView.Adapter<CrimeHolder>() {

    // binding 생성, view holder 안에 view를 넣어준 다음 view holder 리턴.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
        return CrimeHolder(binding)
    }

    override fun getItemCount() = crime.size

    // Populating a given holder with the crime from a given position.
    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crime[position]
        holder.bind(crime)
    }
}
