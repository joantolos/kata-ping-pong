package com.joantolos.kata.pingpong.domain.utils.eureka;

import com.joantolos.kata.pingpong.domain.utils.JsonUtils;
import com.joantolos.kata.pingpong.domain.utils.StringUtils;
import com.joantolos.kata.pingpong.domain.utils.eureka.entity.Environment;
import com.joantolos.kata.pingpong.domain.utils.eureka.entity.VipAddress;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EurekaVipResolverTest {

//    private EurekaVipResolver resolver;
//
//    @Before
//    public void setUp() throws IOException {
//        RestTemplate mockedRestTemplate = Mockito.spy(new RestTemplate());
//
//        ResponseEntity pingPongEurekaEntityResponse = new ResponseEntity(
//                JsonUtils.toClass(
//                        StringUtils.toString(this.getClass().getResourceAsStream("/pingPongEurekaEntityResponse.json")),
//                        Map.class),
//                HttpStatus.ACCEPTED);
//
//        Mockito.doReturn(pingPongEurekaEntityResponse)
//                .when(mockedRestTemplate).getForEntity( "http://unit-test-eureka-host:8080/eureka/apps/PINGPONG", Map.class);
//
//        this.resolver = new EurekaVipResolver("http://unit-test-eureka-host:8080");
//        this.resolver.setRestTemplate(mockedRestTemplate);
//    }
//
//    @Test
//    public void shouldProvideFiveVipAddresses() {
//        Assert.assertEquals(5, resolver.getAll("PINGPONG").size());
//    }
//
//    @Test
//    public void shouldProvideOneVipAddressForSnapshot() {
//        Assert.assertNotNull(resolver.getOne("PINGPONG", Environment.SNAPSHOT));
//    }
//
//    @Test
//    public void shouldProvideOneVipAddressesWhenOnlyOneInstance() {
//        Assert.assertEquals(1, resolver.getAll("PINGPONG").size());
//    }
//
//    @Test
//    public void lsSearchShouldHavePublicIpForSnapshot() {
//        Assert.assertNotNull(resolver.getAll("PINGPONG").get(0).getPublicIP());
//    }
//
//    @Test
//    public void lsSearchShouldHavePrivateIpForSnapshot() {
//        Assert.assertNotNull(resolver.getAll("PINGPONG").get(0).getPrivateIP());
//    }
//
//    @Test
//    public void lsSearchShouldHavePortForSnapshot() {
//        Assert.assertNotNull(resolver.getAll("PINGPONG").get(0).getPort());
//    }
//
//    @Test
//    public void shouldProvideThreeVipAddressesForPerfEnvironment() {
//        List<VipAddress> vipAddresses = resolver.getAll("PINGPONG");
//        Assert.assertEquals(new Long(3), vipAddresses.stream()
//                .collect(Collectors.groupingBy(VipAddress::getEnvironment, Collectors.counting()))
//                .get(Environment.PERF));
//    }
//
//    @Test
//    public void shouldProvideOneVipAddressesForSnapshotEnvironment() {
//        List<VipAddress> vipAddresses = resolver.getAll("PINGPONG");
//        Assert.assertEquals(new Long(1), vipAddresses.stream()
//                .collect(Collectors.groupingBy(VipAddress::getEnvironment, Collectors.counting()))
//                .get(Environment.SNAPSHOT));
//    }
//
//    @Test
//    public void shouldProvideOneVipAddressesForStableEnvironment() {
//        List<VipAddress> vipAddresses = resolver.getAll("PINGPONG");
//        Assert.assertEquals(new Long(1), vipAddresses.stream()
//                .collect(Collectors.groupingBy(VipAddress::getEnvironment, Collectors.counting()))
//                .get(Environment.STABLE));
//    }
//
//    @Test
//    public void shouldReturnPublicIP() {
//        Assert.assertEquals("http://54.188.98.167:7001", resolver.getPublicURI("PINGPONG", Environment.SNAPSHOT));
//    }
//
//    @Test
//    public void shouldReturnPrivateIP() {
//        Assert.assertEquals("http://172.30.117.146:7001", resolver.getPrivateURI("PINGPONG", Environment.SNAPSHOT));
//    }
}
