package com.rukiasoft.stupiduselesscalculator.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.rukiasoft.stupiduselesscalculator.R
import com.rukiasoft.stupiduselesscalculator.databinding.MainFragmentBinding
import com.rukiasoft.stupiduselesscalculator.ui.common.BaseFragment

class MainFragment : BaseFragment() {

    companion object {
        private val SCREEN_TEXT_INPUT: String = "screen_text_input"
        private val SCREEN_TEXT_RESULT: String = "screen_text_result"
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        binding.txtResult.text?.let {
            outState.putString(SCREEN_TEXT_RESULT, it.toString())
        }
        binding.edtInput.text?.let {
            outState.putString(SCREEN_TEXT_INPUT, it.toString())
        }

        super.onSaveInstanceState(outState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        savedInstanceState?.let {
            if (it.containsKey(SCREEN_TEXT_INPUT)) {
                val input = it.getString(SCREEN_TEXT_INPUT)
                binding.edtInput.text = input
                activateRightButton(input)
            }
            if (it.containsKey(SCREEN_TEXT_RESULT)) {
                binding.txtResult.text = it.getString(SCREEN_TEXT_RESULT)
            }
        }

        binding.btnNumber1.setOnClickListener {
            binding.txtResult.text = null
            val text = "${binding.edtInput.text}1"
            binding.edtInput.text = text
            binding.btnNumber1.isEnabled = false
            if (viewModel.isOperatorInserted(text)) {
                binding.btnNumber0.isEnabled = true
            } else {
                binding.btnNumberMul.isEnabled = true
            }
        }

        binding.btnNumber0.setOnClickListener {
            val text = "${binding.edtInput.text}0"
            binding.edtInput.text = text
            if (viewModel.hasThreeZerosInserted(text)) {
                binding.btnResult.isEnabled = true
                binding.btnNumber0.isEnabled = false
            }
        }

        binding.btnNumberMul.setOnClickListener {
            val text = binding.edtInput.text.toString()
            val newText = if (viewModel.checkIfOperatorIsInserted(text)) {
                viewModel.replaceLastChar(text, MainViewModel.Operator.MULTIPLY.op)
            } else {
                viewModel.appendChar(text, MainViewModel.Operator.MULTIPLY.op)
            }
            binding.edtInput.text = newText
            binding.btnNumberMul.isEnabled = false
            binding.btnNumber1.isEnabled = true
        }

        binding.btnDelete.setOnClickListener {
            val text = binding.edtInput.text.toString()
            val newText = viewModel.removeLastCharacter(text)
            binding.edtInput.text = newText
            activateRightButton(newText)
        }

        binding.btnResult.setOnClickListener {
            val result = viewModel.performOperation(binding.edtInput.text.toString())
            binding.txtResult.text = result?.toString()
            binding.btnResult.isEnabled = false
            binding.btnNumber1.isEnabled = true
            binding.edtInput.text = null
        }

    }

    fun activateRightButton(text: String) {

        binding.btnNumberMul.isEnabled = false
        binding.btnNumber1.isEnabled = false
        binding.btnNumber0.isEnabled = false
        binding.btnResult.isEnabled = false
        when (viewModel.getButtonToActivate(text)) {
            MainViewModel.ActiveButton.UNO -> binding.btnNumber1.isEnabled = true
            MainViewModel.ActiveButton.MULTIPLY -> binding.btnNumberMul.isEnabled = true
            MainViewModel.ActiveButton.ZERO -> binding.btnNumber0.isEnabled = true
        }
    }

}
