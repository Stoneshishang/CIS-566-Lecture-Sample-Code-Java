package com.ShangShi;

//These are all the components of the subsystem we are going to use
        public class MorgageFacade {
        Loan ln;
        Credit ct;
        Bank bk;
        Customer cr;

//    The façade is passed a reference to each component of the subsystem in its
//    constructor. The façade then assign each to corresponding instance variable.
        public MorgageFacade(Loan ln, Credit ct, Bank bk, Customer cr) {
            this.ln = ln;
            this.ct = ct;
            this.bk = bk;
            this.cr = cr;
        }

        public boolean IsEligible(Customer cr, int loanAmount) {
            int eligibleScore = 0;
            System.out.println(cr.name + " applies for " + loanAmount);
            if (bk.HasSufficientSavings(cr, loanAmount)) {
                eligibleScore = eligibleScore + 2;
                System.out.println("Has sufficient Saving");
            } else {
                eligibleScore = eligibleScore - 1;
                System.out.println("Doesn't have sufficient Saving");
            }
            if (ct.HasBadCredit(cr)) {
                eligibleScore = eligibleScore - 1;
                System.out.println("Has Bad Credit");
            } else {
                eligibleScore = eligibleScore + 1;
                System.out.println("credit is good");
            }
            if (ln.HasBadLoan(cr)) {
                eligibleScore = eligibleScore - 1;
                System.out.println("Has bad loan");
            } else {
                eligibleScore = eligibleScore + 1;
                System.out.println("No bad loan");
            }
            if (eligibleScore >= 2)
                return true;
            else
                return false;
        }

        public class Bank {
            public Bank() {
            }

            public boolean HasSufficientSavings(Customer C, int amount) {
                if (C.SavingAmount > amount)
                    return true;
                else
                    return false;
            }
        }

        public class Credit {
            public Credit() {
            }

            public boolean HasBadCredit(Customer C) {
                if (C.HasBadCredit && C.SavingAmount < 1500)
                    return true;
                else
                    return false;
            }
        }

        public class Loan {
            public Loan() {
            }

            public boolean HasBadLoan(Customer C) {
                if (C.CHasBadLoan() && C.SavingAmount < 1000)
                    return true;
                else
                    return false;
            }
        }


        public class Customer {
            int SavingAmount;
            boolean HasBadLoan;
            boolean HasBadCredit;
            String name;

            public Customer(String name, int SavingAmount, boolean
                    HasBadCredit, boolean HasBadLoan) {
                this.name = name;
                this.SavingAmount = SavingAmount;
                this.HasBadCredit = HasBadCredit;
                this.HasBadLoan = HasBadLoan;
            }

            public String Name() {
                return name;
            }

            public boolean CHasBadCredit() {
                if (HasBadCredit)
                    return true;
                else
                    return false;
            }

            public boolean CHasBadLoan() {
                if (HasBadLoan)
                    return true;
                else
                    return false;
            }

            public int CSavingAmount() {
                return SavingAmount;
            }
        }


        public static void main(String[] args) {
            Customer cust = new Customer("John Bruce", 2500, false, false);
            Bank bk = new Bank();
            Loan ln = new Loan();
            Credit ct = new Credit();
            MorgageFacade Mortgage = new MorgageFacade(ln, ct, bk, cust);
            boolean eligable = Mortgage.IsEligible(cust, 2600);
            if (eligable)
                System.out.println("Mortgage is approved");
            else
                System.out.println("Mortgage is not approved");
            System.out.println("");
        }

}
