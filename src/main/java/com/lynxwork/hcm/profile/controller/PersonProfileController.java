package com.lynxwork.hcm.profile.controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
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
import com.lynxwork.mdm.person.service.PersonService;
import com.lynxwork.mdm.product.dao.IProductDao;
import com.lynxwork.mdm.product.model.Product;
import com.lynxwork.mdm.product.service.ProductService;
import com.lynxwork.persistance.exception.SaveEntityException;
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
	static final Logger log = Logger.getLogger(ProfessionController.class);
	
	//General Configurations
	private User user;
	//Person
	Person person;
	//CivilStatus
	CivilStatus civilStatus;
	
	
	
	
	//Accion control
	boolean isGeneralDataDisabled  = true;
	boolean isBtnCancelRendered = false;
	boolean isBtnSaveRendered = false;
	boolean isBtnEditRendered = true;





	//Person General data properties
	private String name;
	private String firsName;
	private String middleName;
	private String nin;
	private String taxId;
	private String ssn;
	private Date birthDay;
	private boolean isEnableBirthDay;
	private String estateCivilId;
	private String genderId;
	private String birthPlaceId;
	private String bloodTypeId;
	//Product
	private String productId;
	private String productName;
	private String serviceDescription;
	private String profileId;
	//product
	 private String isProductRendered; 
	 private List<Product> productList; //Add Profession
	 private List<Product> productCatList; //Profession calatoge from database
	 private List<SelectItem> productOptions = null; //List of profession acepted

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
		 Locale locMX = new Locale("es","MX");
	     locale = locMX;
	     popup = true;
	     pattern = "d/M/yy HH:mm";
	     isEnableBirthDay = false;
	}

	@PostConstruct
    public void initNewMember() {
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
		
		//Get person data
		if(person==null){
			person = findPerson();
		}
		
	}

	public String getProductName() {
	return productName;
	}

	public void setProductName(String productName) {
	this.productName = productName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
	this.name = name;
	}

	public String getFirsName() {
	return firsName;
	}

	public void setFirsName(String firsName) {
	this.firsName = firsName;
	}

	public String getMiddleName() {
	return middleName;
	}

	public void setMiddleName(String middleName) {
	this.middleName = middleName;
	}

	public String getNin() {
	return nin;
	}

	public void setNin(String nin) {
	this.nin = nin;
	}

	public String getTaxId() {
	return taxId;
	}

	public void setTaxId(String taxId) {
	this.taxId = taxId;
	}

	public String getSsn() {
	return ssn;
	}

	public void setSsn(String ssn) {
	this.ssn = ssn;
	}

	public Date getBirthDay() {
	return birthDay;
	}

	public void setBirthDay(Date birthDay) {
	this.birthDay = birthDay;
	}

	public String getEstateCivilId() {
	return estateCivilId;
	}

	public void setEstateCivilId(String estateCivilId) {
	this.estateCivilId = estateCivilId;
	}

	public String getGenderId() {
	return genderId;
	}

	public void setGenderId(String genderId) {
	this.genderId = genderId;
	}

	public String getBirthPlaceId() {
	return birthPlaceId;
	}

	public void setBirthPlaceId(String birthPlaceId) {
	this.birthPlaceId = birthPlaceId;
	}

	public String getBloodTypeId() {
	return bloodTypeId;
	}

	public void setBloodTypeId(String bloodTypeId) {
	this.bloodTypeId = bloodTypeId;
	}


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


	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setserviceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
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
	
	public String getIsProductRendered() {
		return isProductRendered;
	}


	public void setIsProductRendered(String isProductRendered) {
		this.isProductRendered = isProductRendered;
	}
	
	/**
	 * This method add a fields for input data
	 * */
	public String addProduct(){
		log.debug("Init addProdutct");
		isProductRendered = "true";
		log.debug("End addProduct");
		return "";
	}
	
	/**
	 * This method cancel the data of profession addeded
	 * */
	public String cancelAddProduct(){
		log.debug("Init cancelAddProduct");
		isProductRendered = "false";
		log.debug("End cancelAddProduct");
		return "";
	}
	

	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getProfileId() {
		return profileId;
	}


	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}


	public List<Product> getProductCatList() {
		
		return productCatList;
	}


	public void setProductCatList(List<Product> productCatList) {
		this.productCatList = productCatList;
	}


	public List<SelectItem> getProductOptions() {
		productCatList = new ArrayList<Product>();
		productOptions = new ArrayList<SelectItem>();
    	if(productCatList.size()==0){
			ProductService productService = new ProductService();
			productCatList = productService.findByPersonld("productId");
			if(productCatList.size()>0){
		        for (Product product : productCatList) {
		        	productOptions.add(new SelectItem(product.getProductId()));
		        }
	        }
		}
		return productOptions;
	}


	public void setProductOptions(List<SelectItem> productOptions) {
		this.productOptions = productOptions;
	}
	
	public String saveProduct(){
		log.debug("Init saveProduct");
		log.debug("Product id:" + productName);
		//log.debug("Person First Name:" + person.toString());
		ProductService productService = new ProductService();
		if(productName!=null && productName.length()>0){
			Product p = productService.findById(productName);
			p.setProductName(getProductName());
			productList.add(p);
		}
		log.debug("End saveProduct");
		return "";
	}

	public List<Product> getProductList() {
		List<Product> productList = new ArrayList<Product>();
        MongoMasterDataDaoFactory factory  = new MongoMasterDataDaoFactory();
        IPersonDao personDao = factory.getPersonDao();
        String personId = personDao.findByUserId(user.getUserId()).getPersonId();
        IProductDao productDao = factory.getProductDao();
        productList = productDao.findByPersonld(personId);
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
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
		Person person = personDao.findByUserId( user.getUserId() );
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
		isBtnCancelRendered=true;
		isBtnSaveRendered=true;
		isBtnEditRendered=false;
		isGeneralDataDisabled  = false;
		return "";
	}
	
	public String saveGeneralData(){
		//Codigo para salvar
		PersonService personService = new PersonService();
		try {
			personService.savePerson(this.person);
			personService.save(this.person);
		} catch (SaveEntityException e) {
			log.error("Error al intentar salvar los datos del perfil" + e);
		}
		isBtnCancelRendered=false;
		isBtnSaveRendered=false;
		isBtnEditRendered=true;		
		isGeneralDataDisabled  = true;
		return "";
	}
	
	public String cancelGeneralData(){
		isBtnCancelRendered=false;
		isBtnSaveRendered=false;
		isBtnEditRendered=true;
		isGeneralDataDisabled  = true;
		return "";
	}

	public CivilStatus getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(CivilStatus civilStatus) {
		this.civilStatus = civilStatus;
	}

	
	
	
}