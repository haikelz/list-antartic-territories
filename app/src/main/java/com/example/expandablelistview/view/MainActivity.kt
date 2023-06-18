package com.example.expandablelistview.view

import android.os.Bundle
import android.widget.ExpandableListView
import androidx.appcompat.app.AppCompatActivity
import com.example.expandablelistview.R
import com.example.expandablelistview.adapter.AntartikaAdapter
import com.example.expandablelistview.model.CountryModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvAntartika = findViewById<ExpandableListView>(R.id.lvAntartika)

        val adelieLand = mutableListOf(
            CountryModel(R.drawable.prancis, "Prancis", "Paris"),
        )

        val argentineAntartic = mutableListOf(
            CountryModel(R.drawable.argentina, "Argentina", "Buenos Aires"),
        )

        val australianAntartic = mutableListOf(
            CountryModel(R.drawable.australia, "Australia", "Canberra"),
        )

        val britishAntartic = mutableListOf(
            CountryModel(R.drawable.inggris, "Inggris", "London"),
        )

        val chileanAntartic = mutableListOf(
            CountryModel(R.drawable.chile, "Chile", "Santiago"),
        )

        val peterIsland = mutableListOf(
            CountryModel(R.drawable.norwegia, "Norwegia", "Oslo"),
        )

        val queenMaudLand = mutableListOf(
            CountryModel(R.drawable.norwegia, "Norwegia", "Oslo"),
        )

        val rossDependency = mutableListOf(
            CountryModel(R.drawable.selandia_baru, "Selandia Baru", "Wellington"),
        )

        val title = arrayOf(
            "Adélie Land",
            "Argentine Antarctica",
            "Australian Antarctic",
            "British Antarctic",
            "Chilean Antarctic",
            "Peter I Island",
            "Queen Maud Land",
            "Ross Dependency"
        )

        val countries = mutableListOf(
            mutableListOf("Prancis"),
            mutableListOf("Argentina"),
            mutableListOf("Australia"),
            mutableListOf("Inggris"),
            mutableListOf("Chile"),
            mutableListOf("Norwegia"),
            mutableListOf("Norwegia"),
            mutableListOf("Selandia Baru")
        )

        val territories = mutableListOf(
            adelieLand,
            argentineAntartic,
            australianAntartic,
            britishAntartic,
            chileanAntartic,
            peterIsland,
            queenMaudLand,
            rossDependency
        )

        val adpAntartika = AntartikaAdapter(
            this@MainActivity, title, countries, territories
        )
        lvAntartika.setAdapter(adpAntartika)
    }
}