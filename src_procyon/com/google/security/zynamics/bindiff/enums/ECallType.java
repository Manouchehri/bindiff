package com.google.security.zynamics.bindiff.enums;

public enum ECallType
{
    NORMAL("NORMAL", 0), 
    LIBRARY("LIBRARY", 1), 
    THUNK("THUNK", 2), 
    IMPORTED("IMPORTED", 3), 
    UNKNOWN("UNKNOWN", 4), 
    MIXED("MIXED", 5);
    
    private ECallType(final String s, final int n) {
    }
    
    public static int getOrdinal(final ECallType eCallType) {
        switch (ECallType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ECallType[eCallType.ordinal()]) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 3;
            }
            case 5: {
                return 4;
            }
            case 6: {
                return 5;
            }
            default: {
                throw new IllegalArgumentException("Unknown raw call type.");
            }
        }
    }
    
    public static ECallType getType(final int n) {
        switch (n) {
            case 0: {
                return ECallType.NORMAL;
            }
            case 1: {
                return ECallType.LIBRARY;
            }
            case 2: {
                return ECallType.THUNK;
            }
            case 3: {
                return ECallType.IMPORTED;
            }
            case 4: {
                return ECallType.UNKNOWN;
            }
            case 5: {
                return ECallType.MIXED;
            }
            default: {
                throw new IllegalArgumentException("Unknown raw call type.");
            }
        }
    }
    
    @Override
    public String toString() {
        switch (ECallType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ECallType[this.ordinal()]) {
            case 1: {
                return "Normal";
            }
            case 2: {
                return "Library";
            }
            case 3: {
                return "Thunk";
            }
            case 4: {
                return "Imported";
            }
            case 5: {
                return "Unknown";
            }
            case 6: {
                return "Mixed Call Match";
            }
            default: {
                throw new IllegalArgumentException("Unknown raw call type.");
            }
        }
    }
}
