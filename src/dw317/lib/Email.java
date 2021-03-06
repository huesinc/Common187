package dw317.lib;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Email.
 */
public class Email implements Serializable, Comparable<Email> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 42031768871L;
	
	/** The address. */
	private final String address;
	
	
	/**
	 * Instantiates a new email.
	 *
	 * @param address the address
	 */
	public Email(String address){
		
		if (!Name.isValidString(address, 1))
			throw new IllegalArgumentException("invalid email format");
		this.address = address;
	}
	
	/**
	 * Instantiates a new email.
	 *
	 * @param email the email
	 */
	public Email(Email email)
	{
		this.address = email.address;
	}
	
	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		String str = getAddress().split("@")[0];
		return str;
	}
	
	/**
	 * Gets the host.
	 *
	 * @return the host
	 */
	public String getHost() {
		String str =  getAddress().split("@")[1];
		return str;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address.toUpperCase() == null) ? 0 : address.toUpperCase().hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Email))
			return false;
		Email other = (Email) obj;
		if (address == null) {
			if (other.address != null)
				return false;
	} else if (!address.equalsIgnoreCase(other.address))
	return false;
		
		return true;
		
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getAddress();
	}
	
	/**
	 * Validate email.
	 *
	 * @param address the address
	 * @return true, if successful
	 
	
	
	//Email must implement the compareTo method. Emails are naturally ordered by their case-insensitive host name, 
	//followed by case-insensitive userid. So zhu@abc.com is before A@ba.com

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	/*
	@Override
	public int compareTo(Email o) {
		if (o == null)
			throw new NullPointerException();
		// handle if same host id
		if (this.getHost().equalsIgnoreCase(o.getHost())){
				if (this.getUserId().equalsIgnoreCase(o.getUserId())){
					return 0; //same everything
				// same host but different userID
				}
				else if (this.getUserId().compareToIgnoreCase(o.getUserId()) > 0)
					return -1;
				else if (this.getUserId().compareToIgnoreCase(o.getUserId()) < 0)
					return 1;
		}
		//handle for different hosts
		else if (this.getHost().compareToIgnoreCase(o.getHost())> 0)
			return -1;
		return 1;
	}
		*/////
	
	@Override
	public int compareTo(Email o){
		// Check if the object is null
		if (o == null)
			throw new NullPointerException("The object is null");
		
		String thisHost = getHost().toLowerCase(), // Extract local host
			   objHost = o.getHost().toLowerCase(), // Extract object host
			   thisUserId = getUserId().toLowerCase(), // Extract the local user id
			   objUserId = o.getUserId().toLowerCase(); // Extract the object user id
		
		if (thisHost.equals(objHost))
			return thisUserId.compareTo(objUserId);
		else
			return thisHost.compareTo(objHost);
		
		
		
	}

	public void setAddress(String string) {
		// TODO Auto-generated method stub
		
	}
}
	