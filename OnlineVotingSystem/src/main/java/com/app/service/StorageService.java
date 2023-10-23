package com.app.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
@Repository
public interface StorageService {

	String store(MultipartFile file);
	Resource load(String fileName);
	public List<String> loadAll();

}
