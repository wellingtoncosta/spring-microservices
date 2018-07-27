package br.com.wellingtoncosta.discovery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

/**
 * @author Wellington Costa on 14/05/18.
 */
@EnableEurekaServer
@SpringBootApplication
class ServiceDiscoveryApplication

fun main(args: Array<String>) {
    runApplication<ServiceDiscoveryApplication>(*args)
}