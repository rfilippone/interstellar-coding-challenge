package com.interstellar.codingchallenge.domain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.stereotype.Service;

import com.interstellar.codingchallenge.domain.Granule.Bands;
import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

@Service
public class WaterVaporProcessor implements ImageProcessor {

  @Override
  public byte[] process(Granule granule) throws NotEnoughImages, IOException {
    if (!granule.has(Bands.B09)) {
      throw new NotEnoughImages();
    }
    File jpg = File.createTempFile("gdal", ".jpg");

    int result = 0;
    String cmd1 = "gdal_translate -b 1 -b 1 -b 1 -scale_1 0 100000 0 0  -scale_2 1 100000 0 0 -scale_3 0 16000 0 255 -exponent_3 0.3 -ot Byte -of jpeg "
        + granule.get(Bands.B09) + " " + jpg.getAbsolutePath();
    try {
      Runtime runtime = Runtime.getRuntime();
      result = runtime.exec(cmd1).waitFor();
    } catch (InterruptedException | IOException e) {
      result = 0;
    }
    if (result != 0) {
      throw new NotEnoughImages();
    }

    byte[] res = Files.readAllBytes(jpg.toPath());

    jpg.delete();

    return res;
  }
}
