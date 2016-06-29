package com.google.protobuf;

import java.util.*;

public class MapField implements MutabilityOracle
{
    private volatile boolean isMutable;
    private volatile MapField$StorageMode mode;
    private MapFieldLite$MutatabilityAwareMap mapData;
    private List listData;
    private final MapField$Converter converter;
    
    private MapField(final MapField$Converter converter, final MapField$StorageMode mode, final Map map) {
        this.converter = converter;
        this.isMutable = true;
        this.mode = mode;
        this.mapData = new MapFieldLite$MutatabilityAwareMap(this, map);
        this.listData = null;
    }
    
    private MapField(final MapEntry mapEntry, final MapField$StorageMode mapField$StorageMode, final Map map) {
        this(new MapField$ImmutableMessageConverter(mapEntry), mapField$StorageMode, map);
    }
    
    public static MapField emptyMapField(final MapEntry mapEntry) {
        return new MapField(mapEntry, MapField$StorageMode.MAP, Collections.emptyMap());
    }
    
    public static MapField newMapField(final MapEntry mapEntry) {
        return new MapField(mapEntry, MapField$StorageMode.MAP, new LinkedHashMap());
    }
    
    private Message convertKeyAndValueToMessage(final Object o, final Object o2) {
        return this.converter.convertKeyAndValueToMessage(o, o2);
    }
    
    private void convertMessageToKeyAndValue(final Message message, final Map map) {
        this.converter.convertMessageToKeyAndValue(message, map);
    }
    
    private List convertMapToList(final MapFieldLite$MutatabilityAwareMap mapFieldLite$MutatabilityAwareMap) {
        final ArrayList<Message> list = new ArrayList<Message>();
        for (final Map.Entry<Object, V> entry : mapFieldLite$MutatabilityAwareMap.entrySet()) {
            list.add(this.convertKeyAndValueToMessage(entry.getKey(), entry.getValue()));
        }
        return list;
    }
    
    private MapFieldLite$MutatabilityAwareMap convertListToMap(final List list) {
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final Iterator<Message> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.convertMessageToKeyAndValue(iterator.next(), linkedHashMap);
        }
        return new MapFieldLite$MutatabilityAwareMap(this, linkedHashMap);
    }
    
    public Map getMap() {
        if (this.mode == MapField$StorageMode.LIST) {
            synchronized (this) {
                if (this.mode == MapField$StorageMode.LIST) {
                    this.mapData = this.convertListToMap(this.listData);
                    this.mode = MapField$StorageMode.BOTH;
                }
            }
        }
        return Collections.unmodifiableMap((Map<?, ?>)this.mapData);
    }
    
    public Map getMutableMap() {
        if (this.mode != MapField$StorageMode.MAP) {
            if (this.mode == MapField$StorageMode.LIST) {
                this.mapData = this.convertListToMap(this.listData);
            }
            this.listData = null;
            this.mode = MapField$StorageMode.MAP;
        }
        return this.mapData;
    }
    
    public void mergeFrom(final MapField mapField) {
        this.getMutableMap().putAll(MapFieldLite.copy(mapField.getMap()));
    }
    
    public void clear() {
        this.mapData = new MapFieldLite$MutatabilityAwareMap(this, new LinkedHashMap());
        this.mode = MapField$StorageMode.MAP;
    }
    
    public boolean equals(final Object o) {
        return o instanceof MapField && MapFieldLite.equals(this.getMap(), ((MapField)o).getMap());
    }
    
    public int hashCode() {
        return MapFieldLite.calculateHashCodeForMap(this.getMap());
    }
    
    public MapField copy() {
        return new MapField(this.converter, MapField$StorageMode.MAP, MapFieldLite.copy(this.getMap()));
    }
    
    List getList() {
        if (this.mode == MapField$StorageMode.MAP) {
            synchronized (this) {
                if (this.mode == MapField$StorageMode.MAP) {
                    this.listData = this.convertMapToList(this.mapData);
                    this.mode = MapField$StorageMode.BOTH;
                }
            }
        }
        return Collections.unmodifiableList((List<?>)this.listData);
    }
    
    List getMutableList() {
        if (this.mode != MapField$StorageMode.LIST) {
            if (this.mode == MapField$StorageMode.MAP) {
                this.listData = this.convertMapToList(this.mapData);
            }
            this.mapData = null;
            this.mode = MapField$StorageMode.LIST;
        }
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
    
    public void ensureMutable() {
        if (!this.isMutable()) {
            throw new UnsupportedOperationException();
        }
    }
}
