package com.ester.beans;

import java.util.ArrayList;

import org.bson.types.ObjectId;

public class Salarie {

	private ObjectId m_id;
	private String mSecureIdGenerated;
	private String mAnonymityNumber;
	private boolean mFirstConnection;
	private String mPassword;
	private String mSexe;
	private String mYearOfBirth;
	private String mDepartment;
	private String mBusinessSector;
	private String mPCS;
	private ArrayList<Questionnaire> mAnsweredQuestionnaires;
	private ArrayList<Questionnaire> mUnansweredQuestionnaires;
	private Entreprise mAttachedCompany;
	private EsterUser mUserEsterCreator;
	private int mConnectionsNumber;
	private String mLastConnectionDuration;

	public Salarie() {
		m_id = null;
		mSecureIdGenerated= null;
		mAnonymityNumber= null;
		mFirstConnection = false;
		mPassword= null;
		mSexe= null;
		mYearOfBirth= null;
		mDepartment= null;
		mBusinessSector= null;
		mPCS= null;
		mAnsweredQuestionnaires= null;
		mUnansweredQuestionnaires= null;
		mAttachedCompany= null;
		mUserEsterCreator= null;
		mConnectionsNumber= -1;
		mLastConnectionDuration= null;
	}

	public Salarie(String pSecureIdGenerated, String pSexe, String pYearOfbirth, String pDepartment, String pPCS) {
		mSecureIdGenerated = pSecureIdGenerated;
		mSexe = pSexe;
		mYearOfBirth = pYearOfbirth;
		mDepartment = pDepartment;
		mPCS = pPCS;

		m_id = null;
		mFirstConnection = true;
		mPassword= null;
		mBusinessSector= null;
		mAnsweredQuestionnaires= null;
		mUnansweredQuestionnaires= null;
		mAttachedCompany= null;
		mUserEsterCreator= null;
		mConnectionsNumber= -1;
		mLastConnectionDuration= null;
	}

	public ObjectId getM_id() {
		return m_id;
	}

	public void setM_id(ObjectId m_id) {
		this.m_id = m_id;
	}

	public String getmSecureIdGenerated() {
		return mSecureIdGenerated;
	}

	public void setmSecureIdGenerated(String mSecureIdGenerated) {
		this.mSecureIdGenerated = mSecureIdGenerated;
	}

	public String getmAnonymityNumber() {
		return mAnonymityNumber;
	}

	public void setmAnonymityNumber(String mAnonymityNumber) {
		this.mAnonymityNumber = mAnonymityNumber;
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

	public String getmSexe() {
		return mSexe;
	}

	public void setmSexe(String mSexe) {
		this.mSexe = mSexe;
	}

	public String getmYearOfBirth() {
		return mYearOfBirth;
	}

	public void setmYearOfBirth(String mYearOfBirth) {
		this.mYearOfBirth = mYearOfBirth;
	}

	public String getmDepartment() {
		return mDepartment;
	}

	public void setmDepartment(String mDepartment) {
		this.mDepartment = mDepartment;
	}

	public String getmBusinessSector() {
		return mBusinessSector;
	}

	public void setmBusinessSector(String mBusinessSector) {
		this.mBusinessSector = mBusinessSector;
	}

	public String getmPCS() {
		return mPCS;
	}

	public void setmPCS(String mPCS) {
		this.mPCS = mPCS;
	}

	public ArrayList<Questionnaire> getmAnsweredQuestionnaires() {
		return mAnsweredQuestionnaires;
	}

	public void setmAnsweredQuestionnaires(ArrayList<Questionnaire> mAnsweredQuestionnaires) {
		this.mAnsweredQuestionnaires = mAnsweredQuestionnaires;
	}

	public ArrayList<Questionnaire> getmUnansweredQuestionnaires() {
		return mUnansweredQuestionnaires;
	}

	public void setmUnansweredQuestionnaires(ArrayList<Questionnaire> mUnansweredQuestionnaires) {
		this.mUnansweredQuestionnaires = mUnansweredQuestionnaires;
	}

	public Entreprise getmAttachedCompany() {
		return mAttachedCompany;
	}

	public void setmAttachedCompany(Entreprise mAttachedCompany) {
		this.mAttachedCompany = mAttachedCompany;
	}

	public EsterUser getmUserEsterCreator() {
		return mUserEsterCreator;
	}

	public void setmUserEsterCreator(EsterUser mUserEsterCreator) {
		this.mUserEsterCreator = mUserEsterCreator;
	}

	public int getmConnectionsNumber() {
		return mConnectionsNumber;
	}

	public void setmConnectionsNumber(int mConnectionsNumber) {
		this.mConnectionsNumber = mConnectionsNumber;
	}

	public String getmLastConnectionDuration() {
		return mLastConnectionDuration;
	}

	public void setmLastConnectionDuration(String mLastConnectionDuration) {
		this.mLastConnectionDuration = mLastConnectionDuration;
	}
}
