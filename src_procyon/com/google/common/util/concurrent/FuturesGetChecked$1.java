package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.lang.reflect.*;
import java.util.*;

final class FuturesGetChecked$1 implements Function
{
    public Boolean apply(final Constructor constructor) {
        return Arrays.asList(constructor.getParameterTypes()).contains(String.class);
    }
}
