package com.google.common.collect;

import com.google.common.primitives.*;
import java.util.*;

public final class MutableClassToInstanceMap extends MapConstraints$ConstrainedMap implements ClassToInstanceMap
{
    private static final MapConstraint VALUE_CAN_BE_CAST_TO_KEY;
    private static final long serialVersionUID = 0L;
    
    public static MutableClassToInstanceMap create() {
        return new MutableClassToInstanceMap(new HashMap());
    }
    
    public static MutableClassToInstanceMap create(final Map map) {
        return new MutableClassToInstanceMap(map);
    }
    
    private MutableClassToInstanceMap(final Map map) {
        super(map, MutableClassToInstanceMap.VALUE_CAN_BE_CAST_TO_KEY);
    }
    
    @Override
    public Object putInstance(final Class clazz, final Object o) {
        return cast(clazz, this.put(clazz, o));
    }
    
    @Override
    public Object getInstance(final Class clazz) {
        return cast(clazz, this.get(clazz));
    }
    
    private static Object cast(final Class clazz, final Object o) {
        return Primitives.wrap(clazz).cast(o);
    }
    
    static {
        VALUE_CAN_BE_CAST_TO_KEY = new MutableClassToInstanceMap$1();
    }
}
