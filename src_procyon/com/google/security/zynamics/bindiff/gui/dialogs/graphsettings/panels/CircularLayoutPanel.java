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

public class CircularLayoutPanel extends JPanel
{
    private static final int LABEL_WIDTH = 275;
    private static final int ROW_HEIGHT = 25;
    private static final int NUMBER_OF_ROWS = 2;
    private final JComboBox layoutStyle;
    private final JFormattedTextField minimumNodeDistance;
    private final ESettingsDialogType dialogType;
    private final GraphSettings settings;
    
    public CircularLayoutPanel(final String s, final ESettingsDialogType dialogType) {
        super(new BorderLayout());
        this.layoutStyle = new JComboBox();
        this.minimumNodeDistance = new JFormattedTextField(new DefaultFormatterFactory((JFormattedTextField.AbstractFormatter)new CDecFormatter(3)));
        Preconditions.checkNotNull(s);
        if (dialogType == null || dialogType == ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or non-initial.");
        }
        this.dialogType = dialogType;
        this.settings = null;
        this.init(s);
    }
    
    public CircularLayoutPanel(final String s, final ESettingsDialogType dialogType, final GraphSettings settings) {
        super(new BorderLayout());
        this.layoutStyle = new JComboBox();
        this.minimumNodeDistance = new JFormattedTextField(new DefaultFormatterFactory((JFormattedTextField.AbstractFormatter)new CDecFormatter(3)));
        Preconditions.checkNotNull(s);
        if (dialogType == null || dialogType != ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or not non-initial.");
        }
        this.dialogType = dialogType;
        this.settings = settings;
        this.init(s);
    }
    
    private ECircularLayoutStyle getCircularLayoutStyle(final BinDiffConfigFile binDiffConfigFile) {
        switch (CircularLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return ECircularLayoutStyle.getEnum(binDiffConfigFile.getInitialCallgraphSettings().getCircularLayoutStyle());
            }
            case 2: {
                return ECircularLayoutStyle.getEnum(binDiffConfigFile.getInitialFlowgraphSettings().getCircularLayoutStyle());
            }
            default: {
                return this.settings.getLayoutSettings().getCircularLayoutStyle();
            }
        }
    }
    
    private int getMinimumNodeDistance(final BinDiffConfigFile binDiffConfigFile) {
        switch (CircularLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getCircularMinimumNodeDistance();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getCircularMinimumNodeDistance();
            }
            default: {
                return (int)this.settings.getLayoutSettings().getMinimumCircularNodeDistance();
            }
        }
    }
    
    private void init(final String s) {
        this.setBorder(new LineBorder(Color.GRAY));
        this.layoutStyle.addItem("Compact");
        this.layoutStyle.addItem("Isolated");
        this.layoutStyle.addItem("Single Cycle");
        this.setCurrentValues();
        final JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        panel.setBorder(new TitledBorder(s));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Layout style", 275, this.layoutStyle, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Preferred node distance", 275, this.minimumNodeDistance, 25));
        this.add(panel, "North");
    }
    
    public ECircularLayoutStyle getCircularLayoutStyle() {
        return ECircularLayoutStyle.getEnum(this.layoutStyle.getSelectedIndex());
    }
    
    public int getMinimumNodeDistance() {
        return Integer.parseInt(this.minimumNodeDistance.getText());
    }
    
    public void setCurrentValues() {
        final BinDiffConfigFile instance = BinDiffConfigFile.getInstance();
        this.layoutStyle.setSelectedIndex(ECircularLayoutStyle.getOrdinal(this.getCircularLayoutStyle(instance)));
        this.minimumNodeDistance.setText(Integer.toString(this.getMinimumNodeDistance(instance)));
    }
}
