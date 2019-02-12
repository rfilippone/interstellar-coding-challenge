package com.interstellar.codingchallenge.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Granule {
  // Pattern: T33UUP_20180804T100031_B01.tif
  public static enum Bands {
    B02, B03, B04, B05, B06, B07, B09
  }

  private Map<Bands, String> map;

  private Granule() {
    map = new HashMap<Granule.Bands, String>();
  }

  public static Granule fromfiles(List<String> files) {
    Granule granule = new Granule();
    Pattern p = Pattern.compile("");
    for (String file : files) {
      String bandString = file.substring(23, 26);
      try {
        granule.map.put(Bands.valueOf(bandString), file);
      } catch (Exception e) {
      }
    }

    return granule;
  }

  public boolean has(Bands band) {
    return map.containsKey(band);
  }
}
