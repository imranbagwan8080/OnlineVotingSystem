package com.app.service;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
@Repository
public interface StorageService {

	String store(MultipartFile file);
	Resource load(String fileName);
}
