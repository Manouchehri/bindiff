/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabpanels;

import com.google.common.collect.Lists;
import com.google.security.zynamics.bindiff.graph.filter.enums.EMatchStateFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESelectionFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESideFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.EVisibilityFilter;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabcomponents.AddressRangeFieldPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabcomponents.FilterComboboxPanel;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class FilteringTabPanel
extends JPanel {
    private static int FILTER_LABEL_WIDTH = 100;
    private static int FILTER_COMBOBOX_WIDTH = 150;
    private static int ROW_HEIGHT = 25;
    private static final String FILTER_ITEM_NONE = "None";
    private static final String FILTER_ITEM_PRIMARY = "Primary";
    private static final String FILTER_ITEM_SECONRARY = "Secondary";
    private static final String FILTER_ITEM_SELECTED = "Selected";
    private static final String FILTER_ITEM_UNSELECTED = "Unselected";
    private static final String FILTER_ITEM_VISIBLE = "Visible";
    private static final String FILTER_ITEM_INVISIBLE = "Invisible";
    private static final String FILTER_ITEM_MATCHED = "Matched";
    private static final String FILTER_ITEM_MATCHED_IDENTICAL = "Matched Identical";
    private static final String FILTER_ITEM_MATCHED_INSTRUCTION_CHANGES = "Matched with Changes";
    private static final String FILTER_ITEM_MATCHED_INSTRUCTION_ONLY_CHANGES = "Matched with Instruction Changes Only";
    private static final String FILTER_ITEM_MATCHED_STRUCTURAL_CHANGES = "Matched with structural Changes";
    private static final String FILTER_ITEM_UNMATCHED = "Unmatched";
    private FilterComboboxPanel matchStateCombo;
    private FilterComboboxPanel selectionCombo;
    private FilterComboboxPanel visibilityCombo;
    private FilterComboboxPanel sideCombo;
    private AddressRangeFieldPanel startRangeField;
    private AddressRangeFieldPanel endRangeField;
    private String initialSelection;
    private String initialVisibility;
    private String initialMatchState;
    private String initialSide;
    private IAddress initialStartRange;
    private IAddress initialEndRange;

    public FilteringTabPanel(boolean bl2, boolean bl3) {
        super(new BorderLayout());
        this.add((Component)this.createPanel(bl2, bl3), "Center");
        this.setDefaults();
    }

    private JPanel createPanel(boolean bl2, boolean bl3) {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new LineBorder(Color.GRAY));
        JPanel jPanel2 = new JPanel(new GridLayout(bl2 ? 6 : 5, 1, 2, 2));
        jPanel2.setBorder(new TitledBorder("Filter Options"));
        ArrayList arrayList = Lists.newArrayList("None", "Matched", "Unmatched");
        ArrayList arrayList2 = Lists.newArrayList("None", "Selected", "Unselected");
        ArrayList arrayList3 = Lists.newArrayList("None", "Visible", "Invisible");
        ArrayList arrayList4 = Lists.newArrayList("None", "Primary", "Secondary");
        if (bl3) {
            arrayList.add(2, "Matched Identical");
            arrayList.add(3, "Matched with Instruction Changes Only");
            arrayList.add(4, "Matched with structural Changes");
        } else {
            arrayList.add(2, "Matched Identical");
            arrayList.add(3, "Matched with Changes");
        }
        this.matchStateCombo = new FilterComboboxPanel("Match State", arrayList, FILTER_LABEL_WIDTH, FILTER_COMBOBOX_WIDTH, ROW_HEIGHT);
        this.selectionCombo = new FilterComboboxPanel("Selection", arrayList2, FILTER_LABEL_WIDTH, FILTER_COMBOBOX_WIDTH, ROW_HEIGHT);
        this.sideCombo = new FilterComboboxPanel("Side", arrayList4, FILTER_LABEL_WIDTH, FILTER_COMBOBOX_WIDTH, ROW_HEIGHT);
        this.visibilityCombo = new FilterComboboxPanel("Visibility", arrayList3, FILTER_LABEL_WIDTH, FILTER_COMBOBOX_WIDTH, ROW_HEIGHT);
        this.startRangeField = new AddressRangeFieldPanel("Start Range", new CAddress("0000000000000000", 16), FILTER_LABEL_WIDTH, FILTER_COMBOBOX_WIDTH, ROW_HEIGHT);
        this.endRangeField = new AddressRangeFieldPanel("End Range", new CAddress("FFFFFFFFFFFFFFFF", 16), FILTER_LABEL_WIDTH, FILTER_COMBOBOX_WIDTH, ROW_HEIGHT);
        jPanel2.add(this.matchStateCombo);
        jPanel2.add(this.selectionCombo);
        jPanel2.add(this.visibilityCombo);
        if (bl2) {
            jPanel2.add(this.sideCombo);
        }
        jPanel2.add(this.startRangeField);
        jPanel2.add(this.endRangeField);
        jPanel.add((Component)jPanel2, "North");
        return jPanel;
    }

    public IAddress getEndAddress() {
        return this.endRangeField.getValue();
    }

    public EMatchStateFilter getMatchStateFilter() {
        if (this.matchStateCombo.getValue().equals("Matched")) {
            return EMatchStateFilter.MATCHED;
        }
        if (this.matchStateCombo.getValue().equals("Unmatched")) {
            return EMatchStateFilter.UNMATCHED;
        }
        if (this.matchStateCombo.getValue().equals("Matched Identical")) {
            return EMatchStateFilter.MATCHED_IDENTICAL;
        }
        if (this.matchStateCombo.getValue().equals("Matched with Instruction Changes Only")) {
            return EMatchStateFilter.MATCHED_INSTRUCTION_CHANGES;
        }
        if (this.matchStateCombo.getValue().equals("Matched with Changes")) {
            return EMatchStateFilter.MATCHED_INSTRUCTION_CHANGES;
        }
        if (!this.matchStateCombo.getValue().equals("Matched with structural Changes")) return EMatchStateFilter.NONE;
        return EMatchStateFilter.MATCHED_STRUTURAL_CHANGES;
    }

    public ESelectionFilter getSelectionFilter() {
        if (this.selectionCombo.getValue().equals("Selected")) {
            return ESelectionFilter.SELECTED;
        }
        if (!this.selectionCombo.getValue().equals("Unselected")) return ESelectionFilter.NONE;
        return ESelectionFilter.UNSELECTED;
    }

    public ESideFilter getSideFilter() {
        if (this.sideCombo.getValue().equals("Primary")) {
            return ESideFilter.PRIMARY;
        }
        if (!this.sideCombo.getValue().equals("Secondary")) return ESideFilter.NONE;
        return ESideFilter.SECONDARY;
    }

    public IAddress getStartAddress() {
        return this.startRangeField.getValue();
    }

    public EVisibilityFilter getVisibilityFilter() {
        if (this.visibilityCombo.getValue().equals("Visible")) {
            return EVisibilityFilter.VISIBLE;
        }
        if (!this.visibilityCombo.getValue().equals("Invisible")) return EVisibilityFilter.NONE;
        return EVisibilityFilter.INVISIBLE;
    }

    public void restoreInitialSettings() {
        this.selectionCombo.setValue(this.initialSelection);
        this.visibilityCombo.setValue(this.initialVisibility);
        this.matchStateCombo.setValue(this.initialMatchState);
        this.sideCombo.setValue(this.initialSide);
        this.startRangeField.setValue(this.initialStartRange);
        this.endRangeField.setValue(this.initialEndRange);
    }

    public void setDefaults() {
        this.selectionCombo.setValue("None");
        this.visibilityCombo.setValue("None");
        this.matchStateCombo.setValue("None");
        this.sideCombo.setValue("None");
        this.startRangeField.setDefault();
        this.endRangeField.setDefault();
    }

    public void storeInitialSettings() {
        this.initialSelection = this.selectionCombo.getValue();
        this.initialVisibility = this.visibilityCombo.getValue();
        this.initialMatchState = this.matchStateCombo.getValue();
        this.initialSide = this.sideCombo.getValue();
        this.initialStartRange = this.startRangeField.getValue();
        this.initialEndRange = this.endRangeField.getValue();
    }
}

