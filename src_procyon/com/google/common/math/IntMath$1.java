package com.google.common.math;

import java.math.*;

class IntMath$1
{
    static {
        $SwitchMap$java$math$RoundingMode = new int[RoundingMode.values().length];
        try {
            IntMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.UNNECESSARY.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            IntMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            IntMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            IntMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            IntMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            IntMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            IntMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            IntMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
    }
}
