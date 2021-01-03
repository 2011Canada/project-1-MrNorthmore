package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;

public interface IReimbursementService {
	
	public List<Reimbursement> getAllReimbursementsByAuthor(int authorId);
	public List<Reimbursement> getAllPendingReimbursementsByAuthor(int authorId);
	public List<Reimbursement> getAllPendingReimbursements();
	public List<Reimbursement> getAllReimbursements();
	public List<Reimbursement> createNewReimbursement(double amount, String description, String receipt, int authorId,
			int typeId);
	public List<Reimbursement> updateReimbursement(int reimbursementId, int reimbursementResolver, int reimbursementStatus);

}
