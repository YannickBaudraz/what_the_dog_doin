package com.example.whatthedogdoin.ui.breeds.add

import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.LayoutRes
import com.example.whatthedogdoin.R
import com.example.whatthedogdoin.db.entities.Breed
import com.example.whatthedogdoin.db.entities.Category
import java.util.*

class BreedAdapter(
    context: Context,
    @LayoutRes private val layoutResource: Int,
) :
    ArrayAdapter<Category>(context, layoutResource)
{
    var mCategories = mutableListOf<Category>()

    override fun getCount(): Int {
        return mCategories.size
    }

    override fun getItem(p0: Int): Category? {
        return mCategories.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        // Or just return p0
        return mCategories.get(p0).id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: TextView = convertView as TextView? ?: LayoutInflater.from(context)
            .inflate(layoutResource, parent, false) as TextView
        view.text = mCategories[position].noun
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val label = super.getView(position, convertView, parent!!) as TextView
        val item = getItem(position)
        label.text = item?.noun
        return label
    }

}