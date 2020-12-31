package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimbursement;

public interface IReimbursementDao {
	
	public List<Reimbursement> getAllReimbursementsByAuthor(int authorId);
	
	public List<Reimbursement> getAllReimbursements();
	
}
