package com.google.protobuf;

import java.util.*;

public class MapFieldLite implements MutabilityOracle
{
    private MapFieldLite$MutatabilityAwareMap mapData;
    private boolean isMutable;
    private static final MapFieldLite EMPTY_MAP_FIELD;
    
    private MapFieldLite(final Map map) {
        this.mapData = new MapFieldLite$MutatabilityAwareMap(this, map);
        this.isMutable = true;
    }
    
    public static MapFieldLite emptyMapField() {
        return MapFieldLite.EMPTY_MAP_FIELD;
    }
    
    public static MapFieldLite newMapField() {
        return new MapFieldLite(new LinkedHashMap());
    }
    
    public Map getMap() {
        return Collections.unmodifiableMap((Map<?, ?>)this.mapData);
    }
    
    public Map getMutableMap() {
        return this.mapData;
    }
    
    public void mergeFrom(final MapFieldLite mapFieldLite) {
        this.mapData.putAll(copy(mapFieldLite.mapData));
    }
    
    public void clear() {
        this.mapData.clear();
    }
    
    private static boolean equals(final Object o, final Object o2) {
        if (o instanceof byte[] && o2 instanceof byte[]) {
            return Arrays.equals((byte[])o, (byte[])o2);
        }
        return o.equals(o2);
    }
    
    static boolean equals(final Map map, final Map map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (final Map.Entry<Object, V> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey())) {
                return false;
            }
            if (!equals(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
    
    public boolean equals(final Object o) {
        return o instanceof MapFieldLite && equals(this.mapData, ((MapFieldLite)o).mapData);
    }
    
    private static int calculateHashCodeForObject(final Object o) {
        if (o instanceof byte[]) {
            return LiteralByteString.hashCode((byte[])o);
        }
        if (o instanceof Internal$EnumLite) {
            return Internal.hashEnum((Internal$EnumLite)o);
        }
        return o.hashCode();
    }
    
    static int calculateHashCodeForMap(final Map map) {
        int n = 0;
        for (final Map.Entry<Object, V> entry : map.entrySet()) {
            n += (calculateHashCodeForObject(entry.getKey()) ^ calculateHashCodeForObject(entry.getValue()));
        }
        return n;
    }
    
    public int hashCode() {
        return calculateHashCodeForMap(this.mapData);
    }
    
    private static Object copy(final Object o) {
        if (o instanceof byte[]) {
            final byte[] array = (byte[])o;
            return Arrays.copyOf(array, array.length);
        }
        return o;
    }
    
    static Map copy(final Map map) {
        final LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (final Map.Entry<Object, V> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), copy(entry.getValue()));
        }
        return linkedHashMap;
    }
    
    public MapFieldLite copy() {
        return new MapFieldLite(copy(this.mapData));
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
    
    static {
        (EMPTY_MAP_FIELD = new MapFieldLite(Collections.emptyMap())).makeImmutable();
    }
}
