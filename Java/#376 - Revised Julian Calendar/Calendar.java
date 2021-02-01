/**
 *
 */

import static java.util.stream.LongStream.range;

public class Calendar {
    private long totalLeaps;

    private long getTotalLeaps(){
        return totalLeaps;
    }

    Calendar(){

    }

    /**
     * Useless method - use alternateIterateYears. This method is incredibly inefficient compared to alternate which checks for
     * leap years in a 900 year cycle and then determines cycle count in range.
     */
//    void iterateYears(){
//        range(start/4, end/4).map(i -> i*4).forEach(this::checkYear);
//    }

    long alternateIterateYears(long start, long end){
        var cycles = (end-start)/900;       // Determines how many 900yr cycles there are in range
        System.out.println("Cycles : " + cycles);
        var cycleDelimiter = end-cycles * 900L;  // This represents the final portion of the range which is < 900 - leap years will be checked manually in this range.
        System.out.println("Manual end : " + cycleDelimiter);
        totalLeaps = leapCycle(start, cycleDelimiter) + leapCycle(0,900) * cycles;
        return totalLeaps;
    }

    long leapCycle(long start, long end){
        return range(start, end)
                .filter(i -> i % 4 == 0)
                .filter(i ->i % 100 != 0 || i % 900 == 600 || i % 900 == 200)
                .count();
    }
    void checkYear(long year){
        if(year % 100 != 0 || year % 900 == 200 || year % 900 == 600){
            System.out.println("Added: " + year);
//            tracker++;
//            if(year % 900 == 200 || year % 900 == 600){
//                //validYears.add(year);
//                //leapYears[tracker] = year;
//                System.out.println("Added: " + year);
//                tracker++;
//            }
        }

    }

    /**
     * This method will find the first year in the range divisible by 4. W/O doing so the stream
     * in iterateYears() can skip the last potential leap year.
     * @param n
     */
//    public void setStart(long n){
//        for(long i = n; i < n+4; i++){
//            if(i % 4 == 0){
//                start = i;
//                System.out.println("First divisible year found :  " + i);
//                }
//
//            }
//        }

    /**
     * This method will find the last year in the range divisible by 4. W/O doing so the stream
     * in iterateYears() can skip the last potential leap year.
      * @param n
     */
//    public void setEnd(long n){
//        for(long i = n; i > n-4; i--){
//            if(i % 4 == 0){
//                end = i;
//                System.out.println("Last divisible year found :  " + i);
//            }
//
//        }
//
//    }

    public void displayStats(){
        System.out.println("Total leaps : " + getTotalLeaps());
    }

    }






