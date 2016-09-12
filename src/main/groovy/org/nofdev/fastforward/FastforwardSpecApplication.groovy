package org.nofdev.fastforward

import groovy.transform.CompileStatic
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@CompileStatic
@ComponentScan(["org.nofdev.fastforward","org.nofdev"])
@SpringBootApplication
class fastforwardspecApplication {

    static void main(String[] args) {
        SpringApplication.run fastforwardspecApplication, args
    }
}
