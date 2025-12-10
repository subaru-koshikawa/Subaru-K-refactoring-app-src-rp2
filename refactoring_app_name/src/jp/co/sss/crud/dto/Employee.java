package jp.co.sss.crud.dto;

public class Employee {
	private int empId;
	private String empName;
	private int gender;
	private String birthday;

	private Department department;

	public static final String MALE = "男性";
    public static final String FEMALE = "女性";

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


//	    @Override
//	    public String toString() {
//	        return empId + "\t" + empName + "\t" + gender + "\t" + birthday + "\t" + deptName;
//	    }
	// Employee#toStringのオーバーライド例

	@Override
	public String toString() {

		String gender_ja = "";

		if (this.gender == 1) {

			gender_ja = MALE;

		} else if (this.gender == 2) {

			gender_ja = FEMALE;

		}

		return empId + "\t" + empName + "\t" + gender_ja + "\t" + birthday + "\t" + department.getDeptName();

	}
}
