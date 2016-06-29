/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.enums;

public enum EMouseAction {
    ZOOM,
    SCROLL;
    

    private EMouseAction() {
    }

    public static EMouseAction getEnum(int n2) {
        EMouseAction eMouseAction;
        if (n2 == 0) {
            eMouseAction = ZOOM;
            return eMouseAction;
        }
        eMouseAction = SCROLL;
        return eMouseAction;
    }

    public static int getOrdinal(EMouseAction eMouseAction) {
        if (eMouseAction != ZOOM) return 1;
        return 0;
    }
}

