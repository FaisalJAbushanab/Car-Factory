package carFactory;

import java.util.ArrayList;
import java.util.Random;

public class Request {

    public ArrayList<Computer> computers = new ArrayList<>();
    // TODO private int selectedCost;
    // TODO private int selectedTime;
    private String day;
    private String hour;
    private String minute;


    public Request(int day, int hour, int minute) {
        if(day < 10)
            this.day = "0" + String.valueOf(day);
        else
            this.day = String.valueOf(day);
        if(hour < 10)
            this.hour = "0" + String.valueOf(hour);
        else
            this.hour = String.valueOf(hour);
        if(minute < 10)
            this.minute = "0" + String.valueOf(minute);
        else
            this.minute = String.valueOf(minute);

        for (int i = 0; i < 1000; i++) {

            Computers[] comp = Computers.values();
            Random random = new Random();
            int n = random.nextInt(comp.length);

            String[] info = getInfoArr(comp[n]);
            int[] materials = getMatsArr(comp[n]);
            int[] emplys = /*getEmplysArr(comp[n]);*/ new int[3];

            Computer computer = new Computer(info, materials, emplys);
            computers.add(computer);
        }
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

    public int findFactory(ArrayList<Factory> factories) {
        int best = -1;
        int bestIndex = -1;
        for(Factory fact: factories) {
         /*   if(!fact.isOccupied) {
        }*/ int score = checkSuitabilty(fact);
            if (best < score) {
                best = score;
                bestIndex = factories.indexOf(fact);
            }
        }
        if (bestIndex != -1) {
            //factories.get(bestIndex).occupy();
            System.out.printf("For request (%s/%s:%s)\n", day, hour, minute);
            System.out.println("Factory " + (bestIndex + 1) + " has been occupied");
            return 1;
        }
        else {
            System.out.printf("For request (%s/%s:%s)\n", day, hour, minute);
            System.out.println("No Factory have been found");
            return 0;
        }
    }

    public int checkSuitabilty(Factory chosenFactory) {
        int suitabilty = chosenFactory.calculateSuitabilty(this);
        // TODO if() suitibialty
        return suitabilty;
        }
    }
