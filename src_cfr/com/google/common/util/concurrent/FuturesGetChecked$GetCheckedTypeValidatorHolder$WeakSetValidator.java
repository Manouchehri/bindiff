/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FuturesGetChecked;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidator;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

enum FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator implements FuturesGetChecked$GetCheckedTypeValidator
{
    INSTANCE;
    
    private static final Set validClasses;

    private FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator() {
    }

    @Override
    public void validateClass(Class class_) {
        for (WeakReference weakReference : validClasses) {
            if (!class_.equals(weakReference.get())) continue;
            return;
        }
        FuturesGetChecked.checkExceptionClassValidity(class_);
        if (validClasses.size() > 1000) {
            validClasses.clear();
        }
        validClasses.add(new WeakReference<Class>(class_));
    }

    static {
        validClasses = new CopyOnWriteArraySet();
    }
}

