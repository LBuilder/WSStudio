/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import controller.MainViewController;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author s124392
 */
public abstract class View extends JFrame {
    //<editor-fold defaultstate="collapsed" desc="Instance Variables">
    /**
     * This views controller.
     */
    protected MainViewController controller;
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constants"> 
    /**
     * Static frame size for this application's views.
     */
    public static final Dimension SIZE = new Dimension(800, 600);
    //</editor-fold>
    
    /**
     * Constructor.
     * @param c the controller for this view.
     */
    public View(final MainViewController c) {
        this.controller = c;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Centers the frame.
     */
    public void centerize() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2- (int) SIZE.getWidth() / 2, dim.height / 
                2 - (int) SIZE.getHeight() / 2);
    }
}
