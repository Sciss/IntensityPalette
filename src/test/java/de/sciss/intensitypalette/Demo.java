package de.sciss.intensitypalette;

import javax.swing.*;
import java.awt.*;

public class Demo implements Runnable {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Demo());
    }

    public void run() {
        final JFrame f = new JFrame("Palette");
        final int w = IntensityPalette.numColors;
        final int wm = w - 1;
        final float[] frac  = new float[w];
        final Color[] colrs = new Color[w];
        for(int i = 0; i < w; i++ ) {
            final float v   = (float) i / wm;
            frac[i]         = v;
            final int rgb   = IntensityPalette.apply(v);
            colrs[i]        = new Color(rgb);
        }

        final LinearGradientPaint pnt = new LinearGradientPaint(0f, 0f, wm, 0f, frac, colrs);
        final JComponent c = new JComponent() {
            @Override public void paintComponent(Graphics g) {
                final Graphics2D g2 = (Graphics2D) g;
                g2.setPaint(pnt);
                g2.fillRect(0, 0, w, 64);
            }
        };
        f.getRootPane().putClientProperty("Window.style", "small");
        f.setContentPane(c);
        f.setSize(w, 64);
        f.setResizable(false);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}