package com.google.common.math;

import java.math.*;

class LongMath$1
{
    static {
        $SwitchMap$java$math$RoundingMode = new int[RoundingMode.values().length];
        try {
            LongMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.UNNECESSARY.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            LongMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            LongMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            LongMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            LongMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            LongMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            LongMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            LongMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
    }
}
