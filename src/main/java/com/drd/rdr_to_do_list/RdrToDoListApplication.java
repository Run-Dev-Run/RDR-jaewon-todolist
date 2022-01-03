package com.drd.rdr_to_do_list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityListeners;

@EnableJpaAuditing
@EntityListeners({AuditingEntityListener.class})
@SpringBootApplication
public class RdrToDoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(RdrToDoListApplication.class, args);
    }

}
