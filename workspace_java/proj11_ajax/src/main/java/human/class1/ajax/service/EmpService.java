package human.class1.ajax.service;

import java.util.List;

import human.class1.ajax.dto.EmpDTO;

public interface EmpService {

	List<EmpDTO> listEmp();
	int deleteEmp(EmpDTO empDTO);
}