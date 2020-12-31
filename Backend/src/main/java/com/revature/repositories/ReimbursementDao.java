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
		// TODO Auto-generated method stub
		return null;
	}

}
