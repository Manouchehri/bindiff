/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField$Converter;
import com.google.protobuf.MapField$ImmutableMessageConverter;
import com.google.protobuf.MapField$StorageMode;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MapFieldLite$MutatabilityAwareMap;
import com.google.protobuf.Message;
import com.google.protobuf.MutabilityOracle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapField
implements MutabilityOracle {
    private volatile boolean isMutable;
    private volatile MapField$StorageMode mode;
    private MapFieldLite$MutatabilityAwareMap mapData;
    private List listData;
    private final MapField$Converter converter;

    private MapField(MapField$Converter mapField$Converter, MapField$StorageMode mapField$StorageMode, Map map) {
        this.converter = mapField$Converter;
        this.isMutable = true;
        this.mode = mapField$StorageMode;
        this.mapData = new MapFieldLite$MutatabilityAwareMap(this, map);
        this.listData = null;
    }

    private MapField(MapEntry mapEntry, MapField$StorageMode mapField$StorageMode, Map map) {
        this(new MapField$ImmutableMessageConverter(mapEntry), mapField$StorageMode, map);
    }

    public static MapField emptyMapField(MapEntry mapEntry) {
        return new MapField(mapEntry, MapField$StorageMode.MAP, Collections.emptyMap());
    }

    public static MapField newMapField(MapEntry mapEntry) {
        return new MapField(mapEntry, MapField$StorageMode.MAP, new LinkedHashMap());
    }

    private Message convertKeyAndValueToMessage(Object object, Object object2) {
        return this.converter.convertKeyAndValueToMessage(object, object2);
    }

    private void convertMessageToKeyAndValue(Message message, Map map) {
        this.converter.convertMessageToKeyAndValue(message, map);
    }

    private List convertMapToList(MapFieldLite$MutatabilityAwareMap mapFieldLite$MutatabilityAwareMap) {
        ArrayList<Message> arrayList = new ArrayList<Message>();
        Iterator iterator = mapFieldLite$MutatabilityAwareMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            arrayList.add(this.convertKeyAndValueToMessage(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    private MapFieldLite$MutatabilityAwareMap convertListToMap(List list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Message message = (Message)iterator.next();
            this.convertMessageToKeyAndValue(message, linkedHashMap);
        }
        return new MapFieldLite$MutatabilityAwareMap(this, linkedHashMap);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Map getMap() {
        if (this.mode != MapField$StorageMode.LIST) return Collections.unmodifiableMap(this.mapData);
        MapField mapField = this;
        synchronized (mapField) {
            if (this.mode != MapField$StorageMode.LIST) return Collections.unmodifiableMap(this.mapData);
            this.mapData = this.convertListToMap(this.listData);
            this.mode = MapField$StorageMode.BOTH;
            return Collections.unmodifiableMap(this.mapData);
        }
    }

    public Map getMutableMap() {
        if (this.mode == MapField$StorageMode.MAP) return this.mapData;
        if (this.mode == MapField$StorageMode.LIST) {
            this.mapData = this.convertListToMap(this.listData);
        }
        this.listData = null;
        this.mode = MapField$StorageMode.MAP;
        return this.mapData;
    }

    public void mergeFrom(MapField mapField) {
        this.getMutableMap().putAll(MapFieldLite.copy(mapField.getMap()));
    }

    public void clear() {
        this.mapData = new MapFieldLite$MutatabilityAwareMap(this, new LinkedHashMap());
        this.mode = MapField$StorageMode.MAP;
    }

    public boolean equals(Object object) {
        if (!(object instanceof MapField)) {
            return false;
        }
        MapField mapField = (MapField)object;
        return MapFieldLite.equals(this.getMap(), mapField.getMap());
    }

    public int hashCode() {
        return MapFieldLite.calculateHashCodeForMap(this.getMap());
    }

    public MapField copy() {
        return new MapField(this.converter, MapField$StorageMode.MAP, MapFieldLite.copy(this.getMap()));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    List getList() {
        if (this.mode != MapField$StorageMode.MAP) return Collections.unmodifiableList(this.listData);
        MapField mapField = this;
        synchronized (mapField) {
            if (this.mode != MapField$StorageMode.MAP) return Collections.unmodifiableList(this.listData);
            this.listData = this.convertMapToList(this.mapData);
            this.mode = MapField$StorageMode.BOTH;
            return Collections.unmodifiableList(this.listData);
        }
    }

    List getMutableList() {
        if (this.mode == MapField$StorageMode.LIST) return this.listData;
        if (this.mode == MapField$StorageMode.MAP) {
            this.listData = this.convertMapToList(this.mapData);
        }
        this.mapData = null;
        this.mode = MapField$StorageMode.LIST;
        return this.listData;
    }

    Message getMapEntryMessageDefaultInstance() {
        return this.converter.getMessageDefaultInstance();
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    @Override
    public void ensureMutable() {
        if (this.isMutable()) return;
        throw new UnsupportedOperationException();
    }
}

