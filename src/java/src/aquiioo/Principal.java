package aquiioo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.highgui.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

//import com.br.model.PropriedadesFace;
//import com.br.service.ServiceDesfoqueImagem;
//import com.br.service.ServiceCorteImagem;
//import com.br.service.ServiceDeteccaoFacesImagem;
//import com.br.service.ServiceSobreposicaoImagem;
//import com.br.util.Util;

public class Principal {
//	public class PropriedadesFace {
//		private int x;
//		private int y;
//		private int width;
//		private int height;
//		private BufferedImage imageCortada;
//		
//		public int getX() {
//			return x;
//		}
//		public void setX(int x) {
//			this.x = x;
//		}
//		public int getY() {
//			return y;
//		}
//		public void setY(int y) {
//			this.y = y;
//		}
//		public int getWidth() {
//			return width;
//		}
//		public void setWidth(int width) {
//			this.width = width;
//		}
//		public int getHeight() {
//			return height;
//		}
//		public void setHeight(int height) {
//			this.height = height;
//		}
//		public BufferedImage getImageCortada() {
//			return imageCortada;
//		}
//		public void setImageCortada(BufferedImage imageCortada) {
//			this.imageCortada = imageCortada;
//		}
//	}
//
//		public List<PropriedadesFace> CortarImagem(List<PropriedadesFace> dados, BufferedImage imagem){
//			
//			for(PropriedadesFace dado : dados){
//				dado.setImageCortada(imagem.getSubimage(dado.getX(), dado.getY(), dado.getWidth(), dado.getHeight()));
//			}
//			
//			return dados;
//		}
//	
//		public BufferedImage DesfocarImagem(Mat mat){
//			
//			mat = Desfocar(mat);
//			
//			return Util.converterParaImage(mat);
//		}
//		
//		private Mat Desfocar(Mat image){
//				      
//			Mat destination = new Mat(image.rows(),image.cols(),image.type());
//				      
//			Imgproc.GaussianBlur(image, destination,new Size(45,45), 0);
//			
//			return destination;
//		}
//
//		public MatOfRect detectarFaces(CascadeClassifier cascadeClassifier, Mat mat){
//			
//			MatOfRect matOfRect = new MatOfRect();
//			cascadeClassifier.detectMultiScale(mat, matOfRect);
//			
//			return matOfRect;
//		}
//		
//	
//		
//		public List<PropriedadesFace> obDadosFaces(MatOfRect matOfRect){
//			
//			List<PropriedadesFace> dados = new ArrayList<PropriedadesFace>();
//			
//			for (Rect rect : matOfRect.toArray()) {
//				
//				PropriedadesFace prop = new PropriedadesFace();
//				prop.setX(rect.x);
//				prop.setY(rect.y);
//				prop.setHeight(rect.height);
//				prop.setWidth(rect.width);
//				
//				dados.add(prop);
//
//			}
//			
//			return dados;
//		}
//		
//		public MatOfRect detectarFac(CascadeClassifier cascadeClassifier, Mat mat){
//			
//			MatOfRect matOfRect = new MatOfRect();
//			cascadeClassifier.detectMultiScale(mat, matOfRect);
//			
//			return matOfRect;
//		}
//		
//	
//		public List<PropriedadesFace> obterDadosFaces(MatOfRect matOfRect){
//			
//			List<PropriedadesFace> dados = new ArrayList<PropriedadesFace>();
//			
//			for (Rect rect : matOfRect.toArray()) {
//				
//				PropriedadesFace prop = new PropriedadesFace();
//				prop.setX(rect.x);
//				prop.setY(rect.y);
//				prop.setHeight(rect.height);
//				prop.setWidth(rect.width);
//				
//				dados.add(prop);
//
//			}
//			
//			return dados;
//		}
//		
//		
//		public BufferedImage juntarImagens(List<PropriedadesFace> dados, BufferedImage imagemPrincipal){
//			
//			for(PropriedadesFace dado: dados){
//				imagemPrincipal = juntarUmaImage(imagemPrincipal, dado.getImageCortada(),dado.getX(),dado.getY());
//			}
//			
//			return imagemPrincipal;
//			
//		}
//		
//		public static BufferedImage juntarUmaImage(BufferedImage imagemPrincipal,
//	            BufferedImage imagemCortada, int x, int y) {
//	 
//	        Graphics2D g = imagemPrincipal.createGraphics();
//	        
//	        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//	                RenderingHints.VALUE_ANTIALIAS_ON);
//	        
//	        g.drawImage(imagemPrincipal, 0,0, null);
//	 
//	        g.drawImage(imagemCortada, x, y, null);
//	 
//	        g.dispose();
//	        return imagemPrincipal;
//	    }
//		
//		
//		public static Mat converterParaMat(BufferedImage im) {
//			
//			byte[] pixels = ((DataBufferByte)im.getRaster().getDataBuffer()).getData();
//			Mat mat = new Mat(im.getHeight(), im.getWidth(), CvType.CV_8UC3);
//			mat.put(0, 0, pixels);
//			
//			return mat;
//		}
//		
//		public static BufferedImage converterParaImage(Mat image){
//
//			MatOfByte bytemat = new MatOfByte();
//
//			Imgcodecs.imencode(".jpg", image, bytemat);
//
//			byte[] bytes = bytemat.toArray();
//
//			InputStream in = new ByteArrayInputStream(bytes);
//
//			BufferedImage img=null;
//
//			try {
//				img = ImageIO.read(in);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//			return img;
//		}
		
	
	public static void main(String[] args) {
		
		//System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		//esse arquivo contém as parametrizações para fazer a detecção facial
		CascadeClassifier cascadeClassifier = new CascadeClassifier(System.getProperty("user.dir") + "/haarcascade_frontalface_alt_tree.xml");

		Mat mat = Imgcodecs.imread(System.getProperty("user.dir") +"/chaves.png");
		
		//faz a detecção das faces
		ServiceDeteccaoFacesImagem serviceExtractFaces = new ServiceDeteccaoFacesImagem();
		MatOfRect matOfRect = serviceExtractFaces.detectarFaces(cascadeClassifier, mat);
		
		//obtem os dados de onde estão as faces (altura, largura, posição x e y)
		List<aquiioo.PropriedadesFace> propsFaces = serviceExtractFaces.obterDadosFaces(matOfRect);
		
		//desfoca a imagem
		ServiceDesfoqueImagem serviceBlur = new ServiceDesfoqueImagem();
		BufferedImage imagemCorteDesfoque = serviceBlur.DesfocarImagem(mat);
		
		//corta os rostos da imagem desfocada, 
		ServiceCorteImagem serviceCrop = new ServiceCorteImagem();
		propsFaces = serviceCrop.CortarImagem(propsFaces, imagemCorteDesfoque);
		
		ServiceSobreposicaoImagem serviceOverlay = new ServiceSobreposicaoImagem();
		
		//obtem toda a imagem se efeitos
		BufferedImage imagemSemEfeitos = Util.converterParaImage(mat);
		
		//"cola" os rostos desfocados sobre a imagem original
		imagemCorteDesfoque = serviceOverlay.juntarImagens(propsFaces, imagemSemEfeitos);
		
		File outputfile = new File("chaves menor.jpg");
		
	    try {
			ImageIO.write(imagemCorteDesfoque, "jpg", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
