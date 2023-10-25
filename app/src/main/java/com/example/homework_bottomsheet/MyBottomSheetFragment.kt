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
    private val data: ChargePoint? by lazy {
        arguments?.getParcelable<ChargePoint>(ARG_DATA)
    }

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

        setupUI()
        configureBottomSheetBehavior()
    }

    private fun setupUI() {
        data?.let {
            binding.apply {
                stationImage.setImageResource(it.stationImageResId)
                stationNameTextView.text = it.stationName
                stationAddressTextView.text = it.address
                portsInfoTextView.text = "${it.portsAvailable} Ports Available"
                levelTextView.text = it.portType
                priceTextView.text = it.cost
                powerTextView.text = it.power

                if (it.portsAvailable < 3) {
                    portsInfoTextView.setTextColor(Color.parseColor("#F5CA31"))
                }
            }
        }
    }

    private fun configureBottomSheetBehavior() {
        val behavior = BottomSheetBehavior.from(binding.root.parent as View)
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    companion object {
        private const val ARG_DATA = "arg_data"

        fun newInstance(data: ChargePoint): MyBottomSheetFragment {
            val args = Bundle().apply {
                putParcelable(ARG_DATA, data)
            }
            return MyBottomSheetFragment().apply {
                arguments = args
            }
        }
    }
}
