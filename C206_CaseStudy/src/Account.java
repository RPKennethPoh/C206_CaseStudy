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

        public String getAccountId() {
            return accountId;
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