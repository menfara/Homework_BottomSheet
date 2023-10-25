package com.example.homework_bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework_bottomsheet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupChargePoints()
    }

    private fun setupChargePoints() {
        val chargePoints = listOf(
            ChargePoint(
                R.drawable.station_1,
                "ChargePoint Station 1",
                "STREET PULO 25\nAmsterdam, Netherlands",
                8,
                "Level 3",
                "$0.2 per kwh",
                "200 A, 96 kW"
            ),
            ChargePoint(
                R.drawable.station_2,
                "ChargePoint Station 2",
                "STREET SRNA 74\nAmsterdam, Netherlands",
                2,
                "Level 3",
                "$0.5 per kwh",
                "240 A, 140 kW"
            ),
            ChargePoint(
                R.drawable.station_3,
                "ChargePoint Station 3",
                "STREET ADAS 123 123\nAmsterdam, Netherlands",
                5,
                "Level 3",
                "$0.5 per kwh",
                "240 A, 140 kW"
            )
        )

        val pins = listOf(binding.pin1, binding.pin2, binding.pin3)
        for (i in chargePoints.indices) {
            pins[i].setOnClickListener { showBottomSheet(chargePoints[i]) }
        }
    }

    private fun showBottomSheet(data: ChargePoint) {
        val bottomSheet = MyBottomSheetFragment.newInstance(data)
        bottomSheet.show(supportFragmentManager, bottomSheet.tag)
    }
}
