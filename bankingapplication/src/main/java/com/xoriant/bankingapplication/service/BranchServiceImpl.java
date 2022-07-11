package com.xoriant.bankingapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.bankingapplication.dao.BranchDao;
import com.xoriant.bankingapplication.model.Branch;

@Service("branchService")
@Transactional
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	BranchDao branchDao;

	@Override
	public Branch getBranchByID(int id) {
		return branchDao.getBranchById(id);
	}

}
