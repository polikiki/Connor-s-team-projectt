package quiz_server;

public class NaverService {
	
	NaverDAO naverDAO;
	NaverService() {
		this.naverDAO = new NaverDAO();
	}
	
	void setNaverDAO(NaverDAO naverDAO) {
		this.naverDAO = naverDAO;
	}
	
}
