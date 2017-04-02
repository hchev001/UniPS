package com.unips.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.unips.constants.BusinessConstants.BusinessCategory;
import com.unips.constants.BusinessConstants.Roles;
import com.unips.dao.SearchDao;
import com.unips.dao.mapper.BusinessResultSetExtractor;
import com.unips.dao.mapper.SearchResultRowMapper;
import com.unips.entity.Business;

@Repository("search.mysql")
public class SearchDaoMysql implements SearchDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Business> search(String keyword, String category, Integer rating) {
		
		 //TODO: Add the rating.
		
		final String sql = "SELECT * " +
							"FROM `unipsdb`.`user` AS u " +
							"LEFT JOIN ( " +
							"	SELECT *, AVG(rt.rating_value_id) AS rating_average " +
							"    FROM `unipsdb`.`rating` AS rt " + 
							"    GROUP BY rt.business_id " +
							"    ) AS r ON u.user_id = r.business_id " +
							"WHERE u.role_id = ? " +
							"AND u.name like ? " +
							"AND u.business_category_id like ? " +
							"AND IFNULL(r.rating_average, 0) >= ?";
									
		Object[] values = new Object[] {Roles.ROLE_BUSINESS.ordinal(), keyword, category, rating};
		
		return jdbcTemplate.query(sql, new SearchResultRowMapper(), values);
	}
	
	
}