package com.lynxwork.social.publication.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.lynxwork.config.SystemConfig;
import com.lynxwork.persistance.exception.SaveEntityException;
import com.lynxwork.security.model.User;
import com.lynxwork.social.publication.model.Publication;
import com.lynxwork.social.publication.service.PublicationService;

/**
 * Pagina utilizada para el login del usuario de la aplicacion
 * @author Juan Arturo Vargas Torres
 */
@ManagedBean(name = "publicationController")
@SessionScoped
public class PublicationController implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7166244801745355906L;

	static final Logger log = Logger.getLogger(PublicationController.class);

	private Publication publication;
	private List<Publication> publications;
	private User user;
	
	@PostConstruct
    public void init() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) ctx.getExternalContext()
				.getSession(true);
		Object obj = session.getAttribute(SystemConfig.SESSION_CONFIG_USER);
		if (obj != null) {
			user = (User) obj;
			log.info("The user objectis ok");
		} else {
			log.warn("The user object is null, contact to Administration Platform");
		}
		log.info("******End Get User Session Object");
		//Get publications
		publications = new  ArrayList<Publication>();
		publication = new Publication();
		try{
			PublicationService service = new PublicationService();
			publications = service.findPrimaryPublications(user.getUserId());
		}catch(Exception e){
			e.printStackTrace();
			log.error("No es posible consultar las publicaciones del usuario" + e);
		}
		
	}
	
	
	public String savePublication(){
		log.info("----Init savePublication");
		PublicationService service = new PublicationService();
		try {
			publication.setUserId(user.getUserId());
			publication.setCualification(new Integer(0));
			//Audit Fields
			publication.setCreateDate(new Date());
			publication.setCreatoIp("");
			publication.setCreatorId(user.getUserId());
			publication.setLastUpdateDate(new Date());
			publication.setLastUpdaterIp("");
			publication.setLastUpdaterId(user.getUserId());
			service.save(publication);
		} catch (SaveEntityException e) {
			log.error("No es posible salvar la publicacion" + e);
		}catch (Exception e) {
			log.error("No es posible salvar la publicacion" + e);
		}
		log.info("----End savePublication");
		return "";
	}
	


	public Publication getPublication() {
		return publication;
	}


	public void setPublication(Publication publication) {
		this.publication = publication;
	}


	public List<Publication> getPublications() {
		return publications;
	}


	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}
	
}
