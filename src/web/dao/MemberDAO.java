package web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;	//SpringJDBC core API
import org.springframework.jdbc.core.RowMapper;

import web.vo.MemberVO;

public class MemberDAO {
	
	JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate=new JdbcTemplate(dataSource);
	}

	public List<MemberVO> listMembers() {	// selectAllMembers()와 동일
		String sql="select * from member";
		
		List<MemberVO> list=new ArrayList();
		list=jdbcTemplate.query(sql, new RowMapper(){	//anonymous local class

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO vo=new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				System.out.println(vo);
				return vo;
			}
			
		});	//con대여+PreparedStatement+executeQuery
		
		return list;
	}
	
}
