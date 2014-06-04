package com.lynxwork.mdm.person.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CivilStatus implements Serializable, List<CivilStatus> {
	
/**
	 * 
	 */
	private static final long serialVersionUID = -3769920393459687482L;
	
private String civilStatusId;
private String civilStatus;
private String descriptions;
private String observations;
private String createDate;
private String countryId;
private String creatorId;
private String creatorIp;
private Date lastUpdateDate;
private String lastUpdaterId;
private String lastUpdaterIp;


public String getCivilStatusId() {
	return civilStatusId;
}
public void setCivilStatusId(String civilStatusId) {
	this.civilStatusId = civilStatusId;
}
public String getCivilStatus() {
	return civilStatus;
}
public void setCivilStatus(String civilStatus) {
	this.civilStatus = civilStatus;
}
public String getDescriptions() {
	return descriptions;
}
public void setDescriptions(String descriptions) {
	this.descriptions = descriptions;
}
public String getObservations() {
	return observations;
}
public void setObservations(String observations) {
	this.observations = observations;
}
public String getCreateDate() {
	return createDate;
}
public void setCreateDate(String createDate) {
	this.createDate = createDate;
}
public String getCreatorId() {
	return creatorId;
}
public void setCreatorId(String creatorId) {
	this.creatorId = creatorId;
}
public String getCreatorIp() {
	return creatorIp;
}
public void setCreatorIp(String creatorIp) {
	this.creatorIp = creatorIp;
}
public Date getLastUpdateDate() {
	return lastUpdateDate;
}
public void setLastUpdateDate(Date lastUpdateDate) {
	this.lastUpdateDate = lastUpdateDate;
}

public String getLastUpdaterIp() {
	return lastUpdaterIp;
}
public void setLastUpdaterIp(String lastUpdaterIp) {
	this.lastUpdaterIp = lastUpdaterIp;
}
public String getLastUpdaterId() {
	return lastUpdaterId;
}
public void setLastUpdaterId(String lastUpdaterId) {
	this.lastUpdaterId = lastUpdaterId;
}
public String getCountryId() {
	return countryId;
}
public void setCountryId(String countryId) {
	this.countryId = countryId;
}
@Override
public int size() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean contains(Object o) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public Iterator<CivilStatus> iterator() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Object[] toArray() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public <T> T[] toArray(T[] a) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public boolean add(CivilStatus e) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean remove(Object o) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean containsAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean addAll(Collection<? extends CivilStatus> c) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean addAll(int index, Collection<? extends CivilStatus> c) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean removeAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean retainAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public void clear() {
	// TODO Auto-generated method stub
	
}
@Override
public CivilStatus get(int index) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public CivilStatus set(int index, CivilStatus element) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void add(int index, CivilStatus element) {
	// TODO Auto-generated method stub
	
}
@Override
public CivilStatus remove(int index) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public int indexOf(Object o) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int lastIndexOf(Object o) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public ListIterator<CivilStatus> listIterator() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public ListIterator<CivilStatus> listIterator(int index) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public List<CivilStatus> subList(int fromIndex, int toIndex) {
	// TODO Auto-generated method stub
	return null;
}



}
