// Foo Wei Hong

public class Account {
		private int accId, studentId;
		private String studentName, studentGrade, studentClass, studentTeacher, accName, accEmail, accContactNo, ccaRegistrationid;
		
		
		public Account(int accId, int studentId, String studentName, String studentGrade, String studentClass,
				String studentTeacher, String accName, String accEmail, String accContactNo, String ccaRegistrationid) {
			super();
			this.accId = accId;
			this.studentId = studentId;
			this.studentName = studentName;
			this.studentGrade = studentGrade;
			this.studentClass = studentClass;
			this.studentTeacher = studentTeacher;
			this.accName = accName;
			this.accEmail = accEmail;
			this.accContactNo = accContactNo;
			this.ccaRegistrationid = ccaRegistrationid;
		}

		public int getStudentId() {
			return studentId;
		}
		
		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}
		
		public String getStudentName() {
			return studentName;
		}
		
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
		
		public String getStudentGrade() {
			return studentGrade;
		}
		
		public void setStudentGrade(String studentGrade) {
			this.studentGrade = studentGrade;
		}
		
		public String getStudentClass() {
			return studentClass;
		}
		
		public void setStudentClass(String studentClass) {
			this.studentClass = studentClass;
		}
		
		public String getStudentTeacher() {
			return studentTeacher;
		}
		
		public void setStudentTeacher(String studentTeacher) {
			this.studentTeacher = studentTeacher;
		}
		
		public String getAccName() {
			return accName;
		}
		
		public void setAccName(String accName) {
			this.accName = accName;
		}
		
		public String getAccEmail() {
			return accEmail;
		}
		
		public void setAccEmail(String accEmail) {
			this.accEmail = accEmail;
		}
		
		public String getAccContactNo() {
			return accContactNo;
		}
		
		public void setAccContactNo(String accContactNo) {
			this.accContactNo = accContactNo;
		}
		
		public int getAccId() {
			return accId;
		}

		public String getCcaRegistrationid() {
			return ccaRegistrationid;
		}

		public void setCcaRegistrationid(String ccaRegistrationid) {
			this.ccaRegistrationid = ccaRegistrationid;
		}
		
		
		
		
	}
