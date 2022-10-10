package com.greatlearning.CustomerRelationshipManagement.Service;

import java.util.List;

import com.greatlearning.CustomerRelationshipManagement.Entity.customerEntity;

public interface customerService {

	public customerEntity findById(int theId);

	public void save(customerEntity thecustomer);

	public void deleteById(int theId);

	public List<customerEntity> findAll();

}