package commands

import Command
import PermissionTypes
import Permissions.hasPermission
import Send.normal
import arg
import doesLater
import greedyString
import helpers.ShellHelper.bash

object BashCommand : Command("bash") {
    init {
        greedyString("cmd") {
            doesLater { context ->
                if (!message.hasPermission(PermissionTypes.ARCHIVE_CHANNEL)) {
                    return@doesLater
                }
                var cmd: String = context arg "cmd"
                cmd = cmd.replace("''", "\"")
                val output = "```" + cmd.bash() + "```"
                if (output.length > 6) {
                    message.normal(output)
                } else {
                    message.normal("Ran successfully")
                }
            }
        }
    }
}