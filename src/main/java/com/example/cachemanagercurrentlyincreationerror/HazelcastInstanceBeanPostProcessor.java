package com.example.cachemanagercurrentlyincreationerror;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.HazelcastInstance;

import static com.example.cachemanagercurrentlyincreationerror.CacheConfiguration.TEST_CACHE;

@Component
public class HazelcastInstanceBeanPostProcessor implements BeanPostProcessor {

    private final FooMapStore fooMapStore;

    @Autowired
    public HazelcastInstanceBeanPostProcessor(FooMapStore fooMapStore) {
        this.fooMapStore = fooMapStore;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        if (bean.getClass().equals(HazelcastInstance.class)) {
//            HazelcastInstance myHazelcastInstance = (HazelcastInstance) bean;
//            myHazelcastInstance.getConfig()
//                    .addMapConfig(new MapConfig()
//                            .setName(TEST_CACHE)
//                            .setMapStoreConfig(new MapStoreConfig()
//                                    .setImplementation(fooMapStore)));
//        }
        return bean;
    }
}
