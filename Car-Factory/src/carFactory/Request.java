package carFactory;

import java.util.ArrayList;
import java.util.Random;

public class Request {

    public ArrayList<Computer> computers = new ArrayList<>();
    private int selectedCost;
    private int selectedTime;
<<<<<<< HEAD
    private String day;
    private String hour;
    private String minute;
=======
    private int day;
    private int hour;
    private int minute;
>>>>>>> aba23f4b612a5821993d8a74c70602481a663af3

    public Request(int day, int hour, int minute) {
        this.day = day;
        this.hour = hour;
        this.minute = minute;

        for (int i = 0; i < 100; i++) {

            Computers[] comp = Computers.values();
            Random random = new Random();
            int n = random.nextInt(comp.length);

            String[] info = getInfoArr(comp[n]);
            int[] materials = getMatsArr(comp[n]);
<<<<<<< HEAD
            int[] emplys = /*getEmplysArr(comp[n]);*/ {15, 10, 5};
=======
            int[] emplys = /getEmplysArr(comp[n]);/ new int[3];
>>>>>>> aba23f4b612a5821993d8a74c70602481a663af3

            Computer computer = new Computer(info, materials, emplys);
            computers.add(computer);

        }
        for(Computer computer : computers) {
        	selectedTime += computer.productionTime;
        }
//        for(Computer computer : computers) {
//            selectedTime += computer.productionTime;
//        }
        selectedTime = getRandom(10, 20, computers.size());
    }


//    public int[] getMatsArr(Computers vals) {
//        int[] arr = new int[3];
//        arr[0] = vals.getWorkers();
//        arr[1] = vals.getTechnicians();
//        arr[2] = vals.getEngineers();
//        return arr;
//    }

    public String[] getInfoArr(Computers vals) {
        String[] arr = new String[3];
        arr[0] = vals.getCompany();
        arr[1] = vals.getType();
        arr[2] = vals.getQuality();
        return arr;
    }
    public int[] getMatsArr(Computers vals) {
        int[] arr = new int[9];
        arr[0] = vals.getMass1();
        arr[1] = vals.getMass2();
        arr[2] = vals.getMass3();
        arr[3] = vals.getMass4();
        arr[4] = vals.getMass5();
        arr[5] = vals.getMass6();
        arr[6] = vals.getMass7();
        arr[7] = vals.getMass8();
        arr[8] = vals.getMass9();
        return arr;
    }

<<<<<<< HEAD
    private void setSelectedCost(ArrayList<Factory> factories) {
        int averageCost = 0;
        int[] computerSumMaterials = new int[9];
        for (Computer comps : computers) {
            int[] compsMaterial = comps.getConstructMaterial();
            for (int i = 0; i < compsMaterial.length; i++) {
                computerSumMaterials[i] += compsMaterial[i];
            }
        }
        for(Factory fact: factories) {
            int cost =  fact.calculateCostMats(computerSumMaterials);
            averageCost += cost / (double) factories.size();
        }
        selectedCost = getRandom(10,10, averageCost);
    }

    public String getDay() {
        return day;
    }

    public String getHour() {
        return hour;
    }

    public String getMinute() {
        return minute;
    }

    private int getRandom(int lower, int upper, int val) {
        int addOrSub = (int) Math.floor(Math.random() * (2) + 1);
        if (addOrSub == 1) {
            double random = (Math.random() * (lower + 1));
            double factor = random / 100;
            double value = factor * val;
            return val - ((int) value);
        }
        else {
            double random = (Math.random() * (upper + 1));
            double factor = random / 100;
            double value = factor * val;
            return val + ((int) value);
        }
    }

    public ArrayList<Computer> getComputers() {
        return computers;
    }

    public int getSelectedTime() {
        return selectedTime;
    }

    public int findFactory(ArrayList<Factory> factories) {

        double best = -1;
        int bestIndex = -1;

        setSelectedCost(factories);
        System.out.printf("sleccted for request#(%s/%s:%s)\ncost is: %d\ntime is: %d\n",
                day, hour, minute, selectedCost, selectedTime);

        for(Factory factory: factories) {
            if (!factory.isOccupied()) {
                double score = checkSuitabilty(factory);
                System.out.println("factory#" + factories.indexOf(factory) + " got score" + score);
                if (score > best) {
                    best = score;
                    bestIndex = factories.indexOf(factory);
                }
            }
        }
        if (bestIndex != -1) {
            factories.get(bestIndex).setOccupied();
            System.out.printf("For request#(%s/%s:%s)\n", day, hour, minute);
            System.out.println("Factory " + (bestIndex + 1) + " has been occupied");
            return 1;
        }
        else {
            System.out.printf("For request#(%s/%s:%s)\n", day, hour, minute);
            System.out.println("No Factory have been found");
            return 0;
        }
    }

    public double checkSuitabilty(Factory chosenFactory) {
        return getScore(chosenFactory.getRequirments(this));
    }

    private double getScore(int[] vals) {
        double costScore = ((double) selectedCost/vals[0]);
        double timeScore = ((double) selectedTime/vals[1]);
        if ((costScore < 0) || (timeScore < 0)) {
            return -1;
        }
        else{
            return (costScore/2) + (timeScore/2);
        }
    }

    public int getSelectedCost() {
        return selectedCost;
    }
}
=======
    public void findFactory(ArrayList<Factory> factories) {
        for(Factory factory: factories) {
            checkSuitabilty(factory);
            }
    }

    public int checkSuitabilty(Factory chosenFactory) {
//        for(Computer comp: computers) {
//
//            }
        int suitabilty = chosenFactory.calculateSuitabilty(this, selectedTime);
        //if()
        return suitabilty;
        }
    }
>>>>>>> aba23f4b612a5821993d8a74c70602481a663af3
