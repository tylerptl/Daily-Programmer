/**
 * @author Tyler Crill
 * @date 7/16/18
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Commission {
    private BufferedReader br;
    private boolean isRevenue;
    private List<String> names;
    private ArrayList<Person> employees;
    private static final Logger LOGGER = Logger.getLogger(Commission.class.getName());

    public ArrayList<Person> getEmployees() {
        return employees;
    }

    Commission() throws FileNotFoundException {
        br = new BufferedReader(new FileReader(new File("C:\\Users\\asdf\\Documents\\Programming\\Java Work\\Daily Programmer Challenges\\#365 Sales Commission\\input.txt")));
        employees = new ArrayList<>();
    }

    /**
     * This method will initiate most of the other methods in this class as long as there is valid input. It will first read in a line
     * and check for "revenue" or "expenses". Pending on which is found, it will set the respective boolean value which will be used below
     * to add/subtract to the sales. Once an empty line is read in, or any invalid text, the reader will close.
     * @throws IOException
     */
    protected void fillTable() throws IOException {   // Calling this will grab employee names as well as populate the table with their expenses + earnings
        String key;
        while((key = br.readLine()) != null){
            br.readLine();
            if(key.toLowerCase().equals("revenue")){

                isRevenue = true;
                populateNames();
                populateExpensesRevenue();
            }else if(key.toLowerCase().equals("expenses")){

                isRevenue = false;
                populateNames();
                populateExpensesRevenue();
            }
        }
        br.close();
    }

    /**
     * This method will pull in all names from the input
     * @throws IOException
     */
    private void populateNames() throws IOException {

        String key;
        if((key = br.readLine()) != null){
           key = key.trim();
            if(names !=null){
                return;
            }
            names = Arrays.asList(key.trim().split("\\s+"));
            for(String name : names){
                employees.add(new Person(name));
            }
        }
    }

    /**
     * This method will do most of the legwork for reading in and comparing expenses vs revenue. If the
     * table is empty, the method will write whatever input it received first immediately. After reaching the
     * second expense/revenue chart, it will then add/subtract accordingly and set to 0 any index in which
     * the expenses were greater than revenue.
     * @throws IOException
     */
    private void populateExpensesRevenue() throws IOException {
        String key;
        String[] temp;

        while((key = br.readLine()) != null){
            if(key.toLowerCase().equals("expenses") || key.toLowerCase().equals("revenue") || key.isEmpty()){
                LOGGER.log(Level.FINE, "Invalid entry - exiting loop");
                return;
            }
            int x = 1;
            temp = key.trim().split("\\s+");

            if(temp.length != 0){   // Checking for blank lines
                for(Person p : employees){
                    if(!p.getProfits().containsKey(temp[0])){   // Check to see if the item has been entered yet
                        p.addToProfits(temp[0], Integer.parseInt(temp[x]));
                    }else{
                        if(isRevenue){
                            if(p.getProfits().get(temp[0]) >= Integer.parseInt(temp[x])){   // Checking if expenses outweigh earnings for this item
                                p.addToProfits(temp[0], Integer.parseInt(temp[x]) - p.checkInProfits(temp[0]));
                            }
                            else{
                                p.addToProfits(temp[0], 0);
                            }
                        }else if(!isRevenue){
                            if(Integer.parseInt(temp[x]) >= p.getProfits().get(temp[0])){
                                p.getProfits().put(temp[0], 0);
                            }
                            else{
                                p.getProfits().put(temp[0], p.getProfits().get(temp[0]) - Integer.parseInt(temp[x]));
                            }
                        }
                    }

                    x++;

                }
            }

        }

    }

    /**
     * This method will print out a formatted table displaying what each person earned
     */
    public void printCommission(){

        System.out.printf("%10s", " ");
        for(int i = 0; i < names.size(); i++){
            System.out.printf("%10s", names.get(i));
        }
        System.out.println();
        System.out.printf("Commission");
        for(Person p : employees){
            System.out.print(String.format("%10s", p.getCommissions()));
        }

    }
}



