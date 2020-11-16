package hh.swd20.Tournament.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstname;
	private String lastname;
	private int number;		//pelinumero
	private int birthyear;	//syntymävuosi
	
	
	@ManyToOne	
	@JsonIgnoreProperties ("players") // a solution to avoid infinite loop during JSON serialization/deserialization
	@JoinColumn(name = "teamid")
	private Team team;
	public Player() {}
	
	public Player(String firstname , String lastname, int number, int birthyear, Team team) {
		
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.number = number;
	this.birthyear = birthyear;
	this.team = team;
	
	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", number=" + number
				+ ", birthyear=" + birthyear;
		
//		 + ", team=" + team + "]"
	}
	
	
}
