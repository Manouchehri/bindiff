package com.google.common.util.concurrent;

import com.google.common.annotations.*;

@VisibleForTesting
class FuturesGetChecked$GetCheckedTypeValidatorHolder
{
    static final String CLASS_VALUE_VALIDATOR_NAME;
    static final FuturesGetChecked$GetCheckedTypeValidator BEST_VALIDATOR;
    
    static FuturesGetChecked$GetCheckedTypeValidator getBestValidator() {
        try {
            return (FuturesGetChecked$GetCheckedTypeValidator)Class.forName(FuturesGetChecked$GetCheckedTypeValidatorHolder.CLASS_VALUE_VALIDATOR_NAME).getEnumConstants()[0];
        }
        catch (Throwable t) {
            return FuturesGetChecked.weakSetValidator();
        }
    }
    
    static {
        CLASS_VALUE_VALIDATOR_NAME = String.valueOf(FuturesGetChecked$GetCheckedTypeValidatorHolder.class.getName()).concat("$ClassValueValidator");
        BEST_VALIDATOR = getBestValidator();
    }
}
