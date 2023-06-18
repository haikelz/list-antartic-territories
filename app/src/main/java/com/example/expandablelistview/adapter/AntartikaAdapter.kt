package com.example.expandablelistview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.expandablelistview.R
import com.example.expandablelistview.model.CountryModel

class AntartikaAdapter(
    private var context: Context,
    private var title: Array<String>,
    private var countries: MutableList<MutableList<String>>,
    private var territories: MutableList<MutableList<CountryModel>>
) : BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int) = title[groupPosition]
    override fun isChildSelectable(groupPosition: Int, childPosition: Int) = true
    override fun hasStableIds() = false

    override fun getGroupView(
        groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?
    ): View {
        var cv = convertView

        if (cv == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            cv = inflater.inflate(R.layout.layout_territory, null)
        }

        val tvTerritory = cv!!.findViewById<TextView>(R.id.tvTerritory)
        tvTerritory.text = getGroup(groupPosition)

        return cv
    }

    override fun getChildrenCount(groupPosition: Int) = territories[groupPosition].size
    override fun getChild(groupPosition: Int, childPosition: Int) =
        countries[groupPosition][childPosition]

    override fun getGroupId(groupPosition: Int) = groupPosition.toLong()
    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var cv = convertView

        if (cv == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            cv = inflater.inflate(R.layout.layout_country, null)
        }

        val tvCountry = cv!!.findViewById<TextView>(R.id.tvCountry)
        tvCountry.text = countries[groupPosition][childPosition]

        val imgCountry = cv.findViewById<ImageView>(R.id.imgCountry)
        imgCountry!!.setImageResource(territories[groupPosition][childPosition].image)

        cv.setOnClickListener {
            Toast.makeText(
                context,
                territories[groupPosition][childPosition].capital,
                Toast.LENGTH_SHORT
            ).show()
        }

        return cv
    }

    override fun getChildId(groupPosition: Int, childPosition: Int) = childPosition.toLong()
    override fun getGroupCount() = title.size
}