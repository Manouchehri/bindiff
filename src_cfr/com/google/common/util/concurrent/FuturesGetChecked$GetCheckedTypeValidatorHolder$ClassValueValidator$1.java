/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FuturesGetChecked;

final class FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator$1
extends ClassValue {
    FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator$1() {
    }

    protected Boolean computeValue(Class class_) {
        FuturesGetChecked.checkExceptionClassValidity(class_.asSubclass(Exception.class));
        return true;
    }
}

