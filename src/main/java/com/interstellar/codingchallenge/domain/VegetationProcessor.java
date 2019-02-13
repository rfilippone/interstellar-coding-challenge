package com.interstellar.codingchallenge.domain;

import org.springframework.stereotype.Service;

import com.interstellar.codingchallenge.domain.Granule.Bands;
import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

@Service
public class VegetationProcessor implements ImageProcessor {

  @Override
  public byte[] process(Granule granule) throws NotEnoughImages {
    if (!granule.has(Bands.B05) || !granule.has(Bands.B06) || !granule.has(Bands.B07)) {
      throw new NotEnoughImages();
    }
    // TODO Auto-generated method stub
    return null;
  }
}
