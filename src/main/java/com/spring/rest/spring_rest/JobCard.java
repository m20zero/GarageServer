package com.spring.rest.spring_rest;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NamedQueries;

@Entity
@NamedQueries({
	@org.hibernate.annotations.NamedQuery(name = JobCard.FIND_ALL_JOBCARDS, query = "select jc from JobCard jc"),
	@org.hibernate.annotations.NamedQuery(name = JobCard.FIND_ALL_COMPLETED_JOBCARDS, query = "select jc from JobCard jc WHERE jc.status='Completed'"),
	@org.hibernate.annotations.NamedQuery(name = JobCard.FIND_ALL_PENDING_JOBCARDS, query = "select jc from JobCard jc WHERE jc.status='Pending'")
})
public class JobCard {
	
	protected static final String FIND_ALL_JOBCARDS = "find_all_jobcards";
	protected static final String FIND_ALL_COMPLETED_JOBCARDS = "find_all_completed_jobcards";
	protected static final String FIND_ALL_PENDING_JOBCARDS = "find_all_pending_jobcards";
	
	@Id
	@GeneratedValue
	private long jobId;
	private Date jobStartDate;
	private Date jobEndDate;
	private String carNo;
	private String carBrand;
	private String carModel;
	private String carFuelType;
	private float carKM;
	private String carChasisNo;
	private String carEngineNo;
	private int carFuel;
	private String customerName;
	private String customerPhone;
	private String customerEmail;
	private String customerAddress;
	private String status;
	private float total;
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Task> task;
	
	public JobCard(){}

	public JobCard(long jobId, Date jobStartDate, Date jobEndDate, String carNo, String carBrand, String carModel,
			String carFuelType, float carKM, String carChasisNo, String carEngineNo, int carFuel, String customerName,
			String customerPhone, String customerEmail, String customerAddress, String status, float total,
			List<Task> task) {
		super();
		this.jobId = jobId;
		this.jobStartDate = jobStartDate;
		this.jobEndDate = jobEndDate;
		this.carNo = carNo;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.carFuelType = carFuelType;
		this.carKM = carKM;
		this.carChasisNo = carChasisNo;
		this.carEngineNo = carEngineNo;
		this.carFuel = carFuel;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.status = status;
		this.total = total;
		this.task = task;
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public Date getJobStartDate() {
		return jobStartDate;
	}

	public void setJobStartDate(Date jobStartDate) {
		this.jobStartDate = jobStartDate;
	}

	public Date getJobEndDate() {
		return jobEndDate;
	}

	public void setJobEndDate(Date jobEndDate) {
		this.jobEndDate = jobEndDate;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarFuelType() {
		return carFuelType;
	}

	public void setCarFuelType(String carFuelType) {
		this.carFuelType = carFuelType;
	}

	public float getCarKM() {
		return carKM;
	}

	public void setCarKM(float carKM) {
		this.carKM = carKM;
	}

	public String getCarChasisNo() {
		return carChasisNo;
	}

	public void setCarChasisNo(String carChasisNo) {
		this.carChasisNo = carChasisNo;
	}

	public String getCarEngineNo() {
		return carEngineNo;
	}

	public void setCarEngineNo(String carEngineNo) {
		this.carEngineNo = carEngineNo;
	}

	public int getCarFuel() {
		return carFuel;
	}

	public void setCarFuel(int carFuel) {
		this.carFuel = carFuel;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}
}
//insert into job_card values(1,'Honda','Chasis_1','Engine_1',20,'Diesel',2000,'Civic','KA 01 1234','Bengaluru','raj@gmail.com','Raj','9876543698','2020-10-8','2020-10-10','Pending',5000);
//insert into task values(1,'Task 1',2000,20);
//insert into job_card_task values(1,1);
