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
	public enum Status {
		DISABLED, ACTIVE, SUSPENDED, BANNED
	}
	
	/**
	 * Reflects the authority representation of the user.
	 */
	public enum Roles {
		ROLE_ADMIN, ROLE_USER, ROLE_BUSINESS
	}

	/**
	 * Reflects for the business categories
	 */
	public enum BusinessCategory {
		RESTAURANT, SHOPPING, HEALTH, EDUCATION, COFFEE, OTHER
	}
	
	
	/**
	 * Reflects the rating possible
	 */
	public enum RatingValue { 
		BAD, REGULAR, AVERAGE, GOOD, EXCELLENT
	}
	
	/**
	 * Reflects the status of a comment
	 */
	public enum CommentFlag{
		OK, FLAG;
		
		public CommentFlag toggle() {
			if(this.equals(OK))
				return FLAG;
			else
				return OK;
		}
	}
	
}