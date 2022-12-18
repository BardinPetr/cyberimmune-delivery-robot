package ru.bardinpetr.delivery.robot.communication;

import ru.bardinpetr.delivery.libs.messages.kafka.CommonKafkaConfiguration;
import ru.bardinpetr.delivery.libs.messages.kafka.consumers.MonitoredKafkaConsumerFactory;
import ru.bardinpetr.delivery.libs.messages.kafka.producers.MonitoredKafkaProducerFactory;
import ru.bardinpetr.delivery.libs.messages.msg.location.PositionReply;
import ru.bardinpetr.delivery.robot.communication.client.CommHTTPClientService;
import ru.bardinpetr.delivery.robot.communication.server.CommHTTPServerService;

import java.util.List;

import static ru.bardinpetr.delivery.robot.communication.MainService.SERVICE_NAME;

public class Main {
    public static void main(String[] args) {
        var kafkaConfig = CommonKafkaConfiguration.getKafkaGlobalParams(
                Configuration.getKafkaURI(),
                SERVICE_NAME
        );
        var producerFactory = new MonitoredKafkaProducerFactory(kafkaConfig);
        var consumerFactory = new MonitoredKafkaConsumerFactory(kafkaConfig);

        var serverService = new CommHTTPServerService(9990);
        var clientService = new CommHTTPClientService(Configuration.getServerURI());

        var service = new MainService(
                consumerFactory, producerFactory,
                serverService, clientService,
                List.of(PositionReply.class)
        );
        service.start();
    }
}
