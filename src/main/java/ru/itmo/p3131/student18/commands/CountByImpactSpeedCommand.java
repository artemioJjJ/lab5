package ru.itmo.p3131.student18.commands;

import ru.itmo.p3131.student18.collection.tools.CollectionManager;

public class CountByImpactSpeedCommand implements Command {
    private CollectionManager manager;

    public CountByImpactSpeedCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean isWithArgs() {
        return true;
    }

    @Override
    public void execute(String[] params) {
        try {
            manager.count_by_impact_speed(Float.parseFloat(params[0]));
        } catch (NumberFormatException e) {
            System.out.println("Incorrect value. Input value has to be float");
        }
    }

    @Override
    public String getName() {
        return "count_by_impact_speed";
    }
}
