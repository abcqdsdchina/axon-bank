package org.axonframework.samples.bank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("distributed")
@Configuration
public class DistributedConfiguration {

}
