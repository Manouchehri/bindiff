package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import java.util.*;

public class CTabKeyBehavior extends CAbstractKeyBehavior
{
    public CTabKeyBehavior(final CUndoManager cUndoManager) {
        super(cUndoManager);
    }
    
    @Override
    protected void initUndoHistory() {
    }
    
    @Override
    protected void updateCaret() {
        if (!this.isAltPressed() && !this.isCtrlPressed()) {
            final int caretEndPosX = this.getCaretEndPosX();
            final int caretMousePressedY = this.getCaretMousePressedY();
            final ZyLineContent lineContent = this.getLineContent(caretMousePressedY);
            final IZyEditableObject lineFragmentObject = lineContent.getLineFragmentObjectAt(caretEndPosX);
            final List lineFragmentObjectList = lineContent.getLineFragmentObjectList();
            IZyEditableObject zyEditableObject = null;
            if (!this.isShiftPressed()) {
                if (lineFragmentObject != null) {
                    if (!this.isComment(caretEndPosX, caretMousePressedY)) {
                        final int index = lineContent.getLineFragmentObjectList().indexOf(lineFragmentObject);
                        if (index < lineFragmentObjectList.size() - 1) {
                            zyEditableObject = lineFragmentObjectList.get(index + 1);
                        }
                    }
                }
                else {
                    for (final IZyEditableObject zyEditableObject2 : lineFragmentObjectList) {
                        if (zyEditableObject2.getStart() > caretEndPosX) {
                            zyEditableObject = zyEditableObject2;
                            break;
                        }
                    }
                }
                int n = caretMousePressedY;
                if (this.isComment(caretEndPosX, caretMousePressedY)) {
                    final int lastLineIndexOfModel = this.getLabelContent().getLastLineIndexOfModelAt(n);
                    final int nonPureCommentLineIndexOfModel = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(n);
                    if (nonPureCommentLineIndexOfModel != -1) {
                        if (n < nonPureCommentLineIndexOfModel) {
                            n = nonPureCommentLineIndexOfModel - 1;
                        }
                        else {
                            n = lastLineIndexOfModel;
                        }
                    }
                    else {
                        n = this.getLabelContent().getLineCount() - 1;
                    }
                }
                if (zyEditableObject == null) {
                    List lineFragmentObjectList2;
                    for (int n2 = 1; (zyEditableObject == null && n != caretMousePressedY) || n2 != 0; zyEditableObject = lineFragmentObjectList2.get(0)) {
                        n2 = 0;
                        n = ((n == this.getLabelContent().getLineCount() - 1) ? 0 : (++n));
                        lineFragmentObjectList2 = this.getLineContent(n).getLineFragmentObjectList();
                        if (lineFragmentObjectList2.size() > 0) {}
                    }
                }
                if (zyEditableObject != null) {
                    int n3 = zyEditableObject.getStart();
                    if (zyEditableObject.isCommentDelimiter()) {
                        n3 = zyEditableObject.getEnd();
                    }
                    final int n4 = n;
                    this.setCaret(n3, n3, n4, n3, n3, n4);
                }
            }
            else {
                if (lineFragmentObject != null) {
                    if (!this.isComment(caretEndPosX, caretMousePressedY)) {
                        final int index2 = lineContent.getLineFragmentObjectList().indexOf(lineFragmentObject);
                        if (index2 < 1) {
                            zyEditableObject = lineFragmentObjectList.get(index2 - 1);
                        }
                    }
                }
                else {
                    for (int i = lineFragmentObjectList.size() - 1; i >= 0; --i) {
                        final IZyEditableObject zyEditableObject3 = lineFragmentObjectList.get(i);
                        if (zyEditableObject3.getEnd() < caretEndPosX) {
                            zyEditableObject = zyEditableObject3;
                            break;
                        }
                    }
                }
                int n5 = caretMousePressedY;
                if (this.isComment(caretEndPosX, caretMousePressedY)) {
                    final int firstLineIndexOfModel = this.getLabelContent().getFirstLineIndexOfModelAt(n5);
                    final int nonPureCommentLineIndexOfModel2 = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(n5);
                    if (nonPureCommentLineIndexOfModel2 != -1) {
                        if (n5 < nonPureCommentLineIndexOfModel2) {
                            n5 = firstLineIndexOfModel;
                        }
                        else {
                            n5 = nonPureCommentLineIndexOfModel2;
                        }
                    }
                }
                if (zyEditableObject == null) {
                    List lineFragmentObjectList3;
                    for (int n6 = 1; (zyEditableObject == null && n5 != caretMousePressedY) || n6 != 0; zyEditableObject = lineFragmentObjectList3.get(lineFragmentObjectList3.size() - 1)) {
                        n6 = 0;
                        n5 = ((n5 == 0) ? (this.getLabelContent().getLineCount() - 1) : (--n5));
                        lineFragmentObjectList3 = this.getLineContent(n5).getLineFragmentObjectList();
                        if (lineFragmentObjectList3.size() > 0) {}
                    }
                }
                if (zyEditableObject != null) {
                    int n7 = zyEditableObject.getStart();
                    if (zyEditableObject.isCommentDelimiter()) {
                        n7 = zyEditableObject.getEnd();
                    }
                    int n8 = n5;
                    if (this.isComment(n7, n8)) {
                        final int firstLineIndexOfModel2 = this.getLabelContent().getFirstLineIndexOfModelAt(n5);
                        final int nonPureCommentLineIndexOfModel3 = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(n5);
                        if (n8 <= nonPureCommentLineIndexOfModel3 || nonPureCommentLineIndexOfModel3 < 0) {
                            n8 = firstLineIndexOfModel2;
                        }
                        else {
                            n8 = nonPureCommentLineIndexOfModel3;
                        }
                        final IZyEditableObject lineFragmentObject2 = this.getLineContent(n8).getLineFragmentObjectAt(n7);
                        if (lineFragmentObject2 != null && lineFragmentObject2.isCommentDelimiter()) {
                            n7 = lineFragmentObject2.getEnd();
                        }
                    }
                    this.setCaret(n7, n7, n8, n7, n7, n8);
                }
            }
        }
    }
    
    @Override
    protected void updateClipboard() {
    }
    
    @Override
    protected void updateLabelContent() {
    }
    
    @Override
    protected void updateSelection() {
    }
    
    @Override
    protected void updateUndoHistory() {
    }
}
