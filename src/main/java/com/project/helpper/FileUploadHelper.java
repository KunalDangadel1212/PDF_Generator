package com.project.helpper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;



@Component
public class FileUploadHelper {
	
	
	
	//public final String UPLOAD_DIR="C:\\Users\\USER\\Desktop\\SpringBoot1\\SbUsingCrudRepository10\\src\\main\\resources\\image";
	public final String UPLOAD_DIR=new ClassPathResource("image/").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException
	{
	
	}

	public  boolean uploadFile(MultipartFile f)
	{
		boolean f1=false;
		
		try {
//			
//			InputStream is= f.getInputStream();
//			byte data[]=new byte[is.available()];
//			is.read(data);
//			
//			//write
//			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+"\\"+MultipartFile.getOriginalFilename());
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();
//			f1=true;
			
			 Files.copy(f.getInputStream(), Paths.get(UPLOAD_DIR, f.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f1;
	}
}
