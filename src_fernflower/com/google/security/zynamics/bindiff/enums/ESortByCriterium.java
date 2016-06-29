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

   public static ESortByCriterium toSortCriterium(String var0) {
      return "Address".equals(var0)?ADDRESS:("Function Type".equals(var0)?FUNCTIONTYPE:("Side".equals(var0)?SIDE:("Match State".equals(var0)?MATCHSTATE:("Selection".equals(var0)?SELECTION:("Visibility".equals(var0)?VISIBILITY:("Function Name".equals(var0)?FUNCTIONNAME:NONE))))));
   }

   public String toString() {
      switch(ESortByCriterium$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ESortByCriterium[this.ordinal()]) {
      case 1:
         return "None";
      case 2:
         return "Address";
      case 3:
         return "Function Type";
      case 4:
         return "Side";
      case 5:
         return "Match State";
      case 6:
         return "Selection";
      case 7:
         return "Visibility";
      case 8:
         return "Function Name";
      default:
         return "None";
      }
   }
}
