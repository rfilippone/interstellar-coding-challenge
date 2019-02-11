package com.interstellar.codingchallenge.domain;

import java.util.Date;

public class ImageGenerationRequest {
  private int utmZone;
  private String latitudeBand;
  private String gridSquare;
  private Date date;
  private String channelMap;

  public ImageGenerationRequest(int utmZone, String latitudeBand, String gridSquare, Date date, String channelMap) {
    super();
    this.utmZone = utmZone;
    this.latitudeBand = latitudeBand;
    this.gridSquare = gridSquare;
    this.date = date;
    this.channelMap = channelMap;
  }

  public int getUtmZone() {
    return utmZone;
  }

  public String getLatitudeBand() {
    return latitudeBand;
  }

  public String getGridSquare() {
    return gridSquare;
  }

  public Date getDate() {
    return date;
  }

  public String getChannelMap() {
    return channelMap;
  }

}
