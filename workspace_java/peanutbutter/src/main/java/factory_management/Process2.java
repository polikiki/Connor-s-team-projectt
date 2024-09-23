package factory_management;

public class Process2 {
    private String underprocess;
    private String processname2;
    private String image;
    private String productcontent;
    private String processCode;
   
    public Process2(String underProcessData2, String processNameData2, String imageData2, String productContentData2, String processCodeData2) {
        this.underprocess = underProcessData2;       
        this.processCode = processCodeData2;         
        this.image = imageData2;        
        this.processname2 = processNameData2;     
        this.productcontent = productContentData2;
    }

	public String getUnderprocess() {
		return underprocess;
	}

	public void setUnderprocess(String underprocess) {
		this.underprocess = underprocess;
	}

	public String getProcessname2() {
		return processname2;
	}

	public void setProcessname2(String processname2) {
		this.processname2 = processname2;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProductcontent() {
		return productcontent;
	}

	public void setProductcontent(String productcontent) {
		this.productcontent = productcontent;
	}

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}
	
}










