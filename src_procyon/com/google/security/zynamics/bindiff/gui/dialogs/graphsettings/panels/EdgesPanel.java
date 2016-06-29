package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.config.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import java.awt.*;

public class EdgesPanel extends JPanel
{
    private static final int LABEL_WIDTH = 275;
    private static final int ROW_HEIGHT = 25;
    private static final int NUMBER_OF_ROWS = 1;
    private final JComboBox drawBends;
    private final ESettingsDialogType dialogType;
    private final GraphSettings settings;
    
    public EdgesPanel(final String s, final ESettingsDialogType dialogType) {
        super(new BorderLayout());
        this.drawBends = new JComboBox();
        Preconditions.checkNotNull(s);
        if (dialogType == null || dialogType == ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or non-initial.");
        }
        this.dialogType = dialogType;
        this.settings = null;
        this.init(s);
    }
    
    public EdgesPanel(final String s, final ESettingsDialogType dialogType, final GraphSettings settings) {
        super(new BorderLayout());
        this.drawBends = new JComboBox();
        Preconditions.checkNotNull(s);
        if (dialogType == null || dialogType != ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or not non-initial.");
        }
        this.dialogType = dialogType;
        this.settings = settings;
        this.init(s);
    }
    
    private boolean getDrawBends(final BinDiffConfigFile binDiffConfigFile) {
        switch (EdgesPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getDrawBends();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getDrawBends();
            }
            default: {
                return this.settings.getDrawBends();
            }
        }
    }
    
    private void init(final String s) {
        this.setBorder(new LineBorder(Color.GRAY));
        this.drawBends.addItem("On");
        this.drawBends.addItem("Off");
        this.setCurrentValues();
        final JPanel panel = new JPanel(new GridLayout(1, 1, 5, 5));
        panel.setBorder(new TitledBorder(s));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Draw bends", 275, this.drawBends, 25));
        this.add(panel, "North");
    }
    
    public boolean getDrawBends() {
        return this.drawBends.getSelectedIndex() == 0;
    }
    
    public void setCurrentValues() {
        this.drawBends.setSelectedIndex(this.getDrawBends(BinDiffConfigFile.getInstance()) ? 0 : 1);
    }
}
