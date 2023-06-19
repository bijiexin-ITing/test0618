package com.qst.entity;

import org.springframework.web.multipart.MultipartFile;

public class Goods {
	private Integer id;
	private String gname;
	private String contents;
	private Double goprice;
	private Double grprice;
	private Integer saleNum;
	private Integer gstore;
	private MultipartFile logoImage;
	private String gpicture;
	private Integer goodstype_id;
	private String typename;//��ѯʱʹ��
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Double getGoprice() {
		return goprice;
	}
	public void setGoprice(Double goprice) {
		this.goprice = goprice;
	}
	public Double getGrprice() {
		return grprice;
	}
	public void setGrprice(Double grprice) {
		this.grprice = grprice;
	}
	public Integer getGstore() {
		return gstore;
	}
	public void setGstore(Integer gstore) {
		this.gstore = gstore;
	}
	public MultipartFile getLogoImage() {
		return logoImage;
	}
	public void setLogoImage(MultipartFile logoImage) {
		this.logoImage = logoImage;
	}
	public String getGpicture() {
		return gpicture;
	}
	public void setGpicture(String gpicture) {
		this.gpicture = gpicture;
	}
	public Integer getGoodstype_id() {
		return goodstype_id;
	}
	public void setGoodstype_id(Integer goodstype_id) {
		this.goodstype_id = goodstype_id;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Integer getSaleNum() {
		return saleNum;
	}
	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}
	
}
