package com.example.spacexmvvmkotlin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.spacexmvvmkotlin.data.Launch
import com.example.spacexmvvmkotlin.R
import com.example.spacexmvvmkotlin.databinding.SpaceLayoutAdapterBinding

class AdapterSpacex : RecyclerView.Adapter<AdapterSpacex.LaunchViewHolder>()
 {
     private val launches = mutableListOf<Launch>()

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
         val binding = SpaceLayoutAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
         return LaunchViewHolder(binding)
     }

     override fun getItemCount() = launches.size

     override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
         holder.bind(launches[position])
     }

     fun submitList(launches1: List<Launch>) {
         val diffCallback = LaunchDiffCallback(launches, launches1)
         val diffResult = DiffUtil.calculateDiff(diffCallback)
         launches.clear()
         launches.addAll(launches1)
         diffResult.dispatchUpdatesTo(this)
     }

     class LaunchViewHolder(private val binding: SpaceLayoutAdapterBinding) : RecyclerView.ViewHolder(binding.root) {
         fun bind(launch: Launch) {
             binding.missionName.text = launch.mission_name
             binding.rocketName.text = launch.rocket.rocket_name
             binding.launchDate.text = launch.launch_date_utc
             Glide.with(binding.missionPatch.context).load(launch.links.mission_patch_small).into(binding.missionPatch)
         }
     }

  class LaunchDiffCallback(
      private val oldList: List<Launch>,
      private val newList: List<Launch>
  ) : DiffUtil.Callback() {
      override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
          return oldList[oldItemPosition].mission_name == newList[newItemPosition].mission_name
      }

      override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
          return oldList[oldItemPosition] == newList[newItemPosition]
      }

      override fun getOldListSize(): Int {
          return oldList.size
      }

      override fun getNewListSize(): Int {
          return newList.size
      }
  }
}