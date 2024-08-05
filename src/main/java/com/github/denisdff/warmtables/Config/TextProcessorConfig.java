package com.github.denisdff.warmtables.Config;

import org.kefirsf.bb.BBProcessorFactory;
import org.kefirsf.bb.TextProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TextProcessorConfig {
    @Bean
    public TextProcessor bbCodeProcessor() {
        TextProcessor processor = BBProcessorFactory.getInstance().create();
        System.out.println("TextProcessor bean created: " + processor);
        return processor;
    }
}
