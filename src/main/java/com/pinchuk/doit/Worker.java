package com.pinchuk.doit;



public class Worker implements Workers{
  private String id;
  private String name;
  private String surname;
  private String dateBirthday;
  private String dateStartWorking;

  public Worker() {
  }

  public Worker(String id, String name, String surname, String dateBirthday, String dateStartWorking){
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.dateBirthday = dateBirthday;
    this.dateStartWorking = dateStartWorking;
  }



  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getDateBirthday() {
    return dateBirthday;
  }

  public void setDateBirthday(String dateBirthday) {
    this.dateBirthday = dateBirthday;
  }

  public String getDateStartWorking() {
    return dateStartWorking;
  }

  public void setDateStartWorking(String dateStartWorking) {
    this.dateStartWorking = dateStartWorking;
  }

}
