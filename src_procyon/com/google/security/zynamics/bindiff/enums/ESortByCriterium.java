package com.google.security.zynamics.bindiff.enums;

public enum ESortByCriterium
{
    NONE("NONE", 0), 
    ADDRESS("ADDRESS", 1), 
    FUNCTIONTYPE("FUNCTIONTYPE", 2), 
    SIDE("SIDE", 3), 
    MATCHSTATE("MATCHSTATE", 4), 
    SELECTION("SELECTION", 5), 
    VISIBILITY("VISIBILITY", 6), 
    FUNCTIONNAME("FUNCTIONNAME", 7);
    
    private static final String SORT_CRITERIUM_NONE = "None";
    private static final String SORT_CRITERIUM_ADDRESS = "Address";
    private static final String SORT_CRITERIUM_FUNCTIONTYPE = "Function Type";
    private static final String SORT_CRITERIUM_SIDE = "Side";
    private static final String SORT_CRITERIUM_MATCHSTATE = "Match State";
    private static final String SORT_CRITERIUM_SELECTION = "Selection";
    private static final String SORT_CRITERIUM_VISIBILITY = "Visibility";
    private static final String SORT_CRITERIUM_FUNCTIONNAME = "Function Name";
    
    private ESortByCriterium(final String s, final int n) {
    }
    
    public static ESortByCriterium toSortCriterium(final String s) {
        if ("Address".equals(s)) {
            return ESortByCriterium.ADDRESS;
        }
        if ("Function Type".equals(s)) {
            return ESortByCriterium.FUNCTIONTYPE;
        }
        if ("Side".equals(s)) {
            return ESortByCriterium.SIDE;
        }
        if ("Match State".equals(s)) {
            return ESortByCriterium.MATCHSTATE;
        }
        if ("Selection".equals(s)) {
            return ESortByCriterium.SELECTION;
        }
        if ("Visibility".equals(s)) {
            return ESortByCriterium.VISIBILITY;
        }
        if ("Function Name".equals(s)) {
            return ESortByCriterium.FUNCTIONNAME;
        }
        return ESortByCriterium.NONE;
    }
    
    @Override
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
            default: {
                return "None";
            }
        }
    }
}
