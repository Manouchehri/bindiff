package com.google.security.zynamics.zylib.gui.CodeDisplay;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class CodeDisplayModelExample implements ICodeDisplayModel
{
    private ArrayList data;
    private int totalNumberOfLines;
    private Font fontColumnA;
    private Font fontColumnB;
    private Font fontColumnC;
    
    public CodeDisplayModelExample() {
        this.data = new ArrayList();
        this.totalNumberOfLines = 0;
        this.fontColumnA = new Font("Monospaced", 1, 12);
        this.fontColumnB = new Font("Monospaced", 0, 12);
        this.fontColumnC = new Font("Monospaced", 2, 12);
        for (int i = 0; i < 10000; ++i) {
            final ArrayList<String> list = new ArrayList<String>();
            final ArrayList<String> list2 = new ArrayList<String>();
            final ArrayList<String> list3 = new ArrayList<String>();
            list.add(String.format("* %d *", i));
            list2.add(String.format("Code for line %d", i));
            list3.add(String.format("First comment in line %d", i));
            list3.add(String.format("Second comment in line %d", i));
            this.totalNumberOfLines += 2;
            final ArrayList<Object> list4 = new ArrayList<Object>();
            list4.add(list);
            list4.add(list2);
            list4.add(list3);
            this.data.add(list4);
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
    public int getColumnWidthInCharacters(final int n) {
        switch (n) {
            case 0: {
                return 15;
            }
            case 1: {
                return 40;
            }
            case 2: {
                return 40;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }
    
    @Override
    public int getTotalWidthInCharacters() {
        int n = 0;
        for (int i = 0; i < this.getNumberOfColumns(); ++i) {
            n += this.getColumnWidthInCharacters(i);
        }
        return n;
    }
    
    @Override
    public int getMaximumLinesForRow(final int n) {
        int max = 0;
        for (int i = 0; i < this.getNumberOfColumns(); ++i) {
            max = Math.max(this.data.get(n).get(i).size(), max);
        }
        return max;
    }
    
    @Override
    public int getNumberOfColumns() {
        return 3;
    }
    
    @Override
    public String getColumnName(final int n) {
        switch (n) {
            case 0: {
                return "Line:";
            }
            case 1: {
                return "Code:";
            }
            case 2: {
                return "Comment:";
            }
            default: {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }
    
    public static String padRight(final String s, final int n) {
        return String.format(new StringBuilder(16).append("%1$-").append(n).append("s").toString(), s);
    }
    
    @Override
    public FormattedCharacterBuffer getLineFormatted(final int n, final int n2, final int n3) {
        final ArrayList<String> list = this.data.get(n).get(n2);
        String s;
        if (n3 >= list.size()) {
            s = padRight("", this.getColumnWidthInCharacters(n2));
        }
        else {
            s = padRight(list.get(n3), this.getColumnWidthInCharacters(n2));
        }
        final String substring = s.substring(0, Math.min(s.length(), this.getColumnWidthInCharacters(n2)));
        switch (n2) {
            case 0: {
                return new FormattedCharacterBuffer(substring, this.fontColumnA, Color.BLACK, Color.LIGHT_GRAY);
            }
            case 1: {
                return new FormattedCharacterBuffer(substring, this.fontColumnB, Color.WHITE, Color.DARK_GRAY);
            }
            case 2: {
                return new FormattedCharacterBuffer(substring, this.fontColumnC, Color.LIGHT_GRAY, Color.BLACK);
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public boolean canHaveCaret(final CodeDisplayCoordinate codeDisplayCoordinate) {
        return codeDisplayCoordinate.getColumn() != 0;
    }
    
    @Override
    public boolean isEditable(final CodeDisplayCoordinate codeDisplayCoordinate) {
        return codeDisplayCoordinate.getColumn() == 2;
    }
    
    @Override
    public void keyPressedOrTyped(final CodeDisplayCoordinate codeDisplayCoordinate, final KeyEvent keyEvent) {
        if (!keyEvent.isActionKey()) {
            switch (keyEvent.getKeyCode()) {
                case 10: {
                    break;
                }
                default: {
                    String padRight = this.data.get(codeDisplayCoordinate.getRow()).get(codeDisplayCoordinate.getColumn()).get(codeDisplayCoordinate.getLine());
                    if (padRight.length() < codeDisplayCoordinate.getFieldIndex()) {
                        padRight = padRight(padRight, codeDisplayCoordinate.getFieldIndex());
                    }
                    final String value = String.valueOf(padRight.substring(0, codeDisplayCoordinate.getFieldIndex()));
                    final char keyChar = keyEvent.getKeyChar();
                    final String value2 = String.valueOf(padRight.substring(codeDisplayCoordinate.getFieldIndex()));
                    this.data.get(codeDisplayCoordinate.getRow()).get(codeDisplayCoordinate.getColumn()).set(codeDisplayCoordinate.getLine(), new StringBuilder(1 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append(keyChar).append(value2).toString());
                    codeDisplayCoordinate.setFieldIndex(codeDisplayCoordinate.getFieldIndex() + 1);
                    break;
                }
            }
        }
        else {
            switch (keyEvent.getKeyCode()) {
                case 40: {}
                case 37: {
                    codeDisplayCoordinate.setFieldIndex(codeDisplayCoordinate.getFieldIndex() - 1);
                    break;
                }
                case 39: {
                    codeDisplayCoordinate.setFieldIndex(codeDisplayCoordinate.getFieldIndex() + 1);
                    break;
                }
            }
        }
    }
    
    @Override
    public boolean hasHeaderRow() {
        return false;
    }
    
    @Override
    public FormattedCharacterBuffer getHeader(final int n) {
        return null;
    }
}
