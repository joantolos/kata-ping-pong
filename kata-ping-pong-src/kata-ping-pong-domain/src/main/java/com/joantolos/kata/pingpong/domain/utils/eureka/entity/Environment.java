package com.joantolos.kata.pingpong.domain.utils.eureka.entity;

public enum Environment {

    SNAPSHOT,
    STABLE,
    PERF;

    public static Environment get(String vipAddressId) {
        return vipAddressId.contains("perf") ? Environment.PERF :
                vipAddressId.contains("snapshot") ? Environment.SNAPSHOT :
                        vipAddressId.contains("stable") ? Environment.STABLE : null;
    }
}
