package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Machine;
import java.util.List;

public class BulldozerProducer implements MachineProducer {
    private Bulldozer bulldozer1 = new Bulldozer();
    private Bulldozer bulldozer2 = new Bulldozer();
    private Bulldozer bulldozer3 = new Bulldozer();

    @Override
    public List<Machine> get() {
        return List.of(bulldozer1, bulldozer2, bulldozer3);
    }
}
