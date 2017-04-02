package com.unips.dao.impl;

import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.unips.constants.BusinessConstants.Roles;
import com.unips.constants.BusinessConstants.Status;
import com.unips.dao.BusinessDao;
import com.unips.dao.mapper.BusinessResultSetExtractor;
import com.unips.entity.Business;

@Repository("business.mysql")
public class BusinessDaoMysql implements BusinessDao {
	
	private static final Logger log = Logger.getLogger(BusinessDaoMysql.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Business> getAllBusiness() {
		
		String sql = "SELECT * " +
					 "FROM `unipsdb`.`user` AS u " +
					 "LEFT JOIN `unipsdb`.`address` AS a ON u.address_id = a.address_id " +
					 "LEFT JOIN `unipsdb`.`picture` AS p ON u.user_id = p.user_id " +
					 "LEFT JOIN `unipsdb`.`comment` AS c ON u.user_id = c.business_id " +
					 "LEFT JOIN ( " +	
					 "	SELECT rt.business_id, AVG(rt.rating_value_id) AS rating_average " +
					 "    FROM `unipsdb`.`rating` AS rt " +
					 "    GROUP BY rt.business_id " +
					 "    ) AS r ON u.user_id = r.business_id " +
					 "WHERE u.role_id = ?";

		int role = Roles.ROLE_BUSINESS.ordinal();
		
		List<Business> business = jdbcTemplate.query(sql, new BusinessResultSetExtractor(),
				new Object[] {role});
	
		return business;
	}

	@Override
	public Business getBusiness(String username) {

		String sql = "SELECT * " +
					 "FROM `unipsdb`.`user` AS u " +
					 "LEFT JOIN `unipsdb`.`address` AS a ON u.address_id = a.address_id " +
					 "LEFT JOIN `unipsdb`.`picture` AS p ON u.user_id = p.user_id " +
					 "LEFT JOIN `unipsdb`.`comment` AS c ON u.user_id = c.business_id " +
					 "LEFT JOIN ( " +	
					 "	SELECT rt.business_id, AVG(rt.rating_value_id) AS rating_average " +
					 "    FROM `unipsdb`.`rating` AS rt " +
					 "    GROUP BY rt.business_id " +
					 "    ) AS r ON u.user_id = r.business_id " +
					 "WHERE u.role_id = ? AND u.username = ?";

		try {
			Object[] values = new Object[] {Roles.ROLE_BUSINESS.ordinal(), username};
			int[] types = new int[] {Types.INTEGER, Types.VARCHAR};

			List<Business> business = jdbcTemplate.query(sql, values, types, new BusinessResultSetExtractor());
			return  business.get(0);
		} catch (Exception e) {
			return null;
		}
	}
	

	@Override
	public int addBusiness(Business business) {
		
		String sql = "INSERT INTO `unipsdb`.`user` " + 
					"(`username`, `password`, `email`, `name`, `phone`, `phone_business`, " +
					" `question1`, `question2`, `status_id`, `role_id`, `business_category_id`, " +
					" `token`) " +
					 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Object[] values = {
				business.getUsername(),
				business.getPassword(),
				business.getEmail(),
				business.getName(),
				business.getPhone(),
				business.getPhoneBusiness(),
				business.getQuestion1(),
				business.getQuestion2(),
				business.getStatus().ordinal(),
				business.getRole().ordinal(),
				business.getCategory().ordinal(),
				business.getToken()
		};
		
		return jdbcTemplate.update(sql, values);
	}

	@Override
	public Business updateBusiness(Business business) {
		
		String sql = "UPDATE `unipsdb`.`user` u " +
					 "SET u.username = ?, u.password = ?, u.name = ?, " +
					 "u.phone = ?, u.phone_business = ?, u.email = ?, " +
					 "u.question1 = ?, u.question2 = ?, u.description = ?, " +
					 "u.hours = ?, u.business_category_id = ? " +
					 "WHERE u.username = ?;";		
		
		Object[] values = {
				business.getUsername(),
				business.getName(),
				business.getPassword(),
				business.getPhone(),
				business.getPhoneBusiness(),
				business.getEmail(),
				business.getQuestion1(),
				business.getQuestion2(),
				business.getDescription(),
				business.getHours(),
				business.getCategory().ordinal(),
				business.getUsername()};
		
		jdbcTemplate.update(sql, values);
		return business;
	}

	@Override
	public int deleteBusiness(String username) {
		
		String sql = "DELETE FROM `unipsdb`.`user` WHERE username = ?";
			
		return jdbcTemplate.update(sql, new Object[]{username});
	}	


	@Override
	public String verifyEmail(String candidateToken) {
		
		String sql = "SELECT username FROM `unipsdb`.`user` u WHERE u.token=?";
		String username = jdbcTemplate.queryForObject(sql, new Object[] {candidateToken}, String.class);
		
		return username;
	}

	@Override
	public int updateUserStatus(String username, Status status) {
		
		String sql = "UPDATE `unipsdb`.`user` u SET u.status_id=? WHERE u.username=?;";
	
		return jdbcTemplate.update(sql, new Object[] {status.ordinal(), username});
	}

	@Override
	public List<String> getQuestions(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exits(String username) {
		log.debug(username);
		
		final String sql = "SELECT u.username FROM `unipsdb`.`user`AS u WHERE u.username = ?";
		
		try {
			String result = jdbcTemplate.queryForObject(sql, String.class, new Object[] {username});
			return result != "";
		} catch (Exception e) {
			return false;
		}		
	}

}
