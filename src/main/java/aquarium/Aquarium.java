package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishList = new ArrayList<>();
    public static final int CAPACITY = 20;

    public void addFish(Fish fish) {
        if (fishList.size()*5 > CAPACITY-5) {
            throw new IllegalStateException("Can not add fish because there is no more space.");
        }
        this.fishList.add(fish);
    }

    public void feed() {
        for (Fish fish : fishList) {
            fish.feed();
        }
    }

    public void removeFish(int maxWeight) {
        List<Fish> fishToRemove = new ArrayList<>();
        for (Fish fish : fishList) {
            if (fish.getWeight() > maxWeight) {
                fishToRemove.add(fish);
            }
        }
        fishList.removeAll(fishToRemove);
    }

    public List<String> getStatus() {
        List<String> status = new ArrayList<>();
        for (Fish fish : fishList) {
            status.add(fish.getStatus());
        }
        return status;
    }

    public int getNumberOfFishWithMemoryLoss() {
        int numberOfFishWithMemoryLoss = 0;
        for (Fish fish : fishList) {
            if (fish.hasMemoryLoss()) {
                numberOfFishWithMemoryLoss++;
            }
        }
        return numberOfFishWithMemoryLoss;
    }

    public boolean isThereFishWithGivenColor(String color) {
        for (Fish fish : fishList) {
            if (fish.getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }

    public Fish getSmallestFish() {
        Fish smallestFish = fishList.get(0);
        int smallestWeight = smallestFish.getWeight();
        for (Fish fish : fishList) {
            if (smallestWeight > fish.getWeight()) {
                smallestWeight = fish.getWeight();
                smallestFish = fish;
            }
        }
        return smallestFish;
    }
}
