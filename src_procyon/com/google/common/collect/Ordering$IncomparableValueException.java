package com.google.common.collect;

import com.google.common.annotations.*;

@VisibleForTesting
class Ordering$IncomparableValueException extends ClassCastException
{
    final Object value;
    private static final long serialVersionUID = 0L;
    
    Ordering$IncomparableValueException(final Object value) {
        final String value2 = String.valueOf(value);
        super(new StringBuilder(22 + String.valueOf(value2).length()).append("Cannot compare value: ").append(value2).toString());
        this.value = value;
    }
}
