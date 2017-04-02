package com.unips.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.unips.constants.BusinessConstants.BusinessCategory;
import com.unips.dao.SearchDao;
import com.unips.dao.mapper.BusinessResultSetExtractor;
import com.unips.dao.mapper.SearchResultRowMapper;
import com.unips.entity.Business;


@Repository("search.mysql")
public class SearchDaoMysql implements SearchDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Business> search(String keyword, BusinessCategory category, Double rating) {
		
		String keywordParam;
		String categoryParam;
		
		// Check the values
		if (keyword != null)
			keywordParam = "%" + keyword + "%";
		else
			keywordParam = "%";
		
		if (category != null )
			categoryParam = category.toString();
		else
			categoryParam = "%";
			
		final String sql = "SELECT * " +
							"FROM `unipsdb`.`user` AS u " +
							"WHERE u.role_id = 2 " +
							"AND u.name like ? " +
							"AND u.business_category_id like ?";
									
		Object[] values = new Object[] {keywordParam, categoryParam };
		
		return jdbcTemplate.query(sql, new SearchResultRowMapper(), values);
	}
	
	
}
