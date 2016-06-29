package com.google.common.util.concurrent;

import java.lang.ref.*;
import java.util.*;
import java.util.concurrent.*;

enum FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator implements FuturesGetChecked$GetCheckedTypeValidator
{
    INSTANCE("INSTANCE", 0);
    
    private static final Set validClasses;
    
    private FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator(final String s, final int n) {
    }
    
    @Override
    public void validateClass(final Class clazz) {
        final Iterator<WeakReference<Object>> iterator = FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator.validClasses.iterator();
        while (iterator.hasNext()) {
            if (clazz.equals(iterator.next().get())) {
                return;
            }
        }
        FuturesGetChecked.checkExceptionClassValidity(clazz);
        if (FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator.validClasses.size() > 1000) {
            FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator.validClasses.clear();
        }
        FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator.validClasses.add(new WeakReference<Class>(clazz));
    }
    
    static {
        validClasses = new CopyOnWriteArraySet();
    }
}
