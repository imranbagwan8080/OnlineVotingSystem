package com.app.service;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface StorageService {

	String store(MultipartFile file);
}
