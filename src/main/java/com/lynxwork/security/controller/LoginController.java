package com.lynxwork.security.controller;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.richfaces.cdi.push.Push;
import com.lynxwork.config.SystemConfig;
import com.lynxwork.mdm.person.model.Person;
import com.lynxwork.security.exception.UserRegistrationException;
import com.lynxwork.security.model.User;
import com.lynxwork.security.service.UserService;


/**
 * Pagina utilizada para el login del usuario de la aplicacion
 *
 * @author Juan Arturo Vargas Torres
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7716275092236376258L;
	public static final String PUSH_CDI_TOPIC = "pushCdi";
	static final Logger log = Logger.getLogger(LoginController.class);
    
    @Inject
    @Push(topic = PUSH_CDI_TOPIC) Event<String> pushEvent;
    
    //@Inject
    //UserService userService;
    //login
	private String userEmail;
	private String password;
	//register
	private String firstName;
	private String middleName;
	private String lastName;
	private String joinEmail;
	private String joinPassword;
	
	private boolean isLogin = false;


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJoinEmail() {
		return joinEmail;
	}

	public void setJoinEmail(String joinEmail) {
		this.joinEmail = joinEmail;
	}

	public String getJoinPassword() {
		return joinPassword;
	}

	public void setJoinPassword(String joinPassword) {
		this.joinPassword = joinPassword;
	}

	public String login(){
		log.info("User email:" + userEmail);
		log.info("User password:" + password);
		User user = null;
		UserService userService = new UserService();
		try{
			user = userService.findUser(userEmail, password);
			log.info("usuario :" + user.toString());
			if(user.getEnabled() != null && user.getEnabled().equals("true") ){
				log.info("El usuario :" + userEmail +" esta registrado");
				if( user.getIsBasicProfileComplete()!=null && user.getIsBasicProfileComplete().equalsIgnoreCase("true") ){
					FacesContext ctx = FacesContext.getCurrentInstance();
					HttpSession session = (HttpSession)ctx.getExternalContext().getSession(true);
					session.setAttribute(SystemConfig.SESSION_CONFIG_USER, user);
					isLogin = true;
					return "login";
				}else{
					log.info("El usuario :" + userEmail +" Necesita completar su perfil");
					FacesContext ctx = FacesContext.getCurrentInstance();
					HttpSession session = (HttpSession)ctx.getExternalContext().getSession(true);
					session.setAttribute(SystemConfig.SESSION_CONFIG_USER, user);
					isLogin = true;
					return "completeProfile";
				}
			}else{
				log.info("El usuario :" + userEmail +" No esta registrado");
				return "validateLogin";
			}
		}catch(Exception e){
			log.error("Login error " + e);
			FacesContext facesContext = FacesContext.getCurrentInstance();
	        FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Error!", "Por el momento no es posible iniciar secion en el sistema, favor de contactar a soporte tecnico a support@lynxwork.com");
	        facesContext.addMessage(null, m);
		}
		return "validateLogin";
	}

	public String registration(){
		log.debug("user firstName:" + firstName);
		log.debug("user email:" + joinEmail);
		log.debug("user password:" + joinPassword);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		UserService userService = new UserService();
		//Create a user entity
		User user = new User();
		user.setCurrentsPassword( joinPassword );
		user.setPasswordHint( "0" );
		user.setIsSystem( "false" );
		user.setEnabled( SystemConfig.USER_IS_ENABLED );
		user.setHasLoggedOut( SystemConfig.USER_HAS_LOGOUT );
		user.setRequierePasswordChange( SystemConfig.USER_HAS_LOGINT );
		user.setLastCurrencyUom( SystemConfig.CURRENCY_UOM ); //Configure depending of de country created user pending
		user.setLastLocale( "MX" ); //Calculate locale pending
		user.setLastTimeZone( "UTC/GMT-05:00" ); //Configure timezone pending in df is UTC/GMT-05:00 and UTC/GMT-06:00
		user.setDisabledDataTime( new Date() ); //This is disable
		user.setSuccessiveFailedLogins( 0 );
		user.setExternalAuthId( "NONE" );//Configuring Facebook pending
		user.setUserLdapDn( "NONE" );//No in use
		user.setIsBasicProfileComplete("false");
		user.setLastUpdatedStamp( new Date() );
		user.setLastUpdatedTxStamp( new Date() );
		user.setCreatedStamp( new Date() );
		user.setCreatedTxStamp( new Date() );
		user.setEmail( joinEmail );
		user.setRatings( 0 );	
		user.setIsBasicProfileComplete("false");
		//Create a person
		Person person = new Person();
		person.setFirstName(firstName);
		person.setMiddleName(middleName);
		person.setLastName(lastName);
		try {
			userService.registerUser(user, person);
			FacesContext ctx = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession)ctx.getExternalContext().getSession(true);
			session.setAttribute(SystemConfig.SESSION_CONFIG_USER, user);
			isLogin = true;
			return "completeProfile";
		} catch (UserRegistrationException e) {
			log.info("El usuario ya esta registrado");
	        FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "The user is register");
	        facesContext.addMessage(null, m);
	        return "";//return to index
		} catch (Exception e) {
			log.info("Error no tratado" + e);
	        FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "System Error, contact to support to support@lynxwork.com");
	        facesContext.addMessage(null, m);
	        return "";//return to index
		}
        //pushEvent.fire(String.format("New member added: %s (id: %d)", "111", "222"));
	}
	
	
	public String loginRegistration(){
		return "index";
	}


	public String viewPublications(){
		return "publications";
	}
	public String viewMessages(){
		return "messages";
	}	
	public String viewAlerts(){
		return "alerts";
	}
	public String viewProfile(){
		log.debug("View Profile");
		return "profile";
	}

	public String viewAddProfession(){
		log.debug("Add Profession");
		return "addProfession";
	}

	public String viewTest(){
		log.debug("Add Profession");
		return "test";
	}
	
	public String endRegistration(){
		return "login";
	}
	
	
	
	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	
	
}
