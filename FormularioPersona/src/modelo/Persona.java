package modelo;

public class Persona {

	
	private String name;
	private String surname;
	private String Address;
	private String City;
	private String Phone;
	private String DNI;
	private Integer Age;
	
	public Persona(String name, String surname, String address, String city, String phone, String dNI, Integer age) {
		super();
		this.name = name;
		this.surname = surname;
		Address = address;
		City = city;
		Phone = phone;
		DNI = dNI;
		Age = age;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getAddress() {
		return Address;
	}

	public String getCity() {
		return City;
	}

	public String getPhone() {
		return Phone;
	}

	public String getDNI() {
		return DNI;
	}

	public Integer getAge() {
		return Age;
	}

	@Override
	public String toString() {
		return "Persona [name=" + name + ", surname=" + surname + ", Address=" + Address + ", City=" + City + ", Phone="
				+ Phone + ", DNI=" + DNI + ", Age=" + Age + "]";
	}
	
	
	
	
	
}

