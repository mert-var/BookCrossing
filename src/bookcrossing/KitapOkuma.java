/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookcrossing;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

/**
 *
 * @author MERT
 */
public class KitapOkuma  {
    
 
    String filepath;
 
    public KitapOkuma(String Filepath) {
        
        filepath=Filepath;

     SwingController controller = new SwingController();

        SwingViewBuilder factory = new SwingViewBuilder(controller);

        JPanel viewerComponentPanel = factory.buildViewerPanel();

        controller.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                        controller.getDocumentViewController()));

        JFrame applicationFrame = new JFrame();
        applicationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        applicationFrame.add(viewerComponentPanel);
        
        controller.openDocument(filepath);

        applicationFrame.pack();
        applicationFrame.setVisible(true);
        for(int i=0; i<15;i++)
            {
                System.out.println();
            }
    }
        public static void main(String[] args) throws IOException {
      
            
    }
    
}

