package com.example.homework_bottomsheet

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework_bottomsheet.databinding.BottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MyBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arguments?.getParcelable<ChargePoint>(ARG_DATA)

        if (data != null) {
            binding.apply {
                stationImage.setImageResource(data.stationImageResId)
                stationNameTextView.text = data.stationName
                stationAddressTextView.text = data.address
                portsInfoTextView.text = "${data.portsAvailable} Ports Available"
                levelTextView.text = data.portType
                priceTextView.text = data.cost
                powerTextView.text = data.power
            }
            if (data.portsAvailable < 3) {
                binding.portsInfoTextView.setTextColor(Color.parseColor("#F5CA31"))
            }
        }


        val behavior = BottomSheetBehavior.from(binding.root.parent as View)
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    companion object {
        private const val ARG_DATA = "arg_data"

        fun newInstance(data: ChargePoint): MyBottomSheetFragment {
            val args = Bundle()
            args.putParcelable(ARG_DATA, data)
            val fragment = MyBottomSheetFragment()
            fragment.arguments = args
            return fragment
        }
    }

}
