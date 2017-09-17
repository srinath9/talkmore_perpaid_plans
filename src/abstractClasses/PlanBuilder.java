package abstractClasses;

import models.Amount;
import models.Plan;

/**
 * Created by tech on 17/9/17.
 */
public abstract class PlanBuilder {

    protected Plan plan ;

    public Plan getPlan() {
        if(plan.getPlanCost() == 0)
            throw   new IllegalArgumentException("Requires plan cost");
        return plan;
    }

    public void createNewPlanProduct() {
        plan = new Plan(30, new Amount(100) ,
                new Amount(100) , 100 , 100 );

    }

    public abstract void buildLocalCharge(int amount);
    public abstract void buildStdCharge(int amount);
    public abstract void buildDays(int days);

    public abstract void buildLocalMins(int localmins);
    public abstract void buildStdMins(int stsdmins);
    public abstract void buildPlanCost(int plancost);


}
