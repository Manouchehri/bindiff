package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabpanels;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabcomponents.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.common.collect.*;
import com.google.security.zynamics.zylib.disassembly.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.filter.enums.*;

public class FilteringTabPanel extends JPanel
{
    private static int FILTER_LABEL_WIDTH;
    private static int FILTER_COMBOBOX_WIDTH;
    private static int ROW_HEIGHT;
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
    
    public FilteringTabPanel(final boolean b, final boolean b2) {
        super(new BorderLayout());
        this.add(this.createPanel(b, b2), "Center");
        this.setDefaults();
    }
    
    private JPanel createPanel(final boolean b, final boolean b2) {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new LineBorder(Color.GRAY));
        final JPanel panel2 = new JPanel(new GridLayout(b ? 6 : 5, 1, 2, 2));
        panel2.setBorder(new TitledBorder("Filter Options"));
        final ArrayList arrayList = Lists.newArrayList("None", "Matched", "Unmatched");
        final ArrayList arrayList2 = Lists.newArrayList("None", "Selected", "Unselected");
        final ArrayList arrayList3 = Lists.newArrayList("None", "Visible", "Invisible");
        final ArrayList arrayList4 = Lists.newArrayList("None", "Primary", "Secondary");
        if (b2) {
            arrayList.add(2, "Matched Identical");
            arrayList.add(3, "Matched with Instruction Changes Only");
            arrayList.add(4, "Matched with structural Changes");
        }
        else {
            arrayList.add(2, "Matched Identical");
            arrayList.add(3, "Matched with Changes");
        }
        this.matchStateCombo = new FilterComboboxPanel("Match State", arrayList, FilteringTabPanel.FILTER_LABEL_WIDTH, FilteringTabPanel.FILTER_COMBOBOX_WIDTH, FilteringTabPanel.ROW_HEIGHT);
        this.selectionCombo = new FilterComboboxPanel("Selection", arrayList2, FilteringTabPanel.FILTER_LABEL_WIDTH, FilteringTabPanel.FILTER_COMBOBOX_WIDTH, FilteringTabPanel.ROW_HEIGHT);
        this.sideCombo = new FilterComboboxPanel("Side", arrayList4, FilteringTabPanel.FILTER_LABEL_WIDTH, FilteringTabPanel.FILTER_COMBOBOX_WIDTH, FilteringTabPanel.ROW_HEIGHT);
        this.visibilityCombo = new FilterComboboxPanel("Visibility", arrayList3, FilteringTabPanel.FILTER_LABEL_WIDTH, FilteringTabPanel.FILTER_COMBOBOX_WIDTH, FilteringTabPanel.ROW_HEIGHT);
        this.startRangeField = new AddressRangeFieldPanel("Start Range", new CAddress("0000000000000000", 16), FilteringTabPanel.FILTER_LABEL_WIDTH, FilteringTabPanel.FILTER_COMBOBOX_WIDTH, FilteringTabPanel.ROW_HEIGHT);
        this.endRangeField = new AddressRangeFieldPanel("End Range", new CAddress("FFFFFFFFFFFFFFFF", 16), FilteringTabPanel.FILTER_LABEL_WIDTH, FilteringTabPanel.FILTER_COMBOBOX_WIDTH, FilteringTabPanel.ROW_HEIGHT);
        panel2.add(this.matchStateCombo);
        panel2.add(this.selectionCombo);
        panel2.add(this.visibilityCombo);
        if (b) {
            panel2.add(this.sideCombo);
        }
        panel2.add(this.startRangeField);
        panel2.add(this.endRangeField);
        panel.add(panel2, "North");
        return panel;
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
        if (this.matchStateCombo.getValue().equals("Matched with structural Changes")) {
            return EMatchStateFilter.MATCHED_STRUTURAL_CHANGES;
        }
        return EMatchStateFilter.NONE;
    }
    
    public ESelectionFilter getSelectionFilter() {
        if (this.selectionCombo.getValue().equals("Selected")) {
            return ESelectionFilter.SELECTED;
        }
        if (this.selectionCombo.getValue().equals("Unselected")) {
            return ESelectionFilter.UNSELECTED;
        }
        return ESelectionFilter.NONE;
    }
    
    public ESideFilter getSideFilter() {
        if (this.sideCombo.getValue().equals("Primary")) {
            return ESideFilter.PRIMARY;
        }
        if (this.sideCombo.getValue().equals("Secondary")) {
            return ESideFilter.SECONDARY;
        }
        return ESideFilter.NONE;
    }
    
    public IAddress getStartAddress() {
        return this.startRangeField.getValue();
    }
    
    public EVisibilityFilter getVisibilityFilter() {
        if (this.visibilityCombo.getValue().equals("Visible")) {
            return EVisibilityFilter.VISIBLE;
        }
        if (this.visibilityCombo.getValue().equals("Invisible")) {
            return EVisibilityFilter.INVISIBLE;
        }
        return EVisibilityFilter.NONE;
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
    
    static {
        FilteringTabPanel.FILTER_LABEL_WIDTH = 100;
        FilteringTabPanel.FILTER_COMBOBOX_WIDTH = 150;
        FilteringTabPanel.ROW_HEIGHT = 25;
    }
}
