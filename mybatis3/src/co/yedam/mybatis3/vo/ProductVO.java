package co.yedam.mybatis3.vo;

import java.util.Date;

public class ProductVO {
	String prodCode;
	String prodName;
	String prodDesc;
	int sellingPrice;
	Date creationDate;
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public int getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "ProductVO [prodCode=" + prodCode + ", prodName=" + prodName + ", prodDesc=" + prodDesc
				+ ", sellingPrice=" + sellingPrice + ", creationDate=" + creationDate + "]";
	}
}
