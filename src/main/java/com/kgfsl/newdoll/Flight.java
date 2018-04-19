package com.kgfsl.newdoll;

public class Flight
{
  private String id;
  private String name;
  private  String departure;
  private  String arrival;
  private int fare;
  private String flag;
  /**
   * @param flag the flag to set
   */
  public void setFlag(String flag) {
      this.flag = flag;
  }
  /**
   * @return the flag
   */
  public String getFlag() {
      return flag;
  }
  /**
   * @return the fare
   */
  public int getFare() {
      return fare;
  }
  /**
   * @param fare the fare to set
   */
  public void setFare(int fare) {
      this.fare = fare;
  }
  /**
   * @param id the id to set
   */
  public void setId(String id) {
      this.id = id;
  }
  /**
   * @return the id
   */
  public String getId() {
      return id;
  }
  /**
   * @param name the name to set
   */
  public void setName(String name) {
      this.name = name;
  }
  /**
   * @return the name
   */
  public String getName() {
      return name;
  }
  /**
   * @param departure the departure to set
   */
  public void setDeparture(String departure) {
      this.departure = departure;
  }
  /**
   * @return the departure
   */
  public String getDeparture() {
      return departure;
  }
  /**
   * @param arrival the arrival to set
   */
  public void setArrival(String arrival) {
      this.arrival = arrival;
  }
  /**
   * @return the arrival
   */
  public String getArrival() {
      return arrival;
  }
  public String toString(){
      return id+" "+name+" "+departure+" "+arrival+"  "+fare+" "+flag;
  }
}