package com.example.android.fetchreward

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.example.android.fetchreward.adapter.RewardListAdapter
import com.example.android.fetchreward.databinding.FragmentFirstBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstFragment : Fragment() {

    private val rewards = Network.rewards.getRewards()
    private lateinit var viewBinding: FragmentFirstBinding
    val rewardLists = MutableLiveData<List<RewardItem>>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentFirstBinding.inflate(inflater, container, false).apply {
            fragment = this@FirstFragment
            rewardList.adapter = RewardListAdapter()
            lifecycleOwner = viewLifecycleOwner
            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                val lists =   rewards.await().sortedWith(compareBy({ it.listId }, { it.name })).filter {
                    it.name != null
                }
                rewardLists.postValue(
                    lists
                )
            }
        }
        return viewBinding.root
    }

}