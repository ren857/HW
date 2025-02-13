package service;

import java.util.List;

import model.Porder;

public interface PorderService {
	//create
	void addPorder(Porder porder);
	//read-->列印報表
	String AllPorder();
	List<Porder>findAllPoredor();
	Porder findById(int id);
	//update
	void updatePorder(String name,int id);
	void updatePorder(int wrench,int pail,int hose,int id);
	void updatePorder(Porder porder);
	//delete
	void deletePorderById(int id);
}
