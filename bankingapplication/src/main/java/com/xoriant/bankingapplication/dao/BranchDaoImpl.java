package com.xoriant.bankingapplication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.bankingapplication.model.Branch;
@Component("branchDao")
public class BranchDaoImpl implements BranchDao{
	

	@Autowired	
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernate() {		
		return hibernateTemplate;
	}

	public void setHibernate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	@Transactional
	public void saveNewBranch(Branch branch) {
		hibernateTemplate.save(branch);
		System.out.println("branch has been saved");
	}

	@Override
	@Transactional
	public void updateBranch(Branch branch) {
		hibernateTemplate.update(branch);
		System.out.println("branch has been updated");
	}

	@Override
	@Transactional
	public void deleteBranch(Branch branch) {
		deleteBranch(branch.getBranchId());
		System.out.println("branch has been deleted");
	}

	@Override
	@Transactional
	public void deleteBranch(Integer branchId) {
		Branch branch=hibernateTemplate.get(Branch.class, branchId);

		hibernateTemplate.delete(branch);
		System.out.println("branch has been deleted");
		
	}

	@Override
	@Transactional
	public Branch findById(Integer branchId) {
		Branch branch=hibernateTemplate.get(Branch.class, branchId);
		return branch;
	}

	@Override
	@Transactional
	public Branch getBranchById(int id) {
		Branch branch=hibernateTemplate.get(Branch.class, id);
		return branch;
	}

}
