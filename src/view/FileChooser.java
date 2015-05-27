/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author s124392
 */
public class FileChooser extends JFileChooser {
    
    public FileChooser(String title) {
        super();
        setMode(title);
    }
    
    private void setMode(String title) {
        setMultiSelectionEnabled(false);
        if (title.contains("Image")) {
            setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        } else {
            setFileSelectionMode(JFileChooser.FILES_ONLY);
            setFileFilter(new FileNameExtensionFilter("XML Files","xml"));
        }
    }
}
