package com.google.common.util.concurrent;

enum FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator implements FuturesGetChecked$GetCheckedTypeValidator
{
    INSTANCE("INSTANCE", 0);
    
    private static final ClassValue isValidClass;
    
    private FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator(final String s, final int n) {
    }
    
    @Override
    public void validateClass(final Class clazz) {
        FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator.isValidClass.get(clazz);
    }
    
    static {
        isValidClass = new FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator$1();
    }
}
