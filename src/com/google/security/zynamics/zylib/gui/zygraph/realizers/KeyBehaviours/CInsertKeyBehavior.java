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

import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;

import java.awt.Point;


public class CInsertKeyBehavior extends CAbstractKeyBehavior {
  private int m_caretX = 0;
  private int m_caretY = 0;

  private boolean m_isAboveComment;
  private boolean m_isBehindComment;
  private boolean m_isLabelComment;

  private boolean m_wasUneditableSelection;

  private IZyEditableObject m_editableObject;


  public CInsertKeyBehavior(final CUndoManager undoManager) {
    super(undoManager);
  }

  private boolean isCopy() {
    return isCtrlPressed() && !isShiftPressed() && !isAltPressed();
  }

  private boolean isPaste() {
    return !isCtrlPressed() && isShiftPressed() && !isAltPressed();
  }

  @Override
  protected void initUndoHistory() {
    if (isPaste()) {
      final int x = getCaretEndPosX();
      final int y = getCaretMouseReleasedY();

      final ZyLineContent lineContent = getLineContent(y);
      IZyEditableObject lineFragmentObject = lineContent.getLineFragmentObjectAt(x);

      boolean isNewBehindLineComment = false;
      String text = "";

      m_isAboveComment = isAboveLineComment(y);
      m_isLabelComment = isLabelComment(y);

      if ((x == lineContent.getText().length()) && !isComment(x, y)) {
        m_isBehindComment = true;

        isNewBehindLineComment = true;

        lineFragmentObject = lineContent.getLineObject();
      } else {
        m_isBehindComment = isBehindLineComment(x, y);
      }

      m_editableObject = lineFragmentObject;

      if (lineFragmentObject != null) {
        if (!isNewBehindLineComment) {
          text =
              lineContent.getText().substring(lineFragmentObject.getStart(),
                  lineFragmentObject.getEnd());

          if (isComment(x, y)) {
            text = getMultiLineComment(y);
          }
        }

        udpateUndolist(getLabelContent(), lineContent.getLineObject().getPersistentModel(),
            lineFragmentObject, text, m_isAboveComment, m_isBehindComment, m_isLabelComment,
            getCaretStartPosX(), getCaretMousePressedX(), getCaretMousePressedY(),
            getCaretEndPosX(), getCaretMouseReleasedX(), getCaretMouseReleasedY());
      }
    }
  }

  @Override
  protected void updateCaret() {
    if (isCopy() || isPaste()) {
      setCaret(m_caretX, m_caretX, m_caretY, m_caretX, m_caretX, m_caretY);
    }
  }

  @Override
  protected void updateClipboard() {
    if (isCopy()) {
      final String clipboardText = getSelectedText();

      ClipboardHelpers.copyToClipboard(clipboardText);
    }
  }

  @Override
  protected void updateLabelContent() {
    if (isPaste()) {
      if (m_wasUneditableSelection) {
        m_caretX = getCaretEndPosX();
        m_caretY = getCaretMouseReleasedY();

        return;
      }

      final Point caretPos = pasteClipboardText();

      m_caretX = caretPos.x;
      m_caretY = caretPos.y;
    }
  }

  @Override
  protected void updateSelection() {
    if (isPaste()) {
      m_wasUneditableSelection = !isDeleteableSelection() && isSelection();

      deleteSelection();
    }
  }

  @Override
  protected void updateUndoHistory() {
    if (isPaste()) {
      if (m_editableObject != null) {
        final int x = getCaretEndPosX();
        final int y = getCaretMouseReleasedY();

        final ZyLineContent lineContent = getLineContent(y);
        final IZyEditableObject lineFragmentObject = lineContent.getLineFragmentObjectAt(x);

        if (lineFragmentObject != null) {
          String text =
              lineContent.getText().substring(lineFragmentObject.getStart(),
                  lineFragmentObject.getEnd());

          if (isComment(x, y)) {
            text = getMultiLineComment(y);
          }

          udpateUndolist(getLabelContent(), lineContent.getLineObject().getPersistentModel(),
              lineFragmentObject, text, m_isAboveComment, m_isBehindComment, m_isLabelComment,
              getCaretStartPosX(), getCaretMousePressedX(), getCaretMousePressedY(),
              getCaretEndPosX(), getCaretMouseReleasedX(), getCaretMouseReleasedY());
        }
      }
    }
  }
}
