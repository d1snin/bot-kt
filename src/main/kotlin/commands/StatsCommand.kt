package commands

import Colors
import Command
import helpers.ShellHelper.bash
import helpers.SystemHelper.formattedCpus
import doesLater

object StatsCommand : Command("stats") {
    init {
        doesLater {

            message.channel.send {
                embed {
                    field(
                        "TIME",
                        "date".bash(),
                        false
                    )
                    field(
                        "CPU",
                        formattedCpus(),
                        false
                    )
                    color = Colors.primary
                }
            }
        }
    }
}