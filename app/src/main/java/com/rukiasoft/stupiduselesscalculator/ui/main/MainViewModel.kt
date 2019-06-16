package com.rukiasoft.stupiduselesscalculator.ui.main

import androidx.lifecycle.ViewModel
import java.lang.NumberFormatException
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {
    enum class Operator(val op: Char) {
        ADD('+'),
        MINUS('-'),
        MULTIPLY('*'),
        DIVIDER('/');

        companion object {
            fun getOperationFromChar(op: Char?): Operator? {
                return when (op) {
                    ADD.op -> ADD
                    MINUS.op -> MINUS
                    MULTIPLY.op -> MULTIPLY
                    DIVIDER.op -> DIVIDER
                    else -> null
                }
            }
        }
    }

    enum class ActiveButton {
        UNO, MULTIPLY, ZERO
    }

    fun performOperation(text: String): Double? {
        Operator.getOperationFromChar(text[1])?.let { operator->
            try {
                val parts = text.split(operator.op)
                if (parts.size < 2) return null
                val fOp = parts[0].toDouble()
                val sOp = parts[1].toDouble()
                return when (operator) {
                    Operator.ADD -> fOp.plus(sOp)
                    Operator.MINUS -> fOp.minus(sOp)
                    Operator.MULTIPLY -> fOp.times(sOp)
                    Operator.DIVIDER -> fOp.div(sOp)
                }
            }catch (e: NumberFormatException){
                return null
            }
        }
        return null
    }

    fun checkIfOperatorIsInserted(text: String?): Boolean {
        val candidateCharacter = text?.getOrNull(text.lastIndex)
        Operator.getOperationFromChar(candidateCharacter)?.let {
            return true
        }
        return false
    }

    fun replaceLastChar(text: String, char: Char): String {
        var removed = text.removeRange(text.lastIndex, text.lastIndex + 1)
        removed = removed.plus(char)
        return removed
    }

    fun appendChar(text: String, char: Char): String =
        text.plus(char)

    fun isOperatorInserted(text: String): Boolean =
        null != Operator.getOperationFromChar(text.getOrNull(text.lastIndex - 1))

    fun hasThreeZerosInserted(text: String): Boolean =
        "000" == text.substring(text.lastIndex - 2)

    fun removeLastCharacter(text: String): String =
        if (text.isNotBlank()) {
            text.removeRange(text.lastIndex, text.lastIndex + 1)
        } else {
            text
        }

    fun getButtonToActivate(text: String): ActiveButton {
        if (text.isBlank()) return ActiveButton.UNO
        val char = text.getOrNull(text.lastIndex)
        return if (char == '0') ActiveButton.ZERO
        else if(char == '1' && text.length == 1) ActiveButton.MULTIPLY
        else if(char == '1') ActiveButton.ZERO
        else if (Operator.getOperationFromChar(char) != null) ActiveButton.UNO
        else ActiveButton.UNO
    }
}


