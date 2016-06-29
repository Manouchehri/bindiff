/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$ConstrainedMap;
import com.google.common.collect.MutableClassToInstanceMap$1;
import com.google.common.primitives.Primitives;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class MutableClassToInstanceMap
extends MapConstraints$ConstrainedMap
implements ClassToInstanceMap {
    private static final MapConstraint VALUE_CAN_BE_CAST_TO_KEY = new MutableClassToInstanceMap$1();
    private static final long serialVersionUID = 0;

    public static MutableClassToInstanceMap create() {
        return new MutableClassToInstanceMap(new HashMap());
    }

    public static MutableClassToInstanceMap create(Map map) {
        return new MutableClassToInstanceMap(map);
    }

    private MutableClassToInstanceMap(Map map) {
        super(map, VALUE_CAN_BE_CAST_TO_KEY);
    }

    @Override
    public Object putInstance(Class class_, Object object) {
        return MutableClassToInstanceMap.cast(class_, this.put(class_, object));
    }

    @Override
    public Object getInstance(Class class_) {
        return MutableClassToInstanceMap.cast(class_, this.get(class_));
    }

    private static Object cast(Class class_, Object object) {
        return Primitives.wrap(class_).cast(object);
    }

    static /* synthetic */ Object access$000(Class class_, Object object) {
        return MutableClassToInstanceMap.cast(class_, object);
    }
}

