package br.com.wellingtoncosta.bookms

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

/**
 * @author Wellington Costa on 14/05/18.
 */
@SpringBootApplication
class Application : SpringBootServletInitializer() {

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(Application::class.java)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<Application>(*args)
        }
    }

}