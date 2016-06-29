package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public interface Weigher {
   int weigh(Object var1, Object var2);
}
