package com.example.demo;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sourceforge.tess4j.Tesseract;

@Service
public class TesseractService {

	@Autowired
	private Tesseract tesseract;

	public String recognizedText(InputStream inputStream) throws IOException {
		BufferedImage image = ImageIO.read(inputStream);
		try {
			return tesseract.doOCR(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "faild";
	}
}
