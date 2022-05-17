package com.oliferov.test_for_bearscomgames.presentation.screens

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import com.oliferov.test_for_bearscomgames.R
import com.oliferov.test_for_bearscomgames.databinding.FragmentCircleDiagramBinding
import com.oliferov.test_for_bearscomgames.databinding.FragmentDynamicDiagramBinding
import java.lang.RuntimeException

class CircleDiagramFragment : Fragment() {

    private var _binding: FragmentCircleDiagramBinding? = null
    private val binding: FragmentCircleDiagramBinding
        get() = _binding ?: throw RuntimeException("CircleDiagramFragment is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCircleDiagramBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = mutableListOf<PieEntry>().apply {
            add(PieEntry(2017.55f,"2017"))
            add(PieEntry(16124.02f,"2018"))
            add(PieEntry(4040.71f,"2019"))
            add(PieEntry(11708.97f,"2020"))
//            add(PieEntry(65509.87f,"2021"))
//            add(PieEntry(29440.15f,"2022"))
        }

        val pieDataSet = PieDataSet(list, "Курс Bitcoin за год")
        pieDataSet.colors = ColorTemplate.MATERIAL_COLORS.asList()
        pieDataSet.valueTextColor = Color.BLACK
        pieDataSet.valueTextSize = 25f

        val pieData = PieData(pieDataSet)

        with(binding.pierChart){
            setData(pieData)
            description.text = ("Bitcoin info")
            description.isEnabled = false
            setCenterText("Bitcoin")
            animate()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CircleDiagramFragment()
    }
}