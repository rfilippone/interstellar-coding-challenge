package com.interstellar.codingchallenge.domain;

import java.util.ArrayList;

import org.junit.Test;

import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

public class VisibleProcessorTest {

  @Test(expected = NotEnoughImages.class)
  public void cannotProcessEmptyGranule() throws NotEnoughImages {
    Granule granule = Granule.fromfiles(new ArrayList<>());
    VisibleProcessor processor = new VisibleProcessor();
    processor.process(granule);
  }

}
