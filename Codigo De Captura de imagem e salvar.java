package Telinha;
	import java.awt.Dimension;
import java.awt.image.BufferedImage;

import org.opencv.*;
import org.opencv.core.Mat;
import org.opencv.highgui.*;
import org.opencv.videoio.VideoCapture;

import java.io.File;
	import java.io.IOException;
	import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.concurrent.TimeUnit;
public class ExibeQuadro {

		private static final int CV_CAP_PROP_FRAME_HEIGHT = 0;
		private static final int CV_CAP_PROP_FRAME_WIDTH = 0;

		private void BotaoStartActionPerformed(java.awt.event.ActionEvent evt){                                           
		    Mat imageMat = new Mat(); // matriz de imagem //

		    VideoCapture capture = new VideoCapture();
		    capture.open(0); // abre dispositivo de video de índice 0 //

		    // especifica altura e largura do video //
		    capture.set(CV_CAP_PROP_FRAME_HEIGHT, 320);
		    capture.set(CV_CAP_PROP_FRAME_WIDTH, 640);
		 
		    BufferedImage image;

		    capture.read(imageMat); //Captura o quadro
--		    image = this.MatToBufferedImage(imageMat); //Converte para imageBuffer

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

