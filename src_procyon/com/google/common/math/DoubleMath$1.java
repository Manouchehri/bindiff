package com.google.common.math;

import java.math.*;

class DoubleMath$1
{
    static {
        $SwitchMap$java$math$RoundingMode = new int[RoundingMode.values().length];
        try {
            DoubleMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.UNNECESSARY.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            DoubleMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            DoubleMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            DoubleMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            DoubleMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            DoubleMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            DoubleMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            DoubleMath$1.$SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
    }
}
