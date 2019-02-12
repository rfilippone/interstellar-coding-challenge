package com.interstellar.codingchallenge.domain;

import org.springframework.stereotype.Service;

import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

@Service
public class GranuleFinder {

  public Granule findGranule(ImageGenerationRequest request) throws NotEnoughImages {
    throw new NotEnoughImages();
  }

}
