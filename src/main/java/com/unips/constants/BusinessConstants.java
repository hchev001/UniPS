package com.unips.constants;

/**
 * Class to hold all business logic enumerator and
 * constants.
 * @author alfredo
 *
 */
public class BusinessConstants {
	
	/**
	 * Reflects the status of an user.
	 */
	public enum UserStatus {
		ACTIVE, DISABLED, SUSPENDED, BANNED
	}
	
	/**
	 * Reflects the authority representation of the user.
	 */
	public enum UserAuthorities {
		ROLE_USER, ROLE_ADMIN, ROLE_BUSINESS
	}

}