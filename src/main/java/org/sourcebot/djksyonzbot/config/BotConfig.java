package org.sourcebot.djksyonzbot.config;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.sourcebot.djksyonzbot.bot.SourceBot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BotConfig {

    @Value("${discord.bot.security.token}")
    private String API_TOKEN;

    @Value("${discord.bot.common.activity-message}")
    private String ACTIVITY_MESSAGE;

    @Bean
    public JDA jda(SourceBot sourceBot) {
        JDABuilder jdaBuilder = JDABuilder.createDefault(API_TOKEN);
        jdaBuilder
                .addEventListeners(sourceBot)
                .enableIntents(
                        List.of(
                                GatewayIntent.GUILD_MESSAGES,
                                GatewayIntent.MESSAGE_CONTENT
                        )
                )
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setActivity(Activity.listening(ACTIVITY_MESSAGE))
        ;
        return jdaBuilder.build();
    }

}
