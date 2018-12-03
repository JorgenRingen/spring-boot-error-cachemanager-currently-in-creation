package com.example.cachemanagercurrentlyincreationerror;

import com.hazelcast.core.EntryView;
import com.hazelcast.core.IMap;

public class FooCacheHandler {

    private final IMap<Long, Foo> map;

    public FooCacheHandler(IMap<Long, Foo> map) {
        this.map = map;
    }

    public Object foo(Long id) {
        EntryView<Long, Foo> entryView = map.getEntryView(id);
        return null;
    }
}
