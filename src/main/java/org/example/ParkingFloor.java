package org.example;

import java.util.Map;

public class ParkingFloor {
    public  String name;
    public  Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots;

    public ParkingFloor(String name, Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots){
        this.name = name;
        this.parkingSlots = parkingSlots;
    }

    public ParkingSlot getRelevantSlotForVehicleAndPark(Vehicle vehicle){
        VehicleCategory vehicleCategory = vehicle.getVehicleCategory();
        ParkingSlotType parkingSlotType = selectParkingSlot(vehicleCategory);
        Map<String, ParkingSlot> selectedParkingSlot = parkingSlots.get(parkingSlotType);
        ParkingSlot slot = null;
        for (Map.Entry<String, ParkingSlot> m : selectedParkingSlot.entrySet()){
            if(m.getValue().isAvailable){
                slot = m.getValue();
                slot.addVehicle(vehicle);
                break;
            }
        }

        return slot;
    }

    private ParkingSlotType selectParkingSlot(VehicleCategory vehicleCategory){
        if(vehicleCategory == vehicleCategory.TwoWheeler){
            return  ParkingSlotType.TwoWheeler;
        } else if(vehicleCategory == vehicleCategory.ThreeWheeler){
            return  ParkingSlotType.ThreeWheeler;
        } else if(vehicleCategory == vehicleCategory.Sedan || vehicleCategory == vehicleCategory.HotchBack  || vehicleCategory == vehicleCategory.SUV){
            return  ParkingSlotType.FourWheeler;
        } else if(vehicleCategory == vehicleCategory.Truck || vehicleCategory == vehicleCategory.Bus){
            return  ParkingSlotType.LargeVehicle;
        }

        return ParkingSlotType.SpecialVehicle;
    }
}
