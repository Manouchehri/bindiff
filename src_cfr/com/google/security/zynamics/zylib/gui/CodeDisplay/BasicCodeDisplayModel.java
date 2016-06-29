/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.security.zynamics.zylib.gui.CodeDisplay.ICodeDisplayModel;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.Font;

public abstract class BasicCodeDisplayModel
implements ICodeDisplayModel {
    public static final Font HEADER_FONT_BOLD = GuiHelper.MONOSPACED_FONT.deriveFont(1);
    public static final Font STANDARD_FONT = GuiHelper.MONOSPACED_FONT;
}

