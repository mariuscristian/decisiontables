package com.example.droolsdecisiontablesdemo;

public class Point {

  protected UpToDate occupationUpToDate;
  protected FailedDetectionOfOccupation failedDetectionOfOccupation;
  protected UpToDate upToDate;
  protected Position position;
  protected Moving moving;
  //  protected RouteLocked routeLocked;
//  protected SwitchRequest switchRequest;
//  protected FlankProtectionReceived flankProtectionReceived;
//  protected RouteInhibition inhibited;
//  protected Blocked blocked;
//  protected PositionInRouteDifferent positionRouteDifferent;
//  protected Trailed trailed;
//  protected FailedDetectionOfPosition failedDetectionOfPosition;
//  protected CatenarySwitchedOff catenarySwitchedOff;
//  protected LocalOperation localOperation;
//  protected AxleCounterResetOngoing axleCounterResetOngoing;
//  protected CrankOut crankOut;
//  protected PointHeatingOn pointHeatingOn;
  protected Occupation occupation;
//  protected RouteMarking routeMarking;


  @Override
  public String toString() {
    return "Point{" +
        "occupationUpToDate=" + occupationUpToDate +
        ", failedDetectionOfOccupation=" + failedDetectionOfOccupation +
        ", upToDate=" + upToDate +
        ", position=" + position +
        ", moving=" + moving +
        ", occupation=" + occupation +
        '}';
  }

  public Occupation getOccupation() {
    return occupation;
  }

  public void setOccupation(Occupation occupation) {
    this.occupation = occupation;
  }

  public UpToDate getOccupationUpToDate() {
    return occupationUpToDate;
  }

  public void setOccupationUpToDate(UpToDate occupationUpToDate) {
    this.occupationUpToDate = occupationUpToDate;
  }

  public FailedDetectionOfOccupation getFailedDetectionOfOccupation() {
    return failedDetectionOfOccupation;
  }

  public void setFailedDetectionOfOccupation(
      FailedDetectionOfOccupation failedDetectionOfOccupation) {
    this.failedDetectionOfOccupation = failedDetectionOfOccupation;
  }

  public UpToDate getUpToDate() {
    return upToDate;
  }

  public void setUpToDate(UpToDate upToDate) {
    this.upToDate = upToDate;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public Moving getMoving() {
    return moving;
  }

  public void setMoving(Moving moving) {
    this.moving = moving;
  }

  public Point() {
  }

  public enum UpToDate {
    NOT_UP_TO_DATE,
    UP_TO_DATE,
    NO_STATUS;

    private UpToDate() {
    }

    public String value() {
      return this.name();
    }

    public static UpToDate fromValue(String v) {
      return valueOf(v);
    }
  }

  public enum Position {
    LEFT,
    RIGHT,
    NO_STATUS;

    private Position() {
    }

    public String value() {
      return this.name();
    }

    public static Position fromValue(String v) {
      return valueOf(v);
    }
  }

  public enum FailedDetectionOfOccupation {
    NO_FAILURE,
    FAILURE,
    NO_STATUS;

    private FailedDetectionOfOccupation() {
    }

    public String value() {
      return this.name();
    }

    public static FailedDetectionOfOccupation fromValue(String v) {
      return valueOf(v);
    }
  }

  public enum Moving {
    NOT_IN_MOVEMENT,
    IN_MOVEMENT,
    NO_STATUS;

    private Moving() {
    }

    public String value() {
      return this.name();
    }

    public static Moving fromValue(String v) {
      return valueOf(v);
    }
  }

  public enum Occupation {
    OCCUPIED,
    FREE,
    NO_STATUS;

    private Occupation() {
    }

    public String value() {
      return this.name();
    }

    public static Occupation fromValue(String v) {
      return valueOf(v);
    }
  }
}
