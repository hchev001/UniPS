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
		ACTIVE, DISABLED, SUSPENDED, BANNED
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
		RESTAURANT, SHOPING, HEATH, EDUCATION, COFFEE, OTHER
	}
	
	/**
	 * Reflects the states 
	 */
	public enum StatesUs {
		AL, AK, AZ, AR, CA, CO, CT, DE, FL, GA, HI, ID,
		IL, IN, IA, KS, KY, LA, ME, MD, MA, MI, MN, MS,
		MO, MT, NE, NV, NH, NJ, NM, NY, NC, ND, OH, OK,
		OR, PA, RI, SC, SD, TN, TX, UT, VT, VA, WA, WV,
		WI, WY
	}
	
	/**
	 * Reflects the rating possible
	 */
	public enum RatingCategory { 
		BAD, REGULAR, AVERAGE, GOOD, EXCELLENT
	}
	
	/**
	 * Reflects the status of a comment
	 */
	public enum CommentFlag{
		OK, FLAG
	}
	
}