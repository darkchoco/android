package kr.cloudscape.android.criminalintent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.cloudscape.android.criminalintent.databinding.ListItemCrimeBinding
import kr.cloudscape.android.criminalintent.databinding.ListItemCrimePoliceBinding

class CrimeListAdapter(private val crime: List<Crime>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val CRIME_VIEW_TYPE = 0
        const val CRIME_POLICE_VIEW_TYPE = 1
    }

    // binding 생성, view holder 안에 view를 넣어준 다음 view holder 리턴.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CRIME_VIEW_TYPE -> CrimeHolder(ListItemCrimeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            CRIME_POLICE_VIEW_TYPE -> CrimePoliceHolder(ListItemCrimePoliceBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount() = crime.size

    // Populating a given holder with the crime from a given position.
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return when (crime[position].requiresPolice) {
            true -> (holder as CrimePoliceHolder).bind(crime[position])
            false -> (holder as CrimeHolder).bind(crime[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (crime[position].requiresPolice) CRIME_POLICE_VIEW_TYPE else CRIME_VIEW_TYPE
    }
}
