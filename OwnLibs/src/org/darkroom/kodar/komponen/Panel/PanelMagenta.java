/*
 * @Junior Software, DarkPlace (c) 2014.
 * Jangan merubah dan melakukan editing terhadap pembuat (author)
 * pada file ini. Boleh digunakan sebagai Referensi dan free untuk share
 * 
 * indrakodar.kodar@gmail.com - (c) 0216, 04-August-2015
 * Last Update : 5 Februari 2016
 */
package org.darkroom.kodar.komponen.Panel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import org.darkroom.kodar.ref.KONST;

/**
 *
 * @author Kodar ~ Dark Places
 */
public class PanelMagenta extends JPanel {

    private static final long serialVersionUID = -1;
    private BufferedImage gradientImage;
    private final Color white = Color.WHITE;
    private final Color orange = Color.MAGENTA;

    /**
     * membuat panel white cyan
     */
    public PanelMagenta() {
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isOpaque()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            setUpGradient();
            g2.drawImage(gradientImage, 0, 0, getWidth(), getHeight(), null);

            int width = getWidth();
            int height = getHeight() * 5 / 100;

            Color light = new Color(1F, 1F, 1F, 0.5F);
            Color dark = new Color(1F, 1F, 1F, 0.0F);

            GradientPaint paint = new GradientPaint(0, 0, light, 0, height, dark);
            GeneralPath path = new GeneralPath();
            path.moveTo(0, 0);
            path.lineTo(0, height);
            path.curveTo(0, height, width / 2, height / 2, width, height);
            path.lineTo(width, 0);
            path.closePath();

            g2.setPaint(paint);
            g2.fill(path);

            paint = new GradientPaint(0, getHeight(), light, 0, getHeight() - height, dark);
            path = new GeneralPath();
            path.moveTo(0, getHeight());
            path.lineTo(0, getHeight() - height);
            path.curveTo(0, getHeight() - height, width / 2, getHeight() - height / 2, width, getHeight() - height);
            path.lineTo(width, getHeight());
            path.closePath();

            g2.setPaint(paint);
            g2.fill(path);
            g2.dispose();
        }
    }

    /**
     * membuat gambar background gradient
     */
    private void setUpGradient() {
        gradientImage = new BufferedImage(1, getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) gradientImage.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint paint = new GradientPaint(0, 0, white, 0, getHeight(), orange);

        g2.setPaint(paint);
        g2.fillRect(0, 0, 1, getHeight());
        g2.dispose();
    }

    @Override
    public String toString() {
        return KONST.TO_STRING;
    }
}
