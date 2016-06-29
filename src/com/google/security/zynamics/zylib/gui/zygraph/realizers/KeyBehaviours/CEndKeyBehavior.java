/*
Copyright 2011-2016 Google Inc. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;

public class CEndKeyBehavior extends CAbstractKeyBehavior {
  public CEndKeyBehavior(final CUndoManager undoManager) {
    super(undoManager);
  }

  @Override
  protected void initUndoHistory() {
    // Do nothing
  }

  @Override
  protected void updateCaret() {
    if (!isShiftPressed() && !isCtrlPressed()) {
      final int yPos = getCaretMouseReleasedY();
      final int lastXPos = getLastLineXPos(yPos);

      setCaret(lastXPos, lastXPos, yPos, lastXPos, lastXPos, yPos);
    } else if (isShiftPressed() && !isCtrlPressed()) {
      final int ypos = getCaretMouseReleasedY();
      final int lastXPos = getLineContent(ypos).getTextLayout().getCharacterCount();

      int mouseReleased_X = lastXPos;

      final ZyLineContent lineContent = getLineContent(getCaretMouseReleasedY());

      final boolean noReturn = getCaretEndPosX() == lineContent.getText().length();
      final boolean withReturn =
          lineContent.getText().endsWith("\n")
              && (getCaretEndPosX() == (lineContent.getText().length() - 1));
      final boolean withCReturn =
          lineContent.getText().endsWith("\r")
              && (getCaretEndPosX() == (lineContent.getText().length() - 1));

      if (noReturn || withReturn || withCReturn) {
        mouseReleased_X = getMaxLineLength(getCaretMousePressedY(), getCaretMouseReleasedY());
      }

      if ((lineContent.getText().endsWith("\n") || lineContent.getText().endsWith("\r"))
          && (mouseReleased_X > 0)) {
        mouseReleased_X -= 1;
      }

      setCaret(getCaretStartPosX(), getCaretMousePressedX(), getCaretMousePressedY(), lastXPos,
          mouseReleased_X, ypos);
    } else if (!isShiftPressed() && isCtrlPressed()) {
      final ZyLabelContent labelContent = getLabelContent();

      final int lastXPos =
          labelContent.getLineContent(labelContent.getLineCount() - 1).getText().length();
      final int lastYPos = labelContent.getLineCount() - 1;

      setCaret(lastXPos, lastXPos, lastYPos, lastXPos, lastXPos, lastYPos);
    } else if (isShiftPressed() && isCtrlPressed()) {
      final int lastYPos = getLabelContent().getLineCount() - 1;
      final int lastXPos = getLabelContent().getLineContent(lastYPos).getText().length();

      setCaret(getCaretStartPosX(), getCaretMousePressedX(), getCaretMousePressedY(), lastXPos,
          lastXPos, lastYPos);
    }
  }

  @Override
  protected void updateClipboard() {
    // Do nothing
  }

  @Override
  protected void updateLabelContent() {
    // Do nothing
  }

  @Override
  protected void updateSelection() {
    // Do nothing
  }

  @Override
  protected void updateUndoHistory() {
    // Do nothing
  }
}
