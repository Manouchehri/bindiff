/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints$ConstrainedList;
import java.util.List;
import java.util.RandomAccess;

class Constraints$ConstrainedRandomAccessList
extends Constraints$ConstrainedList
implements RandomAccess {
    Constraints$ConstrainedRandomAccessList(List list, Constraint constraint) {
        super(list, constraint);
    }
}

