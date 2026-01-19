package com.example.btufinalandroidproject.presentation.auth.screen.register

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.btufinalandroidproject.R
import com.example.btufinalandroidproject.databinding.FragmentRegisterBinding
import com.example.btufinalandroidproject.domain.core.validation.PasswordValidationState
import com.example.btufinalandroidproject.presentation.auth.util.toErrorString
import com.example.btufinalandroidproject.presentation.core.base.BaseFragment
import com.example.btufinalandroidproject.presentation.core.util.launchCoroutineScope
import com.example.btufinalandroidproject.presentation.core.util.visibleIf
import com.example.btufinalandroidproject.presentation.core.validation.ValidationAdapter
import com.example.btufinalandroidproject.presentation.core.validation.getValidationItems
import com.example.btufinalandroidproject.presentation.util.showSnackBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val navController by lazy { findNavController() }
    private val viewModel: RegisterViewModel by viewModels()
    private val passwordValidationAdapter by lazy { ValidationAdapter() }

    override fun init() {
        initViews()
        initListeners()
        initPasswordValidationRecycler()
        initObserver()

    }


    private fun initViews() {
        with(binding.topBar) {
            tvTitle.text = getString(R.string.register)
        }


    }

    private fun initListeners() {
        with(binding) {
            btnLogin.setOnClickListener {
                navController.navigateUp()
            }
            topBar.btnStart.setOnClickListener {
                navController.navigateUp()
            }

            btnRegister.setOnClickListener {
                viewModel.register(
                    email = etEmail.text,
                    password = etPassword.text,
                    repeatPassword = etRepeatPassword.text
                )
            }

            etPassword.setOnTextChangedListener(viewModel::onPasswordChanged)
        }
    }

    private fun initPasswordValidationRecycler() {
        binding.rvPasswordValidation.apply {
            itemAnimator = null
            layoutManager = LinearLayoutManager(requireContext())
            adapter = passwordValidationAdapter
        }

    }

    private fun initObserver() {
        launchCoroutineScope {
            viewModel.state.collectLatest { state ->
                if (state.showValidation) {
                    submitValidations(state.passwordValidationState)
                }
                binding.rvPasswordValidation.visibleIf(state.showValidation)
                binding.btnRegister.isLoading = state.loading
                binding.btnLogin.isEnabled = !state.loading

            }
        }

        launchCoroutineScope {
            viewModel.events.collect { event ->
                when (event) {
                    RegisterScreenEvents.Success -> {
                        navController.navigateUp()
                    }

                    is RegisterScreenEvents.Error -> {
                        binding.root.showSnackBar(event.firebaseError.toErrorString(requireContext()))

                    }

                    is RegisterScreenEvents.InvalidInputs -> {
                        setupInputErrors(event)
                    }
                }

            }
        }
    }

    private fun setupInputErrors(event: RegisterScreenEvents.InvalidInputs) {
        if (!event.repeatPasswordValid) {
            binding.etRepeatPassword.errorText = getString(R.string.passwords_do_not_match)
            binding.etRepeatPassword.isError = true
        }
        if (!event.passwordValid) {
            binding.etPassword.errorText = getString(R.string.password_requirement_error)
            binding.etPassword.isError = true
        }
        if (!event.emailValid) {
            binding.etEmail.errorText = getString(R.string.invalid_email_error)
            binding.etEmail.isError = true
        }
    }

    private fun submitValidations(passwordValidationState: PasswordValidationState) {
        val validationList = getValidationItems(passwordValidationState)
        passwordValidationAdapter.submitList(validationList)
    }


}