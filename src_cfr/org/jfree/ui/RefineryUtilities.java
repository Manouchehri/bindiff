/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.jfree.ui.NumberCellRenderer;
import org.jfree.util.Log;
import org.jfree.util.LogContext;

public abstract class RefineryUtilities {
    protected static final LogContext logger;
    static Class class$org$jfree$ui$RefineryUtilities;
    static Class class$java$lang$Number;

    public static void centerFrameOnScreen(Window window) {
        RefineryUtilities.positionFrameOnScreen(window, 0.5, 0.5);
    }

    public static void positionFrameOnScreen(Window window, double d2, double d3) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimension2 = window.getSize();
        int n2 = Math.max(dimension.width - dimension2.width, 0);
        int n3 = Math.max(dimension.height - dimension2.height, 0);
        int n4 = (int)(d2 * (double)n2);
        int n5 = (int)(d3 * (double)n3);
        window.setBounds(n4, n5, dimension2.width, dimension2.height);
    }

    public static void positionFrameRandomly(Window window) {
        RefineryUtilities.positionFrameOnScreen(window, Math.random(), Math.random());
    }

    public static void centerDialogInParent(Dialog dialog) {
        RefineryUtilities.positionDialogRelativeToParent(dialog, 0.5, 0.5);
    }

    public static void positionDialogRelativeToParent(Dialog dialog, double d2, double d3) {
        Dimension dimension = dialog.getSize();
        Container container = dialog.getParent();
        Dimension dimension2 = container.getSize();
        int n2 = container.getX() - dimension.width;
        int n3 = container.getY() - dimension.height;
        int n4 = dimension.width + dimension2.width;
        int n5 = dimension.height + dimension2.height;
        int n6 = n2 + (int)(d2 * (double)n4);
        int n7 = n3 + (int)(d3 * (double)n5);
        Dimension dimension3 = Toolkit.getDefaultToolkit().getScreenSize();
        n6 = Math.min(n6, dimension3.width - dimension.width);
        n6 = Math.max(n6, 0);
        n7 = Math.min(n7, dimension3.height - dimension.height);
        n7 = Math.max(n7, 0);
        dialog.setBounds(n6, n7, dimension.width, dimension.height);
    }

    public static JPanel createTablePanel(TableModel tableModel) {
        JPanel jPanel = new JPanel(new BorderLayout());
        JTable jTable = new JTable(tableModel);
        int n2 = 0;
        do {
            if (n2 >= tableModel.getColumnCount()) {
                jPanel.add(new JScrollPane(jTable));
                return jPanel;
            }
            TableColumn tableColumn = jTable.getColumnModel().getColumn(n2);
            Class class_ = tableModel.getColumnClass(n2);
            if (class_.equals(class$java$lang$Number == null ? RefineryUtilities.class$("java.lang.Number") : class$java$lang$Number)) {
                tableColumn.setCellRenderer(new NumberCellRenderer());
            }
            ++n2;
        } while (true);
    }

    public static JLabel createJLabel(String string, Font font) {
        JLabel jLabel = new JLabel(string);
        jLabel.setFont(font);
        return jLabel;
    }

    public static JLabel createJLabel(String string, Font font, Color color) {
        JLabel jLabel = new JLabel(string);
        jLabel.setFont(font);
        jLabel.setForeground(color);
        return jLabel;
    }

    public static JButton createJButton(String string, Font font) {
        JButton jButton = new JButton(string);
        jButton.setFont(font);
        return jButton;
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }

    static {
        Class class_ = class$org$jfree$ui$RefineryUtilities == null ? (RefineryUtilities.class$org$jfree$ui$RefineryUtilities = RefineryUtilities.class$("org.jfree.ui.RefineryUtilities")) : class$org$jfree$ui$RefineryUtilities;
        logger = Log.createContext(class_);
    }
}

