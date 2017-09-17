package prepaidCharges;

import models.Plan;
import models.EachPlanBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by tech on 17/9/17.
 */
public class PlanCharging {



    public static void main(String[] args){
        System.out.println("starting program");
        ArrayList<Plan> plans = new ArrayList<>();

        EachPlanBuilder build = new EachPlanBuilder();
        build.createNewPlanProduct();
        build.buildDays(30);
        build.buildLocalCharge(50);
        build.buildStdCharge(50);
        build.buildLocalMins(100);
        build.buildStdMins(100);
        build.buildPlanCost(100);

        Plan plan1 = build.getPlan();

        plans.add(plan1);

        System.out.println("no plan applied : "+plan1.getCostPerMonth());

        EachPlanBuilder build1 = new EachPlanBuilder();
        build1.createNewPlanProduct();
        build1.buildDays(15);
        build1.buildLocalCharge(20);
        build1.buildStdCharge(20);
        build1.buildLocalMins(100);
        build1.buildStdMins(100);
        build1.buildPlanCost(50);

        Plan plan2 = build1.getPlan();
        plans.add(plan2);
        System.out.println("50Rs plan applied : "+plan2.getCostPerMonth());

        EachPlanBuilder build2 = new EachPlanBuilder();
        build2.createNewPlanProduct();
        build2.buildDays(30);
        build2.buildLocalCharge(50);
        build2.buildStdCharge(100);
        build2.buildLocalMins(100);
        build2.buildStdMins(100);
        build2.buildPlanCost(20);

        Plan plan3 = build2.getPlan();
        plans.add(plan3);
        System.out.println("20Rs Plan applied "+plan3.getCostPerMonth());

        EachPlanBuilder build3 = new EachPlanBuilder();
        build3.createNewPlanProduct();
        build3.buildDays(30);
        build3.buildLocalCharge(50);
        build3.buildStdCharge(50);
        build3.buildLocalMins(100);
        build3.buildStdMins(100);
        build3.buildPlanCost(35);

        Plan plan4 = build3.getPlan();
        plans.add(plan4);
        System.out.println("35Rs plan applied : "+plan4.getCostPerMonth());


        Collections.sort(plans);

        System.out.println("===============after sorting================");
//        for (Plan plan : plans){
//            System.out.println(plan.getCostPerMonth());
//        }


        System.out.println("least amount plan is "+plans.get(0).getCostPerMonth());

    }

}
