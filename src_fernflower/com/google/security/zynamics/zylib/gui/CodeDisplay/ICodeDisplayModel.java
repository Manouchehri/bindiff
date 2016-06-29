package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplayCoordinate;
import com.google.security.zynamics.zylib.gui.CodeDisplay.FormattedCharacterBuffer;
import java.awt.event.KeyEvent;

public interface ICodeDisplayModel {
   int getNumberOfRows();

   int getTotalNumberOfLines();

   int getTotalWidthInCharacters();

   int getNumberOfColumns();

   int getColumnWidthInCharacters(int var1);

   String getColumnName(int var1);

   int getMaximumLinesForRow(int var1);

   FormattedCharacterBuffer getLineFormatted(int var1, int var2, int var3);

   boolean canHaveCaret(CodeDisplayCoordinate var1);

   boolean isEditable(CodeDisplayCoordinate var1);

   void keyPressedOrTyped(CodeDisplayCoordinate var1, KeyEvent var2);

   boolean hasHeaderRow();

   FormattedCharacterBuffer getHeader(int var1);
}
