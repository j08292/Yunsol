package kr.spring.book.domain;

public class DeliveryCommand {
	private int delivery_num;
	private String delivery_name;
	private String delivery_cell;
	private String delivery_email;
	private String sample3_postcode;
	private String delivery_address;
	private String delivery_receiveDate;
	private String mem_id;
	
	public int getDelivery_num() {
		return delivery_num;
	}

	public void setDelivery_num(int delivery_num) {
		this.delivery_num = delivery_num;
	}

	public String getDelivery_name() {
		return delivery_name;
	}

	public void setDelivery_name(String delivery_name) {
		this.delivery_name = delivery_name;
	}

	public String getDelivery_cell() {
		return delivery_cell;
	}

	public void setDelivery_cell(String delivery_cell) {
		this.delivery_cell = delivery_cell;
	}

	public String getDelivery_email() {
		return delivery_email;
	}

	public void setDelivery_email(String delivery_email) {
		this.delivery_email = delivery_email;
	}

	public String getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	public String getDelivery_receiveDate() {
		return delivery_receiveDate;
	}

	public void setDelivery_receiveDate(String delivery_receiveDate) {
		this.delivery_receiveDate = delivery_receiveDate;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getSample3_postcode() {
		return sample3_postcode;
	}

	public void setSample3_postcode(String sample3_postcode) {
		this.sample3_postcode = sample3_postcode;
	}

	@Override
	public String toString() {
		return "DeliveryCommand [delivery_num=" + delivery_num + ", delivery_name=" + delivery_name + ", delivery_cell="
				+ delivery_cell + ", delivery_email=" + delivery_email + ", delivery_address=" + delivery_address
				+ ", delivery_receiveDate=" + delivery_receiveDate + "]";
	}
}
