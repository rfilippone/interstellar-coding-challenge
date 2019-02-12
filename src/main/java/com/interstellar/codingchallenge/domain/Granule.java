package com.interstellar.codingchallenge.domain;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Granule {
  // Pattern: T33UUP_20180804T100031_B01.tif
  public static enum Bands {
    B02, B03, B04, B05, B06, B07, B09
  }

  private Map<Bands, File> map;

  private Granule() {
    map = new HashMap<Granule.Bands, File>();
  }

  public static Granule fromfiles(List<File> files) {
    Granule granule = new Granule();
    for (File file : files) {
      String bandString = file.getName().substring(23, 26);
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
