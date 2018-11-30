package com.example.cachemanagercurrentlyincreationerror;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@Configuration
@EnableCaching
public class CacheConfiguration {

    @Bean
    public FooMapStore fooMapStore(FooRepository fooRepository) {
        return new FooMapStore(fooRepository);
    }

    @Bean
    public Config config(FooMapStore fooMapStore) {
        Config config = new Config()
                .setInstanceName("testing");

        config.addMapConfig(new MapConfig()
                .setName("testing")
                .setMapStoreConfig(new MapStoreConfig()
                        .setImplementation(fooMapStore)));

        return config;
    }

    @Bean
    public HazelcastInstance hazelcastInstance(Config config) {
        return Hazelcast.getOrCreateHazelcastInstance(config);
    }

}
