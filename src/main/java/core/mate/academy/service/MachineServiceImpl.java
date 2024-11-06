package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import core.mate.academy.model.Workable;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl implements MachineService<Machine> {
    private MachineProducer bulldozerProducer = new BulldozerProducer();
    private MachineProducer excavatorProducer = new ExcavatorProducer();
    private MachineProducer truckProducer = new TruckProducer();

    @Override
    public List<Machine> getAll(Class<? extends Machine> type) {

        return type.equals(Bulldozer.class) ? bulldozerProducer.get()
                : type.equals(Excavator.class) ? excavatorProducer.get()
                : type.equals(Truck.class) ? truckProducer.get()
                : List.of();
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        if (machines == null) {
            throw new NullPointerException("List is null");
        }
        int size = machines.size();
        machines.clear();
        for (int i = 0; i < size; i++) {
            machines.add(value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        if (machines == null) {
            throw new NullPointerException("List is null");
        }

        for (Workable machine : machines) {
            machine.doWork();
        }
    }
}
