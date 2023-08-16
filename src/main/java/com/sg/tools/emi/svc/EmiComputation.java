package com.sg.tools.emi.svc;

/**
 *
 * @author suraj
 */
public class EmiComputation {

    /**
     * This method is used to calculate Monthy EMI.
     * @param principal
     * @param rateOfInt
     * @param time
     * @param isTimeInyears
     * @return
     */
    public static long monthlyEmi(final double principal, final Double rateOfInt, 
            long time, final boolean isTimeInyears) {
        if (isTimeInyears) {
            time = time * 12;
        }

        final double convertedRate = (rateOfInt / 12) / 100;
        final double timeFactor = Math.pow((1 + convertedRate), time);
        final double emi = (principal * convertedRate * timeFactor) / (timeFactor - 1);
        final long finalEmi = Math.round(emi * 100) / 100;

        return finalEmi;
    }

    public static long totalInterestPayable(final double principal, final long emi, 
            long time, final boolean isTimeInyears) {
        if (isTimeInyears) {
            time = time * 12;
        }
        
        final double totalInterest = (time * emi) - principal;
        final long finalTotalInterest = Math.round(totalInterest * 100) / 100;
        
        return finalTotalInterest;
    }
    
    public static long totalPayment(final long emi, long time, 
            final boolean isTimeInyears) {
        if (isTimeInyears) {
            time = time * 12;
        }
        
        final double payment = time * emi;
        final long totalPayment = Math.round(payment * 100) / 100;
        
        return totalPayment;        
    }
}
