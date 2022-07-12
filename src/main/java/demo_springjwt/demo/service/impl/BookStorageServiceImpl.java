package demo_springjwt.demo.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import demo_springjwt.demo.service.BookStorageService;

@Service
public class BookStorageServiceImpl implements BookStorageService{
	
	@Value("${file.share}")
	private String filePath;

	@Override
	public String saveFile(MultipartFile file) {
		if(file.isEmpty()) {
			return null;
		}
		try {
        	Path fileFolder = Paths.get(this.filePath);
	        if (!fileFolder.toFile().exists() || !fileFolder.toFile().isDirectory()) {
				Files.createDirectories(fileFolder);
	        }
	        String fileName = System.currentTimeMillis() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
	        Path destination = fileFolder.resolve(fileName);
			FileCopyUtils.copy(file.getBytes(), new File(destination.toString()));
			return fileName;
        } catch (IOException e) {
	        return null;
        }
	}
	
	public File loadFile(String fileName) {
		if (StringUtils.isEmpty(fileName)) {
			return null;
		}
        Path fileFolder = Paths.get(this.filePath);
        Path destination = fileFolder.resolve(fileName);
        
        return destination.toFile().exists() ? destination.toFile() : null;
	}

}
