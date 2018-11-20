package com.ester.dao;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.ester.beans.Salarie;

public interface SalarieDAO {
	
	void addSalarie(Salarie pSalarie);
	void updateSalarie(Salarie pSalarie, String pIdentifiantUnique);
	boolean salarieExists(String pIdentifiantUnique); 
	Salarie getSalarie(String pIdentifiantUnique);
	ArrayList<Salarie> listSalarie();

}
