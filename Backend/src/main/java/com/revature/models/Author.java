package com.revature.models;

public class Author {
	private int author;

	
	public int getAuthor() {
		return author;
	}




	public void setAuthor(int author) {
		this.author = author;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + author;
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
		Author other = (Author) obj;
		if (author != other.author)
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Author [author=" + author + "]";
	}
}
