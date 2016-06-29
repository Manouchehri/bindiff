/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplayCoordinate;
import com.google.security.zynamics.zylib.gui.CodeDisplay.FormattedCharacterBuffer;
import com.google.security.zynamics.zylib.gui.CodeDisplay.ICodeDisplayModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class CodeDisplayModelExample
implements ICodeDisplayModel {
    private ArrayList data = new ArrayList();
    private int totalNumberOfLines = 0;
    private Font fontColumnA = new Font("Monospaced", 1, 12);
    private Font fontColumnB = new Font("Monospaced", 0, 12);
    private Font fontColumnC = new Font("Monospaced", 2, 12);

    public CodeDisplayModelExample() {
        int n2 = 0;
        while (n2 < 10000) {
            ArrayList<String> arrayList = new ArrayList<String>();
            ArrayList<String> arrayList2 = new ArrayList<String>();
            ArrayList<String> arrayList3 = new ArrayList<String>();
            arrayList.add(String.format("* %d *", n2));
            arrayList2.add(String.format("Code for line %d", n2));
            arrayList3.add(String.format("First comment in line %d", n2));
            arrayList3.add(String.format("Second comment in line %d", n2));
            this.totalNumberOfLines += 2;
            ArrayList<ArrayList<String>> arrayList4 = new ArrayList<ArrayList<String>>();
            arrayList4.add(arrayList);
            arrayList4.add(arrayList2);
            arrayList4.add(arrayList3);
            this.data.add(arrayList4);
            ++n2;
        }
    }

    @Override
    public int getNumberOfRows() {
        return this.data.size();
    }

    @Override
    public int getTotalNumberOfLines() {
        return this.totalNumberOfLines;
    }

    @Override
    public int getColumnWidthInCharacters(int n2) {
        switch (n2) {
            case 0: {
                return 15;
            }
            case 1: {
                return 40;
            }
            case 2: {
                return 40;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public int getTotalWidthInCharacters() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.getNumberOfColumns()) {
            n2 += this.getColumnWidthInCharacters(n3);
            ++n3;
        }
        return n2;
    }

    @Override
    public int getMaximumLinesForRow(int n2) {
        int n3 = 0;
        int n4 = 0;
        while (n4 < this.getNumberOfColumns()) {
            n3 = Math.max(((ArrayList)((ArrayList)this.data.get(n2)).get(n4)).size(), n3);
            ++n4;
        }
        return n3;
    }

    @Override
    public int getNumberOfColumns() {
        return 3;
    }

    @Override
    public String getColumnName(int n2) {
        switch (n2) {
            case 0: {
                return "Line:";
            }
            case 1: {
                return "Code:";
            }
            case 2: {
                return "Comment:";
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static String padRight(String string, int n2) {
        return String.format(new StringBuilder(16).append("%1$-").append(n2).append("s").toString(), string);
    }

    @Override
    public FormattedCharacterBuffer getLineFormatted(int n2, int n3, int n4) {
        ArrayList arrayList = (ArrayList)((ArrayList)this.data.get(n2)).get(n3);
        String string = n4 >= arrayList.size() ? CodeDisplayModelExample.padRight("", this.getColumnWidthInCharacters(n3)) : CodeDisplayModelExample.padRight((String)arrayList.get(n4), this.getColumnWidthInCharacters(n3));
        string = string.substring(0, Math.min(string.length(), this.getColumnWidthInCharacters(n3)));
        switch (n3) {
            case 0: {
                return new FormattedCharacterBuffer(string, this.fontColumnA, Color.BLACK, Color.LIGHT_GRAY);
            }
            case 1: {
                return new FormattedCharacterBuffer(string, this.fontColumnB, Color.WHITE, Color.DARK_GRAY);
            }
            case 2: {
                return new FormattedCharacterBuffer(string, this.fontColumnC, Color.LIGHT_GRAY, Color.BLACK);
            }
        }
        return null;
    }

    @Override
    public boolean canHaveCaret(CodeDisplayCoordinate codeDisplayCoordinate) {
        if (codeDisplayCoordinate.getColumn() != 0) return true;
        return false;
    }

    @Override
    public boolean isEditable(CodeDisplayCoordinate codeDisplayCoordinate) {
        if (codeDisplayCoordinate.getColumn() != 2) return false;
        return true;
    }

    @Override
    public void keyPressedOrTyped(CodeDisplayCoordinate codeDisplayCoordinate, KeyEvent keyEvent) {
        if (!keyEvent.isActionKey()) {
            switch (keyEvent.getKeyCode()) {
                case 10: {
                    return;
                }
            }
            String string = (String)((ArrayList)((ArrayList)this.data.get(codeDisplayCoordinate.getRow())).get(codeDisplayCoordinate.getColumn())).get(codeDisplayCoordinate.getLine());
            if (string.length() < codeDisplayCoordinate.getFieldIndex()) {
                string = CodeDisplayModelExample.padRight(string, codeDisplayCoordinate.getFieldIndex());
            }
            String string2 = String.valueOf(string.substring(0, codeDisplayCoordinate.getFieldIndex()));
            char c2 = keyEvent.getKeyChar();
            String string3 = String.valueOf(string.substring(codeDisplayCoordinate.getFieldIndex()));
            String string4 = new StringBuilder(1 + String.valueOf(string2).length() + String.valueOf(string3).length()).append(string2).append(c2).append(string3).toString();
            ((ArrayList)((ArrayList)this.data.get(codeDisplayCoordinate.getRow())).get(codeDisplayCoordinate.getColumn())).set(codeDisplayCoordinate.getLine(), string4);
            codeDisplayCoordinate.setFieldIndex(codeDisplayCoordinate.getFieldIndex() + 1);
            return;
        }
        switch (keyEvent.getKeyCode()) {
            case 40: {
                return;
            }
            case 38: {
                return;
            }
            case 37: {
                codeDisplayCoordinate.setFieldIndex(codeDisplayCoordinate.getFieldIndex() - 1);
                return;
            }
            case 39: {
                codeDisplayCoordinate.setFieldIndex(codeDisplayCoordinate.getFieldIndex() + 1);
            }
        }
    }

    @Override
    public boolean hasHeaderRow() {
        return false;
    }

    @Override
    public FormattedCharacterBuffer getHeader(int n2) {
        return null;
    }
}

