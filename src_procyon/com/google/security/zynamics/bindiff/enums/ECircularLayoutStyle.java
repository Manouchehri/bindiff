package com.google.security.zynamics.bindiff.enums;

public enum ECircularLayoutStyle
{
    COMPACT("COMPACT", 0), 
    ISOLATED("ISOLATED", 1), 
    SINGLE_CYCLE("SINGLE_CYCLE", 2);
    
    private ECircularLayoutStyle(final String s, final int n) {
    }
    
    public static ECircularLayoutStyle getEnum(final int n) {
        switch (n) {
            case 0: {
                return ECircularLayoutStyle.COMPACT;
            }
            case 1: {
                return ECircularLayoutStyle.ISOLATED;
            }
            case 2: {
                return ECircularLayoutStyle.SINGLE_CYCLE;
            }
            default: {
                throw new IllegalArgumentException("Unknown circular layout style.");
            }
        }
    }
    
    public static int getOrdinal(final ECircularLayoutStyle eCircularLayoutStyle) {
        switch (ECircularLayoutStyle$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ECircularLayoutStyle[eCircularLayoutStyle.ordinal()]) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            default: {
                throw new IllegalArgumentException("Unknown cicular layout style.");
            }
        }
    }
}
