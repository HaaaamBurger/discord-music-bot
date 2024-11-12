package org.sourcebot.djksyonzbot.bot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.sourcebot.djksyonzbot.common.types.Commands;
import org.springframework.stereotype.Component;

@Component
public class SourceBot extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }


        if (event.getMessage().getContentDisplay().equals(Commands.PLAY.getCommand())) {
            event.getChannel().sendMessage("Lets play a music!").queue();
        }

//        event.getChannel()
//                .sendMessage(event.getMessage().getContentDisplay())
//                .queue();
    }
}
