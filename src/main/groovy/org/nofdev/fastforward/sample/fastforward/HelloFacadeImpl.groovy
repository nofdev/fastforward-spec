package org.nofdev.fastforward.sample.fastforward

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

/**
 *
 */
@Service
@Slf4j
@CompileStatic
class HelloFastforwardImpl implements HelloFastforward {
    @Override
    String hello(String something) {
        log.debug("Begin a hello.")
        return "Hello ${something}"
    }
}
