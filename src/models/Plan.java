package models;

import interfaces.IRate;

/**
 * Created by tech on 17/9/17.
 */
public class Plan implements Comparable<Plan>{
    private int days;
    private IRate localCharge;
    private int localMins;

    private IRate stdCharge;
    private int stdMins;

    private int planCost;

    public Plan(int noOfDays, Amount localCharge, Amount stdCharge , int localMins , int stdMins) {
        days = noOfDays;
        this.localCharge = localCharge;
        this.stdCharge = stdCharge;
        this.localMins = localMins;
        this.stdMins = stdMins;
    }

    public Plan() {

    }


    public void setDays(int days) {
        this.days = days;
    }


    public void setLocalCharge(int localCharge) {
        this.localCharge = new Amount(localCharge);
    }


    public void setStdCharge(int stdCharge) {
        this.stdCharge = new Amount(stdCharge) ;
    }

    public void setLocalMins(int localMins) {
        this.localMins = localMins;
    }

    public void setStdMins(int stdMins) {
        this.stdMins = stdMins;
    }

    public void setPlanCost(int planCost) {
        this.planCost = planCost;
    }

    public int getPlanCost() {
        return planCost;
    }

    public float getCostPerMonth(){
        float multiFactor = (float) 30/ days;
        float localcost = localCharge.getRate()* localMins ;
        float stdcost = stdCharge.getRate()* stdMins;
        float totalCost = localcost + stdcost + planCost;
        return totalCost *multiFactor;
    }

    @Override
    public int compareTo(Plan plan) {
        return  (this.getCostPerMonth() - plan.getCostPerMonth()) > 0 ? 1 : -1;
    }
}
