package com.xoriant.bankingapplication.dao;

import com.xoriant.bankingapplication.model.Branch;

/**
 * @author Palha_s
 *
 */
public interface BranchDao {
	/**
	 * it saves new branch
	 * @param branch
	 */
	public void saveNewBranch(Branch branch);

	/**
	 * it updates the current branch
	 * @param branch
	 */
	public void updateBranch(Branch branch);

	/**
	 * it deletes the branch using branch object
	 * @param branch
	 */
	public void deleteBranch(Branch branch);

	/**
	 * it deletes branch using branch id
	 * @param branchId
	 */
	public void deleteBranch(Integer branchId);
	
	/**
	 * it search the branch using branch id
	 * @param branchId
	 * @return
	 */
	public Branch findById(Integer branchId);

	/**
	 * it fetches the branch using branch id
	 * @param id
	 * @return
	 */
	public Branch getBranchById(int id);
	
}
