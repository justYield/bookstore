package service;

import java.io.File;

import model.Picture;

public interface BookService {
    public Picture getPictureById(int id);
	
	public boolean uploadPicture(int id,File file,String contentType,String fileName);

}
