package com.example.btufinalandroidproject.presentation.meal.favourites

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.btufinalandroidproject.R
import com.example.btufinalandroidproject.databinding.FragmentFavouritesBinding
import com.example.btufinalandroidproject.presentation.core.base.BaseFragment
import com.example.btufinalandroidproject.presentation.core.util.hide
import com.example.btufinalandroidproject.presentation.core.util.launchCoroutineScope
import com.example.btufinalandroidproject.presentation.core.util.visibleIf
import com.example.btufinalandroidproject.presentation.meal.adapters.MealAdapter
import com.example.btufinalandroidproject.presentation.meal.home.model.MealUi
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class FavouritesFragment :
    BaseFragment<FragmentFavouritesBinding>(FragmentFavouritesBinding::inflate) {

    private val viewModel: FavouritesViewModel by viewModels()
    private val navController by lazy { findNavController() }
    private val mealAdapter by lazy { MealAdapter(::onMealClicked) }

    override fun init() {
        initViews()
        initMealRecycler()
        initObserver()

    }

    private fun initViews() {
        binding.topBar.btnStart.hide()
        binding.topBar.tvTitle.text = getString(R.string.favourites)
    }

    private fun initMealRecycler() {
        binding.rvFavMeals.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mealAdapter
        }

    }

    private fun initObserver() {
        launchCoroutineScope {
            viewModel.state.collectLatest {
                mealAdapter.submitList(it.favourites)
                binding.rvFavMeals.visibleIf(it.favourites.isNotEmpty())
                binding.tvEmptyFavMeals.visibleIf(it.favourites.isEmpty())
            }
        }
    }

    fun onMealClicked(meal: MealUi) {
        navController.navigate(
            FavouritesFragmentDirections.actionFavouritesFragmentToFavouriteDetailsFragment(
                meal
            )
        )


    }

}