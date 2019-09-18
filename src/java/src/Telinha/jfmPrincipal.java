package Telinha;

import org.opencv.highgui.*;
import org.opencv.core.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.swing.JFileChooser;
import javax.xml.ws.WebServiceClient;

import org.opencv.calib3d.*;
import org.opencv.imgcodecs.*;
import org.opencv.utils.*;
import org.opencv.videoio.VideoCapture;

//public class tells {
//
//	    public static void main(String[] args) {

public class jfmPrincipal extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	VideoCapture webCam;
	ExibeQuadro exibeQuadro;
	Thread executor;
	private DaemonThread myThread = null;
	int count = 0;
	VideoCapture webSource = null;

	Mat frame = new Mat();
	MatOfByte mem = new MatOfByte();

	class DaemonThread implements Runnable {
		protected volatile boolean runnable = false;

		@Override
		public void run() {
			synchronized (this) {
				while (runnable) {
					// if(WebService.this())
					{
						try {
							// WebService.this(frame);
							Imgcodecs.imencode(".bmp", frame, mem);
							Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));

							BufferedImage buff = (BufferedImage) im;
							
							Graphics g = im.getGraphics();

							if (g.drawImage(buff, 0, 0, getWidth(), getHeight() - 150, 0, 0, buff.getWidth(),
									buff.getHeight(), null))

								if (runnable == false) {
									System.out.println("Going to wait()");
									this.wait();
								}
						} catch (Exception ex) {
							System.out.println("Error");
						}
					}
				}
			}
		}
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

		Object jFileChooser1 = null;
		int returnVal = ((JFileChooser) jFileChooser1).showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = ((JFileChooser) jFileChooser1).getSelectedFile();
			HighGui.imshow(file.getPath(), frame);
		} else {
			System.out.println("Acesso negado.");
		}
	}

}

