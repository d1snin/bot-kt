package commands

import Command
import Send.error
import Send.normal
import arg
import doesLater
import greedyString
import helpers.MathHelper.round
import kotlin.math.pow

object CalculatorCommand : Command("calc") {
    init {
        greedyString("input") {
            doesLater { context ->
                val input: String = context arg "input"
                val inputs = input.split(" ")

                if (inputs.size != 3) {
                    message.error("Too many or not enough arguments!\nUsage: `$fullName x + y`")
                    return@doesLater
                }

                val first = inputs[0]
                val operator = inputs[1]
                val second = inputs[2]

                val firstNum: Double
                val secondNum: Double

                try {
                    firstNum = first.toDouble()
                    secondNum = second.toDouble()
                } catch (e: NumberFormatException) {
                    message.error(e.message!!.substring(18) + "is not a valid number!")
                    return@doesLater
                }

                when (operator) {
                    "^" -> message.normal("$first $operator $second = " + (firstNum.pow(secondNum)).toString().replace(".0", ""))
                    "/" -> message.normal("$first $operator $second = " + round(firstNum / secondNum, 2).toString().replace(".0", ""))
                    "*" -> message.normal("$first $operator $second = " + (firstNum * secondNum).toString().replace(".0", ""))
                    "+" -> message.normal("$first $operator $second = " + (firstNum + secondNum).toString().replace(".0", ""))
                    "-" -> message.normal("$first $operator $second = " + (firstNum - secondNum).toString().replace(".0", ""))
                    else -> message.error("$operator is not a valid operator! \nChoose from: `^ / * + -")
                }
            }
        }
    }
}