//
// Copyright (c) 2015 Harry Cheung
//

package harrycheung.map;

import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class Lap {

  protected Track    track;
  protected double   startTime;
  protected int      lapNumber;
  protected static ArrayList<Point> points;
  protected double   duration;
  protected double   distance;
  protected boolean  valid;
  protected double[] splits;
  protected boolean  outLap;

  public Lap(Session session, Track track, double startTime, int lapNumber) {
    this.track = track;
    this.startTime = startTime;
    this.lapNumber = lapNumber;
    /*Allocate once with enough space for most cases*/
    if(this.points == null)
      this.points = new ArrayList<Point>(550);
    else
      this.points.clear();
    this.duration = 0;
    this.distance = 0;
    this.valid = false;
    this.splits = new double[track.numSplits()];
    this.outLap = lapNumber == 0;
  }
  public void add(Point point) {
    duration = point.lapTime;
    distance = point.lapDistance;
    points.add(point);
   }

}