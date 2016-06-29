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

public class OrthogonalLayoutPanel extends JPanel
{
    private static final int LABEL_WIDTH = 275;
    private static final int ROW_HEIGHT = 25;
    private static final int NUMBER_OF_ROWS = 3;
    private final JComboBox orientation;
    private final JComboBox layoutStyle;
    private final JFormattedTextField minimumNodeDistance;
    private final ESettingsDialogType dialogType;
    private final GraphSettings settings;
    
    public OrthogonalLayoutPanel(final String s, final ESettingsDialogType dialogType) {
        super(new BorderLayout());
        this.orientation = new JComboBox();
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
    
    public OrthogonalLayoutPanel(final String s, final ESettingsDialogType dialogType, final GraphSettings settings) {
        super(new BorderLayout());
        this.orientation = new JComboBox();
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
    
    private int getMinimumNodeDistance(final BinDiffConfigFile binDiffConfigFile) {
        switch (OrthogonalLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getOrthogonalMinimumNodeDistance();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getOrthogonalMinimumNodeDistance();
            }
            default: {
                return (int)this.settings.getLayoutSettings().getMinimumOrthogonalNodeDistance();
            }
        }
    }
    
    private EOrthogonalLayoutStyle getOrthogonalLayoutStyle(final BinDiffConfigFile binDiffConfigFile) {
        switch (OrthogonalLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return EOrthogonalLayoutStyle.getEnum(binDiffConfigFile.getInitialCallgraphSettings().getOrthogonalLayoutStyle());
            }
            case 2: {
                return EOrthogonalLayoutStyle.getEnum(binDiffConfigFile.getInitialFlowgraphSettings().getOrthogonalLayoutStyle());
            }
            default: {
                return this.settings.getLayoutSettings().getOrthogonalLayoutStyle();
            }
        }
    }
    
    private ELayoutOrientation getOrthogonalOrientation(final BinDiffConfigFile binDiffConfigFile) {
        switch (OrthogonalLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return ELayoutOrientation.getEnum(binDiffConfigFile.getInitialCallgraphSettings().getOrthogonalOrientation());
            }
            case 2: {
                return ELayoutOrientation.getEnum(binDiffConfigFile.getInitialFlowgraphSettings().getOrthogonalOrientation());
            }
            default: {
                return this.settings.getLayoutSettings().getOrthogonalLayoutOrientation();
            }
        }
    }
    
    private void init(final String s) {
        this.setBorder(new LineBorder(Color.GRAY));
        this.layoutStyle.addItem("Normal");
        this.layoutStyle.addItem("Tree");
        this.orientation.addItem("Horizontal");
        this.orientation.addItem("Vertical");
        this.setCurrentValues();
        final JPanel panel = new JPanel(new GridLayout(3, 1, 5, 5));
        panel.setBorder(new TitledBorder(s));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Layout Style", 275, this.layoutStyle, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Layout orientation", 275, this.orientation, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Minimum node distance", 275, this.minimumNodeDistance, 25));
        this.add(panel, "North");
    }
    
    public int getMinimumNodeDistance() {
        return Integer.parseInt(this.minimumNodeDistance.getText());
    }
    
    public EOrthogonalLayoutStyle getOrthogonalLayoutStyle() {
        return EOrthogonalLayoutStyle.getEnum(this.layoutStyle.getSelectedIndex());
    }
    
    public ELayoutOrientation getOrthogonalOrientation() {
        return ELayoutOrientation.getEnum(this.orientation.getSelectedIndex());
    }
    
    public void setCurrentValues() {
        final BinDiffConfigFile instance = BinDiffConfigFile.getInstance();
        this.layoutStyle.setSelectedIndex(EOrthogonalLayoutStyle.getOrdinal(this.getOrthogonalLayoutStyle(instance)));
        this.orientation.setSelectedIndex(ELayoutOrientation.getOrdinal(this.getOrthogonalOrientation(instance)));
        this.minimumNodeDistance.setText(Integer.toString(this.getMinimumNodeDistance(instance)));
    }
}
