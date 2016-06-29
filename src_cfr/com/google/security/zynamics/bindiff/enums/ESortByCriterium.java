/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.enums;

import com.google.security.zynamics.bindiff.enums.ESortByCriterium$1;

public enum ESortByCriterium {
    NONE,
    ADDRESS,
    FUNCTIONTYPE,
    SIDE,
    MATCHSTATE,
    SELECTION,
    VISIBILITY,
    FUNCTIONNAME;
    
    private static final String SORT_CRITERIUM_NONE = "None";
    private static final String SORT_CRITERIUM_ADDRESS = "Address";
    private static final String SORT_CRITERIUM_FUNCTIONTYPE = "Function Type";
    private static final String SORT_CRITERIUM_SIDE = "Side";
    private static final String SORT_CRITERIUM_MATCHSTATE = "Match State";
    private static final String SORT_CRITERIUM_SELECTION = "Selection";
    private static final String SORT_CRITERIUM_VISIBILITY = "Visibility";
    private static final String SORT_CRITERIUM_FUNCTIONNAME = "Function Name";

    private ESortByCriterium() {
    }

    public static ESortByCriterium toSortCriterium(String string) {
        if ("Address".equals(string)) {
            return ADDRESS;
        }
        if ("Function Type".equals(string)) {
            return FUNCTIONTYPE;
        }
        if ("Side".equals(string)) {
            return SIDE;
        }
        if ("Match State".equals(string)) {
            return MATCHSTATE;
        }
        if ("Selection".equals(string)) {
            return SELECTION;
        }
        if ("Visibility".equals(string)) {
            return VISIBILITY;
        }
        if (!"Function Name".equals(string)) return NONE;
        return FUNCTIONNAME;
    }

    public String toString() {
        switch (ESortByCriterium$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ESortByCriterium[this.ordinal()]) {
            case 1: {
                return "None";
            }
            case 2: {
                return "Address";
            }
            case 3: {
                return "Function Type";
            }
            case 4: {
                return "Side";
            }
            case 5: {
                return "Match State";
            }
            case 6: {
                return "Selection";
            }
            case 7: {
                return "Visibility";
            }
            case 8: {
                return "Function Name";
            }
        }
        return "None";
    }
}

