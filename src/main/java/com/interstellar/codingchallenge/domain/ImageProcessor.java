package com.interstellar.codingchallenge.domain;

import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

public interface ImageProcessor {
  public byte[] process(Granule granule) throws NotEnoughImages;
}
