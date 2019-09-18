package Telinha;
	import java.awt.Dimension;
import java.awt.image.BufferedImage;

import org.opencv.*;
import org.opencv.core.Mat;
import org.opencv.highgui.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import java.io.File;
	import java.io.IOException;
	import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.concurrent.TimeUnit;

public class ExibeQuadro {

		

		private void BotaoStartActionPerformed(java.awt.event.ActionEvent evt){                                           
		    Mat imageMat = new Mat(); // matriz de imagem //

		    VideoCapture capture = new VideoCapture();
		    capture.open(0); // abre dispositivo de video de índice 0 //

		    // especifica altura e largura do video //
		    capture.set(Imgproc.CC_STAT_HEIGHT, 320);
		    capture.set(Imgproc.CC_STAT_WIDTH, 640);
		 
		    BufferedImage image;

		    capture.read(imageMat); //Captura o quadro
		    image = this.MatToBufferedImage(imageMat); //Converte para imageBuffer
             
		    while(capture.isOpened()){
		        Icon icon = new ImageIcon(image);
		        this.imageMat.setIcon(icon);
		        this.imageMat.repaint();

		        try {
		            Thread.sleep(150);
		        } catch (InterruptedException ex) {

		        }
		    }

		}   

	}

