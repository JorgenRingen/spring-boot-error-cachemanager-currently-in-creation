package com.example.cachemanagercurrentlyincreationerror;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
        throw new NotImplementedException();
    }

    @Override
    public void storeAll(Map<Long, Foo> map) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(Long key) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteAll(Collection<Long> keys) {
        throw new NotImplementedException();
    }

    @Override
    public Foo load(Long key) {
        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Foo> loadAll(Collection<Long> keys) {
        throw new NotImplementedException();
    }

    @Override
    public Iterable<Long> loadAllKeys() {
        throw new NotImplementedException();
    }
}
