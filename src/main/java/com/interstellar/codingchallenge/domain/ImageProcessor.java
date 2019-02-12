package com.interstellar.codingchallenge.domain;

public interface ImageProcessor {
  public boolean canProcess(Granule granule);

  public byte[] process(Granule granule);
}
