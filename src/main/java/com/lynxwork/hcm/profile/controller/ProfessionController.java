package com.lynxwork.hcm.profile.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.lynxwork.common.model.Calendar;
import com.lynxwork.config.SystemConfig;
import com.lynxwork.hcm.profile.model.Profession;
import com.lynxwork.hcm.profile.service.ProfessionService;
import com.lynxwork.hcm.work.model.WorkCategory;
import com.lynxwork.hcm.work.model.WorkType;
import com.lynxwork.hcm.work.model.WorkTypeFilter;
import com.lynxwork.hcm.work.service.WorkCategoryService;
import com.lynxwork.hcm.work.service.WorkTypeService;
import com.lynxwork.mdm.address.dao.ICountryDao;
import com.lynxwork.mdm.address.dao.IStateDao;
import com.lynxwork.mdm.address.model.Country;
import com.lynxwork.mdm.address.model.State;
import com.lynxwork.mdm.address.service.StateService;
import com.lynxwork.mdm.factory.impl.mongo.MongoMasterDataDaoFactory;
import com.lynxwork.mdm.person.model.BirthPlace;
import com.lynxwork.mdm.person.model.Person;
import com.lynxwork.security.model.User;

/**
 * Pagina utilizada para el login del usuario de la aplicacion
 *
 * @author Juan Arturo Vargas Torres
 */
@ManagedBean(name = "professionController")
@SessionScoped
public class ProfessionController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8835625050468437110L;

	static final Logger log = Logger.getLogger(ProfessionController.class);
	
	/***********************************************************************************************************
	 * Field declarations
	 ***********************************************************************************************************/
	//General Configurations
	private User user;
	//Person bean
	private Person person;
	
	//Profession
	private String professionName;
	private Profession profession; //Captued profession
	private List<Profession> professionCatList; //Profession calatoge from database
	private List<Profession> professionList; //Add Profession
	private List<SelectItem> professionOptions = null; //List of profession acepted
	private String isProfessionRendered;
	
	//Properties for State control
	private List<State> stateCatList = null;
	private List<SelectItem> stateOptions = null;
	
	//Properties for Country 
	List<Country> countryList;
	private List<SelectItem> countryOptions = null;
	
	//Validate if registration is complete
	private String isRegistrationIncomplete = "true";
	
	//Work Category List
	private List<WorkCategory> workCategoryCatList; //WorkCategory calatoge from database
	private List<SelectItem> workCategoryOptions = null; //List of WorkCategory acepted
	
	//WorkTypeFilter
	private WorkTypeFilter workTypeFilter;
	
	//Work Type Cataloge
	private List<SelectItem> workTypeOptions = null;
	private List<WorkType> workTypeCatList = null;
	
	
	public WorkTypeFilter getWorkTypeFilter() {
		return workTypeFilter;
	}

	public void setWorkTypeFilter(WorkTypeFilter workTypeFilter) {
		this.workTypeFilter = workTypeFilter;
	}

	/***********************************************************************************************************
	 * Constructors declarations
	 ***********************************************************************************************************/
  
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
		//Rendered profession
		isProfessionRendered = "false";
		//Init professionList
		professionList = new ArrayList<Profession>();
    	//Init Entity Beans
    	BirthPlace birthPlace = new BirthPlace();
    	person = new Person();
    	Country country = new Country(); 
    	State state = new State();
    	birthPlace.setCountry(country);
    	birthPlace.setState(state);
    	person.setBirthPlace(birthPlace);
    	profession = new Profession();
    	//init workTypeFilter
    	workTypeFilter = new WorkTypeFilter();
    	//Init calendar values 
    	Calendar publishOfferDate = new Calendar();
    	publishOfferDate.setDate(new Date());
    	publishOfferDate.setDisabled(false);
    	publishOfferDate.setLocale(SystemConfig.getLocaleConfig());
    	publishOfferDate.setPattern(SystemConfig.DATE_PATTERN);
    	publishOfferDate.setPopup(true);
    	publishOfferDate.setShowApply(true);
    	workTypeFilter.setPublishOfferDate(publishOfferDate);

    }

	/***********************************************************************************************************
	 * Accesors and Mutators declarations
	 ***********************************************************************************************************/
	public Profession getProfession() {
		return profession;
	}


	public void setProfession(Profession profession) {
		this.profession = profession;
	}


	/**
	 * Get the profession list asignet to the person profile
	 * */
	public List<Profession> getProfessionList() {
	   	//Fid the professions by userid
    	ProfessionService service = new ProfessionService();
    	List<Profession> actualProfessionList = new ArrayList<Profession>();
    	actualProfessionList = service.findByUserId(user.getUserId());
    	if(actualProfessionList.size()>0){
    		professionList = actualProfessionList;
    	}
		return professionList;
	}


	public void setProfessionList(List<Profession> professionList) {
		this.professionList = professionList;
	}
	
	/**
	 * Initializing profession 
	 * */
    public List<SelectItem> getProfessionOptions() {
    	professionCatList = new ArrayList<Profession>();
    	professionOptions = new ArrayList<SelectItem>();
    	if(professionCatList.size()==0){
			ProfessionService professionService = new ProfessionService();
			professionCatList = professionService.findByCountry(user.getLastLocale());//By Default Mexico
			if(professionCatList.size()>0){
		        for (Profession profession : professionCatList) {
		        	professionOptions.add(new SelectItem(profession.getProfessionId(), profession.getName()));
		        }
	        }
		}
		return professionOptions;
	}

	public void setProfessionOptions(List<SelectItem> professionOptions) {
		this.professionOptions = professionOptions;
	}


	public String getIsProfessionRendered() {
		return isProfessionRendered;
	}


	public void setIsProfessionRendered(String isProfessionRendered) {
		this.isProfessionRendered = isProfessionRendered;
	}
	
    @Produces
    @Named
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<SelectItem> getStateOptions() {
        //Load Country Catalog
		stateCatList = new ArrayList<State>();
		stateOptions = new ArrayList<SelectItem>();
		StateService service = new StateService();
		stateCatList = service.findByCountryId(user.getLastLocale());
		if(stateCatList!=null && stateCatList.size()>0){
	        for (State state : stateCatList) {
	        	stateOptions.add(new SelectItem(state.getStateId(), state.getName() ) );
	        }
		}
		return stateOptions;
	}

	public void setStateOptions(List<SelectItem> stateOptions) {
		this.stateOptions = stateOptions;
	}

	/**
	 * Load the country catalog
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getCountryOptions() {
        //Load Country Catalog
		countryList = new ArrayList<Country>();
		countryOptions = new ArrayList<SelectItem>();
		if(countryList.size()==0){
	        countryList = findAllCountry();
	        for (Country country : countryList) {
	        	countryOptions.add(new SelectItem(country.getCountryId(), country.getName() ) );
	        }	
		}
		return countryOptions;
	}

	public void setCountryOptions(List<SelectItem> countryOptions) {
		this.countryOptions = countryOptions;
	}

	/***********************************************************************************************************
	 * Method accion declarations
	 ***********************************************************************************************************/

	/**
	 * This method add a fields for input data
	 * */
	public String addProfession(){
		log.debug("Init addProfession");
		isProfessionRendered = "true";
		log.debug("End addProfession");
		return "";
	}

	/**
	 * This method cancel the data of profession addeded
	 * */
	public String cancelAddProfession(){
		log.debug("Init cancelAddProfession");
		isProfessionRendered = "false";
		log.debug("End cancelAddProfession");
		return "";
	}

	/**
	 * This method save the data of profession addeded
	 * */
	public String saveProfession(){
		log.debug("Init saveProfession");
		log.debug("Profession id:" + professionName);
		//log.debug("Person First Name:" + person.toString());
		ProfessionService professionService = new ProfessionService();
		if(professionName!=null && professionName.length()>0){
			//Search element in list
			Iterator<Profession> it = professionList.iterator();
			boolean professionisNotAsigned = true;
			while(it.hasNext()){
				Profession item = it.next();
				log.debug("Id:" + item.getProfessionId());
				if(item.getProfessionId().equals(professionName)){
					log.debug("the profession is asigned");
					professionisNotAsigned = false;
				}
			}
			if(professionisNotAsigned){
				Profession p = professionService.findById( professionName );
				p.setName(getProfessionName());
				professionList.add(p);
				//Save the profession on profile
				professionService.saveProfessionInProfileByUserId(user.getUserId(), p);
			}
		}
		log.debug("End saveProfession");
		return "";
	}



	public List<Country> findAllCountry(){
        //Load State Catalog
		List<Country> countryList = new ArrayList<Country>();
        MongoMasterDataDaoFactory factory  = new MongoMasterDataDaoFactory();
        ICountryDao countryDao = factory.getCountryDao();
        countryDao.findAll();
        return countryList;
	}
	
	public List<State> findStateByCountry(String countryId){
        //Load State Catalog
		List<State> stateList = new ArrayList<State>();
        MongoMasterDataDaoFactory factory  = new MongoMasterDataDaoFactory();
        IStateDao stateDao = factory.getStateDao();
        stateList = stateDao.findStateByCountryId( countryId );
        return stateList;
	}
	public String loadStateByCountry(){
		if(person.getBirthPlace().getCountry().getCountryId()!=null){
		    List<State> stateList = findStateByCountry( person.getBirthPlace().getCountry().getCountryId() );
		    for (State state : stateList) {
		    	stateOptions.add(new SelectItem(state.getStateId(), state.getName() ) );
		    }
		}
	    return null;
	}


	public String getProfessionName() {
		return professionName;
	}


	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}

	public String getIsRegistrationIncomplete() {
		return isRegistrationIncomplete;
	}

	public void setIsRegistrationIncomplete(String isRegistrationIncomplete) {
		this.isRegistrationIncomplete = isRegistrationIncomplete;
	}

	public List<WorkCategory> getWorkCategoryCatList() {
		return workCategoryCatList;
	}

	public void setWorkCategoryCatList(List<WorkCategory> workCategoryCatList) {
		this.workCategoryCatList = workCategoryCatList;
	}

	public List<SelectItem> getWorkCategoryOptions() {
		WorkCategoryService service = new WorkCategoryService();
		workCategoryCatList = service.findWorkCategoryByCountryId(user.getLastLocale());
		workCategoryOptions = new ArrayList<SelectItem>();
		if(workCategoryCatList!=null && workCategoryCatList.size()>0){
			for(WorkCategory workCategory: workCategoryCatList){
				workCategoryOptions.add(new SelectItem(workCategory.getWorkCategoryId(),workCategory.getName()));
			}
		}
		return workCategoryOptions;
	}

	public void setWorkCategoryOptions(List<SelectItem> workCategoryOptions) {
		this.workCategoryOptions = workCategoryOptions;
	}

	/**
	 * Find the Work Type List By Country
	 * **/
	public List<SelectItem> getWorkTypeOptions() {
		log.debug("Init getWorkTypeOptions " );
		log.debug("Last Locale: " +  user.getLastLocale());
		WorkTypeService service = new WorkTypeService(); 
		this.workTypeOptions = new ArrayList<SelectItem>();
		try{
			this.workTypeCatList = service.findByCountryId(user.getLastLocale());
			if(this.workTypeCatList!=null && this.workTypeCatList.size()>0){
				for(WorkType workType: this.workTypeCatList){
					this.workTypeOptions.add(new SelectItem(workType.getWorkTypeId(),workType.getName()));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error("Error in get Work Type Options, contact to System Administrator: " + e );
		}
		return this.workTypeOptions;
	}

	public void setWorkTypeOptions(List<SelectItem> workTypeOptions) {
		this.workTypeOptions = workTypeOptions;
	}

	public List<WorkType> getWorkTypeCatList() {
		return workTypeCatList;
	}

	public void setWorkTypeCatList(List<WorkType> workTypeCatList) {
		this.workTypeCatList = workTypeCatList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<State> getStateCatList() {
		return stateCatList;
	}

	public void setStateCatList(List<State> stateCatList) {
		this.stateCatList = stateCatList;
	}


}
