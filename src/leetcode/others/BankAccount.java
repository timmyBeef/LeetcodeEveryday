package leetcode.others;

public class BankAccount {
    private Long seq;
    private String id;
    private String name;

    private BankAccount(){}

    public static class Builder {
        private Long seq;
        private String id;
        private String name;
        public Builder() {
            this.seq = seq;
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public BankAccount build() {
            BankAccount acc = new BankAccount();
            acc.seq = this.seq;
            acc.id = this.id;
            acc.name = this.name;
            return acc;
        }
    }
}
