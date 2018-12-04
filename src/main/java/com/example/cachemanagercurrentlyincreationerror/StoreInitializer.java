package com.example.cachemanagercurrentlyincreationerror;

import javax.annotation.PostConstruct;

import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.HazelcastInstance;

import org.springframework.stereotype.Component;

/**
 * A simple initializer that configures a JPA-dependent store.
 *
 * @author Stephane Nicoll
 */
@Component
class StoreInitializer {

	private final FooMapStore fooMapStore;

	private final HazelcastInstance hazelcastInstance;

	public StoreInitializer(FooMapStore fooMapStore, HazelcastInstance hazelcastInstance) {
		this.fooMapStore = fooMapStore;
		this.hazelcastInstance = hazelcastInstance;
	}

	@PostConstruct
	public void initializeStore() {
		this.hazelcastInstance.getConfig().addMapConfig(new MapConfig()
				.setName("testing")
				.setMapStoreConfig(new MapStoreConfig()
						.setImplementation(fooMapStore)));
	}
}
