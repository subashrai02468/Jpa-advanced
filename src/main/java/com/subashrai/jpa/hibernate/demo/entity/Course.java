package com.subashrai.jpa.hibernate.demo.entity;

import jakarta.persistence.*;

@Entity
@NamedQueries({
		@NamedQuery(name = "query_get_all_courses", query = "SELECT c FROM Course c"),
		@NamedQuery(name = "query_get_100_Step_courses", query = "SELECT c FROM Course c WHERE c.name LIKE '%100 Steps%'")
})
public class Course {
	// existing fields and methods

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	protected Course() {
	}

	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Course[%s]", name);
	}



}