package com.lynxwork.common.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

@ManagedBean(name = "fileUploadController")
@SessionScoped
public class FileUploadController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8301037577587831454L;
	static final Logger log = Logger.getLogger(FileUploadController.class);
	private ArrayList<UploadedImage> files = new ArrayList<UploadedImage>();
	 
    public void paint(OutputStream stream, Object object) throws IOException {
        stream.write(getFiles().get((Integer) object).getData());
        stream.close();
    }
 
    public void listener(FileUploadEvent event) throws Exception {
    	log.debug("init listener");
        UploadedFile item = event.getUploadedFile();
        UploadedImage file = new UploadedImage();
        file.setLength(item.getData().length);
        file.setName(item.getName());
        file.setData(item.getData());
        files.add(file);
        log.debug("end listener");
    }
    
    public String clearUploadData() {
        files.clear();
        return null;
    }
 
    public int getSize() {
        if (getFiles().size() > 0) {
            return getFiles().size();
        } else {
            return 0;
        }
    }
 
    public long getTimeStamp() {
        return System.currentTimeMillis();
    }
 
    public ArrayList<UploadedImage> getFiles() {
        return files;
    }
 
    public void setFiles(ArrayList<UploadedImage> files) {
        this.files = files;
    }
    
}