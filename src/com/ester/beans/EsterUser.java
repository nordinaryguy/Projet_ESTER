package com.ester.beans;

import java.util.ArrayList;

import org.bson.types.ObjectId;

public class EsterUser {

	private ObjectId m_id;
	private String mLastName;
	private String mFirstName;
	private String mIdCountGeneration;
	private String mMail;
	private boolean mFirstConnection;
	private String mPassword;
	private String mUserRole;
	private ArrayList<String> mAccessRights;

	public EsterUser() {
		m_id = null;
		mLastName = null;
		mFirstName= null;
		mIdCountGeneration= null;
		mMail= null;
		mFirstConnection=false;
		mPassword= null;
		mUserRole= null;
		mAccessRights= null;
	}
	
	public EsterUser(String pLastName, String pFirstName, String pIdCountGeneration, String pMail, String pPassword, String pUserRole, ArrayList<String> pAccessRights) {
		m_id = null;
		mLastName = pLastName;
		mFirstName= pFirstName;
		mIdCountGeneration= pIdCountGeneration;
		mMail= pMail;
		mFirstConnection=true;
		mPassword= pPassword;
		mUserRole= pUserRole;
		mAccessRights= pAccessRights;
	}

	public ObjectId getM_id() {
		return m_id;
	}

	public void setM_id(ObjectId m_id) {
		this.m_id = m_id;
	}

	public String getmLastName() {
		return mLastName;
	}

	public void setmLastName(String mLastName) {
		this.mLastName = mLastName;
	}

	public String getmFirstName() {
		return mFirstName;
	}

	public void setmFirstName(String mFirstName) {
		this.mFirstName = mFirstName;
	}

	public String getmIdCountGeneration() {
		return mIdCountGeneration;
	}

	public void setmIdCountGeneration(String mIdCountGeneration) {
		this.mIdCountGeneration = mIdCountGeneration;
	}

	public String getmMail() {
		return mMail;
	}

	public void setmMail(String mMail) {
		this.mMail = mMail;
	}

	public boolean ismFirstConnection() {
		return mFirstConnection;
	}

	public void setmFirstConnection(boolean mFirstConnection) {
		this.mFirstConnection = mFirstConnection;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getmUserRole() {
		return mUserRole;
	}

	public void setmUserRole(String mUserRole) {
		this.mUserRole = mUserRole;
	}

	public ArrayList<String> getmAccessRights() {
		return mAccessRights;
	}

	public void setmAccessRights(ArrayList<String> mAccessRights) {
		this.mAccessRights = mAccessRights;
	}
}
