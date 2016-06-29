/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidator;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator$1;

enum FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator implements FuturesGetChecked$GetCheckedTypeValidator
{
    INSTANCE;
    
    private static final ClassValue isValidClass;

    private FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator() {
    }

    @Override
    public void validateClass(Class class_) {
        isValidClass.get(class_);
    }

    static {
        isValidClass = new FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator$1();
    }
}

