package com.google.security.zynamics.bindiff.enums;

public enum EMatchState
{
    MATCHED("MATCHED", 0), 
    PRIMARY_UNMATCHED("PRIMARY_UNMATCHED", 1), 
    SECONDRAY_UNMATCHED("SECONDRAY_UNMATCHED", 2);
    
    private EMatchState(final String s, final int n) {
    }
    
    public static EMatchState getMatchState(final int n) {
        switch (n) {
            case 0: {
                return EMatchState.MATCHED;
            }
            case 1: {
                return EMatchState.PRIMARY_UNMATCHED;
            }
            case 2: {
                return EMatchState.SECONDRAY_UNMATCHED;
            }
            default: {
                throw new IllegalArgumentException("Unknown match state.");
            }
        }
    }
    
    public static int getOrdinal(final EMatchState eMatchState) {
        switch (EMatchState$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[eMatchState.ordinal()]) {
            case 1: {
                return 2;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 0;
            }
            default: {
                throw new IllegalArgumentException("Unknown match state type.");
            }
        }
    }
    
    @Override
    public String toString() {
        switch (EMatchState$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[this.ordinal()]) {
            case 3: {
                return "Matched";
            }
            case 2: {
                return "Primary Unmatched";
            }
            case 1: {
                return "Secondary Unmatched";
            }
            default: {
                throw new IllegalArgumentException("Unknown match state type.");
            }
        }
    }
}
