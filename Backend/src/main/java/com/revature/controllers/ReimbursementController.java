package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Author;
import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbursementDao;
import com.revature.services.ReimbursementService;

public class ReimbursementController {
	
	private ReimbursementService rs = new ReimbursementService(new ReimbursementDao());
	
	private ObjectMapper om = new ObjectMapper();
	
	//actually do the request
	public void getReimbursementsByUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Author author = om.readValue(req.getInputStream(), Author.class);
		System.out.println(author.toString());
		List<Reimbursement> r = rs.getAllReimbursementsByAuthor(author.getAuthor());
		
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(r));
	}
	
	public void getPendingReimbursementsByUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Author author = om.readValue(req.getInputStream(), Author.class);
		System.out.println(author.toString());
		List<Reimbursement> r = rs.getAllPendingReimbursementsByAuthor(author.getAuthor());
		
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(r));
	}
	
	public void getPendingReimbursements(HttpServletRequest req, HttpServletResponse res) throws IOException {
		List<Reimbursement> r = rs.getAllPendingReimbursements();
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(r));
	}
	
	public void getAllReimbursements(HttpServletRequest req, HttpServletResponse res) throws IOException {
		List<Reimbursement> r = rs.getAllReimbursements();
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(r));
	}
	
	public void createNewReimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Reimbursement newReimbursement = om.readValue(req.getInputStream(), Reimbursement.class);
		System.out.println(newReimbursement.toString());
		List<Reimbursement> r = rs.createNewReimbursement(newReimbursement.getReimbursementAmt(), newReimbursement.getReimbursementDesc(), newReimbursement.getReimbursementReceipt(), newReimbursement.getReimbursementAuthor(), newReimbursement.getReimbursementType());
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(r));
	}
	
	public void updateReimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Reimbursement newReimbursement = om.readValue(req.getInputStream(), Reimbursement.class);
		List<Reimbursement> r = rs.updateReimbursement(newReimbursement.getReimbursementId(), newReimbursement.getReimbursementResolver(), newReimbursement.getReimbursementStatus());
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(r));
	}
}
