package com.joantolos.kata.pingpong.domain.utils.eureka.entity;

public class VipAddress {

    private Environment environment;
    private String publicIP;
    private String privateIP;
    private String port;

    public VipAddress(Environment environment, String publicIP, String privateIP, String port) {
        this.environment = environment;
        this.publicIP = publicIP;
        this.privateIP = privateIP;
        this.port = port;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public String getPublicIP() {
        return publicIP;
    }

    public String getPrivateIP() {
        return privateIP;
    }

    public String getPort() {
        return port;
    }
}
