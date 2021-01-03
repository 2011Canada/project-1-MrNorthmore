package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbursementDao;

public class ReimbursementService implements IReimbursementService {
	
	private ReimbursementDao rd;
	
	public ReimbursementService(ReimbursementDao rd) {
		this.rd = rd;
	}

	@Override
	public List<Reimbursement> getAllReimbursementsByAuthor(int authorId) {
		List<Reimbursement> reimbursementList = rd.getAllReimbursementsByAuthor(authorId);
		return reimbursementList;
	}

	@Override
	public List<Reimbursement> getAllPendingReimbursementsByAuthor(int authorId) {
		List<Reimbursement> reimbursementList = rd.getAllReimbursementsByAuthor(authorId);
		List<Reimbursement> pendingReimbursements = new ArrayList<Reimbursement>();
		for(Reimbursement r: reimbursementList) {
			if(r.getReimbursementStatus() == 1) {
				System.out.println(r.toString());
				pendingReimbursements.add(r);
			}
		}
		return pendingReimbursements;
	}

	@Override
	public List<Reimbursement> getAllPendingReimbursements() {
		List<Reimbursement> reimbursementList = rd.getAllPendingReimbursements();
		return reimbursementList;
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> reimbursementList = rd.getAllReimbursements();
		return reimbursementList;
	}
	
	@Override
	public List<Reimbursement> createNewReimbursement(double amount, String description, String receipt, int authorId,
			int typeId) {
		List<Reimbursement> reimbursement = rd.createNewReimbursement(amount, description, receipt, authorId, typeId);
		
		return reimbursement;
		
	}

	@Override
	public List<Reimbursement> updateReimbursement(int reimbursementId, int reimbursementResolver,
			int reimbursementStatus) {
		List<Reimbursement> reimbursement = rd.updateReimbursement(reimbursementId, reimbursementResolver, reimbursementStatus);
		return reimbursement;
	}
	
	
	
}
