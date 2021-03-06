package org.kamiblue.botkt.command

import org.kamiblue.command.Command
import org.kamiblue.commons.interfaces.DisplayEnum
import java.util.*

enum class Category(
    override val displayName: String,
    val commands: TreeSet<Command<MessageExecuteEvent>> = TreeSet(compareBy { it.name })
) : DisplayEnum {
    FUN("Fun"),
    GITHUB("Github"),
    INFO("Info"),
    MISC("Misc"),
    MODERATION("Moderation"),
    SYSTEM("System");

    override fun toString(): String {
        return displayName
    }
}
