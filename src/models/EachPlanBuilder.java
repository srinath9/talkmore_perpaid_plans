package models;

import abstractClasses.PlanBuilder;
/**
 * Created by tech on 17/9/17.
 */
public class EachPlanBuilder extends PlanBuilder {


    @Override
    public void buildLocalCharge(int amount) {
        plan.setLocalCharge(amount);
    }

    @Override
    public void buildStdCharge(int amount) {
        plan.setStdCharge(amount);
    }

    @Override
    public void buildDays(int days) {
        plan.setDays(days);
    }

    @Override
    public void buildLocalMins(int localmins) {
        plan.setLocalMins(localmins);
    }

    @Override
    public void buildStdMins(int stdmins) {
        plan.setStdMins(stdmins);
    }

    @Override
    public void buildPlanCost(int plancost) {
        plan.setPlanCost(plancost);
    }

}
