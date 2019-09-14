package Telinha;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import com.sun.org.apache.regexp.*;
import java.util.concurrent.TimeUnit;

public class TimedWebcam {

	public BufferedImage matToBufferedImage(Mat matrix) {  
		 int cols = matrix.cols();  
		 int rows = matrix.rows();  
		 int elemSize = (int)matrix.elemSize();  
		 byte[] data = new byte[cols * rows * elemSize];  
		 int type;  
		 matrix.get(0, 0, data);  
		 switch (matrix.channels()) {  
		   case 1:  
		     type = BufferedImage.TYPE_BYTE_GRAY;  
		     break;  
		   case 3:  
		     type = BufferedImage.TYPE_3BYTE_BGR;  
		     // bgr to rgb  
		     byte b;  
		     for(int i=0; i<data.length; i=i+3) {  
		       b = data[i];  
		       data[i] = data[i+2];  
		       data[i+2] = b;  
		     }  
		     break;  
		   default:  
		     return null;  
		 }  
		 BufferedImage image = new BufferedImage(cols, rows, type);  
		 image.getRaster().setDataElements(0, 0, cols, rows, data);  
		 return image;  

		} 

	private void BotaoStartActionPerformed(java.awt.event.ActionEvent evt){                                           
	    Mat imageMat = new Mat(); // matriz de imagem //

	    VideoCapture capture = new VideoCapture();
	    capture.open(0); // abre dispositivo de video de índice 0 //

	    // especifica altura e largura do video //
--	    capture.set(org.opencv.highgui.Highgui.CV_CAP_PROP_FRAME_HEIGHT, 320);
--	    capture.set(org.opencv.highgui.Highgui.CV_CAP_PROP_FRAME_WIDTH, 640);

	    BufferedImage image;

	    capture.read(imageMat); //Captura o quadro
	    image = this.matToBufferedImage(imageMat); //Converte para imageBuffer
	    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	    while(capture.isOpened()){
	    	
	        Icon icon = new ImageIcon(image);
--	        this.TelaImagem.setIcon(icon);
--	        this.TelaImagem.repaint();

	        try {
	            Thread.sleep(150);
	        } catch (InterruptedException ex) {

	        }
	    }

	}   

}
