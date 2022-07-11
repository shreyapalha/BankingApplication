package com.xoriant.bankingapplication.service;

import com.xoriant.bankingapplication.model.Branch;

/**
 * @author Palha_s
 *
 */
public interface BranchService {
	
	/**
	 * @param id
	 * @return
	 */
	Branch getBranchByID(int id);

}
