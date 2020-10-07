package commands

import Command
import Send.stackTrace
import arg
import doesLater
import greedyString
import javax.script.ScriptEngineManager


object CalculatorCommand : Command("calc") {
    init {
        greedyString("input") {
            doesLater { context ->
                val input: String = context arg "input"
                try {
                    val manager = ScriptEngineManager()
                    val engine = manager.getEngineByName("js")
                    val result = engine.eval(input)
                    message.channel.send(result.toString())
                } catch(e: Exception){
                    message.stackTrace(e)
                }
            }
        }
    }
}