package factory_management;

public class Process {
    private String processCode;
    private String processName;
    private String processCategory;
    private String isUsed;
    private String cycleTime;
    private String productCode;

    // Constructor
    public Process(String processCode, String processName, String processCategory, String isUsed, String cycleTime, String productCode) {
        this.processCode = processCode;
        this.processName = processName;
        this.processCategory = processCategory;
        this.isUsed = isUsed;
        this.cycleTime = cycleTime;
        this.productCode = productCode;
    }

    // Getters and Setters
    public String getProcessCode() { return processCode; }
    public void setProcessCode(String processCode) { this.processCode = processCode; }

    public String getProcessName() { return processName; }
    public void setProcessName(String processName) { this.processName = processName; }

    public String getProcessCategory() { return processCategory; }
    public void setProcessCategory(String processCategory) { this.processCategory = processCategory; }

    public String getIsUsed() { return isUsed; }
    public void setIsUsed(String isUsed) { this.isUsed = isUsed; }

    public String getCycleTime() { return cycleTime; }
    public void setCycleTime(String cycleTime) { this.cycleTime = cycleTime; }

    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }
}