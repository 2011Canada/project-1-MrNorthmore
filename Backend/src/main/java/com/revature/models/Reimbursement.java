package com.revature.models;

public class Reimbursement {
	private int reimbursementId;
	private double reimbursementAmt;
	private String reimbursementSubmitted;
	private String reimbursementResolved;
	private String reimbursementDesc;
	private String reimbursementReceipt;
	private int reimbursementAuthor;
	private int reimbursementResolver;
	private int reimbursementStatus;
	private int reimbursementType;
	
	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public double getReimbursementAmt() {
		return reimbursementAmt;
	}

	public void setReimbursementAmt(double reimbursementAmt) {
		this.reimbursementAmt = reimbursementAmt;
	}

	public String getReimbursementSubmitted() {
		return reimbursementSubmitted;
	}

	public void setReimbursementSubmitted(String reimbursementSubmitted) {
		this.reimbursementSubmitted = reimbursementSubmitted;
	}

	public String getReimbursementResolved() {
		return reimbursementResolved;
	}

	public void setReimbursementResolved(String reimbursementResolved) {
		this.reimbursementResolved = reimbursementResolved;
	}

	public String getReimbursementDesc() {
		return reimbursementDesc;
	}

	public void setReimbursementDesc(String reimbursementDesc) {
		this.reimbursementDesc = reimbursementDesc;
	}

	public String getReimbursementReceipt() {
		return reimbursementReceipt;
	}

	public void setReimbursementReceipt(String reimbursementReceipt) {
		this.reimbursementReceipt = reimbursementReceipt;
	}

	public int getReimbursementAuthor() {
		return reimbursementAuthor;
	}

	public void setReimbursementAuthor(int reimbursementAuthor) {
		this.reimbursementAuthor = reimbursementAuthor;
	}

	public int getReimbursementResolver() {
		return reimbursementResolver;
	}

	public void setReimbursementResolver(int reimbursementResolver) {
		this.reimbursementResolver = reimbursementResolver;
	}

	public int getReimbursementStatus() {
		return reimbursementStatus;
	}

	public void setReimbursementStatus(int reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}

	public int getReimbursementType() {
		return reimbursementType;
	}

	public void setReimbursementType(int reimbursementType) {
		this.reimbursementType = reimbursementType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimbursementAmt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbursementAuthor;
		result = prime * result + ((reimbursementDesc == null) ? 0 : reimbursementDesc.hashCode());
		result = prime * result + reimbursementId;
		result = prime * result + ((reimbursementReceipt == null) ? 0 : reimbursementReceipt.hashCode());
		result = prime * result + ((reimbursementResolved == null) ? 0 : reimbursementResolved.hashCode());
		result = prime * result + reimbursementResolver;
		result = prime * result + reimbursementStatus;
		result = prime * result + ((reimbursementSubmitted == null) ? 0 : reimbursementSubmitted.hashCode());
		result = prime * result + reimbursementType;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(reimbursementAmt) != Double.doubleToLongBits(other.reimbursementAmt))
			return false;
		if (reimbursementAuthor != other.reimbursementAuthor)
			return false;
		if (reimbursementDesc == null) {
			if (other.reimbursementDesc != null)
				return false;
		} else if (!reimbursementDesc.equals(other.reimbursementDesc))
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (reimbursementReceipt == null) {
			if (other.reimbursementReceipt != null)
				return false;
		} else if (!reimbursementReceipt.equals(other.reimbursementReceipt))
			return false;
		if (reimbursementResolved == null) {
			if (other.reimbursementResolved != null)
				return false;
		} else if (!reimbursementResolved.equals(other.reimbursementResolved))
			return false;
		if (reimbursementResolver != other.reimbursementResolver)
			return false;
		if (reimbursementStatus != other.reimbursementStatus)
			return false;
		if (reimbursementSubmitted == null) {
			if (other.reimbursementSubmitted != null)
				return false;
		} else if (!reimbursementSubmitted.equals(other.reimbursementSubmitted))
			return false;
		if (reimbursementType != other.reimbursementType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", reimbursementAmt=" + reimbursementAmt
				+ ", reimbursementSubmitted=" + reimbursementSubmitted + ", reimbursementResolved="
				+ reimbursementResolved + ", reimbursementDesc=" + reimbursementDesc + ", reimbursementReceipt="
				+ reimbursementReceipt + ", reimbursementAuthor=" + reimbursementAuthor + ", reimbursementResolver="
				+ reimbursementResolver + ", reimbursementStatus=" + reimbursementStatus + ", reimbursementType="
				+ reimbursementType + "]";
	}

}
