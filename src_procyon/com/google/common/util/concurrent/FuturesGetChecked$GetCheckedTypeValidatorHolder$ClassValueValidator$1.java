package com.google.common.util.concurrent;

final class FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator$1 extends ClassValue
{
    @Override
    protected Boolean computeValue(final Class clazz) {
        FuturesGetChecked.checkExceptionClassValidity(clazz.asSubclass(Exception.class));
        return true;
    }
}
