package factory_management;

public class UnderProcessDTO {
    private String processCode;
    private String underProcessCode;
    private String processName;
    private String image;
    private String productContent;

    // 기본 생성자
    public UnderProcessDTO() {}

    // 매개변수 있는 생성자
    public UnderProcessDTO(String processCode, String underProcessCode, String processName, String image, String productContent) {
        this.processCode = processCode;
        this.underProcessCode = underProcessCode;
        this.processName = processName;
        this.image = image;
        this.productContent = productContent;
    }

    // Getter 및 Setter 메서드
    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getUnderProcessCode() {
        return underProcessCode;
    }

    public void setUnderProcessCode(String underProcessCode) {
        this.underProcessCode = underProcessCode;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }
}


