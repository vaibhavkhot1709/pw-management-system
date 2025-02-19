package com.pw.pw.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name="pwAddress")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addId;


    private int floorNo;
    private int flatNo;
    

    private String buildingName;
    private int pinNum;
}
