package human.class1.ajax.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import human.class1.ajax.dto.EmpDTO;

@Repository
public class EmpDAOImpl implements EmpDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<EmpDTO> selectEmp() {
		List<EmpDTO> result = sqlSession.selectList("mapper.emp.selectEmp");
		return result;
	}
	
}