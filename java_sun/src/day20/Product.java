package day20;

import java.text.DecimalFormat;
import java.util.Objects;

import lombok.Data;

@Data
public class Product {
	
	//제품 코드(6자리, ABC001), 분류, 제품명, 옵션, 가격
	private String productCode; 
	
	private String category;
	private String name;
	private String option;
	private int price;
	private int amount;
	


	
	public Product(String productCode,String category, String name, String option, int price) {
		//this.productCode = productCode;
		this.category = category;
		this.name = name;
		this.option = option;
		this.price = price;
	}

	public Product(int max, String category, String name, String option, int price) {
		this("",category, name, option, price);
		String prefix = Product.getCodePrefix(category);
		DecimalFormat format = new DecimalFormat("000");
		String suffix = format.format(max+1);
		this.productCode = prefix+suffix;
		//code를 추가 : ABC+001
		
	}

	@Override
	public String toString() {
		return "[" + category + "] " + "("+ productCode+ ")"+ name + "/" + option + " : " + price + "원(수량 : " + amount + ")" ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && Objects.equals(name, other.name)
				&& Objects.equals(option, other.option);
	}

	public static String getCodePrefix(String category) {
		//문구 : ABC, 의류 : DEF, 식품 : XYZ, 가전 : ELC, 기타 : ETC
		switch(category) {
		case "문구":
			return "ABC";
		case "의류":
			return "DEF";
		case "식품":
			return "XYZ";
		case "가전":
			return "ELC";
		case "기타":
			return "ETC";
		default:
			return null;
		}
	}

	
//	public Product(String category, String productName, String option, int price) {
//		this.category = category;
//		DecimalFormat format = new DecimalFormat("###");
//		productNum = format.format(productNum);
//		
//		switch(category) {
//		case "문구":
//			productCode = "ABC";
//			break;
//		case "의류":
//			productCode = "DEF";
//			break;
//		case "식품":
//			productCode = "XYZ";
//			break;
//		case "가전":
//			productCode = "ELC";
//			break;
//		case "기타":
//			productCode = "ETC";
//			break;
//		}
//		
//		this.productName = productName;
//		this.option = option;
//		this.price = price;
//	}
	 
	 
}
