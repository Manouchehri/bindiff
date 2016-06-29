package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.date.SerialDate;

public class SerialDateChooserPanel extends JPanel implements ActionListener {
   public static final Color DEFAULT_DATE_BUTTON_COLOR;
   public static final Color DEFAULT_MONTH_BUTTON_COLOR;
   private SerialDate date;
   private Color dateButtonColor;
   private Color monthButtonColor;
   private Color chosenOtherButtonColor;
   private int firstDayOfWeek;
   private int yearSelectionRange;
   private Font dateFont;
   private JComboBox monthSelector;
   private JComboBox yearSelector;
   private JButton todayButton;
   private JButton[] buttons;
   private boolean refreshing;

   public SerialDateChooserPanel() {
      this(SerialDate.createInstance(new Date()), false, DEFAULT_DATE_BUTTON_COLOR, DEFAULT_MONTH_BUTTON_COLOR);
   }

   public SerialDateChooserPanel(SerialDate var1, boolean var2) {
      this(var1, var2, DEFAULT_DATE_BUTTON_COLOR, DEFAULT_MONTH_BUTTON_COLOR);
   }

   public SerialDateChooserPanel(SerialDate var1, boolean var2, Color var3, Color var4) {
      super(new BorderLayout());
      this.chosenOtherButtonColor = Color.darkGray;
      this.firstDayOfWeek = 1;
      this.yearSelectionRange = 20;
      this.dateFont = new Font("SansSerif", 0, 10);
      this.monthSelector = null;
      this.yearSelector = null;
      this.todayButton = null;
      this.buttons = null;
      this.refreshing = false;
      this.date = var1;
      this.dateButtonColor = var3;
      this.monthButtonColor = var4;
      this.add(this.constructSelectionPanel(), "North");
      this.add(this.getCalendarPanel(), "Center");
      if(var2) {
         this.add(this.constructControlPanel(), "South");
      }

   }

   public void setDate(SerialDate var1) {
      this.date = var1;
      this.monthSelector.setSelectedIndex(var1.getMonth() - 1);
      this.refreshYearSelector();
      this.refreshButtons();
   }

   public SerialDate getDate() {
      return this.date;
   }

   public void actionPerformed(ActionEvent var1) {
      JComboBox var2;
      if(var1.getActionCommand().equals("monthSelectionChanged")) {
         var2 = (JComboBox)var1.getSource();
         this.date = SerialDate.createInstance(this.date.getDayOfMonth(), var2.getSelectedIndex() + 1, this.date.getYYYY());
         this.refreshButtons();
      } else if(var1.getActionCommand().equals("yearSelectionChanged")) {
         if(!this.refreshing) {
            var2 = (JComboBox)var1.getSource();
            Integer var3 = (Integer)var2.getSelectedItem();
            this.date = SerialDate.createInstance(this.date.getDayOfMonth(), this.date.getMonth(), var3.intValue());
            this.refreshYearSelector();
            this.refreshButtons();
         }
      } else if(var1.getActionCommand().equals("todayButtonClicked")) {
         this.setDate(SerialDate.createInstance(new Date()));
      } else if(var1.getActionCommand().equals("dateButtonClicked")) {
         JButton var6 = (JButton)var1.getSource();
         int var7 = Integer.parseInt(var6.getName());
         SerialDate var4 = this.getFirstVisibleDate();
         SerialDate var5 = SerialDate.addDays(var7, var4);
         this.setDate(var5);
      }

   }

   private JPanel getCalendarPanel() {
      JPanel var1 = new JPanel(new GridLayout(7, 7));
      var1.add(new JLabel("Sun", 0));
      var1.add(new JLabel("Mon", 0));
      var1.add(new JLabel("Tue", 0));
      var1.add(new JLabel("Wed", 0));
      var1.add(new JLabel("Thu", 0));
      var1.add(new JLabel("Fri", 0));
      var1.add(new JLabel("Sat", 0));
      this.buttons = new JButton[42];

      for(int var2 = 0; var2 < 42; ++var2) {
         JButton var3 = new JButton("");
         var3.setMargin(new Insets(1, 1, 1, 1));
         var3.setName(Integer.toString(var2));
         var3.setFont(this.dateFont);
         var3.setFocusPainted(false);
         var3.setActionCommand("dateButtonClicked");
         var3.addActionListener(this);
         this.buttons[var2] = var3;
         var1.add(var3);
      }

      return var1;
   }

   protected Color getButtonColor(SerialDate var1) {
      return this.date.equals(this.date)?this.dateButtonColor:(var1.getMonth() == this.date.getMonth()?this.monthButtonColor:this.chosenOtherButtonColor);
   }

   protected SerialDate getFirstVisibleDate() {
      SerialDate var1 = SerialDate.createInstance(1, this.date.getMonth(), this.date.getYYYY());

      for(var1 = SerialDate.addDays(-1, var1); var1.getDayOfWeek() != this.getFirstDayOfWeek(); var1 = SerialDate.addDays(-1, var1)) {
         ;
      }

      return var1;
   }

   private int getFirstDayOfWeek() {
      return this.firstDayOfWeek;
   }

   protected void refreshButtons() {
      SerialDate var1 = this.getFirstVisibleDate();

      for(int var2 = 0; var2 < 42; ++var2) {
         JButton var3 = this.buttons[var2];
         var3.setText(String.valueOf(var1.getDayOfWeek()));
         var3.setBackground(this.getButtonColor(var1));
         var1 = SerialDate.addDays(1, var1);
      }

   }

   private void refreshYearSelector() {
      if(!this.refreshing) {
         this.refreshing = true;
         this.yearSelector.removeAllItems();
         Vector var1 = this.getYears(this.date.getYYYY());
         Enumeration var2 = var1.elements();

         while(var2.hasMoreElements()) {
            this.yearSelector.addItem(var2.nextElement());
         }

         this.yearSelector.setSelectedItem(new Integer(this.date.getYYYY()));
         this.refreshing = false;
      }

   }

   private Vector getYears(int var1) {
      Vector var2 = new Vector();

      for(int var3 = var1 - this.yearSelectionRange; var3 <= var1 + this.yearSelectionRange; ++var3) {
         var2.addElement(new Integer(var3));
      }

      return var2;
   }

   private JPanel constructSelectionPanel() {
      JPanel var1 = new JPanel();
      this.monthSelector = new JComboBox(SerialDate.getMonths());
      this.monthSelector.addActionListener(this);
      this.monthSelector.setActionCommand("monthSelectionChanged");
      var1.add(this.monthSelector);
      this.yearSelector = new JComboBox(this.getYears(0));
      this.yearSelector.addActionListener(this);
      this.yearSelector.setActionCommand("yearSelectionChanged");
      var1.add(this.yearSelector);
      return var1;
   }

   private JPanel constructControlPanel() {
      JPanel var1 = new JPanel();
      var1.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
      this.todayButton = new JButton("Today");
      this.todayButton.addActionListener(this);
      this.todayButton.setActionCommand("todayButtonClicked");
      var1.add(this.todayButton);
      return var1;
   }

   static {
      DEFAULT_DATE_BUTTON_COLOR = Color.red;
      DEFAULT_MONTH_BUTTON_COLOR = Color.lightGray;
   }
}
