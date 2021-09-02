package com.test.demo.sample.database;

import com.test.demo.sample.IConnect;

public class MySQL implements IConnect {

    private String ip;
    private Integer port;

    public MySQL(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void connect(){
        System.out.println(this.ip+":"+this.port);
    }
}
