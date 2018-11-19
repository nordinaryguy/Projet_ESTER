package com.ester.dao;

import java.util.ArrayList;

import com.ester.beans.EsterUser;

public interface EsterUserDAO {

	void addUserEster(EsterUser pUserEster);
	ArrayList<EsterUser> listEsterUsers();
}
