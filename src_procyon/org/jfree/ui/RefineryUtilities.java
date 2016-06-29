package org.jfree.ui;

import javax.swing.table.*;
import java.awt.*;
import javax.swing.*;
import org.jfree.util.*;

public abstract class RefineryUtilities
{
    protected static final LogContext logger;
    static Class class$org$jfree$ui$RefineryUtilities;
    static Class class$java$lang$Number;
    
    public static void centerFrameOnScreen(final Window window) {
        positionFrameOnScreen(window, 0.5, 0.5);
    }
    
    public static void positionFrameOnScreen(final Window window, final double n, final double n2) {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final Dimension size = window.getSize();
        window.setBounds((int)(n * Math.max(screenSize.width - size.width, 0)), (int)(n2 * Math.max(screenSize.height - size.height, 0)), size.width, size.height);
    }
    
    public static void positionFrameRandomly(final Window window) {
        positionFrameOnScreen(window, Math.random(), Math.random());
    }
    
    public static void centerDialogInParent(final Dialog dialog) {
        positionDialogRelativeToParent(dialog, 0.5, 0.5);
    }
    
    public static void positionDialogRelativeToParent(final Dialog dialog, final double n, final double n2) {
        final Dimension size = dialog.getSize();
        final Container parent = dialog.getParent();
        final Dimension size2 = parent.getSize();
        final int n3 = parent.getX() - size.width;
        final int n4 = parent.getY() - size.height;
        final int n5 = size.width + size2.width;
        final int n6 = size.height + size2.height;
        final int n7 = n3 + (int)(n * n5);
        final int n8 = n4 + (int)(n2 * n6);
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setBounds(Math.max(Math.min(n7, screenSize.width - size.width), 0), Math.max(Math.min(n8, screenSize.height - size.height), 0), size.width, size.height);
    }
    
    public static JPanel createTablePanel(final TableModel tableModel) {
        final JPanel panel = new JPanel(new BorderLayout());
        final JTable table = new JTable(tableModel);
        for (int i = 0; i < tableModel.getColumnCount(); ++i) {
            final TableColumn column = table.getColumnModel().getColumn(i);
            if (tableModel.getColumnClass(i).equals((RefineryUtilities.class$java$lang$Number == null) ? (RefineryUtilities.class$java$lang$Number = class$("java.lang.Number")) : RefineryUtilities.class$java$lang$Number)) {
                column.setCellRenderer(new NumberCellRenderer());
            }
        }
        panel.add(new JScrollPane(table));
        return panel;
    }
    
    public static JLabel createJLabel(final String s, final Font font) {
        final JLabel label = new JLabel(s);
        label.setFont(font);
        return label;
    }
    
    public static JLabel createJLabel(final String s, final Font font, final Color foreground) {
        final JLabel label = new JLabel(s);
        label.setFont(font);
        label.setForeground(foreground);
        return label;
    }
    
    public static JButton createJButton(final String s, final Font font) {
        final JButton button = new JButton(s);
        button.setFont(font);
        return button;
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        logger = Log.createContext((RefineryUtilities.class$org$jfree$ui$RefineryUtilities == null) ? (RefineryUtilities.class$org$jfree$ui$RefineryUtilities = class$("org.jfree.ui.RefineryUtilities")) : RefineryUtilities.class$org$jfree$ui$RefineryUtilities);
    }
}
