package com.google.common.collect;

import java.lang.reflect.*;

final class Serialization$FieldSetter
{
    private final Field field;
    
    private Serialization$FieldSetter(final Field field) {
        (this.field = field).setAccessible(true);
    }
    
    void set(final Object o, final Object o2) {
        try {
            this.field.set(o, o2);
        }
        catch (IllegalAccessException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    void set(final Object o, final int n) {
        try {
            this.field.set(o, n);
        }
        catch (IllegalAccessException ex) {
            throw new AssertionError((Object)ex);
        }
    }
}
