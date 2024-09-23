package emp;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import emp.crud.EmpDTO;

public class EmpDAO {
	
	private  SqlSessionFactory sqlMapper = null;

    public  SqlSessionFactory getInstance() {
        if(sqlMapper == null) {
        	// DB 접속
        	// 자동 커밋 : sqlMapper.openSession()
        	// 수동 커밋 : sqlMapper.openSession(false)
            try {
                String res = "mybatis/SqlMapConfig.xml";
                Reader reader = Resources.getResourceAsReader(res);

                SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
                sqlMapper = ssfb.build(reader);

                reader.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sqlMapper;
    }
    
    public List<EmpDTO> selectEmp() {
    	List<EmpDTO> empList = null;
    	
    	// SqlMapConfig.xml을 읽어옴
    	sqlMapper = getInstance();
    	if(sqlMapper != null) {
    		
    		// DB 접속
        	SqlSession sqlSession = sqlMapper.openSession();
        	
        	empList = sqlSession.selectList("mapper.emp.selectAllEmp");
        	System.out.println("empList.size :" + empList.size());
    	} else {
    		System.out.println("DB 접속 실패");
    	}
    	
    	return empList;
    }
    
    
    public List<Map> selectEmpMAP() {
    	List<Map> empListMap = null;
    	
    	// SqlMapConfig.xml을 읽어옴
    	sqlMapper = getInstance();
    	if(sqlMapper != null) {
    		
    		// DB 접속
        	SqlSession sqlSession = sqlMapper.openSession();
        	
        	empListMap = sqlSession.selectList("mapper.emp.selectAllEmpMap");
        	System.out.println("empListMap.size :" + empListMap.size());
    	} else {
    		System.out.println("DB 접속 실패");
    	}
    	
    	return empListMap;
    }
	
    public EmpDTO selectOneEmp() {
    	EmpDTO empDTO = null;
    	
    	// SqlMapConfig.xml을 읽어옴
    	sqlMapper = getInstance();
    	if(sqlMapper != null) {
    		
    		// DB 접속
        	SqlSession sqlSession = sqlMapper.openSession();
        	
        	try {
        		empDTO = (EmpDTO) sqlSession.selectOne("mapper.emp.selectOneEmp");
        	}catch (Exception e) {
        		e.printStackTrace();
			}
    	} else {
    		System.out.println("DB 접속 실패");
    	}
    	
    	return empDTO;
    }
    
    
    public int selectTotalEmp() {
    	int total = -1;
    	
    	// SqlMapConfig.xml을 읽어옴
    	sqlMapper = getInstance();
    	if(sqlMapper != null) {
    		
    		// DB 접속
        	SqlSession sqlSession = sqlMapper.openSession();
        	
        	try {
        		total = sqlSession.selectOne("mapper.emp.selectTotalEmp");
        	}catch (Exception e) {
        		e.printStackTrace();
			}
    	} else {
    		System.out.println("DB 접속 실패");
    	}
    	
    	return total;
    }
    
    
    public String selectEnameEmp() {
    	String ename = null;
    	
    	// SqlMapConfig.xml을 읽어옴
    	sqlMapper = getInstance();
    	if(sqlMapper != null) {
    		
    		// DB 접속
        	SqlSession sqlSession = sqlMapper.openSession();
        	
        	try {
        		ename = sqlSession.selectOne("mapper.emp.selectEnameEmp");
        	}catch (Exception e) {
        		e.printStackTrace();
			}
    	} else {
    		System.out.println("DB 접속 실패");
    	}
    	
    	return ename;
    }
    
    public int updateEmp(EmpDTO empDTO) {
    	int result = -1;
    	
    	// SqlMapConfig.xml을 읽어옴
    	sqlMapper = getInstance();
    	if(sqlMapper != null) {
    		
    		// DB 접속
    		// 자동 커밋 : sqlMapper.openSession()
    		// 수동 커밋 : sqlMapper.openSession(false) 
        	SqlSession sqlSession = sqlMapper.openSession();
        	
        	try {
        		System.out.println(empDTO);
        		result = sqlSession.update("mapper.emp.updateEmp", empDTO);
        		sqlSession.commit();
        	}catch (Exception e) {
        		e.printStackTrace();
			}
    	} else {
    		System.out.println("DB 접속 실패");
    	}
    	
    	return result;
    }
    
    public EmpDTO selectEmpByEname(String ename) {
    	EmpDTO empDTO = null;
    	
    	// SqlMapConfig.xml을 읽어옴
    	sqlMapper = getInstance();
    	if(sqlMapper != null) {
    		
    		// DB 접속
        	SqlSession sqlSession = sqlMapper.openSession();
        	
        	try {
        		empDTO = (EmpDTO) sqlSession.selectOne("mapper.emp.selectEmpByEname",ename);
        	}catch (Exception e) {
        		e.printStackTrace();
			}
    	} else {
    		System.out.println("DB 접속 실패");
    	}
    	
    	return empDTO;
    }
    
}
