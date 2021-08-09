import java.util.ArrayList;

// Foo Wei Hong
//Account//

public class Account {
		private String accountId;
		private int accountType;
		
		public Account(String accountId, int accountType) {
			this.accountId = accountId;
			this.accountType = accountType;
		}

<<<<<<< HEAD
		public String getAccountId() {
			return accountId;
=======
		public Account(int accId, int studentId, String studentName, String studentGrade, String studentClass,
				String studentTeacher, String accName, String accEmail, String accContactNo) {
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
>>>>>>> branch 'master' of https://github.com/RPKennethPoh/C206_CaseStudy.git
		}

		public void setAccountId(String accountId) {
			this.accountId = accountId;
		}

		public int getAccountType() {
			return accountType;
		}

		public void setAccountType(int accountType) {
			this.accountType = accountType;
		}
		
	}

