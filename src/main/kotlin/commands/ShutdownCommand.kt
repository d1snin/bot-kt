package commands

import Colors
import Command
import Main
import PermissionTypes
import Permissions.hasPermission
import doesLater

object ShutdownCommand : Command("shutdown") {
    init {
        doesLater {
            if (!message.hasPermission(PermissionTypes.REBOOT_BOT)) {
                return@doesLater
            }

            message.channel.send {
                embed {
                    title = "Shutting down..."
                    color = Colors.success
                }
            }
            Main.exit()
        }
    }
}