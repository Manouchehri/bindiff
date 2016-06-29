package com.google.security.zynamics.zylib.gui.CodeDisplay;

import java.awt.event.*;

public interface ICodeDisplayModel
{
    int getNumberOfRows();
    
    int getTotalNumberOfLines();
    
    int getTotalWidthInCharacters();
    
    int getNumberOfColumns();
    
    int getColumnWidthInCharacters(final int p0);
    
    String getColumnName(final int p0);
    
    int getMaximumLinesForRow(final int p0);
    
    FormattedCharacterBuffer getLineFormatted(final int p0, final int p1, final int p2);
    
    boolean canHaveCaret(final CodeDisplayCoordinate p0);
    
    boolean isEditable(final CodeDisplayCoordinate p0);
    
    void keyPressedOrTyped(final CodeDisplayCoordinate p0, final KeyEvent p1);
    
    boolean hasHeaderRow();
    
    FormattedCharacterBuffer getHeader(final int p0);
}
