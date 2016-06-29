/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplayCoordinate;
import java.util.EventListener;

public interface CodeDisplayEventListener
extends EventListener {
    public void caretChanged(CodeDisplayCoordinate var1);
}

