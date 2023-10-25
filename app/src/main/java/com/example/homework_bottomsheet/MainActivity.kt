package com.example.homework_bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.homework_bottomsheet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            pin1.setOnClickListener {
                val data = ChargePoint(
                    R.drawable.station_1,
                    "ChargePoint Station 1",
                    "STREET PULO 25\nAmsterdam, Netherlands",
                    8,
                    "Level 3",
                    "$0.2 per kwh",
                    "200 A, 96 kW"
                )
                val bottomSheet = MyBottomSheetFragment.newInstance(data)
                bottomSheet.show(supportFragmentManager, bottomSheet.tag)
            }

            pin2.setOnClickListener {
                val data = ChargePoint(
                    R.drawable.station_2,
                    "ChargePoint Station 2",
                    "STREET SRNA 74\nAmesterdam, Netherlands",
                    2,
                    "Level 3",
                    "$0.5 per kwh",
                    "240 A, 140 kW"
                )
                val bottomSheet = MyBottomSheetFragment.newInstance(data)
                bottomSheet.show(supportFragmentManager, bottomSheet.tag)
            }

            pin3.setOnClickListener {
                val data = ChargePoint(
                    R.drawable.station_3,
                    "ChargePoint Station 3",
                    "STREET ADAS 123 123\nAmesterdam, Netherlands",
                    5,
                    "Level 3",
                    "$0.5 per kwh",
                    "240 A, 140 kW"
                )
                val bottomSheet = MyBottomSheetFragment.newInstance(data)
                bottomSheet.show(supportFragmentManager, bottomSheet.tag)
            }
        }
    }
}