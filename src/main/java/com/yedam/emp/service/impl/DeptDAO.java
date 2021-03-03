package com.yedam.emp.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.DeptVO;

@Repository
public class DeptDAO {

	@Autowired JdbcTemplate jdbc;
	
	private final String GET_SEARCH_DEPT = "SELECT * FROM DEPARTMENTS";
	private final String GET_DEPT = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
	private final String INSERT_DEPT = "INSERT INTO DEPARTMENTS VALUES(?,?,?,?)";
	private final String UPDATE_DEPT = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = ? WHERE DEPARTMENT_ID = ?";
	private final String DELETE_DEPT = "DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
	
	// 전체 조회
	public List<DeptVO> getSearchDept(DeptVO vo) {
		return jdbc.query(GET_SEARCH_DEPT, new DeptRowMapper());
	}
	
	// 단건 조회
	public DeptVO getDept(DeptVO vo) {
		return jdbc.queryForObject(GET_DEPT, new DeptRowMapper(), vo.getDepartment_id());
	}
	
	// 등록
	public int insertDept(DeptVO vo) {
		int result = 0;
		result = jdbc.update(INSERT_DEPT,
					vo.getDepartment_id(),
					vo.getDepartment_name(),
					vo.getManager_id(),
					vo.getLocation_id()
					);
		return result;
	}
	
	// 수정
	public int updateDept(DeptVO vo) {
		int result = 0;
		result = jdbc.update(UPDATE_DEPT,
							vo.getDepartment_name(),
							vo.getDepartment_id()
							);
		return result;
	}
	
	// 삭제
	public int deleteDept(DeptVO vo) {
		int result = 0;
		result = jdbc.update(DELETE_DEPT, vo.getDepartment_id());
		return result;
	}
	
	// rowMapper
	class DeptRowMapper implements RowMapper<DeptVO>{

		@Override
		public DeptVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeptVO vo = new DeptVO();
			vo.setDepartment_id(rs.getInt("department_id"));
			vo.setDepartment_name(rs.getString("department_name"));
			vo.setLocation_id(rs.getInt("location_id"));
			vo.setManager_id(rs.getInt("manager_id"));
			return vo;
		}
		
	}
	
}
