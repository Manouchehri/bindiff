/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.BorderUIResource;

public class UIUtilities {
    private UIUtilities() {
    }

    public static void setupUI() {
        Object object;
        try {
            object = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel((String)object);
        }
        catch (Exception var0_1) {
            var0_1.printStackTrace();
        }
        object = UIManager.getDefaults();
        object.put("PopupMenu.border", new BorderUIResource.EtchedBorderUIResource(0, object.getColor("controlShadow"), object.getColor("controlLtHighlight")));
        MatteBorder matteBorder = new MatteBorder(1, 1, 1, 1, Color.black);
        MatteBorder matteBorder2 = new MatteBorder(2, 2, 2, 2, object.getColor("control"));
        BorderUIResource.CompoundBorderUIResource compoundBorderUIResource = new BorderUIResource.CompoundBorderUIResource(matteBorder2, matteBorder);
        BorderUIResource.EmptyBorderUIResource emptyBorderUIResource = new BorderUIResource.EmptyBorderUIResource(0, 0, 0, 0);
        object.put("SplitPane.border", emptyBorderUIResource);
        object.put("Table.scrollPaneBorder", emptyBorderUIResource);
        object.put("ComboBox.border", compoundBorderUIResource);
        object.put("TextField.border", compoundBorderUIResource);
        object.put("TextArea.border", compoundBorderUIResource);
        object.put("CheckBox.border", compoundBorderUIResource);
        object.put("ScrollPane.border", emptyBorderUIResource);
    }
}

