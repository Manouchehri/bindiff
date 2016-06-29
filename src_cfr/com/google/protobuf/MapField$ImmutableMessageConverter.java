/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.MapEntry;
import com.google.protobuf.MapEntry$Builder;
import com.google.protobuf.MapField$Converter;
import com.google.protobuf.Message;
import java.util.Map;

class MapField$ImmutableMessageConverter
implements MapField$Converter {
    private final MapEntry defaultEntry;

    public MapField$ImmutableMessageConverter(MapEntry mapEntry) {
        this.defaultEntry = mapEntry;
    }

    @Override
    public Message convertKeyAndValueToMessage(Object object, Object object2) {
        return this.defaultEntry.newBuilderForType().setKey(object).setValue(object2).buildPartial();
    }

    @Override
    public void convertMessageToKeyAndValue(Message message, Map map) {
        MapEntry mapEntry = (MapEntry)message;
        map.put(mapEntry.getKey(), mapEntry.getValue());
    }

    @Override
    public Message getMessageDefaultInstance() {
        return this.defaultEntry;
    }
}

