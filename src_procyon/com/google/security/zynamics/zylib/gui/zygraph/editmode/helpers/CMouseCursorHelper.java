package com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers;

import java.awt.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;

public class CMouseCursorHelper
{
    private static Cursor DEFAULT_CURSOR;
    private static Cursor MOVE_CURSOR;
    private static Cursor HAND_CURSOR;
    
    public static void setDefaultCursor(final AbstractZyGraph abstractZyGraph) {
        if (abstractZyGraph.getViewCursor() != CMouseCursorHelper.DEFAULT_CURSOR) {
            abstractZyGraph.setViewCursor(CMouseCursorHelper.DEFAULT_CURSOR);
        }
    }
    
    public static void setHandCursor(final AbstractZyGraph abstractZyGraph) {
        if (abstractZyGraph.getViewCursor() != CMouseCursorHelper.HAND_CURSOR) {
            abstractZyGraph.setViewCursor(CMouseCursorHelper.HAND_CURSOR);
        }
    }
    
    public static void setMoveCursor(final AbstractZyGraph abstractZyGraph) {
        if (abstractZyGraph.getViewCursor() != CMouseCursorHelper.MOVE_CURSOR) {
            abstractZyGraph.setViewCursor(CMouseCursorHelper.MOVE_CURSOR);
        }
    }
    
    static {
        CMouseCursorHelper.DEFAULT_CURSOR = Cursor.getDefaultCursor();
        CMouseCursorHelper.MOVE_CURSOR = Cursor.getPredefinedCursor(13);
        CMouseCursorHelper.HAND_CURSOR = Cursor.getPredefinedCursor(12);
    }
}
