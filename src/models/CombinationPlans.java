package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by tech on 17/9/17.
 */
public class CombinationPlans {

    private ArrayList<Plan> plans;
    private int minVal = Integer.MAX_VALUE;
    private int minPlan1;
    private int minPlan2;

    public void setPlans(ArrayList<Plan> plans) {
        this.plans = plans;
    }

    public void calculateComboPlans(){

        for(Plan plan: plans)
            for (Plan t1 : plans)
                if (plan != t1)
                    compare(plan, t1);


        System.out.println("total cost min with combination is : "+minVal +" for plan "+minPlan1+ " ,  "+ minPlan2);
    }

    public int compare(Plan plan, Plan t1) {

//        System.out.println("plan 1 "+ plan.getPlanCost() + " plan 2 "+ t1.getPlanCost());

        float local;
        float std;
        if(plan.getLocalCharge().getRate() > t1.getLocalCharge().getRate())
            local = calLocalCost(t1);

        else if (plan.getLocalCharge().getRate() == t1.getLocalCharge().getRate()) {
            if (plan.getPlanCost() > t1.getPlanCost())
                local = calLocalCost(t1);
            else
                local = calLocalCost(plan);
        }
        else
            local = calLocalCost(plan);

        if(plan.getStdCharge().getRate() > t1.getStdCharge().getRate())
            std = calStdCost(t1);

        else if (plan.getStdCharge().getRate() == t1.getStdCharge().getRate()) {
            if (plan.getPlanCost() > t1.getPlanCost())
                std = calStdCost(t1);
            else
                std = calStdCost(plan);
        }
        else
            std = calStdCost(plan);

        int totalCost = (int) (local + std);

//        System.out.println("totoal "+totalCost);

        if (totalCost < minVal ){
            minVal = totalCost;
            minPlan1 = plan.getPlanCost();
            minPlan2 = t1.getPlanCost();
        }



        return 0;
    }

    private float calLocalCost(Plan plan){
        float days = (float) (30/plan.getDays());
        float planCost = plan.getPlanCost() * days;
        float callCost = plan.getLocalCharge().getRate() * plan.getLocalMins();
        float totalCost = planCost + callCost;
//        System.out.println("plan local cost "+plan.getPlanCost() + " days "+plan.getDays());
        return totalCost;

    }

    private float calStdCost(Plan plan){
        float days = (float) (30/plan.getDays());
        float planCost = plan.getPlanCost() * days;
        float callCost = plan.getStdCharge().getRate() * plan.getStdMins();
        float totalCost = planCost + callCost;

//        System.out.println("plan std cost "+plan.getPlanCost() + " days "+plan.getDays());
        return totalCost;
    }

}
