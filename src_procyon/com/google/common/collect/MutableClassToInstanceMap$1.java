package com.google.common.collect;

import com.google.common.primitives.*;
import java.util.*;

final class MutableClassToInstanceMap$1 implements MapConstraint
{
    public void checkKeyValue(final Class clazz, final Object o) {
        cast(clazz, o);
    }
}
