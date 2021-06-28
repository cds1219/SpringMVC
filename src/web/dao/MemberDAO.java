package web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberDAO {
	
	JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate=new JdbcTemplate(dataSource);
	}

	public List listMembers() {	// selectAllMembers()와 동일
		String sql="select * from member";
		jdbcTemplate.query(sql, null);	//con대여+PreparedStatement+executeQuery
		
		return list;
	}
	
	class MyRowMapper implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO vo=new MemberVO();
			vo.setId(rs.getString("id"));
			vo.setPw(rs.getString("pw"));
			vo.setName(rs.getString("name"));
			return vo;
		}
		
	}

}
