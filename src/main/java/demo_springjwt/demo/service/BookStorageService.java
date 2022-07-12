package demo_springjwt.demo.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface BookStorageService {
	String saveFile(MultipartFile file);
	File loadFile(String fileName);
}
