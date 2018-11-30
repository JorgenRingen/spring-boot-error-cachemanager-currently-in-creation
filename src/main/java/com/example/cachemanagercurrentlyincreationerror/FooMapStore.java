package com.example.cachemanagercurrentlyincreationerror;

import java.util.Collection;
import java.util.Map;

import com.hazelcast.core.MapStore;

/**
 *
 */
public class FooMapStore implements MapStore<Long, Foo> {

    private final FooRepository fooRepository;

    public FooMapStore(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    @Override
    public void store(Long key, Foo value) {

    }

    @Override
    public void storeAll(Map<Long, Foo> map) {

    }

    @Override
    public void delete(Long key) {

    }

    @Override
    public void deleteAll(Collection<Long> keys) {

    }

    @Override
    public Foo load(Long key) {
        return null;
    }

    @Override
    public Map<Long, Foo> loadAll(Collection<Long> keys) {
        return null;
    }

    @Override
    public Iterable<Long> loadAllKeys() {
        return null;
    }
}
