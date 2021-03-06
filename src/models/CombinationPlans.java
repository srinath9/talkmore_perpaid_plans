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

    private int minStd = Integer.MAX_VALUE;
    private int minLocal = Integer.MAX_VALUE;
    private Plan minStdPlan;
    private Plan minLocalPlan;

    public void setPlans(ArrayList<Plan> plans) {
        this.plans = plans;
    }

    public void calculateComboPlans(){

//        for(Plan plan: plans)
//            for (Plan t1 : plans)
//                if (plan != t1)
//                    compare(plan, t1);
        ArrayList<Plan> data = new ArrayList<>();

//        findCombinations(plans, data, 0, plans.size()-1,0 , 2);
        findMinStdLocalPlan();
        System.out.println("total cost min with combination is : "+minVal +" for plan "+minPlan1+ " ,  "+ minPlan2);
    }

    private void findMinStdLocalPlan(){

        // std plan based sorting
        Collections.sort(plans, new Comparator<Plan>() {
            @Override
            public int compare(Plan plan, Plan t1) {

                return plan.getStdCharge().getRate() > t1.getStdCharge().getRate() ? 1 : -1;

            }
        });

        minStdPlan = plans.get(0);


        // local plan based sorting
        Collections.sort(plans, new Comparator<Plan>() {
            @Override
            public int compare(Plan plan, Plan t1) {

                return plan.getLocalCharge().getRate() > t1.getLocalCharge().getRate() ? 1 : -1;

            }
        });

        minLocalPlan = plans.get(0);

        compare(minLocalPlan, minStdPlan);

    }

    public int compare(Plan plan, Plan t1) {

//        System.out.println("plan 1 "+ plan.getPlanCost() + " plan 2 "+ t1.getPlanCost());

        float local;
        float std;
        if( plan != t1) {
            if (plan.getLocalCharge().getRate() > t1.getLocalCharge().getRate())
                local = calLocalCost(t1);

            else if (plan.getLocalCharge().getRate() == t1.getLocalCharge().getRate()) {
                if (plan.getPlanCost() > t1.getPlanCost())
                    local = calLocalCost(t1);
                else
                    local = calLocalCost(plan);
            } else
                local = calLocalCost(plan);

            if (plan.getStdCharge().getRate() > t1.getStdCharge().getRate())
                std = calStdCost(t1);

            else if (plan.getStdCharge().getRate() == t1.getStdCharge().getRate()) {
                if (plan.getPlanCost() > t1.getPlanCost())
                    std = calStdCost(t1);
                else
                    std = calStdCost(plan);
            } else
                std = calStdCost(plan);

            int totalCost = (int) (local + std);

//        System.out.println("totoal "+totalCost);

            if (totalCost < minVal) {
                minVal = totalCost;
                minPlan1 = plan.getPlanCost();
                minPlan2 = t1.getPlanCost();
            }

        }
        else{
            minVal = (int) plan.getCostPerMonth();
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


    private void findCombinations(ArrayList<Plan> arr, ArrayList<Plan> data, int start,
                         int end, int index, int r) {
        
        if (index == r)
        {
            for (int j=0; j<r; j++)
                System.out.print(data.get(j)+" ");

            compare(data.get(0), data.get(1));
            System.out.println("");
            return;
        }

        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            if(data.size() < 2)
                data.add( arr.get(i));
            else
                data.set(index, arr.get(i) );

            findCombinations(arr, data, i+1, end, index+1, r);
        }
    }

}
