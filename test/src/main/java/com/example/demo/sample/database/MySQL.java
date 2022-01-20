package com.example.demo.sample.database;

import com.example.demo.sample.IConnect;
import org.springframework.stereotype.Component;

import java.awt.*;


public class MySQL implements IConnect {
    private String ip;
    private Integer port;

    public MySQL(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void connect() {
        System.out.println(this.ip + ":" + this.port);
    }
}
