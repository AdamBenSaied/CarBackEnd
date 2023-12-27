package com.example.car;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MappingConfiguration {

    @Bean
    public Mapper mapper(@Value(value = "classpath*:mapping/*mapping.xml") Resource[] resourceArray) throws IOException {
        List<String> mappingFileUrlList = new ArrayList<>();
        mappingFileUrlList.add("dozerJdk8Converters.xml");

        for (Resource resource : resourceArray) {
            mappingFileUrlList.add(String.valueOf(resource.getURL()));
        }
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(mappingFileUrlList);
        return dozerBeanMapper;
    }
}
