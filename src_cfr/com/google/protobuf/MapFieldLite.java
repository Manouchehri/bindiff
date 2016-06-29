/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Internal;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.LiteralByteString;
import com.google.protobuf.MapFieldLite$MutatabilityAwareMap;
import com.google.protobuf.MutabilityOracle;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MapFieldLite
implements MutabilityOracle {
    private MapFieldLite$MutatabilityAwareMap mapData;
    private boolean isMutable;
    private static final MapFieldLite EMPTY_MAP_FIELD = new MapFieldLite(Collections.emptyMap());

    private MapFieldLite(Map map) {
        this.mapData = new MapFieldLite$MutatabilityAwareMap(this, map);
        this.isMutable = true;
    }

    public static MapFieldLite emptyMapField() {
        return EMPTY_MAP_FIELD;
    }

    public static MapFieldLite newMapField() {
        return new MapFieldLite(new LinkedHashMap());
    }

    public Map getMap() {
        return Collections.unmodifiableMap(this.mapData);
    }

    public Map getMutableMap() {
        return this.mapData;
    }

    public void mergeFrom(MapFieldLite mapFieldLite) {
        this.mapData.putAll(MapFieldLite.copy(mapFieldLite.mapData));
    }

    public void clear() {
        this.mapData.clear();
    }

    private static boolean equals(Object object, Object object2) {
        if (!(object instanceof byte[])) return object.equals(object2);
        if (!(object2 instanceof byte[])) return object.equals(object2);
        return Arrays.equals((byte[])object, (byte[])object2);
    }

    static boolean equals(Map map, Map map2) {
        Map.Entry entry;
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        Iterator iterator = map.entrySet().iterator();
        do {
            if (!iterator.hasNext()) return true;
            entry = iterator.next();
            if (map2.containsKey(entry.getKey())) continue;
            return false;
        } while (MapFieldLite.equals(entry.getValue(), map2.get(entry.getKey())));
        return false;
    }

    public boolean equals(Object object) {
        if (!(object instanceof MapFieldLite)) {
            return false;
        }
        MapFieldLite mapFieldLite = (MapFieldLite)object;
        return MapFieldLite.equals(this.mapData, mapFieldLite.mapData);
    }

    private static int calculateHashCodeForObject(Object object) {
        if (object instanceof byte[]) {
            return LiteralByteString.hashCode((byte[])object);
        }
        if (!(object instanceof Internal$EnumLite)) return object.hashCode();
        return Internal.hashEnum((Internal$EnumLite)object);
    }

    static int calculateHashCodeForMap(Map map) {
        int n2 = 0;
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            n2 += MapFieldLite.calculateHashCodeForObject(entry.getKey()) ^ MapFieldLite.calculateHashCodeForObject(entry.getValue());
        }
        return n2;
    }

    public int hashCode() {
        return MapFieldLite.calculateHashCodeForMap(this.mapData);
    }

    private static Object copy(Object object) {
        if (!(object instanceof byte[])) return object;
        byte[] arrby = (byte[])object;
        return Arrays.copyOf(arrby, arrby.length);
    }

    static Map copy(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            linkedHashMap.put(entry.getKey(), MapFieldLite.copy(entry.getValue()));
        }
        return linkedHashMap;
    }

    public MapFieldLite copy() {
        return new MapFieldLite(MapFieldLite.copy(this.mapData));
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

    static {
        EMPTY_MAP_FIELD.makeImmutable();
    }
}

