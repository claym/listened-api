package io.listened.api.configuration;

import io.listened.api.delegate.PodcastSubmitDelegate;
import io.listened.api.delegate.PodcastUpdateDelegate;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Clay on 6/21/2015.
 */
@Configuration
@EnableRabbit
public class QueueConfig {

    public final static String podcastUpdateQueue = "job.podcast.refresh";
    public final static String podcastSubmitQueueName = "job.podcast.add";

    @Autowired
    PodcastSubmitDelegate podcastSubmitDelegate;

    @Autowired
    PodcastUpdateDelegate podcastUpdateDelegate;

    @Bean
    SimpleMessageListenerContainer podcastUpdateContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(podcastUpdateQueue);
        container.setMessageListener(new MessageListenerAdapter(podcastUpdateDelegate));
        return container;
    }

    @Bean
    SimpleMessageListenerContainer podcastSubmitContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(podcastSubmitQueueName);
        container.setMessageListener(new MessageListenerAdapter(podcastSubmitDelegate));
        return container;
    }

}
