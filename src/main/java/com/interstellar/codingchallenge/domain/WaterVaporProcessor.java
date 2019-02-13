package com.interstellar.codingchallenge.domain;

import org.springframework.stereotype.Service;

import com.interstellar.codingchallenge.domain.Granule.Bands;
import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

@Service
public class WaterVaporProcessor implements ImageProcessor {

  @Override
  public byte[] process(Granule granule) throws NotEnoughImages {
    if (!granule.has(Bands.B09)) {
      throw new NotEnoughImages();
    }
    // TODO Auto-generated method stub
    return null;
  }
}
