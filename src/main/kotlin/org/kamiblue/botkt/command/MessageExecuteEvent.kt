package org.kamiblue.botkt.command

import net.ayataka.kordis.entity.server.Server
import net.ayataka.kordis.event.events.message.MessageEvent
import net.ayataka.kordis.event.events.message.MessageReceiveEvent
import org.kamiblue.command.ArgIdentifier
import org.kamiblue.command.ExecuteEvent

class MessageExecuteEvent (
    args: Array<String>,
    event: MessageReceiveEvent
) : ExecuteEvent(CommandManager, args), MessageEvent {

    override val server: Server? = event.server
    val message = event.message

    fun ArgIdentifier<Long>.getChannelOrNull() = server?.channels?.find(this.value)

}