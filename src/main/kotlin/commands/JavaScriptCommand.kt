package commands

import Command
import Permissions.hasPermission
import Send.normal
import arg
import doesLater
import greedyString
import helpers.ShellHelper.bash

object JavaScriptCommand : Command("js") {
    init {
        greedyString("cmd") {
            doesLater { context ->
                if (!message.hasPermission(PermissionTypes.ARCHIVE_CHANNEL)) return@doesLater
                var cmd: String = context arg "cmd"
                cmd = cmd.replace("''", "\"")
                val output = "```" + "echo \"$cmd\" > file.js && node file.js".bash() + "```"
                if (output.length > 6) {
                    message.normal(output)
                } else {
                    message.normal("Ran successfully")
                }
                "rm file.js".bash()
            }
        }
    }
}