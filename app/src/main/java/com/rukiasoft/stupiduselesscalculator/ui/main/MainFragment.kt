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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        binding.btnNumber1.setOnClickListener {
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
            binding.btnNumberMul.isEnabled = false
            binding.btnNumber1.isEnabled = false
            binding.btnNumber0.isEnabled = false
            binding.btnResult.isEnabled = false
            when(viewModel.getButtonToActivate(newText)){
                MainViewModel.ActiveButton.UNO -> binding.btnNumber1.isEnabled = true
                MainViewModel.ActiveButton.MULTIPLY -> binding.btnNumberMul.isEnabled = true
                MainViewModel.ActiveButton.ZERO -> binding.btnNumber0.isEnabled = true
            }
        }


    }

}
