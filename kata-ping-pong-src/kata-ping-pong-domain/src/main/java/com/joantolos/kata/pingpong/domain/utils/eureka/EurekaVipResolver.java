package com.joantolos.kata.pingpong.domain.utils.eureka;

import com.joantolos.kata.pingpong.domain.utils.eureka.entity.Environment;
import com.joantolos.kata.pingpong.domain.utils.eureka.entity.VipAddress;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EurekaVipResolver {

    private String eurekaHost;
    private RestTemplate restTemplate;

    public EurekaVipResolver(String eurekaHost) {
        this.eurekaHost = eurekaHost;
        this.restTemplate = new RestTemplate();
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<VipAddress> getAll(String serviceId) {
        ResponseEntity<Map> entityResponse = restTemplate.getForEntity(eurekaHost + "/eureka/apps/" + serviceId.toUpperCase(), Map.class);
        Map<String, Object> response = entityResponse.getBody();
        Map<String, Object> application = (Map<String, Object>) response.get("application");
        List<Map<String, Object>> instances = getInstances(application);

        return instances.stream().map(instance -> new VipAddress(
                Environment.get((String) instance.get("vipAddress")),
                this.resolveIp(instance, "public-ipv4"),
                this.resolveIp(instance, "local-ipv4"),
                (String) ((Map<String, Object>) instance.get("port")).get("$")
        )).collect(Collectors.toList());
    }

    public VipAddress getOne(String serviceId, Environment environment) {
        return this.getAll(serviceId).stream().filter(vipAddress -> vipAddress.getEnvironment().equals(environment)).findFirst().orElse(null);
    }

    public String getPublicURI(String serviceId, Environment environment) {
        VipAddress vipAddress = this.getOne(serviceId, environment);
        return "http://" + vipAddress.getPublicIP() + ":" + vipAddress.getPort();
    }

    public String getPrivateURI(String serviceId, Environment environment) {
        VipAddress vipAddress = this.getOne(serviceId, environment);
        return "http://" + vipAddress.getPrivateIP() + ":" + vipAddress.getPort();
    }

    private List<Map<String, Object>> getInstances(Map<String, Object> application) {
        List<Map<String, Object>> instances;
        try {
            instances = (List<Map<String, Object>>) application.get("instance");
        } catch(ClassCastException onlyOneInstanceException) {
            instances = new ArrayList<>();
            instances.add((Map<String, Object>) application.get("instance"));
        }
        return instances;
    }

    private String resolveIp(Map<String, Object> instance, String nature) {
        Map<String, Object> dataCenterInfo = (Map<String, Object>) instance.get("dataCenterInfo");
        Map<String, Object> metadata = (Map<String, Object>) dataCenterInfo.get("metadata");
        return (String) metadata.get(nature);
    }
}
