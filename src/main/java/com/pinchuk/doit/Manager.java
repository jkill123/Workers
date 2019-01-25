package com.pinchuk.doit;

import java.util.ArrayList;
import java.util.Arrays;

public class Manager {

  private ArrayList<Worker> wrk = new ArrayList<>();

  public void addWorker(Worker w){
    wrk.add(w);
  }

  public  void  addWorker(Worker[] workers){
    wrk.addAll(Arrays.asList(workers));
  }
}
