package com.google.protobuf;

import java.util.*;

class MapField$ImmutableMessageConverter implements MapField$Converter
{
    private final MapEntry defaultEntry;
    
    public MapField$ImmutableMessageConverter(final MapEntry defaultEntry) {
        this.defaultEntry = defaultEntry;
    }
    
    public Message convertKeyAndValueToMessage(final Object key, final Object value) {
        return this.defaultEntry.newBuilderForType().setKey(key).setValue(value).buildPartial();
    }
    
    public void convertMessageToKeyAndValue(final Message message, final Map map) {
        final MapEntry mapEntry = (MapEntry)message;
        map.put(mapEntry.getKey(), mapEntry.getValue());
    }
    
    public Message getMessageDefaultInstance() {
        return this.defaultEntry;
    }
}
