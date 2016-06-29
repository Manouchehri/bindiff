package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.zylib.gui.*;
import javax.swing.text.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import java.awt.*;

public class HierarchicalLayoutPanel extends JPanel
{
    private static final int LABEL_WIDTH = 275;
    private static final int ROW_HEIGHT = 25;
    private static final int NUMBER_OF_ROWS = 4;
    private final JComboBox orientation;
    private final JComboBox layoutStyle;
    private final JFormattedTextField minimumLayerDistance;
    private final JFormattedTextField minimumNodeDistance;
    private final ESettingsDialogType dialogType;
    private final GraphSettings settings;
    
    public HierarchicalLayoutPanel(final String s, final ESettingsDialogType dialogType) {
        super(new BorderLayout());
        this.orientation = new JComboBox();
        this.layoutStyle = new JComboBox();
        this.minimumLayerDistance = new JFormattedTextField(new DefaultFormatterFactory((JFormattedTextField.AbstractFormatter)new CDecFormatter(3)));
        this.minimumNodeDistance = new JFormattedTextField(new DefaultFormatterFactory((JFormattedTextField.AbstractFormatter)new CDecFormatter(3)));
        Preconditions.checkNotNull(s);
        if (dialogType == null || dialogType == ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or non-initial.");
        }
        this.dialogType = dialogType;
        this.settings = null;
        this.init(s);
    }
    
    public HierarchicalLayoutPanel(final String s, final ESettingsDialogType dialogType, final GraphSettings settings) {
        super(new BorderLayout());
        this.orientation = new JComboBox();
        this.layoutStyle = new JComboBox();
        this.minimumLayerDistance = new JFormattedTextField(new DefaultFormatterFactory((JFormattedTextField.AbstractFormatter)new CDecFormatter(3)));
        this.minimumNodeDistance = new JFormattedTextField(new DefaultFormatterFactory((JFormattedTextField.AbstractFormatter)new CDecFormatter(3)));
        Preconditions.checkNotNull(s);
        if (dialogType == null || dialogType != ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or not non-initial.");
        }
        this.dialogType = dialogType;
        this.settings = settings;
        this.init(s);
    }
    
    private ELayoutOrientation getLayoutOrientation(final BinDiffConfigFile binDiffConfigFile) {
        switch (HierarchicalLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return ELayoutOrientation.getEnum(binDiffConfigFile.getInitialCallgraphSettings().getHierarchicalOrientation());
            }
            case 2: {
                return ELayoutOrientation.getEnum(binDiffConfigFile.getInitialFlowgraphSettings().getHierarchicalOrientation());
            }
            default: {
                return this.settings.getLayoutSettings().getHierarchicOrientation();
            }
        }
    }
    
    private int getMinimumLayerDistance(final BinDiffConfigFile binDiffConfigFile) {
        switch (HierarchicalLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getHierarchicalMinimumNodeDistance();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getHierarchicalMinimumNodeDistance();
            }
            default: {
                return (int)this.settings.getLayoutSettings().getMinimumHierarchicLayerDistance();
            }
        }
    }
    
    private int getMinimumNodeDistance(final BinDiffConfigFile binDiffConfigFile) {
        switch (HierarchicalLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getHierarchicalMinimumLayerDistance();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getHierarchicalMinimumLayerDistance();
            }
            default: {
                return (int)this.settings.getLayoutSettings().getMinimumHierarchicNodeDistance();
            }
        }
    }
    
    private boolean getOrthogonalEdgeRouting(final BinDiffConfigFile binDiffConfigFile) {
        switch (HierarchicalLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getHierarchicalOrthogonalEdgeRouting();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getHierarchicalOrthogonalEdgeRouting();
            }
            default: {
                return this.settings.getLayoutSettings().getHierarchicalOrthogonalEdgeRouting();
            }
        }
    }
    
    private void init(final String s) {
        this.setBorder(new LineBorder(Color.GRAY));
        this.layoutStyle.addItem("On");
        this.layoutStyle.addItem("Off");
        this.orientation.addItem("Vertical");
        this.orientation.addItem("Horizontal");
        this.setCurrentValues();
        final JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.setBorder(new TitledBorder(s));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Orthogonal Edge Routing", 275, this.layoutStyle, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Layout orientation", 275, this.orientation, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Minimum layer distance", 275, this.minimumLayerDistance, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Minimum node distance", 275, this.minimumNodeDistance, 25));
        this.add(panel, "North");
    }
    
    public ELayoutOrientation getLayoutOrientation() {
        return ELayoutOrientation.getEnum(this.orientation.getSelectedIndex());
    }
    
    public int getMinimumLayerDistance() {
        return Integer.parseInt(this.minimumLayerDistance.getText());
    }
    
    public int getMinimumNodeDistance() {
        return Integer.parseInt(this.minimumNodeDistance.getText());
    }
    
    public boolean getOrthogonalEdgeRouting() {
        return this.layoutStyle.getSelectedIndex() == 0;
    }
    
    public void setCurrentValues() {
        final BinDiffConfigFile instance = BinDiffConfigFile.getInstance();
        this.layoutStyle.setSelectedIndex(this.getOrthogonalEdgeRouting(instance) ? 0 : 1);
        this.orientation.setSelectedIndex(ELayoutOrientation.getOrdinal(this.getLayoutOrientation(instance)));
        this.minimumLayerDistance.setText(Integer.toString(this.getMinimumLayerDistance(instance)));
        this.minimumNodeDistance.setText(Integer.toString(this.getMinimumNodeDistance(instance)));
    }
}
