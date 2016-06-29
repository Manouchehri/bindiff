/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.awt.Cursor;

public class CMouseCursorHelper {
    private static Cursor DEFAULT_CURSOR = Cursor.getDefaultCursor();
    private static Cursor MOVE_CURSOR = Cursor.getPredefinedCursor(13);
    private static Cursor HAND_CURSOR = Cursor.getPredefinedCursor(12);

    public static void setDefaultCursor(AbstractZyGraph abstractZyGraph) {
        if (abstractZyGraph.getViewCursor() == DEFAULT_CURSOR) return;
        abstractZyGraph.setViewCursor(DEFAULT_CURSOR);
    }

    public static void setHandCursor(AbstractZyGraph abstractZyGraph) {
        if (abstractZyGraph.getViewCursor() == HAND_CURSOR) return;
        abstractZyGraph.setViewCursor(HAND_CURSOR);
    }

    public static void setMoveCursor(AbstractZyGraph abstractZyGraph) {
        if (abstractZyGraph.getViewCursor() == MOVE_CURSOR) return;
        abstractZyGraph.setViewCursor(MOVE_CURSOR);
    }
}

