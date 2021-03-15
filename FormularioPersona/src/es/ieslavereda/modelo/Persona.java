package es.ieslavereda.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Persona implements Serializable{

	
	private String name;
	private String surname;
	private String address;
	private String city;
	private String Phone;
	private String DNI;
	private LocalDate birthday;
	private String sexo;
	
	public Persona(String name, String surname, String address, String city, String phone, String dNI, LocalDate age, String sexo) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.city = city;
		Phone = phone;
		DNI = dNI;
		birthday = age;
		this.sexo = sexo;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getPhone() {
		return Phone;
	}

	public String getDNI() {
		return DNI;
	}

	public LocalDate getAge() {
		return birthday;
	}
	
	public String getSexo() {
		return sexo;
	}

	@Override
	public String toString() {
		return "Persona [name=" + name + ", surname=" + surname + ", Address=" + address + ", City=" + city + ", Phone="
				+ Phone + ", DNI=" + DNI + ", Birthday=" + birthday + ", sexo=" + sexo + "]\n";
	}


	
	
	
	
	
}

