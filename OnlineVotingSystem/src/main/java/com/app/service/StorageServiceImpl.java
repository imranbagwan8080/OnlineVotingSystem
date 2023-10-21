package com.app.service;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StorageServiceImpl implements StorageService {

	@Override
	public String store(MultipartFile file) {

		String fileName = file.getOriginalFilename();
		File dir = new File("images");
		
		if(!dir.isDirectory()) {
			System.out.println("dir created");
			dir.mkdir();
		}
		
		File filePath = new File("images", fileName);
		try(FileOutputStream out = new FileOutputStream(filePath)) {
			System.out.println("file write");
			FileCopyUtils.copy(file.getInputStream(), out);
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
}
