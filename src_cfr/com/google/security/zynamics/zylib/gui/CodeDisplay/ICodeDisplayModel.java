/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplayCoordinate;
import com.google.security.zynamics.zylib.gui.CodeDisplay.FormattedCharacterBuffer;
import java.awt.event.KeyEvent;

public interface ICodeDisplayModel {
    public int getNumberOfRows();

    public int getTotalNumberOfLines();

    public int getTotalWidthInCharacters();

    public int getNumberOfColumns();

    public int getColumnWidthInCharacters(int var1);

    public String getColumnName(int var1);

    public int getMaximumLinesForRow(int var1);

    public FormattedCharacterBuffer getLineFormatted(int var1, int var2, int var3);

    public boolean canHaveCaret(CodeDisplayCoordinate var1);

    public boolean isEditable(CodeDisplayCoordinate var1);

    public void keyPressedOrTyped(CodeDisplayCoordinate var1, KeyEvent var2);

    public boolean hasHeaderRow();

    public FormattedCharacterBuffer getHeader(int var1);
}

