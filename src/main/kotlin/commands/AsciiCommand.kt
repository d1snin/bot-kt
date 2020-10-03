package commands

import Command
import arg
import doesLater
import greedyString
import helpers.ShellHelper.bash

object AsciiCommand : Command("ascii") {
    init {
        greedyString("text") {
            doesLater { context ->
                val text: String = context arg "text"
                message.channel.send("```" + "figlet \"$text\"".bash().substring(0) + "```")
            }
        }
    }
}