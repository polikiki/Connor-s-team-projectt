package pt.DTO;

public class Part_ManagementDTO {

	private String part_code;
	private String part_name;
	private String part_image;
	private String part_unit;
	private String part_standard;
	private String part_modelname;
	private String part_sort;
	private String part_vendor1 ;
	private String part_vendor2 ;
	private String receving_warehouse;
	private String part_barcode;
	private int rnum;
	public String getPart_code() {
		return part_code;
	}
	public void setPart_code(String part_code) {
		this.part_code = part_code;
	}
	public String getPart_name() {
		return part_name;
	}
	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}
	public String getPart_image() {
		return part_image;
	}
	public void setPart_image(String part_image) {
		this.part_image = part_image;
	}
	public String getPart_unit() {
		return part_unit;
	}
	public void setPart_unit(String part_unit) {
		this.part_unit = part_unit;
	}
	public String getPart_standard() {
		return part_standard;
	}
	public void setPart_standard(String part_standard) {
		this.part_standard = part_standard;
	}
	public String getPart_modelname() {
		return part_modelname;
	}
	public void setPart_modelname(String part_modelname) {
		this.part_modelname = part_modelname;
	}
	public String getPart_sort() {
		return part_sort;
	}
	public void setPart_sort(String part_sort) {
		this.part_sort = part_sort;
	}
	public String getPart_vendor1() {
		return part_vendor1;
	}
	public void setPart_vendor1(String part_vendor1) {
		this.part_vendor1 = part_vendor1;
	}
	public String getPart_vendor2() {
		return part_vendor2;
	}
	public void setPart_vendor2(String part_vendor2) {
		this.part_vendor2 = part_vendor2;
	}
	public String getReceving_warehouse() {
		return receving_warehouse;
	}
	public void setReceving_warehouse(String receving_warehouse) {
		this.receving_warehouse = receving_warehouse;
	}
	public String getPart_barcode() {
		return part_barcode;
	}
	public void setPart_barcode(String part_barcode) {
		this.part_barcode = part_barcode;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	@Override
	public String toString() {
		return "Part_ManagementDTO [part_code=" + part_code + ", part_name=" + part_name + ", part_image=" + part_image
				+ ", part_unit=" + part_unit + ", part_standard=" + part_standard + ", part_modelname=" + part_modelname
				+ ", part_sort=" + part_sort + ", part_vendor1=" + part_vendor1 + ", part_vendor2=" + part_vendor2
				+ ", receving_warehouse=" + receving_warehouse + ", part_barcode=" + part_barcode + ", rnum=" + rnum
				+ "]";
	}
	
	
	
}