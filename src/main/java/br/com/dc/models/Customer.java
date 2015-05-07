package br.com.dc.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
@SequenceGenerator(name = "CUSTOMER_SEQUENCE", sequenceName = "CUSTOMER_SEQUENCE", allocationSize = 1, initialValue = 0)
public class Customer {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "CUSTOMER_SEQUENCE")
    private int id;
 
    @Column
    private String name;
 
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER,orphanRemoval=true)
    // @JoinColumn(name="USER_ID", nullable=false)
    @PrimaryKeyJoinColumn
    private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
}