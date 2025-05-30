// Source code is decompiled from a .class file using FernFlower decompiler.
package com.DroneCatalog;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainApp {
   public MainApp() {
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         JFrame frame = new JFrame("Drone Simulation Interface");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(1100, 700);
         frame.add(new MainDashboardPanel());
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
      });
   }
}
