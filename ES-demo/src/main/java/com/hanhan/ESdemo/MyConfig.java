package com.hanhan.ESdemo;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by James on 2019/4/30.
 */
@Configuration
public class MyConfig {

    @Bean
    public TransportClient client() throws UnknownHostException {

        Settings settings = Settings.builder().put("cluster.name", "logger").build();

        PreBuiltTransportClient client = new PreBuiltTransportClient(settings);

        int[] local_ports = {9300, 9301, 9302};
        for (int port : local_ports) {
            client.addTransportAddress(new TransportAddress(
                    InetAddress.getByName("localhost"), port
            ));
        }

        return client;

    }

}
