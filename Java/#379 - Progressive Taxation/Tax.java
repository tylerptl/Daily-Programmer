public class Tax {
    private int[] taxBrackets = {10000,30000,100000};
    private double[] taxRates = {0,0.1,0.25,0.40};

    private int income;

    Tax(int income){
        this.income = income;
    }


    private double getTaxes(){
        int taxedIncome = 0;        // Declare what has already been taxed of the income
        int taxHarvested = 0;       // How much tax revenue is generated
        int untaxedIncome = 0;      // What will be left over for the last applicable tax bracket
        untaxedIncome = income;
        System.out.println("Displaying tax info based on income of: $" + income);
        for(int i = 0; i < taxBrackets.length; i++){
            if(i==0){
                System.out.println("Current bracket cap: $" + taxBrackets[i]);
                untaxedIncome-=taxBrackets[i];
                taxHarvested = 0;
//                System.out.println("Current remaining taxable income : $" + untaxedIncome);
            }
            else {
                if(income <= taxBrackets[i]){
                    taxHarvested += (income - taxBrackets[i-1]) * taxRates[i];
                    System.out.println("Landed within tax bracket - current tax harvest: $" + taxHarvested);
                }else{
                    taxHarvested += (taxBrackets[i] - taxBrackets[i-1]) * taxRates[i];
                    System.out.println("Moving to next bracket - current tax harvest: $" + taxHarvested);

                }
            }
        }
        if(income > taxBrackets[taxBrackets.length-1]){
            taxHarvested+= (income - taxBrackets[2]) * taxRates[3];
            System.out.println("Unbounded upper tax bracket reached - final tax harvest: $" + taxHarvested);
        }
        else{
            System.out.println("Income fully taxed - final tax harvest: $" + taxHarvested);
        }



        return 0;
    }



    public static void main(String... args){
        Tax challengeOne = new Tax(1234567);
        challengeOne.getTaxes();
    }
}
