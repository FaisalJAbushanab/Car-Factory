package carFactory;

import java.util.ArrayList;
import java.util.Random;

public class Request {

    public ArrayList<Computer> computers = new ArrayList<>();
    private int selectedCost;
    private int selectedTime;
    private int day;
    private int hour;
    private int minute;


    public Request(int day, int hour, int minute) {
        this.day = day;
        this.hour = hour;
        this.minute = minute;

        for (int i = 0; i < 1000; i++) {

            Computers[] comp = Computers.values();
            Random random = new Random();
            int n = random.nextInt(comp.length);

            String[] info = getInfoArr(comp[n]);
            int[] materials = getMatsArr(comp[n]);
            int[] emplys = /getEmplysArr(comp[n]);/ new int[3];

            Computer computer = new Computer(info, materials, emplys);
            computers.add(computer);

        }
        for(Computer computer : computers) {
        	selectedTime += computer.productionTime;
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