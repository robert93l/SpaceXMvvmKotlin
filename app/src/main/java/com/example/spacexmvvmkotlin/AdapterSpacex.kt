package com.example.spacexmvvmkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterSpacex : RecyclerView.Adapter<AdapterSpacex.LaunchViewHolder>() {

    private var launches: List<Launch> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.space_layout_adapter, parent, false)
        return LaunchViewHolder(view)
    }

    override fun getItemCount() = launches.size

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bind(launches[position])
    }

    fun setLaunches(launches: List<Launch>) {
        this.launches = launches
    }

    class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val missionName: TextView = itemView.findViewById(R.id.mission_name)
        private val rocketName: TextView = itemView.findViewById(R.id.rocket_name)
        private val imageView: ImageView = itemView.findViewById(R.id.mission_patch)

        fun bind(launch: Launch) {
            missionName.text = launch.mission_name
            rocketName.text = launch.rocket.rocket_name

            Glide.with(imageView.context).load(launch.links.mission_patch_small).into(imageView)
        }
    }
}