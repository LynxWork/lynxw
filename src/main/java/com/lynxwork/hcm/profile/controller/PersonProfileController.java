package com.lynxwork.hcm.profile.controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.lynxwork.config.SystemConfig;
import com.lynxwork.hcm.profile.model.Education;
import com.lynxwork.hcm.profile.service.EducationService;
import com.lynxwork.mdm.factory.impl.mongo.MongoMasterDataDaoFactory;
import com.lynxwork.mdm.person.dao.ICivilStatusDao;
import com.lynxwork.mdm.person.dao.IPersonDao;
import com.lynxwork.mdm.person.model.CivilStatus;
import com.lynxwork.mdm.person.model.Person;
import com.lynxwork.mdm.person.service.CivilStatusService;
import com.lynxwork.mdm.person.service.PersonService;
import com.lynxwork.security.model.User;

/**
 * Pagina utilizada para el login del usuario de la aplicacion
 *
 * @author Juan Arturo Vargas Torres
 */
@ManagedBean(name = "personProfileController")
@SessionScoped
public class PersonProfileController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7250669827317454027L;
	static final Logger log = Logger.getLogger(PersonProfileController.class);
	//General Configurations
	private User user;
	//Person
	Person person;
	//StateCivil 
	private List<SelectItem> stateCivilOptions = null; //List of StateCivil acepted
	private List<CivilStatus> stateCivilCatList; //Profession calatoge from database
	private List<CivilStatus> stateCivilList; //Add Profession
	//Accion control Genaral 
	private boolean isGeneralDataDisabled  = true;
	private boolean isBtnCancelRendered = false;
	private boolean isBtnSaveRendered = false;
	private boolean isBtnEditRendered = true;
	//Almacena los mensajes de las acciones ejecutadas
	private String msgAccion = "";
    //Person General data properties
	private boolean isEnableBirthDay;
	
	//Education General 
	private String address;
	private String instituton;
	private String degree;
	private String resume;
	
	private String educationName;
	private String isEducationRendered;
	private List<Education> educationList; //Add Education
	private List<SelectItem> educationOptions = null; //List of education acepted
	//PROJECTS
	 private String projectsId;
	 private String projectsNamne;
	 private String custumerName;
	 private String projectsStatus;
	 private String projectsDescription;

	 private String summaryId;
	 private String title;
	 private String company;
	 private String initMonth;
	 private String initYear;
	 private String endMonth;
	 private String endYear;
	 private String isCurrentWork;
	 private String summary;
	//Calendar Setings
	 private Locale locale;
	 private boolean popup;
	 private String pattern;
	 private boolean showApply = true;
	 private boolean useCustomDayLabels;
	 private boolean disabled = false;


	public PersonProfileController() {
		// init variables
		log.info("******Get User Session Object");
		Locale locMX = new Locale("es", "MX");
		locale = locMX;
		popup = true;
		pattern = "d/M/yy HH:mm";
		isEnableBirthDay = false;
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
		if (person == null) {
			person = findPerson();
			person.setUserId(user.getUserId());
		}
	}
	 
	/*
	@PostConstruct
    public void initNewMember() {
		log.debug("******initNewMember");
		 Locale locMX = new Locale("es","MX");
	     locale = locMX;
	     popup = true;
	     pattern = "d/M/yy HH:mm";
	     isEnableBirthDay = false;
			//init variables
			FacesContext ctx = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession)ctx.getExternalContext().getSession(true);
			Object obj = session.getAttribute(SystemConfig.SESSION_CONFIG_USER);
			if(obj!=null){
				user = (User)obj;
				log.debug("The user objectis ok");
			}else{
				log.warn("The user object is null, contact to Administration Platform");
			}
			

			if(person==null){
				person = findPerson();
			}

	}
*/
	
	public Locale getLocale() {
	return locale;
	}


	public void setLocale(Locale locale) {
	this.locale = locale;
	}


	public boolean isPopup() {
	return popup;
	}


	public void setPopup(boolean popup) {
	this.popup = popup;
	}


	public String getPattern() {
	return pattern;
	}


	public void setPattern(String pattern) {
	this.pattern = pattern;
	}


	public boolean isShowApply() {
	return showApply;
	}


	public void setShowApply(boolean showApply) {
	this.showApply = showApply;
	}


	public boolean isUseCustomDayLabels() {
	return useCustomDayLabels;
	}


	public void setUseCustomDayLabels(boolean useCustomDayLabels) {
	this.useCustomDayLabels = useCustomDayLabels;
	}


	public boolean isDisabled() {
	return disabled;
	}


	public void setDisabled(boolean disabled) {
	this.disabled = disabled;
	}


	public boolean isEnableBirthDay() {
	return isEnableBirthDay;
	}


	public void setEnableBirthDay(boolean isEnableBirthDay) {
	this.isEnableBirthDay = isEnableBirthDay;
	}


	public String getAddress() {
	return address;
	}


	public void setAddress(String address) {
	this.address = address;
	}


	public String getInstituton() {
	return instituton;
	}


	public void setInstituton(String instituton) {
	this.instituton = instituton;
	}


	public String getDegree() {
	return degree;
	}


	public void setDegree(String degree) {
	this.degree = degree;
	}


	public String getResume() {
	return resume;
	}


	public void setResume(String resume) {
	this.resume = resume;
	}


	public String getSummaryId() {
	return summaryId;
	}


	public void setSummaryId(String summaryId) {
	this.summaryId = summaryId;
	}


	public String getTitle() {
	return title;
	}


	public void setTitle(String title) {
	this.title = title;
	}


	public String getCompany() {
	return company;
	}


	public void setCompany(String company) {
	this.company = company;
	}


	public String getInitMonth() {
	return initMonth;
	}


	public void setInitMonth(String initMonth) {
	this.initMonth = initMonth;
	}


	public String getInitYear() {
	return initYear;
	}


	public void setInitYear(String initYear) {
	this.initYear = initYear;
	}


	public String getEndMonth() {
	return endMonth;
	}


	public void setEndMonth(String endMonth) {
	this.endMonth = endMonth;
	}


	public String getEndYear() {
	return endYear;
	}


	public void setEndYear(String endYear) {
	this.endYear = endYear;
	}


	public String getIsCurrentWork() {
	return isCurrentWork;
	}


	public void setIsCurrentWork(String isCurrentWork) {
	this.isCurrentWork = isCurrentWork;
	}


	public String getSummary() {
	return summary;
	}


	public void setSummary(String summary) {
	this.summary = summary;
	}
	public String getProjectsId() {
		return projectsId;
	}


	public void setProjectsId(String projectsId) {
		this.projectsId = projectsId;
	}


	public String getProjectsNamne() {
		return projectsNamne;
	}


	public void setProjectsNamne(String projectsNamne) {
		this.projectsNamne = projectsNamne;
	}


	public String getCustumerName() {
		return custumerName;
	}


	public void setCustumerName(String custumerName) {
		this.custumerName = custumerName;
	}


	public String getProjectsStatus() {
		return projectsStatus;
	}


	public void setProjectsStatus(String projectsStatus) {
		this.projectsStatus = projectsStatus;
	}


	public String getProjectsDescription() {
		return projectsDescription;
	}


	public void setProjectsDescription(String projectsDescription) {
		this.projectsDescription = projectsDescription;
	}
	//EDUCATION
	public String getEducationName() {
		return educationName;
	}


	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
	
	public List<Education> getEducationList() {
		return educationList;
	}


	public void setEducationList(List<Education> educationList) {
		this.educationList = educationList;
	}
	
	public String getIsEducationRendered() {
		return isEducationRendered;
	}


	public void setIsEducationRendered(String isEducationRendered) {
		this.isEducationRendered = isEducationRendered;
	}
	
	public List<SelectItem> getEducationOptions() {
		return educationOptions;
	}


	public void setEducationOptions(List<SelectItem> educationOptions) {
		this.educationOptions = educationOptions;
	}
    //EDUCATION
	public String addEducation(){
		log.debug("Init addProfession");
		setIsEducationRendered("true");
		log.debug("End addProfession");
		return "";
	}
	/**
	 * This method save the data of Education addeded
	 * */
	public String saveEducation(){
		log.debug("Init saveEducation");
		log.debug("Education id:" + educationName);
		EducationService educationService = new EducationService();
		if(educationName!=null && educationName.length()>0){
			Education e = educationService.findById( educationName );
			e.setInstitution(getInstituton());
			educationList.add(e);
		}
		log.debug("End saveEducation");
		return "";
	}

	/**
	 * This method cancel the data of Education addeded
	 * */
	public String cancelAddEducation(){
		log.debug("Init cancelAddEducation");
		isEducationRendered = "false";
		log.debug("End cancelAddProfession");
		return "";
	}
	
	//PROJECTS
	//general data
	public String viewPersonProfile(){
		log.debug("viewPersonProfile");
		/*log.debug("person nin:"+ nin);
		log.debug("person taxId:"+ taxId);
		log.debug("person ssn:"+ ssn);
		log.debug("person estateCivilId:"+ estateCivilId);
		log.debug("person genderId:"+ genderId);
		log.debug("person birthPlaceId:"+ birthPlaceId);
		log.debug("person bloodTypeId:"+ bloodTypeId);
		log.debug("person birthDay:"+ birthDay);
		Person person = new Person();
		person.setNin(nin);
		person.setTaxid(taxId);
		person.setSsn(ssn);
		person.setStateCivilId(estateCivilId);
		person.setGenderId(genderId);
		person.setBirthPlaceId(birthPlaceId);
		person.setBloodTypeId(bloodTypeId);
		person.setBirthday(birthDay);*/
		return "personProfile";
	}
	
	
	public Person findPerson(){
		MongoMasterDataDaoFactory factory  = new MongoMasterDataDaoFactory();
		IPersonDao personDao = factory.getPersonDao();
		Person person = new Person();
		try{
			person = personDao.findByUserId( user.getUserId() );
		}catch(Exception e){
			log.error("Error al buscar los datos generales" + e);
		}
		return person;
	}
	 
	public CivilStatus findCivil(){
		MongoMasterDataDaoFactory factory  = new MongoMasterDataDaoFactory();
		ICivilStatusDao civilStatusDao = factory.getCivilStatusDao();
		CivilStatus civilStatus = civilStatusDao.find(user.getUserId());
		return civilStatus;
	}
	 
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public boolean getIsGeneralDataDisabled() {
		return isGeneralDataDisabled;
	}
	public void setGeneralDataDisabled(boolean isGeneralDataDisabled) {
		this.isGeneralDataDisabled = isGeneralDataDisabled;
	}
	public boolean getIsBtnCancelRendered() {
		return isBtnCancelRendered;
	}
	public void setBtnCancelRendered(boolean isBtnCancelRendered) {
		this.isBtnCancelRendered = isBtnCancelRendered;
	}
	public boolean getIsBtnSaveRendered() {
		return isBtnSaveRendered;
	}
	public void setBtnSaveRendered(boolean isBtnSaveRendered) {
		this.isBtnSaveRendered = isBtnSaveRendered;
	}

	public boolean getIsBtnEditRendered() {
		return isBtnEditRendered;
	}

	public void setBtnEditRendered(boolean isBtnEditRendered) {
		this.isBtnEditRendered = isBtnEditRendered;
	}
	
	
	public String editGeneralData(){
		log.info("editGeneralData");
		isBtnCancelRendered=true;
		isBtnSaveRendered=true;
		isBtnEditRendered=false;
		isGeneralDataDisabled  = false;
		this.msgAccion = "Puede editar sus datos personales";
		return "";
	}

	public String saveGeneralData(){
		//Codigo para salvar
		log.info("saveGeneralData");
		log.info("Person: " + person.toString());
		PersonService personService = new PersonService();
		try {
			personService.update(this.person);
			isBtnCancelRendered=false;
			isBtnSaveRendered=false;
			isBtnEditRendered=true;		
			isGeneralDataDisabled  = true;
			this.msgAccion = "Los datos fueron almacenados con exito";
		} catch (Exception e) {
			log.error("Error al intentar salvar los datos del perfil" + e);
			this.msgAccion = "Lo sentimos, por el momento no podemos almacenar la informacion";
		}
		return "";
	}

	public String cancelGeneralData(){
		log.info("cancelGeneralData");
		isBtnCancelRendered=false;
		isBtnSaveRendered=false;
		isBtnEditRendered=true;
		isGeneralDataDisabled  = true;
		this.msgAccion = "La edicion fue cancelada";
		return "";
	}
	public String getMsgAccion() {
		return msgAccion;
	}


	public void setMsgAccion(String msgAccion) {
		this.msgAccion = msgAccion;
	}

	public List<SelectItem> getStateCivilOptions() {
		stateCivilCatList = new ArrayList<CivilStatus>();
		stateCivilOptions = new ArrayList<SelectItem>();
    	if(stateCivilCatList.size()==0){
    		CivilStatusService civilStatusService = new CivilStatusService();
    		stateCivilCatList = civilStatusService.findByCountry(user.getLastLocale());
			if(stateCivilCatList.size()>0){
		        for (CivilStatus civilStatus : stateCivilCatList) {
		        	stateCivilOptions.add(new SelectItem(civilStatus.getCivilStatusId(), civilStatus.getCivilStatus()));
		        }
	        }
		}
		return stateCivilOptions;
	}

	public void setStateCivilOptions(List<SelectItem> stateCivilOptions) {
		this.stateCivilOptions = stateCivilOptions;
	}

	public List<CivilStatus> getStateCivilCatList() {
		return stateCivilCatList;
	}

	public void setStateCivilCatList(List<CivilStatus> stateCivilCatList) {
		this.stateCivilCatList = stateCivilCatList;
	}

	public List<CivilStatus> getStateCivilList() {
		return stateCivilList;
	}

	public void setStateCivilList(List<CivilStatus> stateCivilList) {
		this.stateCivilList = stateCivilList;
	}



	
	
	
	
}