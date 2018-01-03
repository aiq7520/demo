package ssm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 做cordova实例是需要用到的实体
 * @author lenove1
 *
 */
@Entity
@Table(name="mms_car")
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String vin;
	private String standard;
	private String color;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Car() {
		super();
	}
	public Car(String vin, String standard, String color) {
		super();
		this.vin = vin;
		this.standard = standard;
		this.color = color;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", vin=" + vin + ", standard=" + standard
				+ ", color=" + color + "]";
	}
	
}
