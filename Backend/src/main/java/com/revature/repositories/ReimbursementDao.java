package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDao implements IReimbursementDao {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	@Override
	public List<Reimbursement> getAllReimbursementsByAuthor(int authorId) {
		Connection conn = this.cf.getConnection();
		
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		try {

			String sql = "select * from ers_reimbursement where \"reimb_author\" = ?;";
			PreparedStatement findReimbursements = conn.prepareStatement(sql);

			findReimbursements.setInt(1, authorId);

			ResultSet res = findReimbursements.executeQuery();

			while (res.next()) {
				Reimbursement reimb = new Reimbursement();
				reimb.setReimbursementId(res.getInt("reimb_id"));
				reimb.setReimbursementAmt(res.getDouble("reimb_amount"));
				reimb.setReimbursementSubmitted(res.getString("reimb_submitted"));
				reimb.setReimbursementResolved(res.getString("reimb_resolved"));
				reimb.setReimbursementDesc(res.getString("reimb_description"));
				reimb.setReimbursementReceipt(res.getString("reimb_receipt"));
				reimb.setReimbursementAuthor(res.getInt("reimb_author"));
				reimb.setReimbursementResolver(res.getInt("reimb_resolver"));
				reimb.setReimbursementStatus(res.getInt("reimb_status_id"));
				reimb.setReimbursementType(res.getInt("reimb_type_id"));
				
				reimbursements.add(reimb);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		Connection conn = this.cf.getConnection();
		
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		try {

			String sql = "select * from ers_reimbursement;";
			PreparedStatement findReimbursements = conn.prepareStatement(sql);

			ResultSet res = findReimbursements.executeQuery();

			while (res.next()) {
				Reimbursement reimb = new Reimbursement();
				reimb.setReimbursementId(res.getInt("reimb_id"));
				reimb.setReimbursementAmt(res.getDouble("reimb_amount"));
				reimb.setReimbursementSubmitted(res.getString("reimb_submitted"));
				reimb.setReimbursementResolved(res.getString("reimb_resolved"));
				reimb.setReimbursementDesc(res.getString("reimb_description"));
				reimb.setReimbursementReceipt(res.getString("reimb_receipt"));
				reimb.setReimbursementAuthor(res.getInt("reimb_author"));
				reimb.setReimbursementResolver(res.getInt("reimb_resolver"));
				reimb.setReimbursementStatus(res.getInt("reimb_status_id"));
				reimb.setReimbursementType(res.getInt("reimb_type_id"));
				
				reimbursements.add(reimb);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getAllPendingReimbursementsByAuthor(int authorId) {
		Connection conn = this.cf.getConnection();
		
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		try {

			String sql = "select * from ers_reimbursement where \"reimb_author\" = ? and \"reimb_status_id\" = 1;";
			PreparedStatement findReimbursements = conn.prepareStatement(sql);

			findReimbursements.setInt(1, authorId);

			ResultSet res = findReimbursements.executeQuery();

			while (res.next()) {
				Reimbursement reimb = new Reimbursement();
				reimb.setReimbursementId(res.getInt("reimb_id"));
				reimb.setReimbursementAmt(res.getDouble("reimb_amount"));
				reimb.setReimbursementSubmitted(res.getString("reimb_submitted"));
				reimb.setReimbursementResolved(res.getString("reimb_resolved"));
				reimb.setReimbursementDesc(res.getString("reimb_description"));
				reimb.setReimbursementReceipt(res.getString("reimb_receipt"));
				reimb.setReimbursementAuthor(res.getInt("reimb_author"));
				reimb.setReimbursementResolver(res.getInt("reimb_resolver"));
				reimb.setReimbursementStatus(res.getInt("reimb_status_id"));
				reimb.setReimbursementType(res.getInt("reimb_type_id"));
				
				reimbursements.add(reimb);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;

	}

	@Override
	public List<Reimbursement> getAllPendingReimbursements() {
		Connection conn = this.cf.getConnection();
		
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		try {

			String sql = "select * from ers_reimbursement where \"reimb_status_id\" = 1;";
			PreparedStatement findReimbursements = conn.prepareStatement(sql);

			ResultSet res = findReimbursements.executeQuery();

			while (res.next()) {
				Reimbursement reimb = new Reimbursement();
				reimb.setReimbursementId(res.getInt("reimb_id"));
				reimb.setReimbursementAmt(res.getDouble("reimb_amount"));
				reimb.setReimbursementSubmitted(res.getString("reimb_submitted"));
				reimb.setReimbursementResolved(res.getString("reimb_resolved"));
				reimb.setReimbursementDesc(res.getString("reimb_description"));
				reimb.setReimbursementReceipt(res.getString("reimb_receipt"));
				reimb.setReimbursementAuthor(res.getInt("reimb_author"));
				reimb.setReimbursementResolver(res.getInt("reimb_resolver"));
				reimb.setReimbursementStatus(res.getInt("reimb_status_id"));
				reimb.setReimbursementType(res.getInt("reimb_type_id"));
				
				reimbursements.add(reimb);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;


	}

	@Override
	public List<Reimbursement> createNewReimbursement(double amount, String description, String receipt, int authorId,
			int typeId) {
		Connection conn = this.cf.getConnection();
		
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		try {

			String sql = "insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_receipt, reimb_author, reimb_status_id, reimb_type_id)\n"
					+ "	values (?, Now(), ?, ?, ?, 1, ?) returning \"reimb_id\";";
			PreparedStatement newReimbursement = conn.prepareStatement(sql);

			newReimbursement.setDouble(1, amount);
			newReimbursement.setString(2, description);
			newReimbursement.setString(3, receipt);
			newReimbursement.setInt(4, authorId);
			newReimbursement.setInt(5, typeId);
			

			ResultSet res = newReimbursement.executeQuery();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> updateReimbursement(int reimbursementId, int reimbursementResolver,
			int reimbursementStatus) {
		Connection conn = this.cf.getConnection();
		
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		try {

			
			String sql = "update ers_reimbursement as er set reimb_status_id = ?, reimb_resolved = Now(), reimb_resolver = ? where reimb_id = ? returning \"reimb_id\";";
			PreparedStatement newReimbursement = conn.prepareStatement(sql);

			newReimbursement.setInt(1, reimbursementStatus);
			newReimbursement.setInt(2, reimbursementResolver);
			newReimbursement.setInt(3, reimbursementId);

			ResultSet res = newReimbursement.executeQuery();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

}
