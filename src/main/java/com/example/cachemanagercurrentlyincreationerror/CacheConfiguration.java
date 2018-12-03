package com.example.cachemanagercurrentlyincreationerror;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@Configuration
@EnableCaching
public class CacheConfiguration {

    public static final String TEST_CACHE = "test-cache";

    @Bean
    public FooMapStore fooMapStore(FooRepository fooRepository) {
        return new FooMapStore(fooRepository);
    }

    @Bean
    public Config config() {
        Config config = new Config()
                .setInstanceName("testing");

        config.addMapConfig(new MapConfig()
                        .setName(TEST_CACHE)
                        .setMapStoreConfig(new MapStoreConfig()
                                .setWriteDelaySeconds(0)
                                .setImplementation(new FooMapStore(null))));

        return config;
    }

    @Bean
    public HazelcastInstance myHazelcastInstance(Config config) {
        HazelcastInstance hazelcastInstance = Hazelcast.getOrCreateHazelcastInstance(config);
        return hazelcastInstance;
    }

    @Bean
    public FooCacheHandler fooCacheHandler(HazelcastInstance myHazelcastInstance) {
        IMap<Long, Foo> map = myHazelcastInstance.getMap(TEST_CACHE);
        try {
            map.put(1L, new Foo());
        } catch (Exception e) {
            System.err.println("CacheConfiguration.fooCacheHandler failed to put!");
        }
        return new FooCacheHandler(map);
    }

}
